import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Methods {
    static HashMap<String, String> map = new HashMap<>();

    public void addContact() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/contactsList.txt", true))) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter a name: ");
            String userName = sc.nextLine();
            System.out.println("enter a phone number");
            String userPhone = sc.nextLine();

            bw.write(userName + ":" + userPhone);
            bw.newLine();

        } catch (Exception e) {
            System.out.println("error");
        }
    }


    public void deleteContact() {


        System.out.println(map);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a contact to delete:");
        String userInput = sc.nextLine();




                if (map.containsKey(userInput)) {
                    map.remove(userInput);
                    saveContacts();
                }else {
                    System.out.println("Cant find file");
                }


    }

    public void loadContacts() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/data/contactsList.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                map.put(contact[0], contact[1]);
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public   void saveContacts() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/data/contactsList.txt"));

            for (Map.Entry<String, String> entry : map.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }





    //
//            ********************************** SEARCH FOR CONTACT METHOD *************************************
//


    public void searchForContact() {

        Scanner sc = new Scanner(System.in);

//        vvv DECLARING THIS OUTSIDE OF TRY CATCH TO CLOSE br LATER
        BufferedReader br = null;
        try {

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader("src/data/contactsList.txt"));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);

//                PROMPTING THE USER
                System.out.println("Enter a contacts name:");
                String userInput = sc.nextLine();
                for (String person : map.values()) {
                    if (person.contains(userInput)) {
                        System.out.println(person);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
                ;
            }
        }

    }


    public void showAllContacts() {
        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/data/contactsList.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
