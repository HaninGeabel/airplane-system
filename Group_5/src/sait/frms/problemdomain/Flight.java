package sait.frms.problemdomain;

/**
 * class Flight that describe the Flight object.
 * 
 * @author Henry Shi
 * @author Hanin Ahmed Hussein Geabel
 * @author Deborah Odoh
 * 
 * @version March 2022
 */

public class Flight {
	private String code;
	private String airlineName;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private int seats;
	private double costPerSeat;
	

	/**
	 * Create an Flight object with default values
	 */
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create an Flight object by providing code, airlineName, from,
	 * to, weekday, time, seats, costPerSeat
	 * @param code
	 * @param airlineName
	 * @param from
	 * @param to
	 * @param weekday
	 * @param time
	 * @param seats
	 * @param costPerSeat
	 */
	public Flight(String code, String airlineName, String from, String to, String weekday, String time, int seats,
			double costPerSeat) {
		super();
		this.code = code;
		this.airlineName = airlineName;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	/**
	 * return the Flight code
	 * @return code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * return the Flight AirlineName
	 * @return AirlineName
	 */
	public String getAirlineName() {
		return airlineName;
	}

	/**
	 * return where the Flight From
	 * @return from
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * return where the Flight goes to
	 * @return to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * return the Weekday of Flight
	 * @return weekday
	 */
	public String getWeekday() {
		return weekday;
	}

	/**
	 * return the time of Flight
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * return the seats of Flight
	 * @return seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * return the cost per seats of Flight
	 * @return costPerSeat
	 */
	public double getCostPerSeat() {
		return costPerSeat;
	}

	/**
	 * return is the flight Domestic
	 * @return false
	 */
	public boolean isDomestic() {
		return false;

	}

	/**
	 * parse the flight code
	 * @param code
	 */
	private void parseCode(String code) {

	}

	@Override
	public String toString() {
		 return code +", From: " + from + ", To: " + to + ", Day: "
				+ weekday + ", Cost: " + costPerSeat;
	}

}
