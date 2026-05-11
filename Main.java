import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<ArrayList<MaintenanceRecord>> allRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String[] menuOptions = {"1. Add a car", "2. Select a car", "3. Exit"};
    static String[] carMenuOptions = {"1. Add maintenance record", "2. Print all records", "3. Search records", "4. Show summary", "5. Go back"};

    // Make = letters + spaces only
    public static boolean isValidMake(String s) {
        return s.matches("[A-Za-z ]+");
    }

    // Model = letters + numbers + spaces
    public static boolean isValidModel(String s) {
        return s.matches("[A-Za-z0-9 ]+");
    }

    // Service name = letters + numbers + spaces
    public static boolean isValidServiceName(String s) {
        return s.matches("[A-Za-z0-9 ]+");
    }

    // VIN must be exactly 17 alphanumeric characters
    public static boolean isValidVIN(String vin) {
        return vin.matches("[A-Za-z0-9]{17}");
    }

    // Date must be MM/DD/YYYY
    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static void main(String[] args) {
        System.out.println("=== Car Maintenance History Recorder ===");
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n--- Main Menu ---");
            for (String option : menuOptions) {
                System.out.println(option);
            }
            System.out.print("Choose an option: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }
            if (choice == 1) {
                addCar();
            } else if (choice == 2) {
                selectCar();
            } else if (choice == 3) {
                System.out.println("Exiting. Goodbye!");
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    public static void addCar() {
        System.out.print("Enter car make: ");
        String make = scanner.nextLine().trim();
        if (!isValidMake(make)) {
            System.out.println("Make must contain only letters and spaces. Car not added.");
            return;
        }

        System.out.print("Enter car model: ");
        String model = scanner.nextLine().trim();
        if (!isValidModel(model)) {
            System.out.println("Model must contain only letters, numbers, and spaces. Car not added.");
            return;
        }

        System.out.print("Enter car year: ");
        int year;
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Car not added.");
            return;
        }

        System.out.print("Enter current mileage: ");
        int mileage;
        try {
            mileage = Integer.parseInt(scanner.nextLine());
            if (mileage < 0) {
                System.out.println("Mileage cannot be negative. Car not added.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid mileage. Car not added.");
            return;
        }

        System.out.print("Enter VIN (17 characters): ");
        String vin = scanner.nextLine().trim();
        if (!isValidVIN(vin)) {
            System.out.println("VIN must be exactly 17 alphanumeric characters. Car not added.");
            return;
        }

        cars.add(new Car(make, model, year, mileage, vin));
        allRecords.add(new ArrayList<>());
        System.out.println("Car added: " + year + " " + make + " " + model);
    }

    public static void selectCar() {
        if (cars.isEmpty()) {
            System.out.println("No cars registered yet. Please add a car first.");
            return;
        }
        System.out.println("\n--- Select a Car ---");
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            System.out.println((i + 1) + ". " + c.getYear() + " " + c.getMake() + " " + c.getModel());
        }
        System.out.print("Choose a car: ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }
        if (index < 0 || index >= cars.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        showCarMenu(cars.get(index), allRecords.get(index));
    }

    public static void showCarMenu(Car car, ArrayList<MaintenanceRecord> records) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- " + car.getYear() + " " + car.getMake() + " " + car.getModel() + " ---");
            for (String option : carMenuOptions) {
                System.out.println(option);
            }
            System.out.print("Choose an option: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 through 5.");
                continue;
            }
            if (choice == 1) {
                addRecord(records);
            } else if (choice == 2) {
                printHistory(car, records);
            } else if (choice == 3) {
                searchRecords(records);
            } else if (choice == 4) {
                showSummary(car, records);
            } else if (choice == 5) {
                System.out.println("Going back to main menu.");
            } else {
                System.out.println("Invalid option. Please choose 1 through 5.");
            }
        }
    }

    public static void addRecord(ArrayList<MaintenanceRecord> records) {
        System.out.println("\nIs this a (1) Routine Service or (2) Major Repair?");
        System.out.print("Enter 1 or 2: ");
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Record not added.");
            return;
        }
        if (type != 1 && type != 2) {
            System.out.println("Invalid choice. Record not added.");
            return;
        }

        System.out.print("Enter service name: ");
        String serviceName = scanner.nextLine().trim();
        if (!isValidServiceName(serviceName)) {
            System.out.println("Service name must contain only letters, numbers, and spaces. Record not added.");
            return;
        }

        System.out.print("Enter mileage at service: ");
        int mileage;
        try {
            mileage = Integer.parseInt(scanner.nextLine());
            if (mileage < 0) {
                System.out.println("Mileage cannot be negative. Record not added.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid mileage. Record not added.");
            return;
        }

        System.out.print("Enter date (MM/DD/YYYY): ");
        String date = scanner.nextLine().trim();
        if (!isValidDate(date)) {
            System.out.println("Invalid date format. Record not added.");
            return;
        }

        System.out.print("Enter notes: ");
        String notes = scanner.nextLine().trim();
        if (notes.isEmpty()) {
            System.out.println("Notes cannot be empty. Record not added.");
            return;
        }

        if (type == 1) {
            System.out.print("Enter service interval (miles): ");
            int interval;
            try {
                interval = Integer.parseInt(scanner.nextLine());
                if (interval < 0) {
                    System.out.println("Interval cannot be negative. Record not added.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid interval. Record not added.");
                return;
            }
            records.add(new RoutineService(serviceName, mileage, date, notes, interval));
            System.out.println("Routine service record added.");
        } else {
            System.out.print("Enter parts cost ($): ");
            double cost;
            try {
                cost = Double.parseDouble(scanner.nextLine());
                if (cost < 0) {
                    System.out.println("Cost cannot be negative. Record not added.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Record not added.");
                return;
            }
            records.add(new MajorRepair(serviceName, mileage, date, notes, cost));
            System.out.println("Major repair record added.");
        }
    }

    public static void printHistory(Car car, ArrayList<MaintenanceRecord> records) {
        System.out.println("\n========================================");
        System.out.println("Vehicle: " + car.getYear() + " " + car.getMake() + " " + car.getModel());
        System.out.println("VIN: " + car.getVIN());
        System.out.println("Current Mileage: " + car.getMileage());
        System.out.println("========================================");
        if (records.isEmpty()) {
            System.out.println("No maintenance records on file.");
        } else {
            System.out.println("Maintenance History (" + records.size() + " records):");
            for (int i = 0; i < records.size(); i++) {
                System.out.println("\n--- Record " + (i + 1) + " ---");
                System.out.println(records.get(i).toString());
            }
        }
        System.out.println("========================================");
    }

    public static void searchRecords(ArrayList<MaintenanceRecord> records) {
        if (records.isEmpty()) {
            System.out.println("No records to search.");
            return;
        }
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        if (keyword.isEmpty()) {
            System.out.println("Keyword cannot be empty.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).toString().toLowerCase().contains(keyword)) {
                System.out.println("\n--- Record " + (i + 1) + " ---");
                System.out.println(records.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found matching: " + keyword);
        }
    }

    public static void showSummary(Car car, ArrayList<MaintenanceRecord> records) {
        System.out.println("\n========================================");
        System.out.println("Summary for: " + car.getYear() + " " + car.getMake() + " " + car.getModel());
        System.out.println("Total records: " + records.size());
        if (!records.isEmpty()) {
            int highestMileage = 0;
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getMileage() > highestMileage) {
                    highestMileage = records.get(i).getMileage();
                }
            }
            System.out.println("Highest mileage service: " + highestMileage + " miles");
        }
        System.out.println("========================================");
    }
}
