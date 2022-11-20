package sait.frms.manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import sait.frms.problemdomain.Flight;

public class FlightManager {
	public String weekday;
	public String Sunday;
	public String Monday; 
	public String Tuesday;
	public String Wednesday;
	public String Thursday;
	public String Friday;
	public String Saturday;
	
	private ArrayList<Flight> flights = new ArrayList<Flight>();
	private ArrayList<String> airports = new ArrayList<String>();
	
	
	public FlightManager() {
		populateFlights();
		populateAirports();
		
	}

	public ArrayList<Flight> getFlights() {
		
		 
		
		return flights;
		
		
	}
	public String[] findairportStrings() {
		//        String k[] = al.toArray(new String[al.size()]);

		try {
			String[] airportNamesTemp = airports.toArray(new String[airports.size()]);
			String[] airportNames = new String[(int)(airportNamesTemp.length/2)];
			for (int i=0; i < airportNamesTemp.length; i=i+2) {
				int j = (int) i/2;
				airportNames[j]=  (airportNamesTemp[i]);
				
			}
			 Arrays.sort(airportNames);
			return airportNames;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return null;
	}
		
	

	

	
	/**
	 * @return list of airports
	 */
	public ArrayList<String> getAirports() {
		return airports;

	}
	
	public String findAirportByCode(String code) {
		return null;	
	}
	
	public Flight findFlightByCode(String code) {
		for(Flight f:flights) {
			if(code.equals(f.getCode())){
			return f;
		
			
		}
		}
		
		return null;
		
	}
	
	public ArrayList<Flight> findFlights(String from, String to, String weekday){
	
		ArrayList<Flight> foundFlights = new ArrayList<Flight>();
		
		for(Flight f:flights) {
			if((from.equals(f.getFrom()) &&(to.equals(f.getTo())&&(weekday.equals(f.getWeekday()))))){
				foundFlights.add(f);
			}
			else if(from.equals(f.getFrom()) &&(to.equals(f.getTo())&&(weekday.equals("Any")))){
				foundFlights.add(f);
				
			}
			}
		return foundFlights;
		
	}
	
	private void populateFlights() 
	{
		try {
			Scanner in = new Scanner(new File("res/flights.csv"));
			while(in.hasNext())
			{
				String line = in.nextLine();
				String[] flight = line.split(",");	
				String code= flight[0];
				
				String departure= flight[1];
				String codeArrival = flight[2];
				String weekday = flight[3];
				String time = flight[4];
				int seats =Integer.parseInt(flight[5]) ;
				double cost = Double.parseDouble(flight[6]) ;
		
				 String airlineCode = code.substring(0, 2);
				 String subAirLineCode = code.substring(code.length() - 4);
				 if((airlineCode.matches("[a-zA-Z]+")) && ((subAirLineCode.matches("[0-9]+"))))
				 	{

				
				// if(Character.isDigit(c))   str.matches("[a-zA-Z]+");
					 	if (airlineCode.equals("OA"))
					 	{
					 			airlineCode = "Otto Airlines";
					 	}
					else if (airlineCode.equals("CA"))
						{
						airlineCode = "Conned Air";
						} 
					else if (airlineCode.equals("TB"))
						{
						airlineCode = "Try a Bus Airways";
						}
					else if (airlineCode.equals("VA")) 
						{
						airlineCode = "Vertical Airways";
						}
					else 
						{
						System.out.println("Check the code : "+ code);
						continue;
						}
				 	}else
				 	{
						System.out.println("Check the code : "+ code);
					continue;
				 	}
				// create an object 
					Flight f = new Flight(code, airlineCode,departure,codeArrival,weekday,time,seats,cost);
					flights.add(f);
			}		
			
				in.close();
			
			} catch (FileNotFoundException e) 
				{
					System.out.println("File does not exist");
						e.printStackTrace();
			
				}
	}
		
	
	
	
	
	private void populateAirports() {
		
		try {
		Scanner in = new Scanner(new File("res/airports.csv"));
		while (in.hasNext()) {
		String line = in.nextLine();
		String[] airportPopertity = line.split(",");
		String airportSimpleName = airportPopertity[0];
		String airportName = airportPopertity[1];
		airports.add(airportSimpleName);
		airports.add(airportName);
		}
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		}
	
	}