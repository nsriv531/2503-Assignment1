import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class runs the program; reads the file with the Employee data and makes the employees
 * @author Emilio Guajardo Garza, Nikhil
 * @version 1.0
 * Last Modified: September 25, 2022  Commented code Emilio Guajardo Garza
 */

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		
		final String FILE_PATH = "src/Employee Test Data.txt";
		ArrayList<Employee> employees = new ArrayList<>();
		File employeeInventory = new File(FILE_PATH);
		
		try (Scanner fileReader = new Scanner(employeeInventory)) {
			String currentLine;
			String [] splittedLine;
			char typeOfEmployee;
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(" ");
				typeOfEmployee = splittedLine[3].charAt(0);
				
				if (typeOfEmployee == 'S') {
					
					Employee s = new Employee(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], (splittedLine[3].charAt(0)), Double.parseDouble(splittedLine[4]), Double.parseDouble(splittedLine[5]));
					employees.add(s);
					
				} else if (typeOfEmployee == 'H') {
					
					Employee h = new Employee(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], (splittedLine[3].charAt(0)), Double.parseDouble(splittedLine[4]), Double.parseDouble(splittedLine[5]));
					employees.add(h);
					
				} else if (typeOfEmployee == 'C') {
					
					Employee c = new Employee(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], (splittedLine[3].charAt(0)), Double.parseDouble(splittedLine[4]), Double.parseDouble(splittedLine[5]));
					employees.add(c);
					
				}
				
			}
			fileReader.close();
		}
		
		for (Employee tempEmployee: employees) {
			
			System.out.println(tempEmployee);
			System.out.println("Employee Net pay: $"+tempEmployee.calculateNetPay(tempEmployee.getMaxHours()));
			System.out.println("");
			
		}
		

	}

}
