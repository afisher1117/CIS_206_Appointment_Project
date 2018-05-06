public class Monthly extends Appointment
{
    public Monthly(int day, int month, int year, String description){
        super(day, month, year, description);
    }

    public boolean occursOn(int day){
        if(getDay() == day){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "Monthly: " + description + " on every " + day + " of the month\n";
    }
}
