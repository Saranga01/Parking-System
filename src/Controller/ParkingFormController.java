package Controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tm.OnParkingTm;
import tm.vehicleTm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class ParkingFormController extends ManagementFormController{

    public ComboBox<String> ComboSelectVehicle;
    public ComboBox comboSelectDriver;
    public Label lblVehicleType;
    public Label lblSlotNumber;
    public Label lblDateandTime;
    public AnchorPane rootLoginForm;
    public AnchorPane rootParkingDetails;
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane rootParkingForm;
    public Label lblUserNameError;
    public Label lblPasswordError;
    public Label lblTime;
    public Label lblDate;
    public Button btnLogin;
    public Button btnLogin2;
    public Button btnCancel;
    public static int x;
    public Button btnParkVehicle;
    public Button btnOnDeliveryShift;
    static String vehicleNumber;
    static String driverName;
    static int vanCount=0;
    static int cargoLorryCount=0;
    static int busCount=0;
    static int y;
    public Label lblautoSelectDriver;
    public Label txtDriver;
    public static int b=0;
    public static int v=0;
    public static int c=0;
    public Label time;
    public Label date;
    public Label datable;
    private volatile boolean stop=false;


    public void initialize(){
        lblautoSelectDriver.setVisible(false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();
        lblTime.setText(dtf.format(now));
        TimeNow();

        for(int i=0;i<count;i++) {
            ComboSelectVehicle.getItems().addAll(addVehicle[i].getVehicleNumber());
        }
        for(int i=0;i<dCount;i++) {
            comboSelectDriver.getItems().addAll(addDriver[i].getDriverName());
        }
        comboSelectDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            driverName= (String) newValue;
        });

        ComboSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            vehicleNumber=newValue;
            for(int i=0;i<count;i++) {
                if (newValue.equals(addVehicle[i].getVehicleNumber())) {
                    lblVehicleType.setText("  " + addVehicle[i].getVehicleType());
                }
            }
                loop1:
                for(int i=0;i<1;i++) {
                    if (lblVehicleType.getText().equals("  Van")) {
                        for (int j = 0; j < Van.reservedSlotVan.length; j++) {
                            if(newValue.equals(Van.vehicleNumber[j])) {
                                if (newValue.equals(Van.vehicleNumber[j])) {
                                    if (Van.reservedSlotVan[j] == 0) {
                                            break ;
                                    } else {
                                        x = Van.reservedSlotVan[j];
                                        btnParkVehicle.setDisable(true);
                                        btnOnDeliveryShift.setDisable(false);
                                        comboSelectDriver.setVisible(true);
                                        txtDriver.setVisible(true);
                                        break loop1;
                                    }
                                }
                            }
                        }
                        comboSelectDriver.setVisible(false);
                        txtDriver.setVisible(false);
                        if (Van.reservedSlotVan[0] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 1;
                                break;
                            } else if (Van.reservedSlotVan[1] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 2;
                                break;
                            } else if (Van.reservedSlotVan[2] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 3;
                                break;

                            } else if (Van.reservedSlotVan[3] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 4;
                                break;
                            } else if (Van.reservedSlotVan[4] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 12;
                                break;
                            } else if (Van.reservedSlotVan[5] == 0) {
                                btnParkVehicle.setDisable(false);
                                btnOnDeliveryShift.setDisable(true);
                                x = 13;
                                break;
                            } else {
                                btnOnDeliveryShift.setDisable(false);
                                btnParkVehicle.setDisable(true);
                                x = 1;
                                break;
                            }

                    } else if (lblVehicleType.getText().equals("  Cargo Lorry")) {
                        for (int j = 0; j < CargoLorry.reservedSlotCargoLorry.length; j++) {
                            if (newValue.equals(CargoLorry.vehicleNumber[j])) {
                                if (newValue.equals(CargoLorry.vehicleNumber[j])) {
                                    if (CargoLorry.reservedSlotCargoLorry[j] == 0) {

                                    } else {
                                        x = CargoLorry.reservedSlotCargoLorry[j];
                                        btnParkVehicle.setDisable(true);
                                        btnOnDeliveryShift.setDisable(false);
                                        comboSelectDriver.setVisible(true);
                                        txtDriver.setVisible(true);
                                        break loop1;
                                    }
                                }
                            }
                        }
                        comboSelectDriver.setVisible(false);
                        txtDriver.setVisible(false);
                        if (CargoLorry.reservedSlotCargoLorry[0] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 5;
                            break;
                        } else if (CargoLorry.reservedSlotCargoLorry[1] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 6;
                            break;
                        } else if (CargoLorry.reservedSlotCargoLorry[2] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 7;
                            break;

                        } else if (CargoLorry.reservedSlotCargoLorry[3] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 8;
                            break;

                        } else if (CargoLorry.reservedSlotCargoLorry[4] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 9;
                            break;

                        } else if (CargoLorry.reservedSlotCargoLorry[5] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 10;
                            break;
                        } else if (CargoLorry.reservedSlotCargoLorry[6] == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 11;
                            break;
                        } else {
                            btnParkVehicle.setDisable(true);
                            btnOnDeliveryShift.setDisable(false);
                            x = 5;
                            break;
                        }

                    } else if (lblVehicleType.getText().equals("  Bus")) {
                        for (int j = 0; j <Bus.reservedSlotBus.length; j++) {
                            if (newValue.equals(Bus.vehicleNumber[j])) {
                                if (newValue.equals(Bus.vehicleNumber[j])) {
                                    if (Bus.reservedSlotBus[j] == 0) {

                                    } else {
                                        x = Bus.reservedSlotBus[j];
                                        btnParkVehicle.setDisable(true);
                                        btnOnDeliveryShift.setDisable(false);
                                        comboSelectDriver.setVisible(true);
                                        txtDriver.setVisible(true);
                                        break loop1;
                                    }
                                }

                            }
                        }
                        comboSelectDriver.setVisible(false);
                        txtDriver.setVisible(false);
                        if (Bus.reservedSlotBus[0]==0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDeliveryShift.setDisable(true);
                            x = 14;
                            break;
                        }

                        }else {
                            btnParkVehicle.setDisable(true);
                            btnOnDeliveryShift.setDisable(false);
                            x = 14;
                            break;
                        }

                    }
            if (x < 10) {
                lblSlotNumber.setText("      " + "0" + x);
            } else {
                lblSlotNumber.setText("      " + x);

                }
        });

    }
    public void ParkingFormLoading() throws IOException {
        Parent parent=FXMLLoader.load(this.getClass().getResource("../view/ParkingForm.fxml"));
        Scene scene=new Scene(parent);
        Stage primaryStage= (Stage) this.rootParkingForm.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle("parking System");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void TimeNow(){
        Thread thread=new Thread(() ->{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(" hh:mm:ss a");
            SimpleDateFormat date=new SimpleDateFormat(" dd/MM/yyyy");

            while (!stop){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timeNow=simpleDateFormat.format(new Date());
                final String dateNow=date.format(new Date());
                Platform.runLater(() ->{
                    time.setText(timeNow);
                    datable.setText(dateNow);
                });
            }
        });
        thread.start();
    }

    public void btnParkVehicleOnAction(ActionEvent actionEvent) throws IOException {
        if(lblVehicleType.getText().equals("  Van")) {
                    Van.reservedSlotVan[vanCount] = x;
                    Van.vehicleNumber[vanCount] = vehicleNumber;
                    Van.vehicleType[vanCount1] = lblVehicleType.getText();
                    Van.dateAndTime[vanCount] = lblTime.getText();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Park Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    vanCount++;


        }else if(lblVehicleType.getText().equals("  Bus")){

                    Bus.reservedSlotBus[busCount] = x;
                    Bus.vehicleNumber[busCount] = vehicleNumber;
                    Bus.vehicleType[busCount] = lblVehicleType.getText();
                    Bus.dateAndTime[busCount] = lblTime.getText();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Park Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    busCount++;





        }else {
                    CargoLorry.reservedSlotCargoLorry[cargoLorryCount] = x;
                    CargoLorry.vehicleNumber[cargoLorryCount] = vehicleNumber;
                    CargoLorry.vehicleType[cargoLorryCount] = lblVehicleType.getText();
                    CargoLorry.dateAndTime[cargoLorryCount] = lblTime.getText();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Park Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    cargoLorryCount++;


        }


    }


    public void btnOnDiliveryShiftOnAction(ActionEvent actionEvent) throws IOException {
        if(lblVehicleType.getText().equals("  Van")) {
            for(int i=0;i<Van.reservedSlotVan.length;i++) {
                if(vehicleNumber.equals(Van.vehicleNumber[i])) {
                    Van.reservedSlotVan[i]=0;
                    Van.vehicleNumber[i]=vehicleNumber;
                    Van.vehicleType[i]=lblVehicleType.getText();
                    Van.dateAndTime[i]=lblTime.getText();
                    Van.driverName[i]=driverName;
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Leave Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    vanCount--;


                }
            }
        }else if(lblVehicleType.getText().equals("  Bus")){
            for(int i=0;i<Bus.reservedSlotBus.length;i++) {
                if(vehicleNumber.equals(Bus.vehicleNumber[i])) {
                    Bus.reservedSlotBus[i]=0;
                    Bus.vehicleNumber[i]=vehicleNumber;
                    Bus.vehicleType[i]=lblVehicleType.getText();
                    Bus.dateAndTime[i]=lblTime.getText();
                    Bus.driverName[i]=driverName;
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Leave Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    busCount--;


                }
            }
        }else {
            for(int i=0;i<CargoLorry.reservedSlotCargoLorry.length;i++) {
                if (vehicleNumber.equals(CargoLorry.vehicleNumber[i])) {
                    CargoLorry.reservedSlotCargoLorry[i]=0;
                    CargoLorry.vehicleNumber[i]=vehicleNumber;
                    CargoLorry.vehicleType[i]=lblVehicleType.getText();
                    CargoLorry.dateAndTime[i]=lblTime.getText();
                    CargoLorry.driverName[i]=driverName;
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Leave Vehicle Successfully....!", ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    cargoLorryCount--;

                }
            }
        }
    }

    public void btnLoginManagementOnAction(ActionEvent actionEvent) {
        rootLoginForm.setVisible(true);
        rootParkingDetails.setDisable(true);
    }

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        if(txtUserName.getText().equals("")){
             lblUserNameError.setVisible(true);
             lblUserNameError.setText("please Enter User Name");
        }else if(txtPassword.getText().equals("")){
            lblUserNameError.setVisible(false);
             lblPasswordError.setVisible(true);
             lblPasswordError.setText("Please Enter Password");
        }else {
            lblPasswordError.setVisible(false);
            lblUserNameError.setVisible(false);
            if (txtUserName.getText().equals("Saranga01")) {
                if (txtPassword.getText().equals("123456")) {
                    Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManagementForm.fxml"));
                    Scene scene = new Scene(parent);

                    Stage primaryStage = (Stage) this.rootParkingForm.getScene().getWindow();

                    primaryStage.centerOnScreen();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.setTitle("Management Form");
                }else{
                    lblUserNameError.setVisible(false);
                    lblPasswordError.setVisible(true);
                    lblPasswordError.setText("Incorrect Password...!");
                }
            }else{
                lblUserNameError.setVisible(true);
                lblUserNameError.setText("incorrect user name...!");
            }
        }
        
    }

    public void btnLoginCancelOnAction(ActionEvent actionEvent) throws IOException {
                   rootLoginForm.setVisible(false);
                   rootParkingDetails.setDisable(false);


    }

    public void imgRefreshOnClicked(MouseEvent mouseEvent) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();
        lblTime.setText(dtf.format(now));
    }

    public void btnParkOnMouseEnterd(MouseEvent mouseEvent) {
        btnParkVehicle.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnParkOnMouseExited(MouseEvent mouseEvent) {
        btnParkVehicle.setStyle("-fx-background-color:blue ");
    }

    public void btnShiftOnMouseEnterd(MouseEvent mouseEvent) {
        btnOnDeliveryShift.setStyle("-fx-background-color:#044db5 ");
    }

    public void btnShiftOnMouseExited(MouseEvent mouseEvent) {
        btnOnDeliveryShift.setStyle("-fx-background-color:blue");
    }

    public void btnLoginOnMouseEnterd(MouseEvent mouseEvent) {
        btnLogin.setStyle("-fx-background-color:#009d0f");
    }

    public void btnLoginOnMouseExited(MouseEvent mouseEvent) {
        btnLogin.setStyle("-fx-background-color:green");
    }

    public void btnLogin2OnMouseEntered(MouseEvent mouseEvent) {
        btnLogin2.setStyle("-fx-background-color:#009d0f");
    }

    public void btnLogin2OnMouseExited(MouseEvent mouseEvent) {
        btnLogin2.setStyle("-fx-background-color:green");
    }

    public void btnCancelOnMouseEntered(MouseEvent mouseEvent) {
        btnCancel.setStyle("-fx-background-color:#044db5");
    }

    public void btnCancelOnMouseExited(MouseEvent mouseEvent) {
        btnCancel.setStyle("-fx-background-color:blue");
    }
}
