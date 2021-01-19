import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCamper implements ActionListener {

    addCamper thisClass;
    JFrame frame;
    JButton addCamper;
    JButton findCamper;
    JButton removeCamper;
    JButton printCamper;
    JButton getPaid;
    JButton getOwes;
    JButton editCamper;
    JButton editCampeNotes;
    JButton fake;
    Camp Yagilu;

    public addCamper(JFrame frame, JButton addCamper, JButton findCamper, JButton removeCamper, JButton printCamper, JButton getPaid, JButton getOwes,
             JButton editCamper, JButton editCampeNotes, JButton fake, Camp Yagilu)
    {
        this.frame=frame;
        this.addCamper=addCamper;
        this.findCamper=findCamper;
        this.removeCamper=removeCamper;
        this.printCamper=printCamper;
        this.getPaid=getPaid;
        this.getOwes=getOwes;
        this.editCamper=editCamper;
        this.editCampeNotes=editCampeNotes;
        this.fake=fake;
        this.Yagilu=Yagilu;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(addCamper==null || findCamper==null || removeCamper==null || printCamper==null || getPaid==null || getOwes==null || editCamper==null || editCampeNotes==null)
        {
            System.out.println("nope");
        }
        else {
            addCamper.setVisible(false);
            findCamper.setVisible(false);
            removeCamper.setVisible(false);
            printCamper.setVisible(false);
            getPaid.setVisible(false);
            getOwes.setVisible(false);
            editCamper.setVisible(false);
            editCampeNotes.setVisible(false);
            fake.setVisible(false);
            System.out.println("pushed");
        }

        System.out.println("add to frame");
        JLabel enterName=new JLabel("enter first name");
        enterName.setBounds(10,40,200, 25);
        frame.add(enterName);
        enterName.setVisible(true);
        JLabel enterLastName=new JLabel("enter last name");
        enterLastName.setBounds(10,60,200, 25);
        frame.add(enterLastName);
        JLabel enterPaid=new JLabel("enter amount paid");
        enterPaid.setBounds(10,80,200, 25);
        frame.add(enterPaid);
        JLabel enterOwed=new JLabel("enter amount owed");
        enterOwed.setBounds(10,100,200, 25);
        frame.add(enterOwed);
        JLabel enterSession=new JLabel("Which Session 1st, 2nd, or 1st & 2nd");
        enterSession.setBounds(10,120,300, 25);
        frame.add(enterSession);
        JLabel fake=new JLabel("");
        fake.setBounds(10,140,200,25);
        frame.add(fake);
        JTextField firstName=new JTextField();
        firstName.setBounds(330,40,200,25);
        frame.add(firstName);
        JTextField lastName=new JTextField();
        lastName.setBounds(330,60,200,25);
        frame.add(lastName);
        JTextField paid=new JTextField();
        paid.setBounds(330,80,200,25);
        frame.add(paid);
        JTextField owed=new JTextField();
        owed.setBounds(330,100,200,25);
        frame.add(owed);
        JTextField session=new JTextField();
        session.setBounds(330,120,200,25);
        frame.add(session);
        JTextField secondFake = new JTextField();
        frame.add(secondFake);


        JButton submit = new JButton("submit");
        submit.setBounds(20, 230,200,25);
        frame.add(submit);
        JButton fakeButton = new JButton("");
        fakeButton.setBounds(40,250,200,25);
        frame.add(fakeButton);
        submit.addActionListener(new SubmitCamper(Yagilu, firstName.getText(), lastName.getText(), Double.parseDouble(paid.getText()), Double.parseDouble(owed.getText()),session.getText()));



    }
}