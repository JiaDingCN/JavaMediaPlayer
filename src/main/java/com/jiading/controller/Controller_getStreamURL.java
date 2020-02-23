package com.jiading.controller;

import com.jiading.classes.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;

public class Controller_getStreamURL {
    @FXML
    Button submitButton;
    @FXML
    Button exitButton;
    @FXML
    Button addNewButton;
    @FXML
    TableView<Stream> streamListTable;
    @FXML
    TableColumn<Stream, String> nameAttribute;
    @FXML
    TableColumn<Stream, String> URLAttribute;
    @FXML
    MenuItem openNewStreamFileItem;
    @FXML
    MenuItem saveThisStreamFileItem;
    @FXML
    MenuItem clearListItem;
    @FXML
    MenuItem exitItem;
    ObservableList<Stream> data = FXCollections.observableArrayList();
    Stage stage;
    int choosedIndex;

    public void setCtr(Controller_mainPanel ctr) {
        this.ctr = ctr;
    }

    Controller_mainPanel ctr;
    Stream choosedStream;

    @FXML
    private void initialize() {
        nameAttribute.setCellValueFactory(cellData -> cellData.getValue().streamNameProperty());
        URLAttribute.setCellValueFactory(cellData -> cellData.getValue().streamURLProperty());
        streamListTable.setRowFactory(new Callback<TableView<Stream>, TableRow<Stream>>() {
            @Override
            public TableRow<Stream> call(TableView<Stream> param) {
                return new TableRowControl();
            }
        });
    }

    /*
    we use a sf file to save stream File
     */
    public void openNewStreamFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a new stream saving file");
        stage = (Stage) addNewButton.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        String pathString = file.toString();
        if (!pathString.substring(pathString.length()-3).equals(".sf")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("notStreamFile.fxml"));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Media Player");
            newStage.setScene(new Scene(root, 365, 154));
            newStage.show();
        } else {
            data.clear();
            InputStreamReader in = new InputStreamReader(new FileInputStream(file), "utf8");
            BufferedReader br = new BufferedReader(in);
            String temp = br.readLine();
            while (temp != null) {
                String[] split1 = temp.split(",|，");
                data.add(new Stream(split1[0], split1[1]));
                temp=br.readLine();
            }
            streamListTable.setItems(data);
            in.close();
            br.close();
        }
    }

    public void exit(MouseEvent actionEvent) {
        stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    public void saveThisFIle(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("chooseFolderAndFile.fxml"));
        Parent root = fxmlLoader.load();
        Controller_chooseLocation controller = fxmlLoader.getController();
        controller.setCtr(this);
        Stage newStage = new Stage();
        newStage.setTitle("Choose Location");
        newStage.setScene(new Scene(root, 530, 278));
        newStage.show();
    }

    public void writeIntoFile(File toWrite) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toWrite, false), "UTF-8"));//这里写false表示不以追加方式写入，而是覆盖以前的。要追加的话就选true
        for (Stream stream : data) {
            out.write(stream.getStreamName() + "," + stream.getStreamURL() + "\n");
        }
        out.close();
    }

    public void clearList(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ReallyClear.fxml"));
        Parent root = fxmlLoader.load();
        Controller_reallyCLear controller = fxmlLoader.getController();
        controller.setCtr(this);
        Stage newStage = new Stage();
        newStage.setTitle("Really clear?");
        newStage.setScene(new Scene(root, 365, 154));
        newStage.show();
    }

    public void doClear() {
        data.clear();
        streamListTable.setItems(data);
    }

    public void submitURL(MouseEvent mouseEvent) {
        if (choosedStream != null) {
            stage = (Stage) submitButton.getScene().getWindow();
            String streamURL = choosedStream.getStreamURL();
            stage.close();
            ctr.openStream(streamURL);
        }
    }

    public void addNewURL(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("inputStream.fxml"));
        Parent root = fxmlLoader.load();
        Controller_inputStream controller = fxmlLoader.getController();
        controller.setCtr(this);
        Stage newStage = new Stage();
        newStage.setTitle("Add new Stream");
        newStage.setScene(new Scene(root, 487, 148));
        newStage.show();
    }

    public void addNewUrl(String name, String url) {
        data.add(new Stream(name, url));
        streamListTable.setItems(data);
    }

    public void delete(MouseEvent mouseEvent) {
        data.remove(choosedStream);
        streamListTable.setItems(data);
    }

    public void exitNow(ActionEvent actionEvent) {
        stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }


    class TableRowControl extends TableRow<Stream> {
        public TableRowControl() {
            super();
            this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)
                            && event.getClickCount() == 1
                            && TableRowControl.this.getIndex() < streamListTable.getItems().size()) {
                        choosedStream = TableRowControl.this.getItem();
                        choosedIndex=TableRowControl.this.getIndex();
                    }
                }
            });
        }
    }
}

