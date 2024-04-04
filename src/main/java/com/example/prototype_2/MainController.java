package com.example.prototype_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainController implements Initializable {

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
    private MenuItem mnClose;

    @FXML
    void onEdit(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event) {

    }

    @FXML
    void onViewDebtDetails(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        String path = ""+fileChooser.showOpenDialog(null).getAbsolutePath();

        File file = new File(path);
        Scanner readFile = new Scanner(file);
        txtEditor.setText("");

        btnEdit.setDisable(false);

        while (readFile.hasNextLine()){

        }

    }
    @FXML
    void onClose(ActionEvent event) throws IOException {
        mnClose.getS

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnEdit.setDisable(true);
        btnSaveUpdate.setDisable(true);
    }
}
