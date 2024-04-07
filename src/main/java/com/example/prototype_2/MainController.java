package com.example.prototype_2;

import javafx.application.Platform;
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
import java.io.PrintWriter;
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
    private TextField txtAmount;

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
    void onSave(ActionEvent event) throws FileNotFoundException {
        String name = txtName.getText();
        String foneNmuber = txtPhone.getText();
        String amount = txtAmount.getText();
        String gender = rdnMale.isSelected()? "male":"female";

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Debtor Details");
        fileChooser.setInitialFileName("Save Debtor Details.txt");

        Stage stage =(Stage) btnSaveDebt.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if(file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("Name: " + name);
                writer.println("Phone: " + foneNmuber);
                writer.println("Amount: " + amount);
                writer.println("Gender: " + gender);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // Handle file not found exception
            }

        }
        txtName.setText("");
        txtPhone.setText("");
        txtAmount.setText("");
        Gender.selectToggle(null);

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
            String output = readFile.nextLine();
            txtEditor.appendText(output+"\n");
        }
        txtEditor.setEditable(true);
        btnSaveUpdate.setDisable(false);

    }
    @FXML
    void onSaveUpdates(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text File");
        File file = fileChooser.showSaveDialog(txtEditor.getScene().getWindow());


        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println(txtEditor.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        txtEditor.setText("");
    }

    @FXML
    void onClose(ActionEvent event) throws IOException {

        Stage stages = (Stage) btnSaveDebt.getScene().getWindow();
        stages.close();

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
        txtEditor.setEditable(false);
    }
}
