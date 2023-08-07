package addressbook;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
    JLabel l1;
    JButton btn1, btn2, btn3, btn4, btn5;
    JPanel p1, p2;
    Font f1, f2;
 
    Home() {
        super("AddressBook Options");
        setLocation(400, 300);
        setSize(530, 250);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 30);

        l1 = new JLabel("Phone Book");

        btn1 = new JButton("Insert");
        btn2 = new JButton("Update");
        btn3 = new JButton("Delete");
        btn4 = new JButton("Search");
        btn5 = new JButton("Exit");

        l1.setHorizontalAlignment(JLabel.CENTER);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

        l1.setFont(f2);
        btn1.setFont(f1);
        btn2.setFont(f1);
        btn3.setFont(f1);
        btn4.setFont(f1);
        btn5.setFont(f1);

        // Creating Panel for layout
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1, 10, 10));
        p1.add(btn1);
        p1.add(btn2);
        p1.add(btn3);
        p1.add(btn4);
        p1.add(btn5);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l1);

        setLayout(new BorderLayout(10, 20));
        add(p1, "East");
        add(p2, "Center");

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){
            this.setVisible(false);
            new EntryData().setVisible(true);
//          System.out.println("Enter Data clicked");

        } else if(e.getSource() == btn2){
            this.setVisible(false);
            new updateData().setVisible(true);
//          System.out.println("Enter Update clicked");

        } else if(e.getSource() == btn3){
            this.setVisible(false);
            new deleteData().setVisible(true);
//          System.out.println("Enter Delete clicked");

        }else if(e.getSource() == btn4){
            this.setVisible(false);
            new SearchData().setVisible(true);
//          System.out.println("Enter search clicked");

        }else{
            this.setVisible(false);
//          System.out.println("Enter exit clicked");
        }
    }
    public static void main(String[] args) {
        new Home().setVisible(true);
    }
}
