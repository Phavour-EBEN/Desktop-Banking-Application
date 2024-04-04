package com.example.prototype_2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgLock;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblLabel;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSaveDebt;

    @FXML
    private Button btnSaveUpdate;

    @FXML
    private Button btnViewDebtDetail;

    @FXML
    private RadioButton rdnFemale;

    @FXML
    private RadioButton rdnMale;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextArea txtEditor;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void onEdit(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event) {

    }

    @FXML
    void onViewDebtDetails(ActionEvent event) {

    }

    @FXML
    void onCancel(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if(username.equals("admin") && password.equals("54321")){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main_Apk.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),829,506);
            Stage stage = new Stage();
            stage.setTitle("Customer Details");
            stage.setScene(scene);
            stage.show();

            Stage stages = (Stage) btnLogin.getScene().getWindow();
            stages.close();

        }else {
//            lblLabel.setVisible(true);
            txtUsername.setText("");
            txtPassword.setText("");
            lblLabel.setText("Invalid Login Details");
        }

    }

}
