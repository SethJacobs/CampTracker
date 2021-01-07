import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Camp {

    HashMap<String, Camper> firstNameMap= new HashMap<String, Camper>();
    HashMap<String, Camper> lastNameMap= new HashMap<String, Camper>();
    LinkedList<Camper> allCampers= new LinkedList<Camper>();
    LinkedList<Camper> stillOweList = new LinkedList<Camper>();
    LinkedList<Camper> allPaid= new LinkedList<Camper>();
    LinkedList<Camper> firstMonth = new LinkedList<Camper>();
    LinkedList<Camper> secondMonth=new LinkedList<Camper>();

    double totalOwed=0;
    double totalPaid=0;


    public void addCamper(String firstName, String lastName, double paid, double owed, String months)
    {
        Camper camper= new Camper(firstName, lastName);

        camper.moneyOwes=owed;
        camper.moneyPaid=paid;
        camper.session=months;
        firstNameMap.put(firstName, camper);
        lastNameMap.put(lastName, camper);
        allCampers.add(camper);
        if(camper.getMoneyOwes()-camper.getMoneyPaid()>0)
        {
            stillOweList.add(camper);
        }
        if(camper.getMoneyPaid()-camper.getMoneyOwes()<=0)
        {
            allPaid.add(camper);
        }

        totalOwed=totalOwed+camper.getMoneyOwes();

        totalPaid=totalPaid+camper.getMoneyPaid();

        if(camper.getSession().equals("1st"))
        {
            firstMonth.add(camper);
        }
        if(camper.getSession().equals("2nd"))
        {
            secondMonth.add(camper);
        }

        if(camper.getSession().equals("1st & 2nd"))
        {
            firstMonth.add(camper);
            secondMonth.add(camper);
        }

    }

    public Camper getCamperByFirstName(String firstName)
    {
        return firstNameMap.get(firstName);
    }

    public Camper getCamperByLastName(String lastName)
    {
        return lastNameMap.get(lastName);
    }

    public List<Camper> getStillOwes()
    {
        return stillOweList;
    }

    public List<Camper> getAllPaid()
    {
        return allPaid;
    }

    public List<Camper> getAllCampers()
    {
        return allCampers;
    }

    public void deleteCamper(Camper camper)
    {
        if(firstNameMap.get(camper.getFirstName())!=null)
        {
            firstNameMap.remove(camper.getFirstName());
            lastNameMap.remove(camper.getLastName());
        }
        if(stillOweList.contains(camper))
        {
            stillOweList.remove(camper);
        }
    }

    public void printAllCampers()
    {
        for(Camper camper: firstNameMap.values())
        {
            System.out.println(camper);
        }
    }

}
