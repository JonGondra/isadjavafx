package ehu.isad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label Erabiltzailelbl;

    @FXML
    private TextField Erabiltzailetxt;

    @FXML
    private Label Pasahitzlbl;

    @FXML
    private PasswordField Psswd;

    @FXML
    private Button Kautotubtn;

    @FXML
    void onClick(ActionEvent event) {
        System.out.println(Erabiltzailetxt.getText());
        System.out.println(Psswd.getText());
        Erabiltzailetxt.setText("");
        Psswd.setText("");
    }

}
