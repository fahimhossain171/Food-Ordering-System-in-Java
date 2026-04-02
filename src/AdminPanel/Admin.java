package AdminPanel;

import java.io.IOException;
import java.util.Scanner;

public class Admin
{
    public static Scanner sc =new Scanner(System.in);

    private static void menuEdit() throws IOException
    {

        System.out.println("-----------WELCOME TO MENU EDIT OPTIONS-----------");
        System.out.println("\nWelcome Admin\n");
        System.out.println("1. Edit Burgers Menu");
        System.out.println("2. Edit Pizza Menu");
        System.out.println("3. Edit Drinks Menu");
        System.out.println("4. Exit");
        System.out.printf("\n\nEnter your Choice: ");

        int choice= sc.nextInt();

        switch(choice)
        {
            case 1:

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("1. Add Burger");
                System.out.println("2. View Burger Menu");
                System.out.println("3. Delete Burger");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice2= sc.nextInt();

                switch (choice2)
                {
                    case 1:
                        Burger.addBurger();
                        break;
                    case 2:
                        Burger.viewBurgerMenu();
                        break;
                    case 3:
                        Burger.deleteBurger();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("You enter invalid choice");
                }

                break;

            case 2:

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("1. Add Pizza");
                System.out.println("2. View Pizza Menu");
                System.out.println("3. Delete Pizza");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice3= sc.nextInt();

                switch (choice3)
                {
                    case 1:
                        Pizza.addPizza();
                        break;
                    case 2:
                        Pizza.viewPizzaMenu();
                        break;
                    case 3:
                        Pizza.deletePizza();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("You enter invalid choice");
                }
                break;
            case 3:

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("1. Add Drink");
                System.out.println("2. View Drink Menu");
                System.out.println("3. Delete Drink");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice4= sc.nextInt();

                switch (choice4)
                {
                    case 1:
                        Drink.addDrink();
                        break;
                    case 2:
                        Drink.viewDrinkMenu();
                        break;
                    case 3:
                        Drink.deleteDrink();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("You enter invalid choice");
                }
                break;
            case 4:
                return;
            default:
                System.out.println("You enter invalid choice");
        }
    }

    public static void callMenuEdit() throws IOException {
        menuEdit();
    }


}

