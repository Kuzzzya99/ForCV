import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane field = new FlowPane();
        Scene scene = new Scene(field, 480, 670);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Second Lab");
        Task1 task1 = new Task1(field);
        task1.start();
        Task2 task2 = new Task2(field);
        task2.start();
        Task3 task3 = new Task3(field);
        task3.start();
        Task4 task4 = new Task4(field);
        task4.start();
        Task5 task5 = new Task5(field);
        task5.start();
        primaryStage.show();
        field.setHgap(10);
        field.setVgap(10);


        field.setPadding(new Insets(15,15,15,15));
    }

    public static void main(String[] args) {
        launch(args);
    }
}