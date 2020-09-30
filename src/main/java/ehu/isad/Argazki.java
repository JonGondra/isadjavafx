package ehu.isad;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Argazki {
    String izena;
    String argazkia;

    public Argazki(String izena, String argazkia) {
        this.izena=izena;
        this.argazkia=argazkia;
    }

    public String getFitx() {

        return argazkia;
    }

    @Override
    public String toString() {
        return izena;
    }
}
