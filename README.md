<h1>Appointment Project for CIS 206</h1>

<h3>P9.21</h3>
Implement a superclass APPOINTMENT and subclasses ONETIME, DAILY, and MONTHLY. An Appointment has a description(for example, "see the dentist") and a date. Write a method occursOn(int year, int month, int day) that checks whether the appointment occurs on that date. For example, for a monthly appointment, you must check whether the day of the month matches. Then fill an array of Appointment objects with a mixture of appointments. Have the user enter a date and print out all appointments that occur on that date.

<h3>P9.23</h3>
Improve the appointment book program of Exercise P9.21 by having the user save the appointment data to a file and reload the data from a file. The saving part is straightforward: Make a method save. Save the type, description, and date to a file. The loading part is not so easy. First determine the type of the appointment to be loaded, create an object of that type, and then call a method to load the data.
