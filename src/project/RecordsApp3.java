package project;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 55slaterbc30
 */
public class RecordsApp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       DAORecords data = new DAORecords();
        System.out.print(data);

        
        
        
        
        //Do these commands once then exit. Then comment out and run again to see if data was saved
      //data.create(new Records(1, "Mean Greene", "0-5", 10, 0));
      //data.create(new Records(2, "Buff Biff", "5-0", 1, 50));
       // System.out.print(data);
               
    }
}
