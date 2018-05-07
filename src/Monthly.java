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

public class Monthly extends Appointment
{
    public Monthly(int day, int month, int year, String description){
        super(day, month, year, description);                                   //Initializes constructor with Superclass
    }                                                                           //Appointment variables
    
    public boolean occursOn(ArrayList<String> arr, String day) {                //returns true if the ArrayList has an appointment 
        for(String a : arr){                                                    //on that day. Loop searches every line of ArrayList
            if(a.contains(day)){                                                //and iterates through each String inside the list
                return true;                                                    //return true if date is already booked
            }
        }
        return false;                                                           //return false if that date is open
    }
    
    public String toString(){                                                   //Adds Monthly: tag and description and day
        return "Monthly: " + description + " on every " + day + " of the month\n";
    }
}
