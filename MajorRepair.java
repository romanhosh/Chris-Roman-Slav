public class MajorRepair extends MaintenanceRecord {

    private double partsCost;

    public MajorRepair(String serviceName, int mileage, String date, String notes, double partsCost) {
        super(serviceName, mileage, date, notes);
        this.partsCost = partsCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public String toString() {
        return super.toString() + "\nParts Cost: $" + partsCost + "\nType: Major Repair";
    }
}