package addressbook;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.sql.*;
import javax.swing.*;

public class EntryData extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton btn1,btn2;
    JPanel p1,p2;
    Font f1,f2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;

    public EntryData(){
        super("Inster Record To AddressBook");
        setLocation(400,50);
        setSize(600, 600);
        
        f1 = new Font("Arial",Font.BOLD,15); //font Size 
        f2 = new Font("Arial",Font.BOLD,40); //font Size 
        
        l1 = new JLabel("Add Contect Details"); // Center Label 
        
        l2 = new JLabel("Enter Name:");
        l3 = new JLabel("Enter Home Address:");
        l4 = new JLabel("Enter Phone Number:");
        l5 = new JLabel("Enter Business Address:");
        l6 = new JLabel("Enter Phone Number (Business):");
        l7 = new JLabel("Enter Fax Number:");
        l8 = new JLabel("Enter cellular phone:");
        l9 = new JLabel("Enter Pager:");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

        btn1 = new JButton("Insert Contect");
        btn2 = new JButton("Back");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        l1.setFont(f2);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);

        btn1.setFont(f1);
        btn2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(10,2,10,20));
        
        p2.add(l2);
        p2.add(t1);
        
        p2.add(l3);
        p2.add(t2);
        
        p2.add(l4);
        p2.add(t3);
        
        p2.add(l5);
        p2.add(t4);
        
        p2.add(l6);
        p2.add(t5);
        
        p2.add(l7);
        p2.add(t6);
        
        p2.add(l8);
        p2.add(t7);
        
        p2.add(l9);
        p2.add(t8);
        
        p2.add(btn1);
        p2.add(btn2);
        
        setLayout(new BorderLayout(9,20));
        add(p1,"North");
        add(p2,"Center");

    }
    public void actionPerformed (ActionEvent e){
        String name = t1.getText();
        String homeAddress = t2.getText();
        String phoneNumber = t3.getText();
        String businessAddress = t4.getText();
        String bphoneNumber = t5.getText();
        String faxNum = t6.getText();
        String cellPhone = t7.getText();
        String pager = t8.getText();
        
        if(e.getSource() == btn1){
            try{
                Connection obj = new Connection();
                String query = "insert into addContect(name,homeAddress,phoneNumber,businessAddress,bphoneNumber,faxNum,cellPhone,pager) values('"+name+"','"+homeAddress+"','"+phoneNumber+"','"+businessAddress+"','"+bphoneNumber+"','"+faxNum+"','"+cellPhone+"','"+pager+"')";
                
                int check = obj.stmt.executeUpdate(query);
                
                if(check == 1){ // Check that if check retuen 1 means true
                    JOptionPane.showMessageDialog(null, "Record Inserted Successfully!!!");
                    this.setVisible(false);
                    new Home().setVisible(true);
                }else{
                     JOptionPane.showMessageDialog(null, "There is some issues to add your data please try again...!");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        if(e.getSource() == btn2){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new EntryData().setVisible(true);
    }
    
}
