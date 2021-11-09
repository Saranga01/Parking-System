package Controller;

public class AddDriver {
    private String driverName;
    private String NIC;
    private String licenseNO;
    private String address;
    private int contactNo;

    public AddDriver(String driverName, String NIC, String licenseNO, String address, int contactNo) {
        this.driverName = driverName;
        this.NIC = NIC;
        this.licenseNO = licenseNO;
        this.address = address;
        this.contactNo = contactNo;
    }

    public AddDriver() {
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLicenseNO() {
        return licenseNO;
    }

    public void setLicenseNO(String licenseNO) {
        this.licenseNO = licenseNO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }
}
