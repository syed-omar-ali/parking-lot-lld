
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CommandExecutorService {

    // Could have been injected using dependency injection
    ParkingLotService parkingLotService = new ParkingLotService();

    public boolean execute(String command){
        StringTokenizer stringTokenizer = new StringTokenizer(command);
        COMMAND operation = null;
        try {
            operation = COMMAND.valueOfLabel(stringTokenizer.nextToken());
            switch (operation){
                case CREATE:
                    if(stringTokenizer.hasMoreTokens()) {
                        Integer size = null;
                        size = Integer.parseInt(stringTokenizer.nextToken());
                        this.parkingLotService.create(size);
                        System.out.println("Created parking of " + size + " slots");
                        return true;
                    } else {
                        return false;
                    }
                case PARK:
                    String licensePlate = null;
                    Integer driversAge = null;
                    if(stringTokenizer.hasMoreTokens()) {
                        licensePlate = stringTokenizer.nextToken();
                    } else {
                        return false;
                    }
                    if (stringTokenizer.hasMoreTokens() && COMMAND.valueOfLabel(stringTokenizer.nextToken()) == COMMAND.DRIVER_AGE) {
                        if (stringTokenizer.hasMoreTokens()) {
                            driversAge = Integer.parseInt(stringTokenizer.nextToken());
                            Slot pickedSlot = this.parkingLotService.parkVehicle(licensePlate,driversAge);
                            if(pickedSlot == null){
                                System.out.println("No Available Slots");
                                return false;
                            }
                            System.out.println("Car with vehicle registration number " + "\"" + licensePlate + "\"" + " has been parked at slot number "+pickedSlot.getNumber());
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                case LEAVE:
                    Integer slotNumber = null;
                    if(stringTokenizer.hasMoreTokens()){
                        slotNumber = Integer.parseInt(stringTokenizer.nextToken());
                        Vehicle leavingVehicle = this.parkingLotService.leaveVehicle(slotNumber);
                        if(leavingVehicle == null) {
                            System.out.println("Slot is empty!");
                            return false;
                        }
                        System.out.println("Slot number " + slotNumber + " vacated, the car with vehicle registration number " + "\"" + leavingVehicle.getLicensePlate() + "\"" + " left the space, the driver of the car was of age " + leavingVehicle.getDriversAge());
                        return true;
                    }else {
                        return false;
                    }
                case GET_SLOT_FOR_AGE:
                    Integer age = null;
                    if(stringTokenizer.hasMoreTokens()){
                        age = Integer.parseInt(stringTokenizer.nextToken());
                        List<Integer> slotNumbers = this.parkingLotService.getSlotNumbersForDriversAge(age);
                        if(slotNumbers == null){
                            System.out.println("No parked car matches the query");
                            return false;
                        }
                        System.out.println(slotNumbers.stream().map(number -> number.toString()).collect(Collectors.joining(",")));
                        return true;
                    }else {
                        return false;
                    }
                case GET_SLOT_FOR_CAR_NUMBER:
                    licensePlate = null;
                    if(stringTokenizer.hasMoreTokens()){
                        licensePlate = stringTokenizer.nextToken();
                        slotNumber = this.parkingLotService.getSlotNumberForLicensePlate(licensePlate);
                        if(slotNumber == null){
                            System.out.println("No parked car matches the query");
                            return false;
                        }
                        System.out.println(slotNumber);
                        return true;
                    }else {
                        return false;
                    }
                case GET_VEHICLE_NUMBER_FOR_AGE:
                    age = null;
                    if(stringTokenizer.hasMoreTokens()){
                        age = Integer.parseInt(stringTokenizer.nextToken());
                        List<String> licensePlates = this.parkingLotService.getLicensePlatesForDriversAge(age);
                        if(licensePlates == null){
                            System.out.println("No parked car matches the query");
                            return false;
                        }
                        System.out.println(licensePlates.stream().collect(Collectors.joining(",")));
                        return true;
                    }else {
                        return false;
                    }
                default:
                    return false;
            }
        }catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}
