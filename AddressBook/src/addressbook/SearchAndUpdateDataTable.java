
package addressbook;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchAndUpdateDataTable extends JFrame implements ActionListener{
        
    Font f1;
    String x[] = {"id","name","homeAddress","businessAddress","businessPhoneNumber","Fax_Number","CellPhone","Pager"};
    String y[][] = new String[20][9];
    int i = 0,j = 0;
    JTable jt;
    JLabel l1;
    JTextField t1;
    JButton btn1;
    JPanel p1;
    
    
    SearchAndUpdateDataTable(){
        
    }
    
    SearchAndUpdateDataTable(String name1){
        super("Contect Information");
        setLocation(450,40);
        setSize(800,400);
        
        f1 = new Font("Arial",Font.BOLD,20);
        
        try{
            Connection con = new Connection();
            String query = "SELECT * FROM addcontect WHERE name='" + name1 + "'";
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
        
        l1 = new JLabel("Enter Contect Id:");
        t1 = new JTextField();
        btn1 = new JButton("Edit");
        
        btn1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(t1);
        p1.add(btn1);
        
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(t1.getText());
        
        if(e.getSource() == btn1){
            new editData(id).setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new SearchAndUpdateDataTable().setVisible(true);
    }
    
    
}
