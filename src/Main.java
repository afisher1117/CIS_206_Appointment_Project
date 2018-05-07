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

public class Main
{
	public static void main(String[] args) throws FileNotFoundException, IOException {
        AppointmentMaker a = new AppointmentMaker();                            //Creates new AppointmentMaker object 
        a.menuPrint();                                                          //Prints menu to begin 
    }
}
