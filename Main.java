import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<MaintenanceRecord> records = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Car Maintenance History Recorder ===");

        System.out.print("Enter car make: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter current mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        Car car = new Car(make, model, year, mileage, vin);
        System.out.println("\nCar registered: " + car.getYear() + " " + car.getMake() + " " + car.getModel());

        showMenu(car);
    }

    public static void showMenu(Car car) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add maintenance record");
            System.out.println("2. Print all records");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            if (choice == 1) {
                addRecord();
            } else if (choice == 2) {
                printHistory(car);
            } else if (choice == 3) {
                System.out.println("Exiting. Goodbye!");
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    public static void addRecord() {
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
        String serviceName = scanner.nextLine();

        System.out.print("Enter mileage at service: ");
        int mileage;
        try {
            mileage = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mileage. Record not added.");
            return;
        }

        System.out.print("Enter date (MM/DD/YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        if (type == 1) {
            System.out.print("Enter service interval (miles): ");
            int interval;
            try {
                interval = Integer.parseInt(scanner.nextLine());
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Record not added.");
                return;
            }
            records.add(new MajorRepair(serviceName, mileage, date, notes, cost));
            System.out.println("Major repair record added.");
        }
    }

    public static void printHistory(Car car) {
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
}
