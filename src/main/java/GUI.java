import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    static JFrame frame;
    static JButton addCamper;
    static JButton findCamper;
    static JButton removeCamper;
    static JButton printCamper;
    static JButton getPaid;
    static JButton getOwes;
    static JButton editCamper;
    static JButton editCampeNotes;
    static JButton fake;
    static Camp Yagilu;

    public static void main(String[] args)
    {
        //Creating the Frame
        frame = new JFrame("Camp Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        JMenuItem m21= new JMenuItem("Sorry cant help here");
        m2.add(m21);

        //Creating the panel at bottom and adding components
        //JPanel panel = new JPanel(); // the panel is not visible in output
       // JLabel label = new JLabel("Enter Text");
        //JTextField tf = new JTextField(10); // accepts up to 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
       // panel.add(label); // Components Added using Flow Layout
       // panel.add(tf);
        //panel.add(send);
        //panel.add(reset);
        addCamper=new JButton("add camper");
        addCamper.setBounds(50,80,200,25);
        frame.add(addCamper);
        findCamper=new JButton("find camper");
        findCamper.setBounds(50,100,200,25);
        frame.add(findCamper);
        removeCamper=new JButton("remove camper");
        removeCamper.setBounds(50,120,200,25);
        frame.add(removeCamper);
        printCamper=new JButton("print all campers");
        printCamper.setBounds(50,140,200,25);
        frame.add(printCamper);
        getPaid=new JButton("get everyone who is all paid");
        getPaid.setBounds(50,160,200,25);
        frame.add(getPaid);
        getOwes=new JButton("get everyone who still owes");
        getOwes.setBounds(50,180,200,25);
        frame.add(getOwes);
        editCamper=new JButton("edit camper info");
        editCamper.setBounds(50,200,200,25);
        frame.add(editCamper);
        editCampeNotes=new JButton("edit camper notes");
        editCampeNotes.setBounds(50,220,200,25);
        frame.add(editCampeNotes);
        fake= new JButton("");
        fake.setBounds(50,240,200,25);
        frame.add(fake);


        //Adding Components to the frame.
      //  frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        addCamper.addActionListener(new addCamper(frame, addCamper, findCamper, removeCamper, printCamper, getPaid, getOwes, editCamper, editCampeNotes, fake, Yagilu));

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("pushed");
    }
}