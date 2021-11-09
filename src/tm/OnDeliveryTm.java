package tm;

public class OnDeliveryTm {
    private String vehicleNumber2;
    private String vehicleType2;
    private String driverName2;
    private String leftTime2;

    public OnDeliveryTm(String vehicleNumber2, String vehicleType2, String driverName2, String leftTime2) {
        this.vehicleNumber2 = vehicleNumber2;
        this.vehicleType2 = vehicleType2;
        this.driverName2 = driverName2;
        this.leftTime2 = leftTime2;
    }

    public OnDeliveryTm() {
    }

    public String getVehicleNumber2() {
        return vehicleNumber2;
    }

    public void setVehicleNumber2(String vehicleNumber2) {
        this.vehicleNumber2 = vehicleNumber2;
    }

    public String getVehicleType2() {
        return vehicleType2;
    }

    public void setVehicleType2(String vehicleType2) {
        this.vehicleType2 = vehicleType2;
    }

    public String getDriverName2() {
        return driverName2;
    }

    public void setDriverName2(String driverName2) {
        this.driverName2 = driverName2;
    }

    public String getLeftTime2() {
        return leftTime2;
    }

    public void setLeftTime2(String leftTime2) {
        this.leftTime2 = leftTime2;
    }
}
