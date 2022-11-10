package com.fxtetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.UnityMath.Vector2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelloApplication extends Application {
    private Game game;
    private HelloController Controller;
    private List<Score> statistics = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Game.WIDTH+100, Game.HEIGHT+100);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Controller = (HelloController) fxmlLoader.getController();
        Canvas canvas = Controller.getCanvas();
        game = Game.getGame();

        GraphicsContext gc = Controller.getCanvas().getGraphicsContext2D();
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(500), e->run(gc)));
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.play();
    }

    public static void main(String[] args) {
        launch();
    }
    private void run(GraphicsContext gc){
        if(!game.nowButtonPresst) {
            if (game.game_b && game.start) {
                if (!game.isStop()) game.active.move(new Vector2(0, -game.size));
                else {
                    game.Respaun();
                    game.Explosion();
                }
                game.scene.repaint(gc);
            } else if(game.start){
                System.out.println("Game Over: " + game.score);
                Date d = new Date();
                d.setTime(System.currentTimeMillis());
                System.out.println(d);
                statistics.add(new Score(d.toString(), game.score));
                Controller.table.setItems(FXCollections.observableArrayList(statistics));
                game.start = false;
            }
        }
    }
}