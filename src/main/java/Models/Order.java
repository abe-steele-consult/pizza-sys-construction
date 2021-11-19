package Models;

import java.util.Date;

public class Order {

	private int orderId;
	private float total = 0;
	private int employeeId;
	private String status;
	private Date date;
	private String customerName;
	private String customerPhoneNumber;
	private String type;
	private String order;

	/**
	 * 
	 * @param employeeId
	 * @param customerName
	 * @param customerPhoneNumber
	 * @param type
	 * @param order
	 */
	public Order(int employeeId, String customerName, String customerPhoneNumber, String type, String order) {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customerName
	 */
	public void cancelOrder(String customerName) {
		// TODO - implement Order.cancelOrder
		throw new UnsupportedOperationException();
	}

	private void calculateTotal() {
		// TODO - implement Order.calculateTotal
		throw new UnsupportedOperationException();
	}

}