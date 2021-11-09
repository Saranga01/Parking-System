package tm;

public class OnParkingTm {
    private String vehicleNumber1;
    private String vehicleType1;
    private int parkingSlot1;
    private String parkingTime1;

    public OnParkingTm(String vehicleNumber1, String vehicleType, int parkingSlot, String parkingTime) {
        this.vehicleNumber1 = vehicleNumber1;
        this.vehicleType1 = vehicleType;
        this.parkingSlot1 = parkingSlot;
        this.parkingTime1 = parkingTime;
    }

    public OnParkingTm() {
    }

    public String getVehicleNumber1() {
        return vehicleNumber1;
    }

    public void setVehicleNumber1(String vehicleNumber1) {
        this.vehicleNumber1 = vehicleNumber1;
    }

    public String getVehicleType() {
        return vehicleType1;
    }

    public void setVehicleType(String vehicleType1) {
        this.vehicleType1 = vehicleType1;
    }

    public int getParkingSlot() {
        return parkingSlot1;
    }

    public void setParkingSlot(int parkingSlot1) {
        this.parkingSlot1 = parkingSlot1;
    }

    public String getParkingTime() {
        return parkingTime1;
    }

    public void setParkingTime(String parkingTime1) {
        this.parkingTime1 = parkingTime1;
    }
}
