package sait.frms.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase 
{
	/**
	 * Instance of flight manager.
	 */
	private FlightManager flightManager;
	
	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;
	
	/**
	 * List of flights.
	 */
	 private JList<Flight> flightsList;
	
	 private DefaultListModel<Flight> flightsModel;
	
	/**
	 * Creates the components for flights tab.
	 */
	
	
	JTextField flighTextField = new JTextField(10);
	JTextField airlineField = new JTextField(10);
	JTextField dayTextField = new JTextField(10);
	JTextField timeTextField = new JTextField(10);
	JTextField costTextField = new JTextField(10);
	JTextField nameField = new JTextField(10);
	JTextField citizenshipTextField = new JTextField(10);
	
	String [] day = {"Any","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	
	String [] fromStrings;
	String [] toStrings;
	JComboBox<?> tobox;
	JComboBox<?> frombox;
	JComboBox<?> daybox;
	
	/**
	 * Creates the components for flights tab.
	 * 
	 * @param flightManager Instance of FlightManager.
	 * @param reservationManager Instance of ReservationManager
	 */
	public FlightsTab(FlightManager flightManager, ReservationManager reservationManager) {
		this.flightManager = flightManager;
		this.reservationManager = reservationManager;
		
		panel.setLayout(new BorderLayout());
		
		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates the north panel.
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);
		
		return panel;
	}
	
	/**
	 * Creates the center panel.
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() 
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		JPanel southJPanel = buildSouthPanel();
		panel.add(southJPanel, BorderLayout.SOUTH);
		
		JPanel eastJPanel = creatEastPanel();
		panel.add(eastJPanel, BorderLayout.EAST);
		
		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);
 
		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.flightsList);
		
		flightsList.addListSelectionListener(new MyListSelectionListener());
		
		panel.add(scrollPane);
		
		
		
		return panel;
	}
	

	/**
	 * Creates the east panel.
	 * @return JPanel that goes in the east.
	 */
	private JPanel creatEastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		JPanel testJPanel = new JPanel();
		JPanel flightInfJPanel = new JPanel();
		JPanel reservePanel = new JPanel();
		
		testJPanel.setLayout(new FlowLayout());
		JLabel reserveLabel = new JLabel("Reserve");
		testJPanel.add(reserveLabel);
		
		flightInfJPanel.setLayout(new GridBagLayout());	
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		JLabel flightJLabel = new JLabel("Flight:");
		
		flightJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		flightInfJPanel.add(flightJLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		flighTextField.setEditable(false);
		flightInfJPanel.add(flighTextField, constraints);
		
		JLabel airLineLabel = new JLabel("Airline:");
		airLineLabel.setHorizontalAlignment(JLabel.RIGHT);
		// c.weightx = 0.5;
		// c.fill = GridBagConstraints.VERTICAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		flightInfJPanel.add(airLineLabel, constraints);
		
		
		// c.weightx = 0.5;
		// c.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		airlineField.setEditable(false);
		flightInfJPanel.add(airlineField, constraints);
		
		JLabel dayLabel = new JLabel("Day:");
		dayLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		flightInfJPanel.add(dayLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		dayTextField.setEditable(false);
		flightInfJPanel.add(dayTextField,constraints);
		
		JLabel timeLabel = new JLabel("Time:");
		timeLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 3;
		flightInfJPanel.add(timeLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		timeTextField.setEditable(false);
		flightInfJPanel.add(timeTextField,constraints);
		
		JLabel costLabel = new JLabel("Cost:");
		costLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 4;
		flightInfJPanel.add(costLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		costTextField.setEditable(false);
		flightInfJPanel.add(costTextField, constraints);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 5;
		flightInfJPanel.add(nameLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		flightInfJPanel.add(nameField, constraints);
		
		JLabel citizenshipLabel = new JLabel("Citizenship:");
		citizenshipLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 6;
		flightInfJPanel.add(citizenshipLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		flightInfJPanel.add(citizenshipTextField, constraints);
		
		reservePanel.setLayout(new FlowLayout());
		JButton reserveButton = new JButton("Reserve");
		eastPanel.add(testJPanel,BorderLayout.NORTH);
		eastPanel.add(flightInfJPanel,BorderLayout.CENTER);
		eastPanel.add(reserveButton,BorderLayout.SOUTH);
		
		reserveButton.addActionListener(new reserveButtonListener());
		return eastPanel;
		
		
	}
	
	/**
	 * Creates the south panel.
	 * @return JPanel that goes in the south.
	 */
	private JPanel buildSouthPanel() {
		/*eastPanel.setLayout(new GridBagLayout());	
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;*/
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		JPanel upperPanel= new JPanel();
		JPanel middlePanel= new JPanel();
		JPanel lowerPanel= new JPanel();
		
		upperPanel.setLayout(new FlowLayout());
		
		JLabel flightFinderLabel = new JLabel("Flight Finder");
		
		upperPanel.add(flightFinderLabel);
		
		
		middlePanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		JLabel fromLabel = new JLabel("From:");
		
		fromLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		middlePanel.add(fromLabel, constraints);

		fromStrings = flightManager.findairportStrings();
				
		frombox= new JComboBox<Object>(fromStrings);
		constraints.gridx = 1;
		constraints.gridy = 0;
		frombox.setPreferredSize(new Dimension(700,20));
		middlePanel.add(frombox, constraints);
		
		toStrings = flightManager.findairportStrings();
		JLabel toLabel = new JLabel("To:");
		toLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		middlePanel.add(toLabel, constraints);
		
		
		tobox= new JComboBox<Object>(toStrings);
		constraints.gridx = 1;
		constraints.gridy = 1;
		middlePanel.add(tobox, constraints);
		
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		middlePanel.add(dayLabel, constraints);
		
		
		daybox= new JComboBox<Object>(day);
		constraints.gridx = 1;
		constraints.gridy = 2;
		middlePanel.add(daybox, constraints);
		
		
		
		
		lowerPanel.setLayout(new FlowLayout());
		JButton findFlightButton = new JButton("Find flights");
		findFlightButton.setPreferredSize(new Dimension(700,20));
		lowerPanel.add(findFlightButton);
		southPanel.add(upperPanel, BorderLayout.NORTH);
		southPanel.add(middlePanel,BorderLayout.CENTER);
		southPanel.add(lowerPanel,BorderLayout.SOUTH);
		//southPanel.setPreferredSize(new Dimension(250,20));

		findFlightButton.addActionListener(new findFlightButtonListener());
		return southPanel;
	}
	
	private class MyListSelectionListener implements ListSelectionListener 
	{
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			try {
			int a = flightsList.getSelectedIndex();
			ListModel<Flight> model = flightsList.getModel();
			Flight itemName = model.getElementAt(a);
			
			
			
			
			flighTextField.setText(itemName.getCode());
			airlineField.setText(itemName.getAirlineName());
			dayTextField.setText(itemName.getWeekday());
			timeTextField.setText(itemName.getTime());
			costTextField.setText(String.valueOf(itemName.getCostPerSeat()));}catch(java.lang.ArrayIndexOutOfBoundsException E){
				System.out.println("OH MY GOD");
				
			}
	
			
			
		}
		
	}
	
	private class reserveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String code =  flighTextField.getText();
			String airlineName=	airlineField.getText();
			String day = dayTextField.getText();
			String time =	timeTextField.getText();
			String from = String.valueOf(frombox.getSelectedItem());
			String to =  String.valueOf(tobox.getSelectedItem());
			
			String cost= costTextField.getText();
			Double costDouble = Double.parseDouble(cost);
			String name=nameField.getText();
			String citizenship=	citizenshipTextField.getText();
			System.out.println("button works");
			Flight newFlight = new Flight(code,airlineName, from,to,day,time,1,costDouble);
			
			try {
				reservationManager.makeReservation(newFlight,  name,  citizenship);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				 JOptionPane.showMessageDialog(null, "name and citizenship field must be filled" );
			}	
			//throw exception when name or citizenship is null
			
				
				
			
			
		}
		
	}
	private class findFlightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flighTextField.setText("");
			airlineField.setText("");
			dayTextField.setText("");
			timeTextField.setText("");
			costTextField.setText("");
			String input = String.valueOf(frombox.getSelectedItem());
			String input2 = String.valueOf(tobox.getSelectedItem());
			String input3 = String.valueOf(daybox.getSelectedItem());

			flightManager.findFlights(input, input2, input3);	
			flightsModel.clear();
			
			for (Flight a : flightManager.findFlights(input, input2, input3)) {
				//System.out.println(a);
				flightsModel.addElement(a);
			}

			}
		}

		


		
}