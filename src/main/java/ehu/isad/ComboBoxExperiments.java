package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ImageView Experiment");
/*
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");

        comboBox.setEditable(true);

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());
        });

        HBox hbox = new HBox(comboBox);
*/

        /*
        InputStream is = getClass().getResourceAsStream("/kass.png");
        BufferedImage reader = ImageIO.read(is);
        Image image = SwingFXUtils.toFXImage(reader,null);
        ImageView imageView = new ImageView(image);
*/

        ComboBox comboBilduma = new ComboBox();
        ImageView imageView = new ImageView();
        List<String> bildumak = List.of("abereak", "landareak", "frutak");


        Map<String, List<Argazki>> bildumaMap = new HashMap<>();

        bildumaMap.put("abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")
        ));
        bildumaMap.put("landareak", List.of(
                new Argazki("Cactus", "cactus.png"),
                new Argazki("Landare Berdea", "landareberdea.jpeg"),
                new Argazki("Landare Horia", "landarehoria.jpeg")
        ));
        bildumaMap.put("frutak", List.of(
                new Argazki("Fresa", "fresa.jpeg"),
                new Argazki("Sagarra", "sagarra.jpeg"),
                new Argazki("Sandia", "sandia.png")
        ));

        ObservableList<String> bildumaList = FXCollections.observableArrayList(bildumak);
        bildumaList.addAll(bildumak);

        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));

        comboBilduma.setItems(bildumaList);
        comboBilduma.getSelectionModel().selectFirst();

        ListView<Argazki> listViewOfArgazki = new ListView<>(argazkiList);

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFitx();
            try {
                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        listViewOfArgazki.getSelectionModel().selectFirst();
        comboBilduma.setOnAction( e -> {
            String sakatuta = (String) comboBilduma.getValue();
            System.out.println(sakatuta);
            argazkiList.clear();
            argazkiList.addAll(bildumaMap.get(sakatuta));
            listViewOfArgazki.getSelectionModel().selectFirst();
        });



        VBox vbox = new VBox(comboBilduma, listViewOfArgazki, imageView);
        //vbox.setAlignment(Pos.BASELINE_CENTER);
        //vbox.setPadding(new Insets(10, 0, 0 ,0));


        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);


/*
        public static void main(String[] args) {
        Application.launch(args);
    }*/
}}
