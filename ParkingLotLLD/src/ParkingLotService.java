import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    ParkingLot parkingLot;

    public Boolean create(Integer size) {
        this.parkingLot = new ParkingLot(size);
        for (int i = 1; i <= size; i++) {
            Slot slot = new Slot(i);
            this.parkingLot.getAvailableSlots().add(slot);
        }
        return true;
    }

    public Slot parkVehicle(String licensePlate, Integer driversAge) {
        if (this.parkingLot.getAvailableSlots().size() == 0) {
            return null;
        }
        Slot pickedSlot = this.parkingLot.getAvailableSlots().poll();
        pickedSlot.setIsFree(false);
        this.parkingLot.getSlotForNumber().put(pickedSlot.getNumber(), pickedSlot);
        Vehicle vehicle = new Vehicle(licensePlate, driversAge, pickedSlot);
        pickedSlot.setVehicle(vehicle);
        vehicle.setOccupiedSlot(pickedSlot);
        this.parkingLot.getVehicleForLicensePlate().put(licensePlate, vehicle);
        if (this.parkingLot.getVehiclesForDriversAge().containsKey(driversAge)) {
            this.parkingLot.getVehiclesForDriversAge().get(driversAge).add(vehicle);
        } else {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>() {{
                add(vehicle);
            }};
            this.parkingLot.getVehiclesForDriversAge().put(driversAge, vehicleList);
        }
        return pickedSlot;
    }

    public Vehicle leaveVehicle(Integer slotNumber) {
        if (!this.parkingLot.getSlotForNumber().containsKey(slotNumber)) {
            return null;
        }
        Slot slot = this.parkingLot.getSlotForNumber().get(slotNumber);
        this.parkingLot.getSlotForNumber().remove(slotNumber);
        this.parkingLot.getVehicleForLicensePlate().remove(slot.getVehicle().getLicensePlate());
        List<Vehicle> vehiclesForDriversAge = this.parkingLot.getVehiclesForDriversAge()
                .get(slot.getVehicle().getDriversAge());
        vehiclesForDriversAge.remove(slot.getVehicle());
        this.parkingLot.getVehiclesForDriversAge().put(slot.getVehicle().getDriversAge(),vehiclesForDriversAge);
        Vehicle vehicle = slot.getVehicle();
        slot.setVehicle(null);
        slot.setIsFree(true);
        this.parkingLot.getAvailableSlots().add(slot);
        return vehicle;
    }

    public List<Integer> getSlotNumbersForDriversAge(Integer driversAge) {
        if (!this.parkingLot.getVehiclesForDriversAge().containsKey(driversAge))
            return null;
        return this.parkingLot.getVehiclesForDriversAge().get(driversAge)
                .stream().map(vehicle -> vehicle.getOccupiedSlot().getNumber()).collect(Collectors.toList());
    }

    public Integer getSlotNumberForLicensePlate(String licensePlate) {
        if (!this.parkingLot.getVehicleForLicensePlate().containsKey(licensePlate))
            return null;
        return this.parkingLot.getVehicleForLicensePlate().get(licensePlate).getOccupiedSlot().getNumber();
    }

    public List<String> getLicensePlatesForDriversAge(Integer driversAge) {
        if(!this.parkingLot.getVehiclesForDriversAge().containsKey(driversAge)){
            return null;
        }
        return this.parkingLot.getVehiclesForDriversAge().get(driversAge)
                .stream().map(vehicle -> vehicle.getLicensePlate()).collect(Collectors.toList());
    }
}
