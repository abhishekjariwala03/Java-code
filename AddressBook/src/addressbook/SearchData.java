package addressbook;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchData extends JFrame implements ActionListener {
    JButton btn1,btn2;
    Font f1,f2;
    JPanel p1,p2;
    JLabel l1,l2;
    JTextField t1;
    int id = 0;
    
    SearchData(){
        super("Enter Name to Search");
        //Setting Location
        setLocation(400,50);
        setSize(300,200);
        
        f1 = new Font("Arial",Font.BOLD,30);
        f2 = new Font("Arial",Font.BOLD,15);
        
        l1 = new JLabel("Search Data");
        
        l2 = new JLabel("Enter Name:");
        
        t1 = new JTextField();
        
        btn1 = new JButton("Search");
        btn2 = new JButton("Back");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        l1.setFont(f1);
        l2.setFont(f2);
        t1.setFont(f2);
        btn1.setFont(f2);
        btn2.setFont(f2);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(btn1);
        p2.add(btn2);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
    }
    
    public static void main(String[] args) {
        new SearchData().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        
         if(e.getSource() == btn1){
             try{
                 Connection con = new Connection();
                 String query = "select name from addContect where name='" + name + "'";
                 ResultSet rest = con.stmt.executeQuery(query);
                 
                 if(rest.next()){
                     String name1 = rest.getString("name");
                     new SearchDataTable(name1).setVisible(true);
                 }else{
                     id = 0;
                     JOptionPane.showMessageDialog(null, "Contect not found!!");
                     this.setVisible(false); // Cloasing current panel for showing msessage
                     this.setVisible(true); // Reopen current panel
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
}
