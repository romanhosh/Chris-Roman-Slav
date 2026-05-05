# Chris-Roman-Slav
# Car-Manager
# This program is a command line Car Maintenance History Recorder. The user enters
# car information and logs maintenance records like oil changes and major repairs.
# Records are stored in an ArrayList, can be printed, and the user can add new
# records through a menu. Chris builds the base classes, Roman builds the subclasses,
# Slav builds the menu and user input, and leads the final merge.
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