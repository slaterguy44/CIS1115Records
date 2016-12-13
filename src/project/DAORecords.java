package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a Collection of Records
 *
 * @author Ben Slater
 */
public class DAORecords {

    private final String fileName = "recordsdata.txt";
    private List<Records> myList;

    public DAORecords() {
        myList = new ArrayList();

        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAORecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Records records) {
        //code to add a records object
        myList.add(records);
        writeList();
    }

    public Records retrieve(int id) {
        //return a single records record from the list or null if it doesn't exist
        //return null;
        for (Records records : myList) {
            if (records.getId() == id) {
                return records;
            }

        }
        return null;
    }

    public void update(Records records) {
        for (Records r : myList) {
            if (r.getId() == records.getId()) {
                r.setName(records.getName());
                r.setPlace(records.getPlace());
                r.setRecord(records.getRecord());
                r.setWinnings(records.getWinnings());
                break;
            }
        }
    }

    public void delete(int id) {
        Records myRecords = null;
        for (Records r : myList) {
            if (r.getId() == id) {
                myRecords = r;
                break;
            }
        }
        myList.remove(myRecords);
        writeList();
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Records::getId));
        return this.toString();
    }

    public String orderByName() {
        myList.sort(Comparator.comparing(Records::getName));
        return this.toString();
    }

    public String orderByRecord() {
        myList.sort(Comparator.comparing(Records::getRecord));
        return this.toString();
    }

    public String orderByWinnings() {
        myList.sort(Comparator.comparing(Records::getRecord).reversed());
        return this.toString();
    }

    public String orderByPlace() {
        myList.sort(Comparator.comparing(Records::getPlace).reversed());
        return this.toString();
    }

    private void readList() {

        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String record = data[2];
                int place = Integer.parseInt(data[3]);
                double winnings = Double.parseDouble(data[4]);
                Records myrecords = new Records(id, name, record, place, winnings);
                myList.add(myrecords);

            }

        } catch (IOException ex) {
            Logger.getLogger(DAORecords.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Records records : myList) {
                writer.write(String.format("%d,%s,%s,%d,%.2f\n",
                        records.getId(),
                        records.getName(),
                        records.getRecord(),
                        records.getPlace(),
                        records.getWinnings()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAORecords.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Statistics() {
        double[] statistics = new double[100];
        int count = 0;
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String thing;
            while ((thing = reader.readLine()) != null) {
                String[] data = thing.split(",");
                double winnings = Double.parseDouble(data[4]);
                statistics[count] = winnings;
                count++;
            }
        } catch (IOException ex) {
            Logger.getLogger(DAORecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(count);
        double sum = 0;
        double max = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if (statistics[i] >= max) {
                max = statistics[i];
            }
            if (statistics[i] <= min) {
                min = statistics[i];
            }
            sum = statistics[i] + sum;
        }
        double average = (sum / count);
        System.out.println("The maximum winnings was " + max);
        System.out.println("The lowest winnings was " + min);
        System.out.println("The sum of the winnings was " + sum);
        System.out.println("The average of the winnings was " + average);

        double total = 0;
        double deviation = 0;
        for (int i = 0; i < count; i++) {
            total += Math.pow((statistics[i] - average), 2);

        }
        deviation = Math.sqrt(total / count);
        System.out.println("The standard deviation is " + deviation);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Records records : myList) {
            sb.append(records).append("\n");
        }
        return sb.toString();
    }

}
