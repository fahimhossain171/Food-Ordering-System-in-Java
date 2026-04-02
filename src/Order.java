import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Order
{
    String customerName;
    String customerPhone;
    public Order(String customerName,String customerPhone)
    {
        this.customerName=customerName;
        this.customerPhone=customerPhone;

        Menu menu=new Menu();
        System.out.println("We Hava Burger  Pizza  Drinks\n");
        System.out.println("1. Only one Type\n2. Two Type\n3. All Three Type\n");
        System.out.print("How many types of items do you want to Order: ");
        int type=Items.sc.nextInt();
        if(type==1)
        {
            System.out.println("\n");
            System.out.println("=========== FOOD MENU ===========");
            System.out.println("1. Burger Menu");
            System.out.println("2. Pizza Menu");
            System.out.println("3. Drinks Menu");
            System.out.print("Enter you choice: ");
            int choice=Items.sc.nextInt();

            switch (choice)
            {
                case 1:
                menu.burgerMenu();
                orderItem("Burger.txt");
                break;

                case 2:
                menu.pizzaMenu();
                orderItem("Pizza.txt");
                break;

                case 3:
                menu.drinkMenu();
                orderItem("Drink.txt");
                break;

                default:
                System.out.println("You entered invalid choice");
            }
        }
        else if(type==2)
        {
            System.out.println("\n");
            System.out.println("=========== FOOD MENU ===========");
            System.out.println("1. Burger & Pizza Menu");
            System.out.println("2. Pizza & Drinks Menu");
            System.out.println("3. Burger & Drinks Menu");
            System.out.print("Enter you choice: ");
            int choice=Items.sc.nextInt();

            switch (choice)
            {
                case 1:

                    orderItem("Burger.txt","Pizza.txt");
                    break;
                case 2:
                    orderItem("Pizza.txt","Drink.txt");
                    break;
                case 3:
                    orderItem("Burger.txt","Drink.txt");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
        else if(type==3)
        {
            System.out.println("\n");
            orderItem("Burger.txt","Pizza.txt","Drink.txt");
        }

        else
        {
            System.out.println("You entered invalid option !!");
        }
    }


    public void orderItem(String filename)
    {
        try
        {
            File file =new File(filename);
            Scanner reader=new Scanner(file);

            System.out.print("\nEnter item ID: ");
            int id=Items.sc.nextInt();

            System.out.print("\nEnter Quantity: ");
            int qty=Items.sc.nextInt();

            while (reader.hasNextLine())
            {
                String line=reader.nextLine();
                String[] data =line.split("\\s+");

                int itemID=Integer.parseInt(data[0]);

                if(itemID==id)
                {
                    String name =data[1];
                    double price;
                    if(data.length==3)
                    {
                        price=Double.parseDouble(data[2]);
                    }
                    else
                    {
                        price=Double.parseDouble(data[3]);
                    }

                    double total=price*qty;
                    System.out.println("\n======= ORDER SUMMARY =======");
                    System.out.println("Customer Name: "+customerName);
                    System.out.println("Phone Number: "+customerPhone+"\n");
                    System.out.println("Item: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty);
                    System.out.println("Total Bill: " + total + " Tk");
                    reader.close();
                    return;


                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Item not found");
        }
    }


    public void orderItem(String filename1,String filename2)
    {
        Menu menu=new Menu();
        double grandTotal=0;

        try {
            if (filename1.equals("Burger.txt")) {
                menu.burgerMenu();
            } else if (filename1.equals("Pizza.txt")) {
                menu.pizzaMenu();
            } else {
                menu.drinkMenu();
            }

            File file1 = new File(filename1);
            Scanner reader1 = new Scanner(file1);

            System.out.print("\nEnter item ID: ");
            int id1 = Items.sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty1 = Items.sc.nextInt();

            while (reader1.hasNextLine()) {
                String line = reader1.nextLine();
                String[] data = line.split("\\s+");

                int itemID = Integer.parseInt(data[0]);

                if (itemID == id1)
                {
                    String name = data[1];
                    double price;

                    if (data.length == 3)
                    {
                        price = Double.parseDouble(data[2]);
                    } else {
                        price = Double.parseDouble(data[3]);
                    }

                    double total1 = price * qty1;
                    grandTotal += total1;

                    System.out.println("\nItem: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty1);
                    System.out.println("Total: " + total1 + " Tk");

                    break;
                }
            }

            reader1.close();

            if (filename2.equals("Burger.txt"))
            {
                menu.burgerMenu();
            } else if (filename2.equals("Pizza.txt"))
            {
                menu.pizzaMenu();
            }
            else
            {
                menu.drinkMenu();
            }

            File file2 = new File(filename2);
            Scanner reader2 = new Scanner(file2);

            System.out.print("\nEnter item ID: ");
            int id2 = Items.sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty2 = Items.sc.nextInt();

            while (reader2.hasNextLine())
            {
                String line = reader2.nextLine();
                String[] data = line.split("\\s+");

                int itemID = Integer.parseInt(data[0]);

                if(itemID == id2)
                {
                    String name = data[1];
                    double price;

                    if(data.length == 3)
                        price = Double.parseDouble(data[2]);
                    else
                        price = Double.parseDouble(data[3]);

                    double total2 = price * qty2;
                    grandTotal += total2;

                    System.out.println("\nItem: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty2);
                    System.out.println("Total: " + total2 + " Tk");

                    break;
                }
            }

            reader2.close();

            System.out.println("\n=========== FINAL BILL ===========");
            System.out.println("Customer Name: "+customerName);
            System.out.println("Phone Number: "+customerPhone);
            System.out.println("Grand Total: " + grandTotal + " Tk");
        }
        catch (IOException e)
        {
            System.out.println("Error reading menu file");
        }
    }


    public void orderItem(String filename1,String filename2,String filename3)
    {
        Menu menu=new Menu();
        double grandTotal=0;

        try
        {
            menu.burgerMenu();
            File file1= new File(filename1);
            Scanner reader1=new Scanner(file1);

            System.out.print("\nEnter item ID: ");
            int id1=Items.sc.nextInt();
            System.out.print("\nEnter Quantity: ");
            int qty1=Items.sc.nextInt();

            while (reader1.hasNextLine())
            {
                String line1=reader1.nextLine();
                String[] data= line1.split("\\s+");

                int itemID=Integer.parseInt(data[0]);

                if(itemID==id1)
                {
                    String name=data[1];
                    double price;
                    price=Double.parseDouble(data[2]);

                    double total1=price*qty1;
                    grandTotal+=total1;

                    System.out.println("\nItem: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty1);
                    System.out.println("Total: " + total1 + " Tk");

                    break;
                }
            }
            reader1.close();

            menu.pizzaMenu();
            File file2=new File(filename2);
            Scanner reader2=new Scanner(file2);

            System.out.print("\nEnter item ID: ");
            int id2 = Items.sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty2 = Items.sc.nextInt();

            while(reader2.hasNextLine())
            {
                String line=reader2.nextLine();
                String[] data=line.split("\\s+");

                int itemID = Integer.parseInt(data[0]);

                if(itemID==id2)
                {
                    String name=data[1];
                    double price;

                    price=Double.parseDouble(data[3]);

                    double total2=price*qty2;
                    grandTotal+=total2;

                    System.out.println("\nItem: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty2);
                    System.out.println("Total: " + total2 + " Tk");

                    break;
                }
            }

            reader2.close();


            menu.drinkMenu();
            File file3=new File(filename3);
            Scanner reader3=new Scanner(file3);

            System.out.print("\nEnter item ID: ");
            int id3 = Items.sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty3 = Items.sc.nextInt();

            while (reader3.hasNextLine())
            {
                String line=reader3.nextLine();
                String[] data=line.split("\\s+");

                int itemID=Integer.parseInt(data[0]);

                if ((itemID==id3))
                {
                    String name= data[1];
                    double price;

                    price=Double.parseDouble(data[3]);

                    double total3=price*qty3;
                    grandTotal+=total3;

                    System.out.println("\nItem: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + qty2);
                    System.out.println("Total: " + total3 + " Tk");

                    break;
                }
            }

            reader3.close();

            System.out.println("\n=========== FINAL BILL ===========");
            System.out.println("Customer Name: "+customerName);
            System.out.println("Phone Number: "+customerPhone);
            System.out.println("Grand Total: " + grandTotal + " Tk");



        }
        catch (IOException e)
        {
            System.out.println("Error reading menu file");
        }


    }
}
