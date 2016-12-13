package project;

/*

 */

/**
 *
 * @author 55slaterbc30
 */
public class Records {
    private int id;
    private String name;
    private String record;
    private int place;
    private double winnings;

    public Records(){
        
    }
    
    public Records(int id, String name, String record, int place, double winnings) {
        this.id = id;
        this.name = name;
        this.record = record;
        this.place = place;
        this.winnings = winnings;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        //return "project{" + "id=" + id + ", name=" + name + ", record=" + record + ", place=" + place + ", winnings=" + winnings + '}';
     return String.format("%5d %-15s %-3s %-3d %5.2f", id, name, record, place, winnings);
    
    }
    
}
