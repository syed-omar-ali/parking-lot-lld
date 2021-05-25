public class Vehicle {
    private String licensePlate;
    private Integer driversAge;
    private Slot occupiedSlot;



    public Vehicle(String licensePlate, Integer driversAge, Slot occupiedSlot){
        this.driversAge = driversAge;
        this.licensePlate = licensePlate;
        this.occupiedSlot = occupiedSlot;
    }

    public boolean equals(Vehicle obj) {
        return ((this.getLicensePlate() == null && obj.getLicensePlate() == null)
                || (this.getLicensePlate() != null && obj.getLicensePlate() == null && this.getLicensePlate().equals(obj.getLicensePlate())));
    }

    // Could use Lombok for generating this boiler plate code
    public Integer getDriversAge() {
        return driversAge;
    }

    public void setDriversAge(Integer driversAge) {
        this.driversAge = driversAge;
    }

    public Slot getOccupiedSlot() {
        return occupiedSlot;
    }

    public void setOccupiedSlot(Slot occupiedSlot) {
        this.occupiedSlot = occupiedSlot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
