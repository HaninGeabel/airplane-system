package sait.frms.manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class ReservationManager {
	
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	final String MODE = "rws";
	final String FILE = "res/reserve.dat";
	
	final int FILE_SIZE = 161; //7+9+22+102+62+8
	
	/**
	 * 
	 */
	public ReservationManager(){
		try {
			RandomAccessFile res = new RandomAccessFile(FILE, MODE);
			if(res.length() > 0) {
				//System.out.println("hhhhh");
				
				populateFromBinary();
				res.close();
			}
		} catch (IOException e) {
			System.out.println("file is not found ");
			//e.printStackTrace();
		}
	}
	
	/**
	 * @param flight Flight code
	 * @param name Customer's full name
	 * @param citizenship Customer's citizenship
	 * @return reservation object
	 * @throws Exception Throws an IO Exception 
	 */
	public Reservation makeReservation(Flight flight, String name, String citizenship) throws Exception{
		Reservation reservation = null ;
		try {
		if(name.equals("") || citizenship.equals(""))
		throw new Exception("name and citizenship field must be entered");



		String rCode = generateReservationCode(flight);
		String flightCode = flight.getCode();
		String airline = flight.getAirlineName();
		double cost = flight.getCostPerSeat();
		boolean isActive = true;
		int seats = getAvailableSeats(flight);
		if(seats<=0) {
			System.out.println("No seats avalable");
			System.exit(0);
		}
 
		reservation = new Reservation(rCode, flightCode, airline, name, citizenship, cost, isActive);
		//update number of flight seats
		reservations.add(reservation);
		persist();
		JOptionPane.showMessageDialog(null, "Your code is "+ rCode );
		
		

		}catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "name and citizenship field must be filled" );
	}
		return reservation;
	}
	
	public ArrayList<Reservation> findReservations(String code, String airline, String name){
		ArrayList<Reservation> foundReservations = new ArrayList<Reservation>();

		for(Reservation reserved: reservations) {
			String rCode = reserved.getCode();
			String rAirline = reserved.getAirline();
			String rName = reserved.getName();
			
			if(rCode.equalsIgnoreCase(code) || rAirline.equalsIgnoreCase(airline) || rName.equalsIgnoreCase(name))
				foundReservations.add(reserved);
			}
		return foundReservations;
	}
	
	public Reservation findReservationByCode(String code) {
		for(Reservation reserved: reservations) {
			String rCode = reserved.getCode();
			if(rCode.equalsIgnoreCase(code))
					return reserved;
			}
		
		return null;
	}
	
	/*public void persist() throws IOException {
		long position;
		
		for(Reservation e: reservations) {
			String rCode = e.getCode();
			String flightCode = e.getFlightCode();
			String airline = e.getAirline();
			String name = e.getName();
			String citizenship = e.getCitizenship();
			double cost = e.getCost();			
			
			RandomAccessFile res = new RandomAccessFile("res/reserve.dat", "rws");
			String data = rCode + " " + flightCode + " " + airline + " " + name + " " + citizenship + " " + cost;
			try {
				//res.seek(0);
				res.write(data.getBytes());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}	*/
	
		
	public void persist() throws IOException {
		//long position;
		RandomAccessFile res = new RandomAccessFile("res/reserve.dat", "rws");
		for(Reservation e: reservations) {
		String rCode = String.format("%-7s", e.getCode());
		String flightCode = String.format("%-9s", e.getFlightCode());
		String airline = String.format("%-50s", e.getAirline());
		String name = String.format("%-50s", e.getName());
		String citizenship = String.format("%-30s", e.getCitizenship());
		double cost = e.getCost();
		boolean active = e.isActive();

	
		try {
		//res.seek(FILE_SIZE);
		//res.write(data.getBytes()); 7+9+102+102+52+8+1
		res.writeUTF(rCode);
		res.writeUTF(flightCode);
		res.writeUTF(airline);
		res.writeUTF(name);
		res.writeUTF(citizenship);
		res.writeDouble(cost);
		res.writeBoolean(active);

		} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		}
		}
	
	private int getAvailableSeats(Flight flight) {
		
		return flight.getSeats();
	}
	
	private String generateReservationCode(Flight flight) {
		
		String from = flight.getFrom();
		String to = flight.getTo();
		String letter = "I";
		int digits = 1000 + (int)(Math.random() * 9000);
		
		if(from.charAt(0) == 'Y' && to.charAt(0) == 'Y') {
			letter = "D";
		}
		
		return letter+digits;
	}
	
	private void populateFromBinary() throws IOException {
		/*final String MODE = "rws";
		final String FILE = "res/reserve.dat";
		RandomAccessFile res = new RandomAccessFile(FILE, MODE);
		final int FILE_SIZE = 210; //7+9+22+102+62+8
		*/
		RandomAccessFile res = new RandomAccessFile(FILE, MODE);
		for(long position = 0; position < res.length(); position += FILE_SIZE) {
			String rCode = res.readUTF().trim();
			String flightCode = res.readUTF().trim();
			String airline = res.readUTF().trim();
			String name = res.readUTF().trim();
			String citizenship = res.readUTF().trim();
			double cost = res.readDouble();
			Boolean active = res.readBoolean();
			
			Reservation reservation = new Reservation(rCode, flightCode, airline, name, citizenship, cost, active);
			reservations.add(reservation);
		}
		
		res.close();
	}
	
	public void modifyReservation(Reservation r, String name, String citizenship, String activte) {
		
		Boolean status = false;
		//System.out.println(activte);
		if (activte.equals("Active"))
			status = true;
			
		r.setName(name);
		r.setCitizenship(citizenship);
		r.setActive(status);
		try {
			persist();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error in modify");
			e.printStackTrace();
		}
	}
	
}
