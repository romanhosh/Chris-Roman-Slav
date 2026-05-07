public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String VIN;

    public Car(String make, String model, int year, int mileage, String VIN) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}