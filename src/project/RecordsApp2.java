package project;

/*

 */

/**
 *
 * @author 55slaterbc30
 */
public class RecordsApp2 {
    public static void main(String[] args) {
        DAORecords data = new DAORecords();
        data.create(new Records(3,"John Doe", "5-0", 1, 49.93));
        data.create(new Records(4, "Jane Doe", "4-1", 2, 35.24));
        data.create(new Records(4, "Joe Doe", "4-1", 3, 18.75));
        data.create(new Records(5, "Greg Kinneer", "3-2", 4, 15.22));
        data.create(new Records(6, "Griffin Mcelroy", "3-2", 5, 9.35));
        
        System.out.println(data);
        System.out.println(data.retrieve(2));
        System.out.println(data.retrieve(-1));
        data.update(new Records(2, "Marmaduke", "4-1", 2, 40.85 ));
        System.out.println(data.retrieve(2));
        data.delete(3);
        System.out.println(data);
    }
}
