import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Task2 {

    private Pane pane;

    public Task2(Pane pane){
        this.pane = pane;
    }

    public void start(){

        // Tittle in second group of elements
        TitledPane titledPane = new TitledPane();
        titledPane.setText("second");
        titledPane.setCollapsible(false);
        titledPane.setPrefWidth(220);


        // Button 1 Apply
        Button button1= new Button("Apply");
        button1.setPrefWidth(100);


        // Button 2 Swap
        Button button2 = new Button("Swap");
        button2.setPrefWidth(100);


        // TextField in second tittle
        TextField textField = new TextField();
        textField.setPrefWidth(110);


        // HBox in second tittle
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, button2);
        hBox.setSpacing(5);


        VBox vBoxSecondTitle = new VBox();
        vBoxSecondTitle.setSpacing(5);
        vBoxSecondTitle.getChildren().addAll(hBox, new Label("Enter word:"), textField);


        button1.setOnAction(event -> {
            if(!textField.getText().equals("")) {
                button2.setText(textField.getText());
                textField.setText("");
            }
        });

        button2.setOnAction(event -> {
            String name = button2.getText();
            button2.setText(button1.getText());
            button1.setText(name);
        });

        titledPane.setContent(vBoxSecondTitle);
        pane.getChildren().add(titledPane);
    }
}