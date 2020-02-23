package com.jiading.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller_inputStream {
    @FXML
    TextField context;

    public void setCtr(Controller_getStreamURL ctr) {
        this.ctr = ctr;
    }

    Controller_getStreamURL ctr;
    public void submit(MouseEvent mouseEvent) {
        String[] split = context.getText().split(",|，");
        ctr.addNewUrl(split[0],split[1]);
        Stage stage = (Stage)context.getScene().getWindow();
        stage.close();
    }
}
