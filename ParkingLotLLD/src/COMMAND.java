public enum COMMAND {
    CREATE("Create_parking_lot"),
    PARK("Park"),
    LEAVE("Leave"),
    DRIVER_AGE("driver_age"),
    GET_SLOT_FOR_AGE("Slot_numbers_for_driver_of_age"),
    GET_SLOT_FOR_CAR_NUMBER("Slot_number_for_car_with_number"),
    GET_VEHICLE_NUMBER_FOR_AGE("Vehicle_registration_number_for_driver_of_age");


    public final String label;

    private COMMAND(String label){
        this.label = label;
    }

    public static COMMAND valueOfLabel(String label) {
        for (COMMAND e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }

}
