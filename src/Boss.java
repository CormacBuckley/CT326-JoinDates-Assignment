import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// Boss class derived from Employee.
//Cormac Buckley 15534413

public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary,  int year, int months, int day, int hour, int minute) throws InvalidDateException {
        super(first, last,year, months,day,hour,minute); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    // get Boss's pay
    public double earnings() {
        return weeklySalary;
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
