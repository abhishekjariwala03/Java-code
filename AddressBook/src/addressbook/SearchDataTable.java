package addressbook;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchDataTable extends JFrame {
    
    Font f1;
    String x[] = {"id","name","homeAddress","businessAddress","businessPhoneNumber","Fax_Number","CellPhone","Pager"};
    String y[][] = new String[20][9];
    int i = 0,j = 0;
    JTable jt;
    
    SearchDataTable(){
        
    }
    SearchDataTable(String name1){
        super("Contect Information");
        setLocation(450,40);
        setSize(800,400);
        
        f1 = new Font("Arial",Font.BOLD,20);
        
        try{
            Connection con = new Connection();
            String query = "select * from addcontect where name='" + name1 + "'";
            ResultSet rest = con.stmt.executeQuery(query);
            
            while(rest.next()){
                y[i][j++]=rest.getString("id"); // Print All data in first row 
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("homeAddress");
                y[i][j++]=rest.getString("phoneNumber");
                y[i][j++]=rest.getString("businessAddress");
                y[i][j++]=rest.getString("bphoneNumber");
                y[i][j++]=rest.getString("faxNum");
                y[i][j++]=rest.getString("cellPhone");
                y[i][j++]=rest.getString("pager");
                
                i++; //increasing row number from 0 to 1;
                j=0; // Set j = 0 so j start from first name and print all data again
            }
            
            jt = new JTable(y,x);
            jt.setFont(f1);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(jt);
        add(sp);
    }
}