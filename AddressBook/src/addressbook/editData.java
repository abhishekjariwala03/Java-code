package addressbook;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class editData extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9,l10;
    JButton btn1, btn2;
    JPanel p1, p2, p3;
    Font f1, f2;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8,t9;
    
    editData(){
        
    }
    
     public editData(int id){
        super("Update Record");
        setLocation(400,50);
        setSize(600, 600);
        
        f1 = new Font("Arial",Font.BOLD,15); //font Size 
        f2 = new Font("Arial",Font.BOLD,40); //font Size 
        
        l1 = new JLabel("Update Contect Details"); // Center Label 
        
        l2 = new JLabel("Enter Name:");
        l3 = new JLabel("Enter Home Address:");
        l4 = new JLabel("Enter Phone Number:");
        l5 = new JLabel("Enter Business Address:");
        l6 = new JLabel("Enter Phone Number (Business):");
        l7 = new JLabel("Enter Fax Number:");
        l8 = new JLabel("Enter cellular phone:");
        l9 = new JLabel("Enter Pager:");
        l10 = new JLabel("ID");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();

        btn1 = new JButton("Update");
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
        l10.setFont(f1);

        
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);

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
        
        p2.add(l10);
        p2.add(t9);
        
        p2.add(btn1);
        p2.add(btn2);
        
        try{
            Connection con = new Connection();
            String query = "select * from addcontect where id='" + id + "'";
            ResultSet res = con.stmt.executeQuery(query);
            
            while(res.next()){
                t9.setText(res.getString("id"));
                t1.setText(res.getString("name"));
                t2.setText(res.getString("homeAddress"));
                t3.setText(res.getString("phoneNumber"));
                t4.setText(res.getString("businessAddress"));
                t5.setText(res.getString("bphoneNumber"));
                t6.setText(res.getString("faxNum"));
                t7.setText(res.getString("cellPhone"));
                t8.setText(res.getString("pager"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        t9.setEditable(false);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){
            int Cid = Integer.parseInt(t9.getText());
            String name = t1.getText();
            String homeAddress = t2.getText();
            String phoneNumber = t3.getText();
            String businessAddress = t4.getText();
            String bphoneNumber = t5.getText();
            String faxNum = t6.getText();
            String cellPhone = t7.getText();
            String pager = t8.getText();
            
            try{
                Connection con = new Connection();
                String q = "update addcontect set name='" + name + "', homeAddress='" + homeAddress + "',phoneNumber='" + phoneNumber + "',businessAddress='" + businessAddress + "',bphoneNumber='" + bphoneNumber + "',faxNum='" + faxNum + "',cellPhone='" + cellPhone +"',pager='"+ pager +"' where id='" + Cid +"'";
                int a = con.stmt.executeUpdate(q);
                
                if(a == 1){
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                    this.setVisible(false);
                    new SearchAndUpdateDataTable(name).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Error");
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
        new editData().setVisible(true);
    }
}
