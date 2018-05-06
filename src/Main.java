/******************************************************************************
 super class named appointment
 subclass called Onetime, Daily, Monthly

 an appointment has a description "see dentist" and a date

 write method occursOn(int year, int month, int day) that checks whether the
 appointment occurs on that date

 fill an array of Appointment objects with a mixture of appointments

 Have user enter a date and print all appointments that occursOn that date

*******************************************************************************/
import java.io.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException, IOException {
        AppointmentMaker a = new AppointmentMaker();
        a.menuPrint();
    }
}
