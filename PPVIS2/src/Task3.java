import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.*;

public class Task3 {

    private Pane pane;

    public Task3(Pane pane){
        this.pane = pane;
    }

    public void start(){

        // Tittle in third group of elements
        TitledPane titledPane = new TitledPane();
        titledPane.setText("third");
        titledPane.setCollapsible(false);
        titledPane.setPrefWidth(220);


        // Button Choose
        Button button = new Button("Choose");
        button .setPrefWidth(100);

        // TextField in third tittle
        TextField textField = new TextField();
        textField.setPrefWidth(110);


        // ToggleGroup for RadioButtons
        ToggleGroup group = new ToggleGroup();


        // RadioButtons
        RadioButton radioButton1 = new RadioButton("Java");
        radioButton1.setToggleGroup(group);
        RadioButton radioButton2 = new RadioButton("C#");
        radioButton2.setToggleGroup(group);
        RadioButton radioButton3 = new RadioButton("Python");
        radioButton3.setToggleGroup(group);


        // HBox in third tittle
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button, textField);


        // VBox in third tittle
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(new Label("Enter your choice:"), hBox, radioButton1, radioButton2, radioButton3);


        Map<String, RadioButton> listOfRadioButtons = new HashMap<>();
        listOfRadioButtons.put("Java", radioButton1);
        listOfRadioButtons.put("C#", radioButton2);
        listOfRadioButtons.put("Python", radioButton3);
        button.setOnAction(event -> {
            if (listOfRadioButtons.containsKey(textField.getText())) {
                listOfRadioButtons.get(textField.getText()).fire();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error : there is no such option");
                alert.setContentText("Please, enter the option again.");
                alert.showAndWait();
            }
        });


        titledPane.setContent(vBox);
        pane.getChildren().add(titledPane);
    }
}