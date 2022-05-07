package com.example.lab4;

import com.example.lab4.bd.Calc;
import com.example.lab4.bd.DBProvider;
import com.example.lab4.bd.Special;
import com.example.lab4.bd.bdclasses.Company;
import com.example.lab4.bd.bdclasses.Country;
import com.example.lab4.bd.bdclasses.Region;
import com.example.lab4.cast.ParserJSON;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    ParserJSON parserJSON = null;
    DBProvider provider;
    Calc calc;

    @FXML
    private TableColumn<Special, SimpleStringProperty> column1;

    @FXML
    private TableColumn<Special, SimpleStringProperty> column2;

    @FXML
    private TableView<Special> table;

    public static void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    public static void error(String e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e);
        alert.showAndWait();
    }

    @FXML
    void start(ActionEvent event) {
        try {
            parserJSON = new ParserJSON(new File((getClass().getResource("ReactorType.json").getFile())));
            provider = new DBProvider();
            provider.connect(new File(getClass().getResource("Lab3.accdb").getFile()));
            provider.setAll(parserJSON.getReactorArrayList());
            provider.close();
            calc = new Calc(provider);
            companyT(event);
            System.out.println();
        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void companyT(ActionEvent event) {
        column1.setText("Company");
        column2.setText("Объем ежегодного потребления, т.");
        ObservableList<Special> data = FXCollections.observableArrayList();
        for (Company company : provider.getCompanies()) {
            data.add(new Special(new SimpleStringProperty(company.getName()), new SimpleDoubleProperty(company.getConsumption())));
        }
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory("consumption"));
        table.setItems(data);
    }

    @FXML
    void countryT(ActionEvent event) {
        column1.setText("Country");
        column2.setText("Объем ежегодного потребления, т.");
        ObservableList<Special> data = FXCollections.observableArrayList();
        for (Country country : provider.getCountries()) {
            data.add(new Special(new SimpleStringProperty(country.getName()), new SimpleDoubleProperty(country.getConsumption())));
        }
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory("consumption"));
        table.setItems(data);

    }

    @FXML
    void regionT(ActionEvent event) {
        column1.setText("Region");
        column2.setText("Объем ежегодного потребления, т.");
        ObservableList<Special> data = FXCollections.observableArrayList();
        for (Region region : provider.getRegions()) {
            data.add(new Special(new SimpleStringProperty(region.getName()), new SimpleDoubleProperty(region.getConsumption())));
        }
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory("consumption"));
        table.setItems(data);

    }


    @FXML
    void importFile(ActionEvent event) {
        try {
            FileChooser jsonFC = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON", "*.json");
            jsonFC.getExtensionFilters().add(extFilter);
            File json = jsonFC.showOpenDialog(null);
            parserJSON = new ParserJSON(json);
        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void importBD(ActionEvent event) {
        if (parserJSON == null) {
            error("Import JSON");
        } else {
            try {
                FileChooser dbFC = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ACCDB", "*.accdb");
                dbFC.getExtensionFilters().add(extFilter);
                File db = dbFC.showOpenDialog(null);
                provider = new DBProvider();
                provider.connect(db);
                provider.setAll(parserJSON.getReactorArrayList());
                provider.close();
                calc = new Calc(provider);
                companyT(event);
            } catch (Exception e) {
                error(e);
            }
        }
    }
}
