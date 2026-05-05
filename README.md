# Chris-Roman-Slav
# Car-Manager
#
# Files:
# Car.java - Chris
# MaintenanceRecord.java - Chris
# RoutineService.java - Roman
# MajorRepair.java - Roman
# Main.java - Slav
#
# Project description approved by professor:
# Our program is a Car Maintenance History Recorder designed for car owners who want
# to keep a clear record of all maintenance done on their vehicle. It helps users
# track mileage, dates, and descriptions of repairs so they can easily share the
# history when selling the car.
#
# What and who is your program for?
# The program is for drivers, car enthusiasts, and anyone preparing to sell a used
# car. It gives them a simple command-line tool to store and view maintenance logs
# such as VANOS rebuilt at 120k miles, oil changed every 3k miles, or brakes
# replaced at 142k miles.
#
# What will your program do?
# The program will let the user enter basic car information and then add maintenance
# records that include the service name, mileage, date, and notes. It will store all
# records in an ArrayList, allow sorting by mileage or date, and display a full
# maintenance history formatted like a sellers post. The program will validate all
# user input and prevent crashes.
#
# What programming techniques will you need?
# We will use conditionals for menu choices and validation, methods for adding and
# displaying records, ArrayLists to store maintenance entries, loops for the menu
# system, classes for Car and MaintenanceRecord, and inheritance for different types
# of services such as RoutineService and MajorRepair.
#
# How do you plan to code this project?
# We will divide the work across the team. Chris will build the Car class and the
# base MaintenanceRecord class. Roman will create subclasses for different service
# types. Slav will build the menu system, input validation, and user interface and
# lead the final merge. After each part is completed we will merge everything in our
# GitHub repository, test all features, and refine the program.
#
# Agreed method and class names everyone must use:
# Car class: getMake() setMake() getModel() setModel() getYear() setYear() getMileage() setMileage() getVIN() setVIN()
# MaintenanceRecord class: getServiceName() setServiceName() getMileage() setMileage() getDate() setDate() getNotes() setNotes() toString()
# RoutineService class: getServiceInterval() setServiceInterval() toString()
# MajorRepair class: getPartsCost() setPartsCost() toString()
# Main class: main() printHistory() showMenu()
#
# 1. Chris - Base classes:
# 	1. Create Car.java
# 		1. Add private attributes make, model, year, mileage, VIN
# 		2. Add getters and setters for all attributes
# 		3. Add a constructor that takes all fields
# 	2. Create MaintenanceRecord.java
# 		1. Add private attributes serviceName, mileage, date, notes
# 		2. Add getters and setters for all attributes
# 		3. Add a constructor that takes all fields
# 		4. Add a toString method that prints all the record information neatly
#
# 2. Roman - Subclasses:
# 	1. Create RoutineService.java extending MaintenanceRecord
# 		1. Add private attribute serviceInterval (int)
# 		2. Add a getter and setter for serviceInterval
# 		3. Add a constructor that takes all fields including serviceInterval
# 		4. Override toString to print all fields including serviceInterval
# 	2. Create MajorRepair.java extending MaintenanceRecord
# 		1. Add private attribute partsCost (double)
# 		2. Add a getter and setter for partsCost
# 		3. Add a constructor that takes all fields including partsCost
# 		4. Override toString to print all fields including partsCost
#
# 3. Slav - Menu, user input, and merge:
# 	1. Create Main.java
# 		1. Create an ArrayList to store MaintenanceRecord objects
# 		2. Use a while loop to show the user a menu with options to add a record, print all records, and exit
# 		3. Use Scanner to read what the user types
# 		4. When adding a record ask the user if it is a RoutineService or MajorRepair
# 		5. Ask the user to enter each field one at a time and create the correct object
# 		6. When the user picks print all records loop through the ArrayList and print each one
# 		7. When the user picks exit end the program
# 	2. Merge all branches into main once everyone is done
# 	3. Run the full program and confirm everything compiles and works together