
public class ParkingLotTest {

    public static void happyFlow(){
        CommandExecutorService commandExecutorService = new CommandExecutorService();
        commandExecutorService.execute("Create_parking_lot 6");
        commandExecutorService.execute("Park KA-01-HH-1234 driver_age 21");
        commandExecutorService.execute("Park HR-01-HH-1234 driver_age 21");
        commandExecutorService.execute("Park RA-01-HH-1234 driver_age 22");
        commandExecutorService.execute("Slot_numbers_for_driver_of_age 21");
        commandExecutorService.execute("Slot_numbers_for_driver_of_age 22");
        commandExecutorService.execute("Park UP-01-HH-1234 driver_age 22");
        commandExecutorService.execute("Slot_numbers_for_driver_of_age 22");
        commandExecutorService.execute("Leave 1");
        commandExecutorService.execute("Leave 3");
        commandExecutorService.execute("Slot_numbers_for_driver_of_age 21");
        commandExecutorService.execute("Vehicle_registration_number_for_driver_of_age 22");
        commandExecutorService.execute("Park GA-01-HH-1234 driver_age 27");
    }

    public static void testOverFlow(){
        CommandExecutorService commandExecutorService = new CommandExecutorService();
        commandExecutorService.execute("Create_parking_lot 2");
        commandExecutorService.execute("Park KA-01-HH-1234 driver_age 21");
        commandExecutorService.execute("Park PB-01-HH-1234 driver_age 21");
        commandExecutorService.execute("Park PB-01-HH-1235 driver_age 22");
    }

    public static void testUnderFlow(){
        CommandExecutorService commandExecutorService = new CommandExecutorService();
        commandExecutorService.execute("Create_parking_lot 2");
        commandExecutorService.execute("Leave 2");
    }

    public static void queryForNonExistentData(){
        CommandExecutorService commandExecutorService = new CommandExecutorService();
        commandExecutorService.execute("Create_parking_lot 2");
        commandExecutorService.execute("Slot_numbers_for_driver_of_age 21");
        commandExecutorService.execute("Slot_number_for_car_with_number PB-01-HH-6789");
        commandExecutorService.execute("Vehicle_registration_number_for_driver_of_age 18");
    }


    public static void main(String[] args) {
        happyFlow();
        testOverFlow();
        testUnderFlow();
        queryForNonExistentData();
    }
}
