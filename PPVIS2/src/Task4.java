import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {

    private Pane pane;

    public Task4(Pane pane){
        this.pane = pane;
    }

    public void start(){

        // Tittle in fourth group of elements
        TitledPane titledPane = new TitledPane();
        titledPane.setText("fourth");
        titledPane.setCollapsible(false);
        titledPane.setPrefWidth(220);


        // Button  Enter
        Button button = new Button("Enter");
        button.setPrefWidth(100);


        // TextField in fourth tittle
        TextField textField = new TextField();
        textField.setPrefWidth(110);


        // Checkboxes
        CheckBox checkBox1 = new CheckBox("English");
        CheckBox checkBox2 = new CheckBox("Russian");
        CheckBox checkBox3 = new CheckBox("German");


        // HBox in fourth tittle
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button, textField);


        // VBox in fourth tittle
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(new Label("What languages you know"), hBox, checkBox1, checkBox2, checkBox3);


        Map<String, CheckBox> listOfCheckBoxes = new HashMap<>();
        listOfCheckBoxes.put("English", checkBox1);
        listOfCheckBoxes.put("Russian", checkBox2);
        listOfCheckBoxes.put("German", checkBox3);
        button.setOnAction(event -> {
            List<String> error = new ArrayList<>();
            for (String compare : textField.getText().split(" ")) {
                if (listOfCheckBoxes.containsKey(compare)) {
                    listOfCheckBoxes.get(compare).fire();
                }
                else {
                    error.add(compare);
                }
            }
            if (!error.isEmpty()) {
                String errorWords = "";
                for(String word : error) errorWords += "\'"+ word + "\'" + ", ";
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error : elements " + errorWords + "are not exist");
                alert.setContentText("Please, check your entered data.");
                alert.showAndWait();
            }

        });


        titledPane.setContent(vBox);
        pane.getChildren().add(titledPane);
    }
}