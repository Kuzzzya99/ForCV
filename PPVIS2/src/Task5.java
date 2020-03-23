import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class Task5{

    private Pane pane;

    public Task5(Pane pane){
        this.pane = pane;
    }

    public void start(){

        ObservableList<task5.Person> list = FXCollections.observableArrayList();

        // Tittle
        TitledPane titledPane = new TitledPane();
        titledPane.setText("fifth");
        titledPane.setCollapsible(false);
        titledPane.setPrefSize(450, 280);


        // Buttons
        Button button1= new Button("Bring in");
        button1.setPrefWidth(215);
        Button button2= new Button("Move to first column");
        button2.setPrefWidth(210);
        Button button3= new Button("Move to second column");
        button3.setPrefWidth(210);


        // TextField
        TextField textField = new TextField();
        textField.setPrefWidth(215);


        //Create column first column
        TableColumn<task5.Person,String> firstCol = new TableColumn<>("first column");
        firstCol.setPrefWidth(215);
        firstCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        //Create column second column
        TableColumn<task5.Person,String> secondCol = new TableColumn<>("second column");
        secondCol.setPrefWidth(215);
        secondCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        // Table
        TableView<task5.Person> table = new TableView<>();
        table.setEditable(true);
        table.setItems(list);
        table.setPrefSize(430, 200);
        table.getColumns().addAll(firstCol, secondCol);


        // Hboxes
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(button1, textField);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(button2, button3);
        hBox2.setSpacing(10);


        // VBox
        VBox vBox= new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(table, hBox1, hBox2);



        button1.setOnAction(event ->{
            if(!textField.getText().equals("")) {
                list.add(new task5.Person(textField.getText()));
                textField.setText("");
            }
        });

        button2.setOnAction(event -> {
            task5.Person person = table.getSelectionModel().getSelectedItem();
            person.SwapLastWithFirst();
            table.refresh();
        });

        button3.setOnAction(event -> {
            task5.Person person = table.getSelectionModel().getSelectedItem();
            person.SwapFirstWithLast();
            table.refresh();
        });

        titledPane.setContent(vBox);
        pane.getChildren().add(titledPane);
    }
}