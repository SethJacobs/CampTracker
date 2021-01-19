import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitCamper implements ActionListener {

    Camp Yagilu;
    String firstName;
    String lastName;
    double paid;
    double owed;
    String session;

    public SubmitCamper(Camp Yagilu, String firstName, String lastName, double paid, double owed, String session)
    {
        this.Yagilu=Yagilu;
        this.firstName=firstName;
        this.lastName=lastName;
        this.paid=paid;
        this.owed=owed;
        this.session=session;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
       // String firstNameText = firstName.getText();
        //String lastNameText= lastName.getText();
        //String paidText = paid.getText();
        //String owedText= owed.getText();
        //String sessionText= session.getText();

       // double paidDouble = Double.parseDouble(paidText);
        //double owedDouble = Double.parseDouble(owedText);

        Yagilu.addCamper(firstName, lastName, paid, owed, session);
    }
}