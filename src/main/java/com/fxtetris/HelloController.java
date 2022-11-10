package com.fxtetris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.UnityMath.Vector2;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableColumn<Score, String> date;
    @FXML
    public TableColumn<Score, Integer> score;
    @FXML
    public TableView<Score> table;
    @FXML
    private Canvas canvas;
    private Game game;
    private GraphicsContext gc;
    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.setWidth(Game.WIDTH);
        canvas.setHeight(Game.HEIGHT);
        gc = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        button.setFocusTraversable(false);
        table.setFocusTraversable(false);

        date.setCellValueFactory(new PropertyValueFactory<Score, String>("date"));
        score.setCellValueFactory(new PropertyValueFactory<Score, Integer>("score"));
    }

    public Canvas getCanvas(){
        game = Game.getGame();
        return canvas;
    }
    @FXML
    protected void onKeyPressed(KeyEvent event) {
        if(!game.game_b) return;
        game.nowButtonPresst = true;
        if(event.getCode().equals(KeyCode.LEFT)){
                if (!game.isBorder('l')){
                    game.active.move(new Vector2(-Game.size, 0));
                    game.scene.repaint(gc);
                }
            }
        else if(event.getCode().equals(KeyCode.RIGHT)){
                if (!game.isBorder('r')) {
                    game.active.move(new Vector2(Game.size, 0));
                    game.scene.repaint(gc);
                }
            }
        else if(event.getCode().equals(KeyCode.DOWN)){
                if (!game.isStop()){
                    game.active.move(new Vector2(0, -Game.size));
                    game.scene.repaint(gc);
                }
                else {
                    game.Respaun();
                    game.Explosion();
                    game.scene.repaint(gc);
                }
            }
        else if(event.getCode().equals(KeyCode.UP)) {
                game.Rotation();
                game.scene.repaint(gc);
            }

        game.nowButtonPresst = false;
    }

    public void onStartClickButton(ActionEvent actionEvent) {
        game.start = true;
        game.ini();
        canvas.requestFocus();
    }
}