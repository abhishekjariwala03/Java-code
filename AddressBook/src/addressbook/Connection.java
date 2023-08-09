/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addressbook;

import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author This PC
 */
public class Connection {
    java.sql.Connection con;
    Statement stmt;

    Connection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhoneBook","Give your mysql user name","you mysql password");
            stmt = con.createStatement();
            System.out.println("Database Connected");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Connection();
    }
}
