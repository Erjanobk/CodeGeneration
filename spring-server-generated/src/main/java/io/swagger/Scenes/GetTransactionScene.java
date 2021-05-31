package io.swagger.Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import io.swagger.api.TransactionApi;
import io.swagger.api.TransactionApiController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javax.swing.*;
import java.util.Date;

public class GetTransactionScene {
    private Stage window;
    public GetTransactionScene(){
        window = new Stage();
        window.setHeight(800);
        window.setWidth(900);
        window.setTitle("Create Transaction by ID");

        Label transactionLabel = new Label("Transaction");
        Label transactionID = new Label("transactionID");
        TextField transactionIDTxtField = new TextField();
        transactionIDTxtField.setPromptText("transactionID");
        Label startDate = new Label("startDate");
        DatePicker pickStartDate = new DatePicker();
        Label endDate = new Label("endDate");
        DatePicker pickEndDate = new DatePicker();
        Button submitButton = new Button("GetTransaction");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(10);
        gridpane.setVgap(8);

        GridPane.setConstraints(transactionLabel,0,0);
        GridPane.setConstraints(transactionID,0,1);
        GridPane.setConstraints(transactionIDTxtField,1,1);
        GridPane.setConstraints(startDate,0,2);
        GridPane.setConstraints(pickStartDate,1,2);
        GridPane.setConstraints(endDate,0,3);
        GridPane.setConstraints(pickEndDate,1,3);
        GridPane.setConstraints(submitButton,0,3);

        gridpane.getChildren().addAll(transactionLabel, transactionID, transactionIDTxtField, startDate, pickStartDate, endDate, pickEndDate, submitButton);

        Scene scene = new Scene(gridpane);
        window.setScene(scene);
    }
}
