Flight reservation management system 

Written by Hanin, Henry, Deborah  

Block C  group 5 

March 28th 2022 



This Program contains 5 packages: application, gui, exception, manager and problemdomain. 

In the problemdomain, there are two classes, class Flight that describe the Flight object and class Reservation that describe the Reservation object. 

In the package manager, there are two classes which are FlightManager and ReservationManager. they contains the funcitons about reading the files, finding informations about flights, make Reservation, find reservations and modify it.

In the package gui, there are four classes created product interface, MainWindow, TabBase, FlightsTab and ReservationsTab. User can use this System through this graphical user interface.

We have put the main class as we create a manager object in the application package.



In this Flight reservation management system, when code excuated. The graphical user interface will show up.

In the Flight page, the user can find the flights base on the destation, where are they from and the date. once they select those information and click Find Flight button, all available flights will show up as list.

Click each list, the user can get all the information about that flight, they can make a reservation by entering their name and citizenship and then click reserve button.A reservation code will be generated and assigned to their name and citizenship.

In the Reservation page, user can find their reservation information by entering their Name, Code or Airline. there are three fields that they can be edited which are name, citizenship and status. once they click update, all reservation objects will save into a binary file.










