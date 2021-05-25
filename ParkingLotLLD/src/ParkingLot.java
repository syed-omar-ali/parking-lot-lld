import java.util.*;

public class ParkingLot {
    private Integer numberOfSlots;
    private PriorityQueue<Slot> availableSlots;
    private Map<Integer,List<Vehicle>> vehiclesForDriversAge;
    private Map<Integer,Slot> slotForNumber;
    private Map<String,Vehicle> vehicleForLicensePlate;


    public ParkingLot(Integer size){
        this.numberOfSlots = size;
        this.availableSlots = new PriorityQueue <Slot> ();
        this.vehiclesForDriversAge = new HashMap<>();
        this.slotForNumber = new HashMap<>();
        this.vehicleForLicensePlate = new HashMap<>();
    }

    // Could use Lombok for generating this boiler plate code
    public Integer getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(Integer numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public void setAvailableSlots(PriorityQueue<Slot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public PriorityQueue<Slot> getAvailableSlots() {
        return availableSlots;
    }

    public Map<Integer, List<Vehicle>> getVehiclesForDriversAge() {
        return vehiclesForDriversAge;
    }

    public void setVehiclesForDriversAge(Map<Integer, List<Vehicle>> vehiclesForDriversAge) {
        this.vehiclesForDriversAge = vehiclesForDriversAge;
    }

    public Map<Integer, Slot> getSlotForNumber() {
        return slotForNumber;
    }

    public void setSlotForNumber(Map<Integer, Slot> slotForNumber) {
        this.slotForNumber = slotForNumber;
    }

    public Map<String, Vehicle> getVehicleForLicensePlate() {
        return vehicleForLicensePlate;
    }

    public void setVehicleForLicensePlate(Map<String, Vehicle> vehicleForLicensePlate) {
        this.vehicleForLicensePlate = vehicleForLicensePlate;
    }
}
