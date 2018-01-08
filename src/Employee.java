import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
//Cormac Buckley 15534413

// Abstract base class Employee.

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDateTime now = LocalDateTime.now();
    private int year;
 	private int months;
    private int day; 
    private int hours;
    private int minutes;

    // constructor
    public Employee(String first, String last, int year, int months, int day, int hour, int minute) throws InvalidDateException {
        firstName = first;
        lastName = last;
        this.year = year;
        hours = hour;
        this.months = months;
        this.day = day;
        this.minutes = minute;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }
    
    public LocalDateTime getNow() {
        return now;
    }
    
    public int getYear() {
 		return year;
 	}

 	public int getMonths() {
 		return months;
 	}

 	public int getDay() {
 		return day;
 	}

 	public int getHours() {
 		return hours;
 	}

 	public int getMinutes() {
 		return minutes;
 	}
 	
 	public String JoinDate(){
		return "" + year + '/' + months + '/' + day + " at " + hours + ':' + minutes;
 		
 	}

    public String toString() {
        return firstName + ' ' + lastName;
    }
    
    

    public abstract double earnings();
}
