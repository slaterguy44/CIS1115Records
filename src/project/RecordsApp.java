/*
 
 */

/**
 *
 * @author 55slaterbc30
 */
package project;





public class RecordsApp {
    public static void main(String[] args) {
        Records p1 = new Records();
        p1.setId(1);
        p1.setName("John Doe");
        p1.setPlace(1);
        p1.setRecord("5"+"-" +"0");
        p1.setWinnings(49.93);
        System.out.println(p1);
        Records p2 = new Records();
        p2.setId(2);
        p2.setName("Jane Doe");
        p2.setPlace(2);
        p2.setRecord("4-"+"1");
        p2.setWinnings(35.24);
        System.out.println(p2);
         

    }
}
