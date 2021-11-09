package tm;

import javafx.scene.control.Button;

public class vehicleTm {
    private  String vehicleNumber1;
    private  String vehicleType1;
    private  int maximumWeight1;
    private  int noOfPassengers1;


    public vehicleTm(String vehicleNumber, String vehicleType, int maximumWeight, int noOfPassengers) {
        this.vehicleNumber1 = vehicleNumber;
        this.vehicleType1 = vehicleType;
        this.maximumWeight1 = maximumWeight;
        this.noOfPassengers1 = noOfPassengers;
    }

    public vehicleTm() {
    }

    public String getVehicleNumber() {
        return vehicleNumber1;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber1 = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType1;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType1 = vehicleType;
    }

    public int getMaximumWeight() {
        return maximumWeight1;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight1 = maximumWeight;
    }

    public int getNoOfPassengers() {
        return noOfPassengers1;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers1 = noOfPassengers;
    }

}
