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

public class Appointment
{
    protected String description;                                               //Declared variables as protected so that 
    protected int day;                                                          //subclasses Monthly and Onetime can use them
    protected int month;
    protected int year;

    public Appointment(int day, int month, int year, String description){       //Initialize constructor with date info and a 
        this.description = description;                                         //description
        this.day = day; 
        this.month = month; 
        this.year = year; 
    }
    
    public int getDay(){                                                        //Accessor method for class variables
        return day;
    }
    
    public int getMonth(){                                                      //Accessor method for class variables
        return month;
    }
    
    public int getYear(){                                                       //Accessor method for class variables
        return year;
    }
    
    public String getDescription(){                                             //Accessor method for class variables
        return description;
    }
    
    public boolean occursOn(ArrayList<String> arr, String day, String month, String year){//returns true if the ArrayList has 
        for(String a : arr){                                                    //an appointment that matches the mm/dd/yyyy format. 
            if(a.contains(month + "/" + day + "/" + year)){                     //Loop searches every line of ArrayList and iterates
                return true;                                                    //over every String in the ArrayList for the specific
            }                                                                   //mm/dd/yyyy passed. Returns true if the date is
        }                                                                       //booked and false if it is open.
        return false;
    }
    
    public String toString(){                                                   //Allows Appointment object to print its information
        return getDescription() + " on: " + getMonth() + "/" + getDay() + "/" + getYear() + "\n";
    }
}
