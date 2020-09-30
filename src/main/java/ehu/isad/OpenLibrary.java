package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpenLibrary {


    public void start(Stage primaryStage) {

        primaryStage.setTitle("OpenLibrary");

        ComboBox comboBox = new ComboBox();
        Label label = new Label();


        comboBox.getItems().add("Blockchain: Blueprint for a New Economy");
        comboBox.getItems().add("R for Data Science");
        comboBox.getItems().add("Fluent Python");
        comboBox.getItems().add("Natural Language Processing with PyTorch");
        comboBox.getItems().add("Data Algorithms");

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());
            Liburua liburua= new Liburua();
            liburua = liburua.URLReader((String)comboBox.getValue());
            label.setText(liburua.getTitle()+" "+liburua.getSubtitle()+"\n"+liburua.getNumber_of_pages()+"\n"+liburua.getPublishers()[0]);
            for(int i=1; i<liburua.getPublishers().length; i++){
                label.setText(label.getText() + "," + liburua.getPublishers()[i]);
            }
        });

        VBox vbox = new VBox(comboBox,label);

        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


