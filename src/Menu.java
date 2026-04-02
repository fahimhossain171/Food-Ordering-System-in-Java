import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu extends ShowMenu
{
    @Override
    public void burgerMenu()
    {
        try
        {
            File file =new File("Burger.txt");
            Scanner reader=new Scanner(file);
            System.out.println("\n=========== Burger MENU ===========");
            System.out.printf("%-5s %-20s %-10s\n", "ID", "NAME", "PRICE");
            System.out.println("-----------------------------------");

            while (reader.hasNextLine())
            {
                String line=reader.nextLine();
                String[] data=line.split("\\s+");
                System.out.printf("%-5s %-20s %-10s\n",data[0],data[1],data[2]);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Menu file not found");
        }
    }

    @Override
    public void pizzaMenu()
    {
        try
        {
            File file = new File("Pizza.txt");
            Scanner reader=new Scanner(file);

            System.out.println("\n================== PIZZA MENU ==================");
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

    @Override
    public void drinkMenu()
    {
        try
        {
            File file = new File("Drink.txt");
            Scanner reader=new Scanner(file);

            System.out.println("\n================ Drink MENU ================");
            System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "NAME", "SIZE(mL)", "PRICE");
            System.out.println("--------------------------------------------");

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


}
