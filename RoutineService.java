public class RoutineService extends MaintenanceRecord {

    private int serviceInterval;

    public RoutineService(String serviceName, int mileage, String date, String notes, int serviceInterval) {
        super(serviceName, mileage, date, notes);
        this.serviceInterval = serviceInterval;
    }

    public int getServiceInterval() {
        return serviceInterval;
    }

    public void setServiceInterval(int serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public String toString() {
        return super.toString() + "\nService Interval: every " + serviceInterval + " miles" + "\nType: Routine Service";
    }
}