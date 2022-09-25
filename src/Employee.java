
/**
 * This Class creates the employees and has methods to calculate payroll for the employees.
 * @author Emilio Guajardo Garza, Nikhil.
 *
 */

public class Employee {

	private int empNo; // This is the employee number. //
	private String empName; // This is the employee name. //
	private String department; // What department the employee belongs to. //
	private char type; // What type of pay do they receive. //
	private double payRate; // This is the employee pay rate. //
	private double maxHours; // This is how many hours the employee worked. //
	
	/**
	 * Constructor with no arguments to replace the default constructor.
	 */
	public Employee() {
		
		this.empNo = 0;
		this.empName = null;
		this.department = null;
		this.type = 0;
		this.payRate = 0.0;
		this.maxHours = 0.0;
	}
	
	/**
	 * This is the main constructor to make an employee.
	 * @param empNo (This is the employee number.)
	 * @param empName (This is the employee name.)
	 * @param department (What department the employee belongs to.)
	 * @param type (What type of pay do they receive. Salary, Hourly, or Consultant)
	 * @param payRate (his is the employee pay rate.)
	 * @param maxHours (This is how many hours the employee worked.)
	 */
	public Employee(int empNo, String empName, String department, char type, double payRate, double maxHours) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.type = type;
		this.payRate = payRate;
		this.maxHours = maxHours;
		
	}
	
	/**
	 * This is a copy constructor that is used to create an employee with the same initial vales as another employee,
	 * but with different name, number, and department.
	 * @param employee (This is another employee which characteristics will be copied.)
	 * @param empNo (This is the employee number.)
	 * @param empName (This is the employee name.)
	 * @param department (What department the employee belongs to.)
	 */
	public Employee(Employee employee, int empNo, String empName, String department) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.type = employee.getType();
		this.payRate = employee.getPayRate();
		this.maxHours = employee.getMaxHours();
	}
	
	/**
	 * This method is used to calculate the gross weekly amount of money made by the employee.
	 * @param hoursWorked (This is how many hours the employee worked.)
	 * @return (returns the gross weekly amount of money made.)
	 */
	public double calculateGrossWeekly(double hoursWorked) {
		
		double grossWeeklyPay = 0;
		double overTimeHours;
		
		switch (type) {
		
			case 'S':
			
				grossWeeklyPay = payRate / 52;
				
				break;
			case 'H':
				
				if (maxHours <= 40) {
					grossWeeklyPay = (payRate * maxHours); 
				} else if (maxHours > 40 && maxHours <= 60) {
					overTimeHours = maxHours - 40;
					grossWeeklyPay = (payRate * 40) + ((payRate * 1.5) * overTimeHours);
				} else {
					overTimeHours = 20;
					grossWeeklyPay = (payRate * 40) + ((payRate * 1.5) * overTimeHours);
				}
				
				break;
				
			case 'C':
		
				grossWeeklyPay = payRate * maxHours;
				
				break;
		}
		
		return grossWeeklyPay;
		
	}
	
	
	/**
	 * This method is used to calculate how much federal tax should be deducted,
	 * by taking the gross amount and applying the appropriate reduction.
	 * @param gross (This is the gross amount of money made by the employee without reductions.)
	 * @return (returns how much federal tax reduction should be reduced)
	 */
	public double calcWithhold(double gross) {
		final double FEDTAXREDUCTION1 = 0.075;
		final double FEDTAXREDUCTION2 = 0.12;
		final double FEDTAXREDUCTION3 = 0.17;
		
		
		if (gross < 1000) {
			gross = gross * FEDTAXREDUCTION1;
		} else if (gross >= 1000 && gross < 2000) {
			gross = gross * FEDTAXREDUCTION2;
		} else {
			gross = gross * FEDTAXREDUCTION3;
		}
		
		return gross;
		
	}
	
	/**
	 * This method calculates the CPP contribution.
	 * @param gross (This is the gross amount of money made by the employee without reductions.)
	 * @return (returns how much CPP is owed.)
	 */
	public double calcCPP(double gross) {
		final double CPPCONTRIBUTION = 0.0475;
		
		gross = gross * CPPCONTRIBUTION;
		
		return gross;
		
	}
	
	/**
	 * This method calculates how much EI contribution should be deducted.
	 * @param gross (This is the gross amount of money made by the employee without reductions.)
	 * @return (returns how much EI should be deducted.)
	 */
	public double calcEI(double gross) {
		final double EICONTRIBUTION = 0.018;
		
		
		gross = gross * EICONTRIBUTION;
		
		return gross;
		
	}
	
	/**
	 * This method calculates how much should be deducted for the employees benefits.
	 * @param gross (This is the gross amount of money made by the employee without reductions.)
	 * @return (returns how much should be deducted for benefits.)
	 */
	public double calcExtHealth(double gross) {
		
		final double PREMIUMCHARGE = 0.013;
		
		gross = gross * PREMIUMCHARGE;
		
		return gross;
	
	}
	
	/**
	 * This method calculates how much money is owed for union dues.
	 * @param gross (This is the gross amount of money made by the employee without reductions.)
	 * @return (returns how much should be deducted for union dues.)
	 */
	public double calcUnionDues(double gross) {
		final double UNIONDUES = 0.01;
		
		gross = gross * UNIONDUES;
		
		return gross;
	
	}
	
	/**
	 * This method deducts money out of the employee's gross pay, depending on
	 * what type of employee they are.
	 * @param hoursWorked (This is how many hours the employee has worked.)
	 * @return (returns the net amount of money after deductions the employee should be paid for.)
	 */
	public double calculateNetPay(double hoursWorked) {
		double netPay = 0;
		double grossWithoutReductions = 0;
		double federalTaxReduction = 0;
		double CPPReduction = 0;
		double EIReduction = 0;
		double premiumsReduction = 0;
		double unionDuesReduction = 0;
		
		grossWithoutReductions = calculateGrossWeekly(hoursWorked);
		federalTaxReduction = calcWithhold(grossWithoutReductions);
		CPPReduction = calcCPP(grossWithoutReductions);
		EIReduction = calcEI(grossWithoutReductions);
		premiumsReduction = calcExtHealth(grossWithoutReductions);
		unionDuesReduction = calcUnionDues(grossWithoutReductions);
		
		switch (this.type) {
		
		case 'S':
			
			netPay = grossWithoutReductions - federalTaxReduction - CPPReduction - EIReduction - premiumsReduction;
			
			break;
		case 'H':
			
			netPay = grossWithoutReductions - federalTaxReduction - CPPReduction - EIReduction - premiumsReduction - unionDuesReduction;
			
			break;
			
		case 'C':
			
			netPay = grossWithoutReductions - federalTaxReduction - CPPReduction - EIReduction;
			
			break;
	}
		
		return netPay;
		
	}
	
	
	/**
	 * This method compares an employee to another based on their employee number.
	 * @param other (Takes another employee to be compared to the current one.)
	 * @return (returns a number based on the two employees being compared.)
	 */
	public int compareTo(Employee other) {
		
		int otherEmpNum = other.getEmpNo();
		
		if (this.empNo < otherEmpNum) {
			return -1;
		} else if (this.empNo == otherEmpNum) {
			return 0;
		} else {
			return 1;
		}
		
	}
	
	
	/**
	 * This method gets the employee number.
	 * @return (returns the employee number.)
	 */
	public int getEmpNo() {
		
		return empNo;
	}
	
	/**
	 * This method is used to set the employee name.
	 * @param empNo (Takes an integer to set the employee number.)
	 */
	public void setEmpNo(int empNo) {
		
		this.empNo = empNo;
	}
	
	/**
	 * This method gets the employee name.
	 * @return (returns the employee name.)
	 */
	public String getEmpName() {
		
		return empName;
	}
	
	/**
	 * This method is used to set the employee number.
	 * @param empName (Takes string to set the employee's name.)
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * This method gets the employee type.
	 * @return (returns the employee type.)
	 */
	public char getType( ) {
		
		return type;
	}
	
	/**
	 * This method is used to set the employee type.
	 * @param type (Takes a character to sets the employee to either S, H, or C.)
	 */
	public void setType(char type) {
		this.type = type;
		
	}
	
	/**
	 * This method gets the employee's pay rate.
	 * @return (returns the employee pay rate.)
	 */
	public double getPayRate() {
		
		return payRate;
	}
	
	/**
	 * This method is used to set the employee's pay rate.
	 * @param payRate (Takes a double and sets the employee pay rate.)
	 */
	public void setPayRate(double payRate) {
		
		this.payRate = payRate;
		
	}
	
	/**
	 * This method gets the employee's hours worked.
	 * @return (returns the employee's worked hours.)
	 */
	public double getMaxHours() {
		
		return maxHours;
	}
	
	/**
	 * This method is used to set the employee's hours worked.
	 * @param maxHours (Takes a double and sets the employee hours.)
	 */
	public void setMaxHours(double maxHours) {
		
		this.maxHours = maxHours;
	}

	/**
	 * This method gets the employee's department.
	 * @return (returns the employee's department.)
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * This method is used to set the employee's department.
	 * @param department (Takes a string and sets the employee's department.)
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * This method overrides the default to string method and displays the employee's details
	 * @return (returns a string with the employees details)
	 */
	public String toString() {
		
		switch (this.type) {
		
		case 'S' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Salary";
			
		case 'H' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Hourly";
			
		case 'C' :
			
			return "Employee Number: " + empNo + "\n" + "Employee Name: " + empName + "\n" + "Employee Type " + "Consultant";
		
		}
		return "Employee []";
	}
	
	
	
}
