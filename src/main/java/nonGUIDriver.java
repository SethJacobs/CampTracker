

import java.io.FileWriter;
import java.util.Scanner;

public class nonGUIDriver {

    static Camp Yagilu = new Camp();
    static SaveFile saveFile= new SaveFile();
    static ReadFile readFile= new ReadFile();


    public static void printOptions()
    {
        System.out.println("A: add camper");
        System.out.println("B: find camper by his first name");
        System.out.println("C: find camper by his last name");
        System.out.println("D: remove camper");
        System.out.println("E: print all campers");
        System.out.println("F: get everyone who is all paid");
        System.out.println("G: get everyone who still owes");
        System.out.println("H: Edit camper payment information");
        System.out.println("I: Edit notes on camper");
        System.out.println("S: save and exit");




        Scanner scanner = new Scanner(System.in);
        String chosen=scanner.nextLine().toLowerCase().trim();
        if(chosen.equals("a"))
        {
            System.out.println("Enter camper first name ");
            scanner = new Scanner(System.in);
            String firstName=scanner.nextLine().trim();
            System.out.println("Enter last name");
            scanner = new Scanner(System.in);
            String lastName=scanner.nextLine().trim();

            System.out.println("Enter how much have they paid");
            scanner = new Scanner(System.in);
            double paid= Double.parseDouble(scanner.nextLine());

            System.out.println("Enter how much they owe");
            scanner = new Scanner(System.in);
            double owed= Double.parseDouble(scanner.nextLine());

            System.out.println("Which Session 1st, 2nd, or 1st & 2nd");
            scanner = new Scanner(System.in);
            String session=scanner.nextLine().trim();

            Yagilu.addCamper(firstName,lastName, paid, owed, session);
            printOptions();


        }
        if(chosen.equals("b"))
        {
            System.out.println("Enter first name of camper");
            scanner = new Scanner(System.in);
            String firstName=scanner.nextLine().trim();
            Camper camper= Yagilu.getCamperByFirstName(firstName);
            if(camper==null)
            {
                System.out.println("camper not in system");
                printOptions();
            }
            System.out.println(camper);
            printOptions();
        }
        if(chosen.equals("c"))
        {
            System.out.println("Enter last name of camper");
            scanner = new Scanner(System.in);
            String lastName=scanner.nextLine().trim();
            Camper camper= Yagilu.getCamperByFirstName(lastName);
            if(camper==null)
            {
                System.out.println("camper not in system");
                printOptions();
            }
            System.out.println(camper);
            printOptions();
        }
        if(chosen.equals("d"))
        {
            System.out.println("Enter first name of camper");
            scanner = new Scanner(System.in);
            String firstName=scanner.nextLine().trim();
            Camper camper= Yagilu.getCamperByFirstName(firstName);
            if(camper==null)
            {
                System.out.println("camper not in system ");
            }
            Yagilu.deleteCamper(camper);
            printOptions();
        }
        if(chosen.equals("e"))
        {
            Yagilu.printAllCampers();
            printOptions();
        }
        if(chosen.equals("f"))
        {
            System.out.println(Yagilu.getAllPaid());
            printOptions();
        }
        if(chosen.equals("g"))
        {
            System.out.println(Yagilu.getStillOwes());
            printOptions();
        }
        if(chosen.equals("h"))
        {
            System.out.println("Enter first name of camper");
            scanner = new Scanner(System.in);
            String firstName=scanner.nextLine().trim();
            Camper camper= Yagilu.getCamperByFirstName(firstName);
            if(camper==null)
            {
                System.out.println("camper not in system");
                printOptions();
            }
            System.out.println("Paid or owes more");
            scanner = new Scanner(System.in);
            String choice=scanner.nextLine().trim();
            if(choice.equals("paid"))
            {
                System.out.println("how much did he pay");
                scanner = new Scanner(System.in);
                double paid= Double.parseDouble(scanner.nextLine().trim());
                System.out.println("he has previously paid "+ camper.getMoneyPaid());
                camper.setMoneyPaid(camper.getMoneyPaid()+paid);
                System.out.println("his total paid is " +camper.getMoneyPaid());
                printOptions();
            }
            if(choice.equals("owes more"))
            {
                System.out.println("how much more do they owe");
                scanner = new Scanner(System.in);
                double owes= Double.parseDouble(scanner.nextLine().trim());
                System.out.println("he has previously owed "+ camper.getMoneyOwes());
                camper.setMoneyOwes(camper.getMoneyOwes()+owes);
                System.out.println("his total owed is " +camper.getMoneyPaid());
                printOptions();
            }
        }
        if(chosen.equals("i"))
        {
            System.out.println("Enter first name of camper");
            scanner = new Scanner(System.in);
            String firstName=scanner.nextLine().trim();
            Camper camper= Yagilu.getCamperByFirstName(firstName);
            if(camper==null)
            {
                System.out.println("camper not in system");
                printOptions();
            }
            System.out.println("Enter note");
            scanner = new Scanner(System.in);
            String note=scanner.nextLine().trim();
            if(camper.getNotes()!=null)
            {
                camper.setNotes(camper.getNotes()+note);
            }
            else
            {
                camper.setNotes(note);
            }
            printOptions();
        }
        if ((chosen.equals("s")))
        {
            try {
                String dir= System.getProperty("user.dir");
                saveFile.writeExcel(Yagilu.getAllCampers(), dir+"Yagilu");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("pick a valid option");
            printOptions();
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Camp Tracker\n\n");
        try
        {
            String dir= System.getProperty("user.dir");
            System.out.println("Loading..");
            Yagilu.allCampers=readFile.readCamperFromExcelFile(dir+"Yagilu");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        printOptions();

    }
}
