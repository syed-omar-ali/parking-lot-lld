public class Slot implements Comparable<Slot>{
    private Integer number;
    private Boolean isFree;
    private Vehicle vehicle;


    public Slot(Integer slotNumber){
        this.number = slotNumber;
    }

    @Override
    public int compareTo(Slot s2){
        if(this.getNumber() < s2.getNumber())
            return -1;
        return 1;
    }

    // Could use Lombok for generating this boiler plate code
    public Boolean getIsFree(){
        return this.isFree;
    }
    public void setIsFree(Boolean isFree){
        this.isFree = isFree;
    }

    public Integer getNumber() {
        return number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
