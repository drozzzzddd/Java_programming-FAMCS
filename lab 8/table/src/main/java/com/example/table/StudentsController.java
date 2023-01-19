package com.example.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Comparator;

public class StudentsController {

    StudentsList st = new StudentsList();

    private ObservableList<Students> Students_list= FXCollections.observableArrayList();

    @FXML
    private Button add_;

    @FXML
    private TextField add_age_;

    @FXML
    private TextField add_fn_;

    @FXML
    private TextField add_sn_;

    @FXML
    void ADD(ActionEvent event) {
        Students_list.add(new Students(add_fn_.getText(), add_sn_.getText(), Integer.parseInt(add_age_.getText())));
        add_fn_.clear();
        add_sn_.clear();
        add_age_.clear();
    }

    @FXML
    private TableView<Students> table_;

    @FXML
    private TableColumn<Students, String> firstNAME_;

    @FXML
    private TableColumn<Students, String> secondNAME_;

    @FXML
    private Button sortingAGE_;

    @FXML
    private Button sorting_name;

    @FXML
    private TableColumn<Students, Integer> thirdAGE_;


    @FXML
    void press_age(ActionEvent event) {
        Comparator<Students> c = new Students.StudentsComparatorAge();
        Students_list.sort(c);
    }

    public void sort(Comparator<Students> compare) {
        Students_list.sort(compare);
    }

    @FXML
    void press_name(ActionEvent event) {
        Comparator<Students> c = new Students.StudentsComparatorName();
        Students_list.sort(c);
    }

    @FXML
    private void initialize() throws IOException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        firstNAME_.setCellValueFactory(new PropertyValueFactory<Students, String>("first_name"));
        secondNAME_.setCellValueFactory(new PropertyValueFactory<Students, String>("second_name"));
        thirdAGE_.setCellValueFactory(new PropertyValueFactory<Students, Integer>("age"));

        // заполняем таблицу данными
        table_.setItems(Students_list);
    }

    private void initData() throws IOException {
        st.readJSON("input.json");
        for(int i=0; i<st.getArrayStudents().size(); ++i) {
            Students_list.add(st.getArrayStudents().get(i));
        }
    }

}
