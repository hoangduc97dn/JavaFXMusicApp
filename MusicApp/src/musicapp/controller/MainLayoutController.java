/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp.controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author sun
 */
public class MainLayoutController implements Initializable {

    @FXML
    private Pane pane_header;
    @FXML
    private Pane pane_home;
    @FXML
    private Pane pane_song;
    @FXML
    private Pane pane_download;
    @FXML
    private Pane pane_about;
    @FXML
    private AnchorPane pane_menu;
    @FXML
    private JFXButton button_home;
    @FXML
    private JFXButton button_song;
    @FXML
    private JFXButton button_download;
    @FXML
    private JFXButton button_setting;
    @FXML
    private JFXButton button_about;
    @FXML
    private AnchorPane pane_setting;
    @FXML
    private JFXButton button_menu;
    @FXML
    private JFXButton button_close;
    @FXML
    private AnchorPane pane_main;
    @FXML
    private JFXButton button_subclose;

    static private int index = 0;
    @FXML
    private FontAwesomeIconView button_play;
    @FXML
    private FontAwesomeIconView button_left;
    @FXML
    private FontAwesomeIconView button_right;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleActionMenu(ActionEvent event) {
        if (event.getSource() == button_home && index != 0) {
            makeFadeOut(pane_home);
            pane_home.toFront();
            index = 0;
        } else if (event.getSource() == button_song && index != 1) {
            makeFadeOut(pane_song);
            pane_song.toFront();
            index = 1;
        } else if (event.getSource() == button_download && index != 2) {
            makeFadeOut(pane_download);
            pane_download.toFront();
            index = 2;
        } else if (event.getSource() == button_setting && !pane_setting.isVisible()) {
            pane_setting.setVisible(true);
            makeFadeOut(pane_setting);
        } else if (event.getSource() == button_about && index != 4) {
            makeFadeOut(pane_about);
            pane_about.toFront();
            index = 4;
        }
    }

    @FXML
    private void menuOnAction(ActionEvent event) {
        if (pane_menu.isVisible()) {
            pane_menu.setVisible(false);

        } else {
            makeFadeOut(pane_menu);
        }

    }

    @FXML
    private void closeOnAction(ActionEvent event) {
        System.exit(0);
    }

    private void makeFadeOut(Pane pane) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(pane);

        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        pane.setVisible(true);
        fadeTransition.play();
    }

    @FXML
    private void subcloseOnAction(ActionEvent event) {
        pane_setting.setVisible(false);
    }
}
