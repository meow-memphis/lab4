package com.example.lab4;

import com.example.lab4.bd.DBProvider;
import com.example.lab4.cast.ParserJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    ParserJSON parserJSON = null;
    @FXML
    private Button importBD;
    @FXML
    private Button importBut;

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
                DBProvider provider = new DBProvider();
                provider.connect(db);
                provider.getAll(parserJSON.getReactorArrayList());
                provider.close();
            } catch (Exception e) {
                error(e);
            }
        }
    }
}
