public class Appointment
{
    protected String description;
    protected int day;
    protected int month;
    protected int year;

    public Appointment(int day, int month, int year, String description){
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public String getDescription(){
        return description;
    }

    public boolean occursOn(int day, int month, int year){
        if((getDay() == day) && (getMonth() == month) && (getYear() == year)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return description + " on: " + month + "/" + day + "/" + year + "\n";
    }
}
