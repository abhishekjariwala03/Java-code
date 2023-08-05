package Assignment.Question2;

// Imports 
import java.util.*;
import javax.swing.*;

public class Book {

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        String input, s;
        int ch;

        while (true) {
            input = JOptionPane.showInputDialog(
                    "Enter 1 To Add \n Enter  To Search\n Enter 3 To Delete\n Enter 4 To Update\n Enter 5 To Exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1:
                    ab.addPerson();
                    break;
                case 2:
                    s = JOptionPane.showInputDialog("Enter Name To Search : ");
                    ab.searchPerson(s);
                    break;
                case 3:
                    s = JOptionPane.showInputDialog("Enter name To Delete : ");
                    ab.DeletePerson(s);
                    break;
                case 4:
                    s = JOptionPane.showInputDialog("Enter Name To Update Data : ");
                    ab.UpdatePersone(s);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Nothing");
                    break;
            }
        }
    }
}

class Info {
    String name;
    String homeAddress;
    String phoneNumber;
    String businessAddress;
    String businessPhoneNumber;
    String faxNumber;
    String cellularPhoneNumber;
    String pagerNumber;

    Info(String Name, String hAdd, String phone, String businessAdd, String businessPhone, String faxNum,
            String cellPhone, String pager) {
        name = Name;
        homeAddress = hAdd;
        phoneNumber = phone;
        businessAddress = businessAdd;
        businessPhoneNumber = businessPhone;
        faxNumber = faxNum;
        cellularPhoneNumber = cellPhone;
        pagerNumber = pager;
    }

    // GUI
    void Display() {
        String Message = "Name: " + name + "\n" +
                "Home Address: " + homeAddress + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Business Address: " + businessAddress + "\n" +
                "Business Phone Number: " + businessPhoneNumber + "\n" +
                "Fax Number: " + faxNumber + "\n" +
                "Cellular Phone Number: " + cellularPhoneNumber + "\n" +
                "Pager Number: " + pagerNumber;

        JOptionPane.showMessageDialog(null, Message);
    }
}

class AddressBook {
    ArrayList<Info> persons;

    AddressBook() {
        persons = new ArrayList<>();
    }

    // Adding Address
    void addPerson() {
        String name = JOptionPane.showInputDialog("Enter Name : ");
        String HomeAddress = JOptionPane.showInputDialog("Enter Home Address : ");
        String PhoneNum = JOptionPane.showInputDialog("Enter Phone Number : ");
        String BusinessAdd = JOptionPane.showInputDialog("Enter Business Address : ");
        String BusinessPhone = JOptionPane.showInputDialog("Enter Business Phone Number : ");
        String faxNum = JOptionPane.showInputDialog("Enter Fax Number : ");
        String cellulorNum = JOptionPane.showInputDialog("Enter Cellulor Phone Number : ");
        String Pager = JOptionPane.showInputDialog("Enter Pager Number : ");

        Info i = new Info(name, HomeAddress, BusinessPhone, BusinessAdd, BusinessPhone, faxNum, PhoneNum, Pager); // Pass
                                                                                                                  // Value
                                                                                                                  // Using
                                                                                                                  // Object
        persons.add(i);
    }

    // Searching Person info
    void searchPerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            Info info = (Info) persons.get(i);

            if (name.equals(info.name)) {
                info.Display();
            }
        }
    }

    // Delete Person
    void DeletePerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            Info info = (Info) persons.get(i);

            if (name.equals(info.name)) {
                persons.remove(i);
                JOptionPane.showMessageDialog(null, "Your Record Deleted SuccessFully");
            }
        }
    }

    // Updating Person Data
    void UpdatePersone(String name) {
        for (int i = 0; i < persons.size(); i++) {
            Info info = (Info) persons.get(i);

            if (name.equals(info.name)) {
                String NewHomeAddress = JOptionPane.showInputDialog("Enter New Home Address : ");
                String NewPhoneNumber = JOptionPane.showInputDialog("Enter New Phone Number : ");
                String NewBusinessAddress = JOptionPane.showInputDialog("Enter New Business Address : ");
                String NewBusinessPhone = JOptionPane.showInputDialog("Enter New Business Phone : ");
                String NewFaxNumber = JOptionPane.showInputDialog("Enter New Fax Number : ");
                String NewCellularPhoneNumber = JOptionPane.showInputDialog("Enter New CellularPhone Number : ");
                String NewPageNumber = JOptionPane.showInputDialog("Enter New Page Number : ");

                info.homeAddress = NewHomeAddress;
                info.phoneNumber = NewPhoneNumber;
                info.businessAddress = NewBusinessAddress;
                info.businessPhoneNumber = NewBusinessPhone;
                info.faxNumber = NewFaxNumber;
                info.cellularPhoneNumber = NewCellularPhoneNumber;
                info.pagerNumber = NewPageNumber;

                JOptionPane.showMessageDialog(null, "Information Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Person Not Found");
            }
        }
    }
}
