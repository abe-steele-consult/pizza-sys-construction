package Models;

import java.security.Timestamp;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.time.LocalTime;

public class Employee {

	private int employeeId;
	private String name;
	private float salary;
	private float timeWorked;
	private LocalTime inTime;
	private String type;
	private String role;

	/**
	 * 
	 * @param name First name of Employee
	 * @param salary Salary based on Employee type
	 * @param type Type of wage earned (annual, hourly, temporary)
	 * @param role Role in the restaurant played by Employee
	 */
	public Employee(String name, float salary, String type, String role) {
		this.name = name;
		this.salary = salary;
		this.type = type;
		this.role = role;
	}

	public boolean clockIn() {
		this.inTime = LocalTime.now();

		throw new UnsupportedOperationException();
	}

	public boolean clockOut() {
		LocalTime inTime = this.inTime;
		LocalTime outTime = LocalTime.now();

		Long timeWorkedLong = inTime.until(outTime, MINUTES);
		this.timeWorked = timeWorkedLong.floatValue();

		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}
	public int getEmployeeId() {return employeeId;}
	public float getSalary() {
		return salary;
	}
	public String getRole() {
		return role;
	}
	public String getType() {
		return type;
	}
	public float getTimeWorked() {
		return timeWorked;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setEmployeeId(int employeeId) {
		if (employeeId <= 99999 && employeeId > 0){
			this.employeeId = employeeId;
		}else{
			System.out.println("Id is of the incorrect format");
		}
	}
	public void setSalary(float salary) {
		if (salary >= 15100){
			this.salary = salary;
		}else{
			System.out.println("Salary is too low");
		}
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTimeWorked(float timeWorked) {
		this.timeWorked = timeWorked;
	}
}