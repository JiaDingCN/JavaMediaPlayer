package com.jiading.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller_chooseLocation {
    @FXML
    Button submitBuuton;
    @FXML
    Label showFolderLabel;
    @FXML
    Label warnLabel;
    @FXML
    TextField filename;
    Stage stage;
    File folder;
    Integer count=0;

    public void setCtr(Controller_getStreamURL ctr) {
        this.ctr = ctr;
    }

    Controller_getStreamURL ctr;

    public void exit(MouseEvent mouseEvent) {
        stage = (Stage) submitBuuton.getScene().getWindow();
        stage.close();
    }

    public void submit(MouseEvent mouseEvent) throws IOException {
        File fileToSub = new File(folder.toString() + File.separatorChar+filename.getText()+".sf");
        if(count==0) {
            if (fileToSub.exists()) {
                warnLabel.setVisible(true);
                count++;
            }else{
                fileToSub.createNewFile();
                ctr.writeIntoFile(fileToSub);
                stage = (Stage) submitBuuton.getScene().getWindow();
                stage.close();
            }
        }else{
            fileToSub.delete();
            fileToSub.createNewFile();
            ctr.writeIntoFile(fileToSub);
            stage = (Stage) submitBuuton.getScene().getWindow();
            stage.close();
        }
    }

    public void chooseFolder(MouseEvent mouseEvent) {
        DirectoryChooser file = new DirectoryChooser();
        file.setTitle("Choose the local dirctionary for saveing");
        Stage stage = (Stage) submitBuuton.getScene().getWindow();
        folder = file.showDialog(stage);//这个file就是选择的文件夹了
        showFolderLabel.setText(folder.getPath());
    }
}
