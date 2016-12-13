/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author 55slaterbc301
 */
public class RecordsAppMenu {

    Scanner sc = new Scanner(System.in);
    DAORecords data = new DAORecords();

    public RecordsAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        String record;
        int place;
        double winnings;

        while (choice != 0) {
            System.out.println("\nRecordsApp");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record ");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All : Ordered by ID");
            System.out.println("7 = Retrieve All : Ordered by name");
            System.out.println("8 = Retrieve All : Ordered by record");
            System.out.println("9 = Retrieve All : Ordered by place");
            System.out.println("10 = Retrieive All : Ordered by winnings");
            System.out.println("11 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 11);
            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter record ID: ");
                name = Prompt.getLine("Enter the name: ");
                record = Prompt.getLine("Enter the W-L record: ");
                place = Prompt.getInt("Enter the place: ");
                winnings = Prompt.getDouble("Enter the winnings: ");
                Records records = new Records(id, name, record, place, winnings);
                data.create(records);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter ID: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {
                System.out.println("Enter Record ID to delete: ");
                id = Integer.parseInt(sc.nextLine());
                data.delete(id);
            }else if(choice == 6){
                System.out.println(data.orderById());
            } else if(choice == 7){
                System.out.println(data.orderByName());
            }else if(choice == 8){
                System.out.println(data.orderByPlace());
            }else if (choice == 9){
                System.out.println(data.orderByRecord());
            }else if (choice == 10){
                System.out.println(data.orderByWinnings());
            }else if (choice == 11){
                data.Statistics();
            }
            
            else if (choice == 0) {
                ;
            } else {
                System.out.println("Please enter an integer between 0 and 11");
            }

        }

    }
    public static void main(String[] args) {
        new RecordsAppMenu();
    }
}
