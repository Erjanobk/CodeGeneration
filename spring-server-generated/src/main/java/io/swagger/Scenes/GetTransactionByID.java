package io.swagger.Scenes;
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

public class GetTransactionByID {
    private Stage window;

    public GetTransactionByID() {
        window = new Stage();
        window.setHeight(800);
        window.setWidth(900);
        window.setTitle("Create Transaction by ID");

        Label transactionLabel = new Label("Transaction");
        Label transactionID = new Label("transactionID");
        TextField transactionIDTxtField = new TextField();
        transactionIDTxtField.setPromptText("transactionID");
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
        GridPane.setConstraints(submitButton,0,3);

        gridpane.getChildren().addAll(transactionLabel, transactionID, transactionIDTxtField, submitButton);

        Scene scene = new Scene(gridpane);
        window.setScene(scene);
    }
}
