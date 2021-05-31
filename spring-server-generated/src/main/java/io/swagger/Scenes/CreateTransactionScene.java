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

public class CreateTransactionScene {
    private Stage window;

public CreateTransactionScene() {
    window = new Stage();
    window.setHeight(800);
    window.setWidth(900);
    window.setTitle("Create Transaction");


    Label transactionLabel = new Label("Transaction");
    Label transferTo = new Label("To");
    TextField transferToTxtField = new TextField();
    transferToTxtField.setPromptText("To");
    Label amountLabel = new Label("amount");
    TextField amountTxtField = new PasswordField();
    amountTxtField.setPromptText("amount");
    Label messageLabel = new Label("message");
    TextField messageTxtField = new PasswordField();
    messageTxtField.setPromptText("message");
    Button submitButton = new Button("SubmitTransaction");


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
    GridPane.setConstraints(transferTo,0,1);
    GridPane.setConstraints(transferToTxtField,1,1);
    GridPane.setConstraints(amountLabel,0,2);
    GridPane.setConstraints(amountTxtField,1,2);
    GridPane.setConstraints(messageLabel,0, 3);
    GridPane.setConstraints(messageTxtField, 1, 3);
    GridPane.setConstraints(submitButton,0,3);

    gridpane.getChildren().addAll(transactionLabel,transferTo,transferToTxtField,amountLabel
            ,amountTxtField,messageLabel,messageTxtField, submitButton);

    Scene scene = new Scene(gridpane);
    window.setScene(scene);

}
}
