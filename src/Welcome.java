import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

public class Welcome {
    public static void welcomeOperations(){
        Pane welcomePane = new Pane();
        Timeline welcomeTimeline;
        Text welcomeEnterText, welcomeEscText;
        Background welcomeBackground;

        welcomeEnterText = new Text("PRESS ENTER TO START");
        welcomeEscText = new Text("PRESS ESC TO EXIT");
        welcomeEnterText.setFont(Font.font(18* DuckHunt.SCALE));
        welcomeEscText.setFont(Font.font(18* DuckHunt.SCALE));
        welcomeEnterText.setFill(Color.ORANGE);
        welcomeEscText.setFill(Color.ORANGE);
        welcomeEnterText.setX((DuckHunt.WIDTH - welcomeEnterText.getLayoutBounds().getWidth()) / 2);
        welcomeEnterText.setY(DuckHunt.HEIGHT*0.70);
        welcomeEscText.setX((DuckHunt.WIDTH - welcomeEscText.getLayoutBounds().getWidth()) / 2);
        welcomeEscText.setY(DuckHunt.HEIGHT*0.70 + (18* DuckHunt.SCALE));

        File audioFile = new File("assets/effects/Title.mp3");
        String mediaPath = audioFile.toURI().toString();
        Media media = new Media(mediaPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(DuckHunt.volume);

        welcomeTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(welcomeEnterText.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(welcomeEnterText.opacityProperty(), 0.0)),
                new KeyFrame(Duration.ZERO, new KeyValue(welcomeEscText.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(welcomeEscText.opacityProperty(), 0.0))
        );
        welcomeTimeline.setAutoReverse(true);
        welcomeTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        BackgroundImage welcomeBackgroundImage = new BackgroundImage(
                new Image("assets/welcome/1.png"),  // Specify the image file path
                BackgroundRepeat.NO_REPEAT,     // Set the repeat mode
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(DuckHunt.WIDTH, DuckHunt.HEIGHT,false,false,true,false)
        );
        welcomeBackground = new Background(welcomeBackgroundImage);

        welcomePane.setBackground(welcomeBackground);
        welcomePane.getChildren().addAll(welcomeEnterText, welcomeEscText);
        DuckHunt.welcomeScene = new Scene(welcomePane, DuckHunt.WIDTH, DuckHunt.HEIGHT);
        welcomeTimeline.play();
        DuckHunt.welcomeScene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                welcomeTimeline.pause();
                Control.controlOperations();
                mediaPlayer.pause();
                //Main.window.setScene(Main.controlScene);
            } else if(event.getCode() == KeyCode.ESCAPE){
                DuckHunt.window.close();
            }
        });
        DuckHunt.window.setScene(DuckHunt.welcomeScene);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }
}
