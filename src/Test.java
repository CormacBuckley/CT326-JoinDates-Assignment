// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
// Java extension packages
import javax.swing.JOptionPane;

//Cormac Buckley 15534413

public class Test {

	public enum Month {
		JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(
				30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

		private int days;

		Month(int days) {
			this.days = days;
		}

	}

	// test Employee hierarchy
	public static void main(String args[]) throws InvalidDateException, ParseException {

		// Storing employees in arraylist for easier rule application
		ArrayList<Employee> emp = new ArrayList<Employee>();
		Employee employee; // superclass reference
		String output = "";

		LocalDate today = LocalDate.now();

		// First Set
		Boss boss = new Boss("John", "Smith", 800.0, 1985, 6, 30, 13, 12);

		CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones", 400.0, 3.0, 150, 2020, 8, 4, 10, 23);

		PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", 2.5, 200, 1996, 2, 29, 9, 35);

		HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", 13.75, 40, 2010, 13, 9, 14, 45);

		// Second Set
		// Boss boss = new Boss("John", "Smith", 800.0, 2008, 10, 27, 8, 33);
		//
		// CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones",
		// 400.0, 3.0, 150, 2003, 1, 18, 11, 14);
		//
		// PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", 2.5, 200, 1999, 2,
		// 30, 16, 11);
		//
		// HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", 13.75, 40,
		// 2015, 7, 8, 12, 37);

		emp.add(boss);
		emp.add(commissionWorker);
		emp.add(pieceWorker);
		emp.add(hourlyWorker);

		LocalDate a;

		DecimalFormat precision2 = new DecimalFormat("0.00");

		for (int i = 0; i < emp.size(); i++) {
			try {
				if (emp.get(i).getYear() > today.getYear()
						|| (emp.get(i).getYear() >= today.getYear() && emp.get(i).getDay() > today.getDayOfMonth())) {
					// Prints out employees name followed by error message
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + emp.get(i).getYear() + ' ' + emp.get(i).getMonths() + ' '
							+ emp.get(i).getDay() + ") Join date cannot be in the future");
				}
				if (emp.get(i).getYear() < 1990) {
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + emp.get(i).getYear() + ") Join date cannot be prior to 1990");
				}
				if (emp.get(i).getMonths() < 1 || emp.get(i).getMonths() > 12) {
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + emp.get(i).getMonths()
							+ ") Join month is invalid. There are only 12 months in a year!");
				}
				// Checking Leap year with mod 4
				if (emp.get(i).getYear() % 4 == 0 && emp.get(i).getMonths() == 2 && (emp.get(i).getDay() > 29)) {
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + emp.get(i).getDay() + ") "
							+ Month.values()[emp.get(i).getMonths() - 1] + " only has 29 days in a leap year");

				}

				else if (emp.get(i).getYear() % 4 != 0
						&& emp.get(i).getDay() > Month.values()[emp.get(i).getMonths() - 1].days) {
					throw new InvalidDateException(
							emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate() + " is Invalid" + "\n("
									+ emp.get(i).getDay() + ") " + Month.values()[emp.get(i).getMonths() - 1]
											+ " only has " + Month.values()[emp.get(i).getMonths() - 1].days + " days");
				}

				if (emp.get(i).getHours() < 9 || emp.get(i).getHours() > 18
						|| (emp.get(i).getHours() >= 18 && emp.get(i).getMinutes() > 0)) {
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + emp.get(i).getHours() + ":" + emp.get(i).getMinutes()
							+ ") Join time cannot be outside of office hours (9:00-18:00)");
				}

				// Checking for weekend
				a = LocalDate.of(emp.get(i).getYear(), emp.get(i).getMonths(), emp.get(i).getDay());
				if (a.getDayOfWeek().toString() == "SATURDAY" || a.getDayOfWeek().toString() == "SUNDAY") {
					throw new InvalidDateException(emp.get(i).toString() + "'s Join date of: " + emp.get(i).JoinDate()
							+ " is Invalid" + "\n(" + a.getDayOfWeek() + ") Join date cannot be during the weekend");
				} else {
					output += emp.get(i).toString() + " earned $ " + precision2.format(emp.get(i).earnings() * 4)
					+ ". Joined: " + emp.get(i).JoinDate() + "\n";
				}
			} catch (InvalidDateException err) {
				System.out.println(err.getMessage());
				output += emp.get(i).toString() + " earned $ " + precision2.format(emp.get(i).earnings() * 4)
				+ ". Joined: Invalid Date " + "\n";

			}
		}

		JOptionPane.showMessageDialog(null, output, "Demonstrating Polymorphism", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
} // end class Test
