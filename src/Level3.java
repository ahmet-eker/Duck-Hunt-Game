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

public class Level3 {

    public static void level3Operations(){
        Pane level3Pane = new Pane();
        DuckHunt.level3Scene = null;
        Text level3Text, ammoText, winText, enterText, gameoverText, enterAgainText, escText;
        final boolean[] nextLevel = {false};
        final boolean[] isKilledBlack = {false};
        final boolean[] isKilledBlue = {false};
        final int[] ammoLeft = {6};


        level3Text = new Text("Level 3/6");
        ammoText = new Text("Ammo Left: " + ammoLeft[0]);
        level3Text.setFont(Font.font(8* DuckHunt.SCALE));
        ammoText.setFont(Font.font(8* DuckHunt.SCALE));
        level3Text.setFill(Color.ORANGE);
        ammoText.setFill(Color.ORANGE);
        level3Text.setX((DuckHunt.WIDTH - level3Text.getLayoutBounds().getWidth()) / 2);
        level3Text.setY(DuckHunt.HEIGHT*0.03);
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

        Image duckScaledBlack = new Image("assets/duck_black/4.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);
        Image duckScaledBlue = new Image("assets/duck_blue/4.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);

        ImageView duckBlackImageView = new ImageView(duckScaledBlack);
        ImageView duckBlueImageView = new ImageView(duckScaledBlue);
        duckBlackImageView.setY(DuckHunt.HEIGHT*0.40);
        duckBlueImageView.setY(DuckHunt.HEIGHT*0.15);
        duckBlueImageView.setX(DuckHunt.WIDTH*0.90);
        duckBlueImageView.setScaleX(-1);

        final int[] xAddedBlack = {20*(int) DuckHunt.SCALE};
        final int[] yAddedBlack = {20*(int) DuckHunt.SCALE};
        final int[] xAddedBlue = {-30*(int) DuckHunt.SCALE};
        final int[] yAddedBlue = {20*(int) DuckHunt.SCALE};

        final int[] indexBlack = {1};
        final int[] indexBlue = {1};
        final int[] fallIndexBlack = {0};
        final int[] fallIndexBlue = {0};

        Image[] blackDuckHorizontal = new Image[3];
        for(int i=0;i<3;i++){
            blackDuckHorizontal[i] = new Image("assets/duck_black/"+(i+4)+".png",duckScaledBlack.getWidth(),duckScaledBlack.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }

        Image[] blueDuckHorizontal = new Image[3];
        for(int i=0;i<3;i++){
            blueDuckHorizontal[i] = new Image("assets/duck_blue/"+(i+4)+".png",duckScaledBlue.getWidth(),duckScaledBlue.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }


        Timeline duckBlackMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.4), event -> {
                    indexBlack[0] = indexBlack[0] % 3;

                    if(DuckHunt.WIDTH - duckBlackImageView.getX() < xAddedBlack[0] || (duckBlackImageView.getX() < -xAddedBlack[0] && xAddedBlack[0] <0)){
                        if(xAddedBlack[0]>0){
                            duckBlackImageView.setScaleX(-1);
                        }else {
                            duckBlackImageView.setScaleX(1);
                        }
                        xAddedBlack[0] = -xAddedBlack[0];
                    }
                    duckBlackImageView.setImage(blackDuckHorizontal[indexBlack[0]]);
                    duckBlackImageView.setX(duckBlackImageView.getX()+xAddedBlack[0]);
                    indexBlack[0]++;
                })
        );
        duckBlackMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        Timeline duckBlueMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.55), event -> {
                    indexBlue[0] = indexBlue[0] % 3;

                    if(DuckHunt.WIDTH - duckBlueImageView.getX() < xAddedBlue[0] || (duckBlueImageView.getX() < -xAddedBlue[0] && xAddedBlue[0] <0)){
                        if(xAddedBlue[0]>0){
                            duckBlueImageView.setScaleX(-1);
                        }else {
                            duckBlueImageView.setScaleX(1);
                        }
                        xAddedBlue[0] = -xAddedBlue[0];
                    }
                    duckBlueImageView.setImage(blueDuckHorizontal[indexBlue[0]]);
                    duckBlueImageView.setX(duckBlueImageView.getX()+xAddedBlue[0]);

                    indexBlue[0]++;
                })
        );
        duckBlueMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        Timeline duckBlackFallTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.35), event -> {
                    if(fallIndexBlack[0]==0){
                        fallIndexBlack[0] = 1;
                        duckBlackImageView.setImage(new Image("assets/duck_black/7.png",duckScaledBlack.getWidth(),duckScaledBlack.getHeight(),false,false));
                    }else if (fallIndexBlack[0] == 1){
                        duckBlackImageView.setImage(new Image("assets/duck_black/8.png",duckFall.getWidth()* DuckHunt.SCALE,duckFall.getHeight()* DuckHunt.SCALE,false,false));
                        duckBlackImageView.setY(duckBlackImageView.getY()+yAddedBlack[0]);
                        if(duckBlackImageView.getY() + yAddedBlack[0] > DuckHunt.HEIGHT){
                            yAddedBlack[0] = 0;
                        }
                    }
                })
        );
        duckBlackFallTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        Timeline duckBlueFallTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.4), event -> {
                    if(fallIndexBlue[0]==0){
                        fallIndexBlue[0] = 1;
                        duckBlueImageView.setImage(new Image("assets/duck_blue/7.png",duckScaledBlue.getWidth(),duckScaledBlue.getHeight(),false,false));
                    }else if (fallIndexBlue[0] == 1){
                        duckBlueImageView.setImage(new Image("assets/duck_blue/8.png",duckFall.getWidth()* DuckHunt.SCALE,duckFall.getHeight()* DuckHunt.SCALE,false,false));
                        duckBlueImageView.setY(duckBlueImageView.getY()+yAddedBlue[0]);
                        if(duckBlueImageView.getY() + yAddedBlue[0] > DuckHunt.HEIGHT){
                            yAddedBlue[0] = 0;
                        }
                    }
                })
        );
        duckBlueFallTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        duckBlackImageView.setOnMouseClicked(event -> {
            mediaPlayerduckfalls.play();
            isKilledBlack[0] = true;
            duckBlackMoveTimeline.pause();
            duckBlackFallTimeline.play();
            if(isKilledBlue[0]){
                level3Pane.getChildren().addAll(winText,enterText);
                enterTimeline.play();
                nextLevel[0] = true;
                mediaPlayerlevelcompleted.play();
            }
        });


        duckBlueImageView.setOnMouseClicked(event -> {
            mediaPlayerduckfalls.play();
            isKilledBlue[0] = true;
            duckBlueMoveTimeline.pause();
            duckBlueFallTimeline.play();
            if(isKilledBlack[0]){
                level3Pane.getChildren().addAll(winText,enterText);
                enterTimeline.play();
                nextLevel[0] = true;
                mediaPlayerlevelcompleted.play();
            }
        });


        level3Pane.setOnMouseClicked(event -> {
            mediaPlayergunshot.play();
            mediaPlayergunshot.stop();
            if(ammoLeft[0]>0){
                ammoLeft[0]--;
                ammoText.setText("Ammo Left: " + ammoLeft[0]);
            }
            if(ammoLeft[0] == 0 && (!isKilledBlack[0]||!isKilledBlue[0])){
                level3Pane.getChildren().addAll(gameoverText,enterAgainText,escText);
                overTimeline.play();
                nextLevel[0] = false;
                mediaPlayergameover.play();
            }
        });


        level3Pane.setBackground(DuckHunt.mainBackground);
        level3Pane.getChildren().addAll(duckBlackImageView,duckBlueImageView,level3Text,ammoText, DuckHunt.mainForeground);
        DuckHunt.level3Scene = new Scene(level3Pane, DuckHunt.WIDTH, DuckHunt.HEIGHT);
        DuckHunt.level3Scene.setCursor(DuckHunt.imageCursor);
        duckBlackMoveTimeline.play();
        duckBlueMoveTimeline.play();
        DuckHunt.level3Scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                enterTimeline.pause();
                if(nextLevel[0]){
                    Level4.level4Operations();
                }else {
                    Control.controlOperations();
                }
            } else if (event.getCode() == KeyCode.ESCAPE) {
                Welcome.welcomeOperations();
            }
        });
        DuckHunt.window.setScene(DuckHunt.level3Scene);


    }
}
