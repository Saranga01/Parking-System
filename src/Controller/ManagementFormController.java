package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tm.DriverTm;
import tm.OnDeliveryTm;
import tm.OnParkingTm;
import tm.vehicleTm;

import java.io.IOException;
import java.util.Optional;

public class ManagementFormController extends Bus{

    public AnchorPane rootAddVehicle;
    public Button btnVehicleAdd;
    public Button btnbackVehicle;
    public AnchorPane rootAddDriver;
    public Button btnDriverAdd;
    public Button btnBackDriver;
    public AnchorPane rootInParking;
    public AnchorPane rootOnDelivery;
    public Button btnAddVehicle;
    public Button btnAddDriver;
    public ComboBox ComboSelectAction;
    public AnchorPane rootManagement;
    public TextField txtVehicleNumber;
    public TextField txtMaximumWeight;
    public TextField txtNoOfPassengers;
    public TextField txtVehicles;
    public TextField txtDriverName;
    public TextField txtDriverNIC;
    public TextField txtDriverLicenseNo;
    public TextField txtDriverContactNo;
    public TextField txtDriverAddress;
    static int count=0;
    static  int dCount=0;
    static AddVehicle[] addVehicle=new AddVehicle[14];
    static AddDriver[] addDriver=new AddDriver[16];
    public ComboBox<String> comboVehicleType;
    static String VehicleType;
    public AnchorPane rootAllVehiclesDetails;
    public TableView<vehicleTm> tblAllVehicleDetails;
    public TableColumn colVehicleName;
    public TableColumn colVehicleType;
    public TableColumn colMaxWeight;
    public TableColumn colNoOfPassengers;
    public TableColumn colDelete;
    public AnchorPane rootAllDriversDetails;
    public TableView<DriverTm> tblAllDriversDetails;
    public TableColumn colDriverName;
    public TableColumn colNIC;
    public TableColumn colDrivingLicenseNo;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDeleteBtn2;
    public Button btnViewVehicle;
    public Button btnViewDrivers;
    public Button btnLogout;
    public Button btnBack3;
    public Button btnBack4;
    public Label lblSuccessfully;
    public TableView<OnParkingTm> tblOnParking;
    public TableView<OnDeliveryTm> tblOnDelivery;
    int count1=0;
    int count2=0;
    static String selectAction;


    public void initialize() {
        rootAddDriver.setVisible(false);
        rootAddVehicle.setVisible(false);
        ComboSelectAction.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(false);
        comboVehicleType.getItems().addAll("Van", "Cargo Lorry", "Bus");
        ComboSelectAction.getItems().addAll("On Parking", "On Delivery");
        rootInParking.setVisible(true);
        comboVehicleType.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            this.VehicleType = newValue;
        }));
        ComboSelectAction.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue.equals("On Parking")) {
                rootInParking.setVisible(true);
                rootOnDelivery.setVisible(false);
            } else {
                rootInParking.setVisible(false);
                rootOnDelivery.setVisible(true);
            }
        }));
        tblAllVehicleDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        tblAllVehicleDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblAllVehicleDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("maximumWeight"));
        tblAllVehicleDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));
        count1 = 0;
        count2 = 0;
        loadVehicle();
        tblAllDriversDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("DriverName1"));
        tblAllDriversDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("DriverNIC1"));
        tblAllDriversDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("LicenseNO1"));
        tblAllDriversDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Address1"));
        tblAllDriversDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("ContactNO1"));

        tblOnDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber2"));
        tblOnDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType2"));
        tblOnDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("driverName2"));
        tblOnDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("leftTime2"));


        loadDriver();
        colNIC.setStyle("-fx-alignment: CENTER;");
        colAddress.setStyle("-fx-alignment: CENTER;");
        colDrivingLicenseNo.setStyle("-fx-alignment: CENTER;");
        colContact.setStyle("-fx-alignment: CENTER;");
        colVehicleName.setStyle("-fx-alignment: CENTER;");
        colVehicleType.setStyle("-fx-alignment: CENTER;");
        colMaxWeight.setStyle("-fx-alignment: CENTER;");
        colNoOfPassengers.setStyle("-fx-alignment: CENTER;");


                for (int j=0;j<BusCount1;j++) {
                     if (reservedSlotBus[j] == 0) {
                        ObservableList<OnDeliveryTm> onPark = tblOnDelivery.getItems();

                            OnDeliveryTm newPark = new OnDeliveryTm(Bus.vehicleNumber[j], Bus.vehicleType[j], Bus.driverName[j], Bus.dateAndTime[j]);
                            onPark.add(newPark);


                    } else {
                        ObservableList<OnParkingTm> onPark = tblOnParking.getItems();

                            OnParkingTm newPark = new OnParkingTm(Bus.vehicleNumber[j], Bus.vehicleType[j], Bus.reservedSlotBus[j], Bus.dateAndTime[j]);
                            onPark.add(newPark);


                    }
                }
        for (int j=0;j<cargoCount1;j++) {
                if (reservedSlotCargoLorry[j] == 0) {
                    ObservableList<OnDeliveryTm> onPark = tblOnDelivery.getItems();

                        OnDeliveryTm newPark = new OnDeliveryTm(CargoLorry.vehicleNumber[j], CargoLorry.vehicleType[j], CargoLorry.driverName[j], CargoLorry.dateAndTime[j]);
                        onPark.add(newPark);


                } else {
                    ObservableList<OnParkingTm> onPark = tblOnParking.getItems();

                        OnParkingTm newPark = new OnParkingTm(CargoLorry.vehicleNumber[j], CargoLorry.vehicleType[j], CargoLorry.reservedSlotCargoLorry[j], CargoLorry.dateAndTime[j]);
                        onPark.add(newPark);

                }
            }
        for(int j=0;j<vanCount1;j++){
            if (reservedSlotVan[j] == 0) {
                ObservableList<OnDeliveryTm> onPark = tblOnDelivery.getItems();

                    OnDeliveryTm newPark = new OnDeliveryTm(Van.vehicleNumber[j], Van.vehicleType[j], Van.driverName[j], Van.dateAndTime[j]);
                    onPark.add(newPark);



            } else {
                ObservableList<OnParkingTm> onPark = tblOnParking.getItems();

                    OnParkingTm newPark = new OnParkingTm(Van.vehicleNumber[j], Van.vehicleType[j], Van.reservedSlotVan[j], Van.dateAndTime[j]);
                    onPark.add(newPark);



            }
        }



        tblOnParking.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber1"));
        tblOnParking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblOnParking.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        tblOnParking.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("parkingTime"));


    }

    public void btnVehicleAddOnAction(ActionEvent actionEvent) {
        int maximumWeight = Integer.parseInt(txtMaximumWeight.getText());
        int noOfPassengers = Integer.parseInt(txtNoOfPassengers.getText());

        addVehicle[count]=new AddVehicle(txtVehicleNumber.getText(),VehicleType,maximumWeight,noOfPassengers);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully....!", ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(addVehicle[count].getVehicleType().equals("Van")){
            ++vanCount1;
        }else if(addVehicle[count].getVehicleType().equals("Cargo Lorry")){
            ++cargoCount1;
        }else if(addVehicle[count].getVehicleType().equals("Bus")){
            ++BusCount1;
        }else{

        }
        txtVehicleNumber.clear();
        txtMaximumWeight.clear();
        txtNoOfPassengers.clear();
        count1=count;
        count++;
        loadVehicle();
        count1++;


    }

    private void  loadVehicle(){
        ObservableList<vehicleTm> vehicles=tblAllVehicleDetails.getItems();
        for (int i=count1;i<count;i++) {


        vehicleTm newVehicles=new vehicleTm(addVehicle[i].getVehicleNumber(),addVehicle[i].getVehicleType(),addVehicle[i].getMaximumWeight(),addVehicle[i].getNumOfPassengers());
        vehicles.add(newVehicles);
        }

    }
    public void btnbackVehicleOnAction(ActionEvent actionEvent) {
        rootAddDriver.setVisible(false);
        rootAddVehicle.setVisible(false);
        ComboSelectAction.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(false);

    }

    public void btnDriverAddOnAction(ActionEvent actionEvent) {
        int contactNumber = Integer.parseInt(txtDriverContactNo.getText());
        addDriver[dCount]= new AddDriver(txtDriverName.getText(),txtDriverNIC.getText(),txtDriverLicenseNo.getText(),txtDriverAddress.getText(),contactNumber);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully....!", ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();
        txtDriverName.clear();
        txtDriverNIC.clear();
        txtDriverAddress.clear();
        txtDriverContactNo.clear();
        txtDriverLicenseNo.clear();
        dCount++;
        loadDriver();
        count2++;


    }

    private void loadDriver(){
        ObservableList<DriverTm> Drivers=tblAllDriversDetails.getItems();
        for (int i=count2;i<dCount;i++) {


            DriverTm newDriver = new DriverTm(addDriver[i].getDriverName(), addDriver[i].getNIC(), addDriver[i].getLicenseNO(), addDriver[i].getAddress(),addDriver[i].getContactNo());
            Drivers.add(newDriver);
        }
    }



    public void btnBackDriverOnAction(ActionEvent actionEvent) {
        rootAddDriver.setVisible(false);
        rootAddVehicle.setVisible(false);
        ComboSelectAction.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(false);
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) {
        ComboSelectAction.setVisible(false);
        rootAddDriver.setVisible(false);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAddVehicle.setVisible(true);

    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        ComboSelectAction.setVisible(false);
        rootAddDriver.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAddVehicle.setVisible(false);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do You Want to Logout ?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)) {
            Parent parent=FXMLLoader.load(this.getClass().getResource("../view/ParkingForm.fxml"));
            Scene scene=new Scene(parent);
            Stage primaryStage= (Stage) this.rootManagement.getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.setTitle("parking System");
            primaryStage.show();
            primaryStage.centerOnScreen();
        }
    }

    public void btnViewVehicleOnAction(ActionEvent actionEvent) throws IOException {
        rootAllVehiclesDetails.setVisible(true);
        rootAllDriversDetails.setVisible(false);

    }

    public void ViewDriversOnAction(ActionEvent actionEvent) throws IOException {
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(true);

    }

    public void btnBackAllVehicleOnAction(ActionEvent actionEvent) {
        rootAddDriver.setVisible(false);
        rootAddVehicle.setVisible(false);
        ComboSelectAction.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(false);
    }

    public void btnBackAllDriversOnAction(ActionEvent actionEvent) {
        rootAddDriver.setVisible(false);
        rootAddVehicle.setVisible(false);
        ComboSelectAction.setVisible(true);
        rootInParking.setVisible(false);
        rootOnDelivery.setVisible(false);
        rootAllVehiclesDetails.setVisible(false);
        rootAllDriversDetails.setVisible(false);
    }

    public void btnAddDriverOMEn(MouseEvent mouseEvent) {
        btnAddDriver.setStyle("-fx-background-color:#044db5 ");

    }

    public void btnAddDriverOMEx(MouseEvent mouseEvent) {
        btnAddDriver.setStyle("-fx-background-color:blue");
    }

    public void btnAddVehicleOMEn(MouseEvent mouseEvent) {
        btnAddVehicle.setStyle("-fx-background-color:#044db5 ");

    }

    public void btnAddVehicleOMEx(MouseEvent mouseEvent) {
        btnAddVehicle.setStyle("-fx-background-color:blue");
    }

    public void btnViewVehicleOMEn(MouseEvent mouseEvent) {
        btnViewVehicle.setStyle("-fx-background-color:#044db5 ");

    }

    public void btnViewVehicleOMEx(MouseEvent mouseEvent) {
        btnViewVehicle.setStyle("-fx-background-color:blue");
    }

    public void btnViewDriversOMEn(MouseEvent mouseEvent) {
        btnViewDrivers.setStyle("-fx-background-color:#044db5 ");

    }

    public void btnViewDriversOMEx(MouseEvent mouseEvent) {
        btnViewDrivers.setStyle("-fx-background-color:blue");
    }

    public void btnLogoutOMEn(MouseEvent mouseEvent) {
        btnLogout.setStyle("-fx-background-color:#009d0f");

    }

    public void btnLogoutOMEx(MouseEvent mouseEvent) {
        btnLogout.setStyle("-fx-background-color:green");
    }

    public void btnBackOMEn(MouseEvent mouseEvent) {
        btnbackVehicle.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnBackOMEx(MouseEvent mouseEvent) {
        btnbackVehicle.setStyle("-fx-background-color:blue ");
    }

    public void btnAddOMEn(MouseEvent mouseEvent) {
        btnVehicleAdd.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnAddOMEx(MouseEvent mouseEvent) {
        btnVehicleAdd.setStyle("-fx-background-color:blue ");

    }

    public void btnBack4OMEn(MouseEvent mouseEvent) {
        btnBack4.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnBack4OMEx(MouseEvent mouseEvent) {
        btnBack4.setStyle("-fx-background-color:blue");
    }

    public void btnBack3OMEn(MouseEvent mouseEvent) {
        btnBack3.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnBack3OMEx(MouseEvent mouseEvent) {
        btnBack3.setStyle("-fx-background-color:blue ");
    }

    public void btnBackDriverOMEn(MouseEvent mouseEvent) {
        btnBackDriver.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnBackDriverOMEx(MouseEvent mouseEvent) {
        btnBackDriver.setStyle("-fx-background-color:blue");
    }

    public void btnDriverAddOMEn(MouseEvent mouseEvent) {
        btnDriverAdd.setStyle("-fx-background-color:#044db5 ");

    }

    public void btnDriverAddOMEx(MouseEvent mouseEvent) {
        btnDriverAdd.setStyle("-fx-background-color:blue ");
    }
}
