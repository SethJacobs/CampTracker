

/*this class represents camper in a camp and
 the information needed about them
 */



public class Camper {

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public double getMoneyOwes() {
        return moneyOwes;
    }

    public void setMoneyOwes(double moneyOwes) {
        this.moneyOwes = moneyOwes;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        session = session;
    }

    public void setNotes(String notes)
    {
        this.notes=notes;
    }

    public String getNotes()
    {
        return notes;
    }
    double moneyPaid;
    double moneyOwes;
    String firstName;
    String lastName;
    String session;
    String notes;




    public Camper(String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return
                "moneyPaid=" + moneyPaid +
                ", moneyOwes=" + moneyOwes +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", session='" + session + '\'';
    }
}
