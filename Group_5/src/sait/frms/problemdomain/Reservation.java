package sait.frms.problemdomain;

/**
 * class Reservation that describe the Reservation object.
 * 
 * @author Henry Shi
 * @author Hanin Ahmed Hussein Geabel
 * @author Deborah Odoh
 * 
 * @version March 2022
 */

public class Reservation {
	
	private String code;
	private String flightCode;
	private String airline;
	private String name;
	private String citizenship;
	private double cost;
	private boolean active;
	
	/**
	 * Create an Reservation object with default values
	 */
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create an Reservation object by providing code, flightCode, airline, name, citizenship, cost, active
	 * @param code 
	 * @param flightCode 
	 * @param airline
	 * @param name 
	 * @param citizenship 
	 * @param cost
	 * @param active
	 */
	public Reservation(String code, String flightCode, String airline, String name, String citizenship, double cost,
			boolean active) {
		super();
		this.code = code;
		this.flightCode = flightCode;
		this.airline = airline;
		this.name = name;
		this.citizenship = citizenship;
		this.cost = cost;
		this.active = active;
	}

	/**
	 * return the Reservation code
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * return the flightCode
	 * @return flightCode
	 */
	public String getFlightCode() {
		return flightCode;
	}

	/**
	 * return the Reservation airline
	 * @return airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * return the name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * return the citizenship
	 * @return citizenship
	 */
	public String getCitizenship() {
		return citizenship;
	}

	/**
	 * return the Reservation cost
	 * @return cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * return the Reservation activation
	 * @return active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * set the name to the name provided
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * set the citizenship to the citizenship provided
	 * @param citizenship
	 */
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	/**
	 * set the activation to the activation provided
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return code; 
		}

}

