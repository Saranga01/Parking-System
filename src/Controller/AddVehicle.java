package Controller;

public class AddVehicle {

    private String vehicleNumber;
    private String vehicleType;
    private int maximumWeight;
    private int numOfPassengers;

    public AddVehicle(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
    }

    public AddVehicle(String text, String txtDriverNICText, String txtDriverLicenseNoText, String txtDriverAddressText, int contactNumber) {
    }

    public  String getVehicleNumber() {
        return vehicleNumber;
    }

    public  void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public  String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public  int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public  int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
