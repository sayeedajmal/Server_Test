package com.Javafx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
    /* These are the Fields */
    @FXML
    public JFXTextField myname = new JFXTextField();
    public JFXTextField fathername = new JFXTextField();
    public JFXTextField mothername = new JFXTextField();
    public TableView<names> tableview = new TableView<>();
    public TableColumn<names, String> name;
    public TableColumn<names, String> father;
    public TableColumn<names, String> mother;

    ObservableList<names> datas = FXCollections.observableArrayList();

    @FXML
    public void add() throws IOException {
        String name = myname.getText();
        String father = fathername.getText();
        String mother = mothername.getText();
        names data = new names(name, father, mother);
        datas.add(data);
        /* clearing TextFields */
        myname.setText(null);
        fathername.setText(null);
        mothername.setText(null);
        /* Creating A Text File */
        File file = new File("names.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        if (file.exists() && !name.isBlank() && !father.isBlank() && !mother.isBlank()) {
            fileWriter.append(name + "\n" + father + "\n" + mother + "\n" + "<<===============>>\n");
            fileWriter.close();
        } else {
            file.createNewFile();
            System.out.println("Fill All Fields");
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            System.out.println(input.next());
        }
        input.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<names, String>("name"));
        father.setCellValueFactory(new PropertyValueFactory<names, String>("father"));
        mother.setCellValueFactory(new PropertyValueFactory<names, String>("mother"));
        tableview.setItems(datas);
    }

}