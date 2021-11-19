package Models;

import java.security.Timestamp;

public class Employee {

	private int employeeId;
	private String name;
	private float salary;
	private float timeWorked;
	private String type;
	private String role;

	/**
	 * 
	 * @param name
	 * @param salary
	 * @param type
	 * @param role
	 */
	public Employee(String name, float salary, String type, String role) {
		this.name = name;
		this.salary = salary;
		this.type = type;
		this.role = role;
	}

	/**
	 * 
	 * @param time
	 */
	public boolean clockIn(Timestamp time) {
		// TODO - implement Employee.clockIn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param time
	 */
	public boolean clockOut(Timestamp time) {
		// TODO - implement Employee.clockOut
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}
}