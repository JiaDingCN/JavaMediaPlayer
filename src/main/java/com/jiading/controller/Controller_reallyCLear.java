package com.jiading.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller_reallyCLear {
    @FXML
    Button cancelButton;

    public void setCtr(Controller_getStreamURL ctr) {
        this.ctr = ctr;
    }

    Controller_getStreamURL ctr;


    public void exit(MouseEvent mouseEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void clear(MouseEvent mouseEvent) {
        ctr.doClear();
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
