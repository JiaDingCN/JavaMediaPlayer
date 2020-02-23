package com.jiading.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class Controller_about {
    @FXML
    Button okButton;
    public void exit(MouseEvent mouseEvent) {
        Stage window = (Stage) okButton.getScene().getWindow();
        window.close();
    }
}
