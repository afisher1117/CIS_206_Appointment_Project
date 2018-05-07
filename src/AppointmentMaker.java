/******************************************************************************
 Filename: Fisher_Chapter2_Arithmetic_CIS206.java
 Author: Adam Fisher
 Email: 0070342@student.vvc.edu
 Description: Improve the appointment book program of Exercise P9.21 by having 
 the user save the appointment data to a file and reload the data from a file. 
 The saving part is straightforward: Make a method save. Save the type, 
 description, and date to a file. The loading part is not so easy. First 
 determine the type of the appointment to be loaded, create an object of that 
 type, and then call a method to load the data.
*******************************************************************************/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AppointmentMaker
{
    BufferedWriter writer = null;
    Scanner in = new Scanner(System.in);

    public AppointmentMaker(){
    }

    public void menuPrint() throws FileNotFoundException, IOException{          //Main menu
        System.out.println("Welcome to the appointment maker.");
        System.out.println("From here, you may: ");
        System.out.println("1) Save a new appointment");
        System.out.println("2) View appointments");
        System.out.println("3) Exit");
        int choice = Integer.parseInt(in.nextLine());
        menuSwitch(choice);
        menuPrint();
    }

    public void menuSwitch(int c) throws FileNotFoundException, IOException{    //Switch for Main Menu
        switch(c){
            case 1: saveAppointmentMenu();
                break;
            case 2: viewAppointmentMenu();
                break;
            case 3: System.exit(0);
        }
    }

    public void saveDailyAppointment(){
        ArrayList<String> arr = new ArrayList<String>();                        //Initializes new ArrayList<String>. This will be 
        char c = '\0';                                                          //a temporary instance for storing new Daily 
        do{                                                                     //appointments. 
            System.out.print("Enter your new Daily appointment: ");
            Daily d = new Daily(in.nextLine());
            String newD = d.toString();
            arr.add(newD);
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Daily appointment? (y/n): ");
            c = in.next().charAt(0);
            in.nextLine();
        }while(c == 'y' || c == 'Y');
        writeDailyAppointment(arr);                                             //The ArrayList is sent to be written to file
    }
    
    public void writeDailyAppointment(ArrayList<String> arr){                   //Writes contents of ArrayList to Appointment file
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {                                              //loops through contents of ArrayList
                writer.write(str);                                              //Writes each iteration to file
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        }
    }

    public void saveMonthlyAppointment(){                                       //Same concept as saveDailyAppointment
        ArrayList<String> arr = new ArrayList<String>();
        char c = '\0';
        Pattern dayMonth = Pattern.compile("\\d\\d");                           //Regex Pattern of 2 digits
        do{
            System.out.print("Enter your new Monthly appointment description: ");
            String a = in.nextLine();
            System.out.print("\nEnter what day of the month this new appointment will fall on (dd): ");
            String dayString = in.nextLine();
            Matcher mD = dayMonth.matcher(dayString);                           //Searches dayString for 'dd' format
            if(!mD.find()){
                System.out.println("Day value entered incorrectly. Please us 'dd' format.");
                saveMonthlyAppointment();
            }
            int b = Integer.parseInt(dayString);                                //Changes String to int to pass into new 
            Monthly m = new Monthly(b,1,1,a);                                   //Monthly object
            String newM = m.toString();                                         //Creating string to use in occursOn method
            if((m.occursOn(arr, dayString))){                                   //See Monthly.java for comments
                System.out.print("You have an appointment on that day. Please select another date: \n");
                in.nextLine();
                saveMonthlyAppointment();
            }
            arr.add(newM);                                                      //adds new String to ArrayList
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Monthly appointment? (y/n): ");
            c = in.next().charAt(0);
            in.nextLine();
        }while(c == 'y' || c == 'Y');
        in.nextLine();
        writeMonthlyAppointment(arr);                                           //Sends ArrayList to be written to file
    }
    
    public void writeMonthlyAppointment(ArrayList<String> arr){                 //Same as writeDailyAppointment
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {
                writer.write(str);
            }
        } catch (IOException e) {
                System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void saveOnetimeAppointment(){                                       //Same as saveMonthlyAppointment
        ArrayList<String> arr = new ArrayList<String>();
        Pattern dayMonth = Pattern.compile("\\d\\d");                           //Regex Pattern for 2 digits dd and mm
        Pattern year = Pattern.compile("\\d\\d\\d\\d");                         //Regex Pattern for 4 digits yyyy
        char e = '\0';
        do{
            System.out.print("Enter your new Onetime appointment date beginning with the day (dd): ");
            String dayString = in.nextLine();
            Matcher mD = dayMonth.matcher(dayString);
            if(!mD.find()){                                                     //Searches dayString for dd format
                System.out.println("Day value entered incorrectly. Please us 'dd' format.");
                saveOnetimeAppointment();
            }
            int a = Integer.parseInt(dayString);                                //Changes String to int for Onetime obj param
            System.out.print("\nEnter what number month this new appointment will fall on (mm): ");
            String monthString = in.nextLine();
            Matcher mM = dayMonth.matcher(monthString);
            if(!mM.find()){                                                     //Searches monthString for mm format
                System.out.println("Month value entered incorrectly. Please us 'mm' format.");
                saveOnetimeAppointment();
            }
            int b = Integer.parseInt(monthString);                              //Changes String to int for Onetime obj param
            System.out.print("\nEnter what year this new appointment will fall on (yyyy): ");
            String yearString = in.nextLine();
            Matcher mY = year.matcher(yearString);
            if(!mY.find()){                                                     //Searches yearString for yyyy format
                System.out.println("Year value entered incorrectly. Please us 'yyyy' format.");
                saveOnetimeAppointment();
            }
            int c = Integer.parseInt(yearString);                               //Changes String to int for Onetime obj param
            System.out.print("\nFinally, enter a description of this new appointment: ");
            String d = in.nextLine();
            Onetime o = new Onetime(a, b, c, d);
            String newO = o.toString();                                         //Creating String for occursOn method
            if((o.occursOn(arr, dayString, monthString, yearString))){          //See Appointment.java for method comments
                System.out.println("You have an appointment on that day. Please select another date: ");
                in.nextLine();
                saveOnetimeAppointment();
            }
            arr.add(newO);                                                      //Adding appointment info to ArrayList
            System.out.println("Appointment saved.\n");
            System.out.print("Add another Onetime appointment? (y/n): ");
            e = in.next().charAt(0);
            in.nextLine();
        }while(e == 'y' || e == 'Y');
        in.nextLine();
        writeOnetimeAppointment(arr);                                           //Passes ArrayList to be written to file
    }
    
    public void writeOnetimeAppointment(ArrayList<String> arr){                 //Same as writeMonthlyAppointment
        try {
            writer = new BufferedWriter(new FileWriter("./Appointments.txt", true));
            for(String str: arr) {
                writer.write(str);
            }
        } catch (IOException e) {
                System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }    
    }

    public void saveAppointmentMenu() throws FileNotFoundException, IOException{//Menu for saving appointments
        System.out.println("Welcome to the appointment saver.");
        System.out.println("From here, you may: ");
        System.out.println("1) Save a new Daily appointment");
        System.out.println("2) Save a new Monthly appointment");
        System.out.println("3) Save a new Onetime appointment");
        System.out.println("4) Return to Main Menu");
        System.out.println("5) Exit program");
        int choice = Integer.parseInt(in.nextLine());
        saveAppointmentSwitch(choice);
        saveAppointmentMenu();
    }

    public void saveAppointmentSwitch(int c) throws FileNotFoundException, IOException{
        switch(c){                                                              //Switch for saveAppointmentMenu
            case 1: saveDailyAppointment();
                break;
            case 2: saveMonthlyAppointment();
                break;
            case 3: saveOnetimeAppointment();
                break;
            case 4: menuPrint();
                break;
            case 5: System.exit(0);
        }
    }

    public void viewAppointmentMenu() throws FileNotFoundException, IOException{//Menu for viewing appointments
        System.out.println("Welcome to the appointment viewer.");
        System.out.println("From here, you may: ");
        System.out.println("1) View your Daily appointments");
        System.out.println("2) View your Monthly appointments");
        System.out.println("3) View your Onetime appointments");
        System.out.println("4) View all appointments");
        System.out.println("5) Return to Main Menu");
        System.out.println("6) Exit program");
        int choice = Integer.parseInt(in.nextLine());
        viewAppointmentSwitch(choice);
        viewAppointmentMenu();
    }

    public void viewAppointmentSwitch(int c) throws FileNotFoundException, IOException{
        switch(c){
            case 1: dailyPrint();                                               //Switch for viewAppointmentMenu
                break;
            case 2: monthlyPrint();
                break;
            case 3: onetimePrint();
                break;
            case 4: allPrint();
                break;
            case 5: menuPrint();
                break;
            case 6: System.exit(0);
        }
    }

    public void dailyPrint() throws FileNotFoundException{                      //Prints all Daily appointments only
        File file = new File("./Appointments.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);                                             //Scanner reads Appointments file
            System.out.println("\nYour Daily Appointments are: ");
            while(in.hasNext()){                                                //Checking every line
                String line = in.nextLine();
                if(line.contains("Daily:"))                                     //If file contains line with 'Daily:' tag
                    System.out.println(line);                                   //SysOut prints the line
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void monthlyPrint() throws FileNotFoundException{                    //Prints all Monthly appointments only
        File file = new File("./Appointments.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);                                             //Scanner reads Appointments file
            System.out.println("\nYour Monthly Appointments are: ");
            while(in.hasNext()){                                                //Checking every line
                String line = in.nextLine();
                if(line.contains("Monthly:"))                                   //If file contains line with 'Monthly:' tag
                    System.out.println(line);                                   //SysOut prints the line
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void onetimePrint() throws FileNotFoundException{                    //Prints all Onetime Appointments only
        File file = new File("./Appointments.txt");                             //Same as dailyPrint and monthlyPrint
        Scanner in = null;
        try {
            in = new Scanner(file);                                         
            System.out.println("\nYour Onetime Appointments are: ");
            while(in.hasNext()){
                String line = in.nextLine();
                if(line.contains("Onetime appt:"))
                    System.out.println(line);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void allPrint() throws IOException{                                  //Prints entire Appointments file
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Appointments.txt"));
            String line = null;
            System.out.println("Your appointments are: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
