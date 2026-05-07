public class MaintenanceRecord {
    private String serviceName;
    private int mileage;
    private String date;
    private String notes;

    public MaintenanceRecord(String serviceName, int mileage, String date, String notes) {
        this.serviceName = serviceName;
        this.mileage = mileage;
        this.date = date;
        this.notes = notes;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "Service Name: " + serviceName +
               "\nMileage: " + mileage +
               "\nDate: " + date +
               "\nNotes: " + notes;
    }
}