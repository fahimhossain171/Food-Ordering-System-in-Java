package AdminPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pizza
{
    public static void addPizza() throws IOException
    {
        try
        {
            FileWriter writer= new FileWriter("Pizza.txt",true);

            System.out.print("Enter ID: ");
            int id =Admin.sc.nextInt();
            Admin.sc.nextLine();

            System.out.print("Enter Name: ");
            String name= Admin.sc.nextLine();

            System.out.print("Enter Pizza size: ");
            String size=Admin.sc.nextLine();

            System.out.print("Enter Price: ");
            double price= Admin.sc.nextDouble();


            File file = new File("Pizza.txt");
            Scanner reader=new Scanner(file);

            while(reader.hasNextLine())
            {
                String line=reader.nextLine();
                if(line.startsWith(id+""))
                {
                    System.out.println(id+" already exist");
                    reader.close();
                    writer.close();
                    return;
                }
            }

            reader.close();
            writer.write(id+"\t\t"+name+"\t\t"+size+"\t\t"+price+"\n");
            writer.close();
            System.out.println("Pizza Added Successfully");
        }
        catch (IOException e)
        {
            System.out.println("Error in writing file");
        }

    }

    public static void viewPizzaMenu()
    {
        try
        {
            File file = new File("Pizza.txt");
            Scanner reader=new Scanner(file);

            System.out.println("\n=========== PIZZA MENU ===========");
            System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "NAME", "SIZE", "PRICE");
            System.out.println("------------------------------------------------");

            while (reader.hasNext())
            {
                String line= reader.nextLine();
                String[] data=line.split("\\s+");

                System.out.printf("%-5s %-20s %-10s %-10s\n",data[0],data[1],data[2],data[3]);

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Menu file not found");
        }

    }

    public static void deletePizza() throws IOException
    {
        System.out.print("Enter ID to delete: ");
        int deleteID=Admin.sc.nextInt();

        File inputFile= new File("Pizza.txt");
        File tempFile= new File("Temp.txt");

        Scanner reader=new Scanner(inputFile);
        FileWriter writer =new FileWriter(tempFile);


        while (reader.hasNextLine())
        {
            String line = reader.nextLine();

            if(!line.startsWith(deleteID+""))
            {
                writer.write(line+"\n");
            }
        }

        reader.close();
        writer.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Item Deleted");
    }
}
