
import AdminPanel.Admin;

import java.io.IOException;
import java.util.Scanner;

public class Customer extends Menu
{
    protected String customerName;
    protected String customerPhone;

    Scanner sc= new Scanner(System.in);

    public Customer() throws IOException {
        System.out.print("Enter your Name: ");
        customerName=sc.nextLine();
        System.out.print("Enter your Phone number: ");
        customerPhone=sc.nextLine();

        if(customerName.equals("admin") && customerPhone.equals("admin"))
        {
            System.out.println("\n");
            Admin.callMenuEdit();
        }
        else
        {
            System.out.println("\n");
            System.out.println("Welcome "+customerName+"\n");
            Order order=new Order(customerName,customerPhone);
        }
    }
}
