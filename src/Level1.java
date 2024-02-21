import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

public class Level1 {

    public static void level1Operations(){
        Pane level1Pane = new Pane();
        DuckHunt.level1Scene = null;
        Text level1Text, ammoText, winText, enterText, gameoverText, enterAgainText, escText;
        final boolean[] nextLevel = {false};
        final boolean[] iskilled = {false};
        final int[] ammoLeft = {3};


        level1Text = new Text("Level 1/6");
        ammoText = new Text("Ammo Left: " + ammoLeft[0]);
        level1Text.setFont(Font.font(8* DuckHunt.SCALE));
        ammoText.setFont(Font.font(8* DuckHunt.SCALE));
        level1Text.setFill(Color.ORANGE);
        ammoText.setFill(Color.ORANGE);
        level1Text.setX((DuckHunt.WIDTH - level1Text.getLayoutBounds().getWidth()) / 2);
        level1Text.setY(DuckHunt.HEIGHT*0.03);
        ammoText.setX(DuckHunt.WIDTH-(50* DuckHunt.SCALE));
        ammoText.setY(DuckHunt.HEIGHT*0.03);
        enterText = new Text("Press ENTER to play next level");
        winText = new Text("YOU WIN");
        enterText.setFont(Font.font(18* DuckHunt.SCALE));
        winText.setFont(Font.font(18* DuckHunt.SCALE));
        enterText.setFill(Color.ORANGE);
        winText.setFill(Color.ORANGE);
        enterText.setX((DuckHunt.WIDTH - enterText.getLayoutBounds().getWidth()) / 2);
        enterText.setY(DuckHunt.HEIGHT*0.48 + (18* DuckHunt.SCALE));
        winText.setX((DuckHunt.WIDTH - winText.getLayoutBounds().getWidth()) / 2);
        winText.setY(DuckHunt.HEIGHT*0.48);
        enterAgainText = new Text("Press Enter to play again");
        escText = new Text("Press ESC to exit");
        gameoverText = new Text("GAME OVER");
        enterAgainText.setFont(Font.font(18* DuckHunt.SCALE));
        escText.setFont(Font.font(18* DuckHunt.SCALE));
        gameoverText.setFont(Font.font(18* DuckHunt.SCALE));
        enterAgainText.setFill(Color.ORANGE);
        escText.setFill(Color.ORANGE);
        gameoverText.setFill(Color.ORANGE);
        enterAgainText.setX((DuckHunt.WIDTH - enterAgainText.getLayoutBounds().getWidth()) / 2);
        escText.setX((DuckHunt.WIDTH - escText.getLayoutBounds().getWidth()) / 2);
        gameoverText.setX((DuckHunt.WIDTH - gameoverText.getLayoutBounds().getWidth()) / 2);
        enterAgainText.setY(DuckHunt.HEIGHT*0.48 + (18* DuckHunt.SCALE));
        escText.setY(DuckHunt.HEIGHT*0.48 + (36* DuckHunt.SCALE));
        gameoverText.setY(DuckHunt.HEIGHT*0.48);

        Timeline enterTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(enterText.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(enterText.opacityProperty(), 0.0))
        );
        enterTimeline.setAutoReverse(true);
        enterTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely

        Timeline overTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(enterAgainText.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(enterAgainText.opacityProperty(), 0.0)),
                new KeyFrame(Duration.ZERO, new KeyValue(escText.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(escText.opacityProperty(), 0.0))
        );
        overTimeline.setAutoReverse(true);
        overTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely

        File audioFileduckfalls = new File("assets/effects/DuckFalls.mp3");
        String mediaPathduckfalls = audioFileduckfalls.toURI().toString();
        Media mediaduckfalls = new Media(mediaPathduckfalls);
        MediaPlayer mediaPlayerduckfalls = new MediaPlayer(mediaduckfalls);
        mediaPlayerduckfalls.setVolume(DuckHunt.volume);

        File audioFilegameover = new File("assets/effects/GameOver.mp3");
        String mediaPathgameover = audioFilegameover.toURI().toString();
        Media mediagameover = new Media(mediaPathgameover);
        MediaPlayer mediaPlayergameover = new MediaPlayer(mediagameover);
        mediaPlayergameover.setVolume(DuckHunt.volume);

        File audioFilegunshot = new File("assets/effects/Gunshot.mp3");
        String mediaPathgunshot = audioFilegunshot.toURI().toString();
        Media mediagunshot = new Media(mediaPathgunshot);
        MediaPlayer mediaPlayergunshot = new MediaPlayer(mediagunshot);
        mediaPlayergunshot.setVolume(DuckHunt.volume);

        File audioFilelevelcompleted = new File("assets/effects/LevelCompleted.mp3");
        String mediaPathlevelcompleted = audioFilelevelcompleted.toURI().toString();
        Media medialevelcompleted = new Media(mediaPathlevelcompleted);
        MediaPlayer mediaPlayerlevelcompleted = new MediaPlayer(medialevelcompleted);
        mediaPlayerlevelcompleted.setVolume(DuckHunt.volume);


        Image duck = new Image("assets/duck_black/4.png");
        Image duckFall = new Image("assets/duck_black/8.png");
        Image duckScaled = new Image("assets/duck_black/4.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);
        ImageView duckImageView = new ImageView(duckScaled);
        duckImageView.setY(30* DuckHunt.SCALE);

        final int[] xAdded = {30*(int) DuckHunt.SCALE};
        final int[] yAdded = {30*(int) DuckHunt.SCALE};
        final int[] index = {1};
        final int[] fallIndex = {0};

        Image[] blackDuckHorizontal = new Image[3];
        for(int i=0;i<3;i++){
            blackDuckHorizontal[i] = new Image("assets/duck_black/"+(i+4)+".png",duckScaled.getWidth(),duckScaled.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }


        Timeline duckMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.4), event -> {
                    index[0] = index[0] % 3;

                    if(DuckHunt.WIDTH - duckImageView.getX() < xAdded[0] || (duckImageView.getX() < -xAdded[0] && xAdded[0] <0)){
                        if(xAdded[0]>0){
                            duckImageView.setScaleX(-1);
                        }else {
                            duckImageView.setScaleX(1);
                        }
                        xAdded[0] = -xAdded[0];
                    }
                    duckImageView.setImage(blackDuckHorizontal[index[0]]);
                    duckImageView.setX(duckImageView.getX()+xAdded[0]);
                    index[0]++;
                })
        );
        duckMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        Timeline duckFallTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.4), event -> {
                    if(fallIndex[0]==0){
                        fallIndex[0] = 1;
                        duckImageView.setImage(new Image("assets/duck_black/7.png",duckScaled.getWidth(),duckScaled.getHeight(),false,false));
                    }else if (fallIndex[0] == 1){
                        duckImageView.setImage(new Image("assets/duck_black/8.png",duckFall.getWidth()* DuckHunt.SCALE,duckFall.getHeight()* DuckHunt.SCALE,false,false));
                        duckImageView.setY(duckImageView.getY()+yAdded[0]);
                        if(duckImageView.getY() + yAdded[0] > DuckHunt.HEIGHT){
                            yAdded[0] = 0;
                        }
                    }
                })
        );
        duckFallTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        duckImageView.setOnMouseClicked(event -> {
            iskilled[0] = true;
            duckMoveTimeline.pause();
            duckFallTimeline.play();
            level1Pane.getChildren().addAll(winText,enterText);
            enterTimeline.play();
            nextLevel[0] = true;
            mediaPlayerduckfalls.play();
            mediaPlayerlevelcompleted.play();
        });

        level1Pane.setOnMouseClicked(event -> {
            mediaPlayergunshot.play();
            mediaPlayergunshot.stop();
            if(ammoLeft[0]>0){
                ammoLeft[0]--;
                ammoText.setText("Ammo Left: " + ammoLeft[0]);
            }
            if(ammoLeft[0] == 0 && !iskilled[0]){
                level1Pane.getChildren().addAll(gameoverText,enterAgainText,escText);
                overTimeline.play();
                nextLevel[0] = false;
                mediaPlayergameover.play();
            }
        });


        level1Pane.setBackground(DuckHunt.mainBackground);
        level1Pane.getChildren().addAll(duckImageView,level1Text,ammoText, DuckHunt.mainForeground);
        DuckHunt.level1Scene = new Scene(level1Pane, DuckHunt.WIDTH, DuckHunt.HEIGHT);
        DuckHunt.level1Scene.setCursor(DuckHunt.imageCursor);
        duckMoveTimeline.play();
        DuckHunt.level1Scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                enterTimeline.pause();
                if(nextLevel[0]){
                    Level2.level2Operations();
                }else {
                    Control.controlOperations();
                }
            } else if (event.getCode() == KeyCode.ESCAPE) {
                Welcome.welcomeOperations();
            }
        });
        DuckHunt.window.setScene(DuckHunt.level1Scene);
    }
}
