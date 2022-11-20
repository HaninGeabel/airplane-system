package sait.frms.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the reservations tab.
 * 
 */
public class ReservationsTab extends TabBase {
	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;
	
	/**
	 * Instance of flight manager.
	 */
	private FlightManager flightManager;
	
	private JList<Reservation> reservationsList;
	
	
	private DefaultListModel<Reservation> reservationModel;
	/**
	 * Creates the components for reservations tab.
	 */
	JTextField codeSearchTextField = new JTextField(50);
	JTextField codeTextField = new JTextField(10);
	JTextField flightTextField = new JTextField(10);
	JTextField airlineTextField = new JTextField(10);
	JTextField airlineSearchTextField = new JTextField(50);
	JTextField costTextField = new JTextField(10);
	JTextField nameTextField = new JTextField(10);
	JTextField nameSearchTextField = new JTextField(50);
	JTextField citizenTextField = new JTextField(10);
	String [] statusStrings = {"Active", "Inactive"};
	JComboBox statusbox = new JComboBox(statusStrings);
	/**
	 * Creates the components for reservations tab.
	 */
	public ReservationsTab(ReservationManager reservationManager) {
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
		
		JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
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
		
		JPanel southJPanel = createSouthPanel();
		panel.add(southJPanel, BorderLayout.SOUTH);
		
		JPanel eastJPanel = createEastPanel();
		panel.add(eastJPanel, BorderLayout.EAST);
		
		
		reservationModel = new DefaultListModel<>();
		reservationsList = new JList<>(reservationModel);
		
		// User can only select one item at a time.
		reservationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.reservationsList);
		
		reservationsList.addListSelectionListener(new MyListSelectionListener());
		
		panel.add(scrollPane);
		
		return panel;
	}
	
	
	/**
	 * Creates the east panel.
	 * @return JPanel that goes in east.
	 */
	private JPanel createEastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		JPanel titleJPanel = new JPanel();
		JPanel detailsJPanel = new JPanel();
		JPanel updatePanel = new JPanel();
		
		titleJPanel.setLayout(new FlowLayout());
		JLabel reserveLabel = new JLabel("Reserve");
		titleJPanel.add(reserveLabel);
		
		detailsJPanel.setLayout(new GridBagLayout());	
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		JLabel codeJLabel = new JLabel("Code:");
		
		codeJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		detailsJPanel.add(codeJLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		codeTextField.setEditable(false);
		detailsJPanel.add(codeTextField, constraints);
		
		JLabel flightLabel = new JLabel("Flight:");
		flightLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		detailsJPanel.add(flightLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		flightTextField.setEditable(false);
		detailsJPanel.add(flightTextField, constraints);
		
		JLabel airlineLabel = new JLabel("Airline:");
		airlineLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		detailsJPanel.add(airlineLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		airlineTextField.setEditable(false);
		detailsJPanel.add(airlineTextField,constraints);
		
		JLabel costLabel = new JLabel("Cost:");
		costLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 3;
		detailsJPanel.add(costLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		costTextField.setEditable(false);
		detailsJPanel.add(costTextField,constraints);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 4;
		detailsJPanel.add(nameLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		detailsJPanel.add(nameTextField, constraints);
		
		JLabel citizenshipLabel = new JLabel("Citizenship:");
		citizenshipLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 5;
		detailsJPanel.add(citizenshipLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		detailsJPanel.add(citizenTextField, constraints);
		
		JLabel statusLabel = new JLabel("Status:");
		statusLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 6;
		detailsJPanel.add(statusLabel, constraints);
		
		
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		detailsJPanel.add(statusbox, constraints);			
		
		
		updatePanel.setLayout(new FlowLayout());
		JButton updateButton = new JButton("Update");
		eastPanel.add(titleJPanel,BorderLayout.NORTH);
		eastPanel.add(detailsJPanel,BorderLayout.CENTER);
		eastPanel.add(updateButton,BorderLayout.SOUTH);	
		updateButton.addActionListener(new updateButtonListener());
		return eastPanel;
	}

	
	/**
	 * Creates the south panel.
	 * @return JPanel that goes in south.
	 */	
	private JPanel createSouthPanel() {
		JPanel southPanel = new JPanel();
		JPanel upperPanel= new JPanel();
		JPanel middlePanel= new JPanel();
		JPanel lowerPanel= new JPanel();
		
		upperPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new BorderLayout());

		JLabel searchLabel = new JLabel("Search");
		
		upperPanel.add(searchLabel);
		
		
		middlePanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel codeLabel = new JLabel("Code:");
		codeLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		middlePanel.add(codeLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		middlePanel.add(codeSearchTextField, constraints);
		
		
		JLabel airlineLabel = new JLabel("Airline:");
		airlineLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		middlePanel.add(airlineLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		middlePanel.add(airlineSearchTextField, constraints);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		middlePanel.add(nameLabel, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		middlePanel.add(nameSearchTextField, constraints);
		
		
		lowerPanel.setLayout(new FlowLayout());
		JButton findRsvButton = new JButton("Find Reservations");
		findRsvButton.setPreferredSize(new Dimension(700,20));
		lowerPanel.add(findRsvButton);
		southPanel.add(upperPanel, BorderLayout.NORTH);
		southPanel.add(middlePanel,BorderLayout.CENTER);
		southPanel.add(lowerPanel,BorderLayout.SOUTH);	
		findRsvButton.addActionListener(new findRsvButtonlistener());
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
				int selectResv = reservationsList.getSelectedIndex();
				ListModel <Reservation>model = reservationsList.getModel();
				Reservation itemName = model.getElementAt(selectResv);
				/*
				 * flighTextField.setText(itemName.getCode());
			airlineField.setText(itemName.getAirlineName());
			dayTextField.setText(itemName.getWeekday());
			timeTextField.setText(itemName.getTime());
				 */
				codeTextField.setText(itemName.getCode());
				flightTextField.setText(itemName.getFlightCode());
				airlineTextField.setText(itemName.getAirline());
				costTextField.setText(Double.toString(itemName.getCost()));
				nameTextField.setText(itemName.getName());
				citizenTextField.setText(itemName.getCitizenship());
				//statusbox.setSelectedItem(itemName.isActive());

				if (itemName.isActive())
					statusbox.getModel().setSelectedItem(statusStrings[0]);
				else 
					statusbox.getModel().setSelectedItem(statusStrings[1]);				
				
				// TODO: handle exception
			}catch (ArrayIndexOutOfBoundsException D) {
				// TODO: handle exception
				System.out.println("check your reservation");
			}
			
		}
		
	}
	
	/**
	 * Called when user clicks the find reservation button.
	 */
	private class findRsvButtonlistener implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			
			 String code = codeSearchTextField.getText();
			 String airLine = airlineSearchTextField.getText();
			 String name = nameSearchTextField.getText();
			
			 if (airLine.equals("") && name.equals("")) {
				Reservation a =  reservationManager.findReservationByCode(code) ;
				 reservationModel.clear();
				reservationModel.addElement(a);
				
			 }
			 else {
				 reservationManager.findReservations(code, airLine, name);
				 reservationModel.clear();
				 for (Reservation a : reservationManager.findReservations(code, airLine, name)) {
						//System.out.println(a);
					reservationModel.addElement(a);
			
			}
			
		}
	}
	}
	
	/**
	 * Called when user clicks the update button.
	 */
	private class updateButtonListener implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			//calling modify reservation 
			int selectResv = reservationsList.getSelectedIndex();
			ListModel <Reservation>model = reservationsList.getModel();
			Reservation reservation = model.getElementAt(selectResv);
			
			String citizenship = citizenTextField.getText();
			String active = String.valueOf(statusbox.getSelectedItem());
		    String name = nameTextField.getText();
			
		    reservationManager.modifyReservation(reservation, name, citizenship, active);
		    
			//System.out.println("botton is working");
		}
	}
	
	

	
	
	

}
