package com.jiading.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller_setting {
    @FXML
    Button exitButton;
    public void exit(MouseEvent mouseEvent) {
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }
}
