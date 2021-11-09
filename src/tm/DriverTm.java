package tm;

import javafx.scene.control.Button;

public class DriverTm {
    private String DriverName1;
    private String DriverNIC1;
    private String LicenseNO1;
    private String Address1;
    private int ContactNO1;

    public DriverTm(String driverName1, String driverNIC1, String licenseNO1, String address1, int contactNO1) {
        this.DriverName1 = driverName1;
        this.DriverNIC1 = driverNIC1;
        this. LicenseNO1 = licenseNO1;
        this.Address1 = address1;
        this.ContactNO1 = contactNO1;

    }

    public DriverTm() {
    }

    public String getDriverName1() {
        return DriverName1;
    }

    public void setDriverName1(String driverName1) {
        DriverName1 = driverName1;
    }

    public String getDriverNIC1() {
        return DriverNIC1;
    }

    public void setDriverNIC1(String driverNIC1) {
        DriverNIC1 = driverNIC1;
    }

    public String getLicenseNO1() {
        return LicenseNO1;
    }

    public void setLicenseNO1(String licenseNO1) {
        LicenseNO1 = licenseNO1;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public int getContactNO1() {
        return ContactNO1;
    }

    public void setContactNO1(int contactNO1) {
        ContactNO1 = contactNO1;
    }
}
