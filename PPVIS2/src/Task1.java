import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    private Pane pane;

    public Task1(Pane pane){
        this.pane = pane;
    }

    public void start(){

        // Tittle in first group of elements
        TitledPane titledPane = new TitledPane();
        titledPane.setText("first");
        titledPane.setCollapsible(false);
        titledPane.setPrefWidth(220);


        // ComboBox in first tittle
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setMaxWidth(200);


        // TextField in first tittle
        TextField textField = new TextField();
        textField.setPrefWidth(100);


        // Button Add city
        Button button1= new Button("Add City");
        button1.setPrefWidth(100);


        // HBox in first tittle
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, textField);


        // VBox in first tittle
        VBox vBox= new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox, new Label("Added cities:"), comboBox);

        List<String> chex = new ArrayList<>();
        button1.setOnAction(event -> {
            boolean check = false;
            for(String compare : chex){
                if(compare.equals(textField.getText())) check = true;
            }
            if (!textField.getText().equals("")) {
                if (check) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error : this word is already listed");
                    alert.setContentText("Please, enter the word again.");
                    alert.showAndWait();
                } else {
                    chex.add(textField.getText());
                    comboBox.getItems().add(textField.getText());
                    textField.setText("");
                }
            }
        });

        titledPane.setContent(vBox);
        pane.getChildren().add(titledPane);
    }
}