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

public class Level6 {

    public static void level6Operations(){
        Pane level6Pane = new Pane();
        DuckHunt.level6Scene = null;
        Text level6Text, ammoText, winText, enterText, gameoverText, enterAgainText, escText;
        final boolean[] nextLevel = {false};
        final boolean[] isKilledBlack = {false};
        final boolean[] isKilledBlue = {false};
        final boolean[] isKilledRed = {false};
        final int[] ammoLeft = {9};

        level6Text = new Text("Level 6/6");
        ammoText = new Text("Ammo Left: " + ammoLeft[0]);
        level6Text.setFont(Font.font(8* DuckHunt.SCALE));
        ammoText.setFont(Font.font(8* DuckHunt.SCALE));
        level6Text.setFill(Color.ORANGE);
        ammoText.setFill(Color.ORANGE);
        level6Text.setX((DuckHunt.WIDTH - level6Text.getLayoutBounds().getWidth()) / 2);
        level6Text.setY(DuckHunt.HEIGHT*0.03);
        ammoText.setX(DuckHunt.WIDTH-(50* DuckHunt.SCALE));
        ammoText.setY(DuckHunt.HEIGHT*0.03);
        enterText = new Text("Press ENTER to play again");
        winText = new Text("You have completed the game");
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

        File audioFilegamecompleted = new File("assets/effects/GameCompleted.mp3");
        String mediaPathgamecompleted = audioFilegamecompleted.toURI().toString();
        Media mediagamecompleted = new Media(mediaPathgamecompleted);
        MediaPlayer mediaPlayergamecompleted = new MediaPlayer(mediagamecompleted);
        mediaPlayergamecompleted.setVolume(DuckHunt.volume);




        Image duck = new Image("assets/duck_black/4.png");
        Image duckFall = new Image("assets/duck_black/8.png");

        Image duckScaledBlack = new Image("assets/duck_black/1.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);
        Image duckScaledBlue = new Image("assets/duck_blue/1.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);
        Image duckScaledRed = new Image("assets/duck_red/1.png",duck.getWidth()* DuckHunt.SCALE,duck.getHeight()* DuckHunt.SCALE,false,false);

        ImageView duckBlackImageView = new ImageView(duckScaledBlack);
        ImageView duckBlueImageView = new ImageView(duckScaledBlue);
        ImageView duckRedImageView = new ImageView(duckScaledRed);
        duckBlackImageView.setY(DuckHunt.HEIGHT*0.20);
        duckBlueImageView.setY(DuckHunt.HEIGHT*0.50);
        duckRedImageView.setY(DuckHunt.HEIGHT*0.40);
        duckBlueImageView.setX(DuckHunt.WIDTH*0.90);
        duckBlackImageView.setX(DuckHunt.WIDTH*0.50);
        duckBlackImageView.setScaleY(1);
        duckBlueImageView.setScaleY(-1);
        duckBlueImageView.setScaleX(-1);
        duckRedImageView.setScaleY(-1);


        final int[] xAddedBlack = {20*(int) DuckHunt.SCALE};
        final int[] yAddedBlack = {-20*(int) DuckHunt.SCALE};
        final int[] xAddedBlue = {-30*(int) DuckHunt.SCALE};
        final int[] yAddedBlue = {20*(int) DuckHunt.SCALE};
        final int[] xAddedRed = {20*(int) DuckHunt.SCALE};
        final int[] yAddedRed = {20*(int) DuckHunt.SCALE};


        final int[] indexBlack = {1};
        final int[] indexBlue = {1};
        final int[] indexRed = {1};
        final int[] fallIndexBlack = {0};
        final int[] fallIndexBlue = {0};
        final int[] fallIndexRed = {0};


        Image[] blackDuckCross = new Image[3];
        for(int i=0;i<3;i++){
            blackDuckCross[i] = new Image("assets/duck_black/"+(i+1)+".png",duckScaledBlack.getWidth(),duckScaledBlack.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }

        Image[] blueDuckCross = new Image[3];
        for(int i=0;i<3;i++){
            blueDuckCross[i] = new Image("assets/duck_blue/"+(i+1)+".png",duckScaledBlue.getWidth(),duckScaledBlue.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }

        Image[] redDuckCross = new Image[3];
        for(int i=0;i<3;i++){
            redDuckCross[i] = new Image("assets/duck_red/"+(i+1)+".png",duckScaledBlue.getWidth(),duckScaledRed.getHeight(),false,false); //, Main.WIDTH, Main.HEIGHT, false, false
        }



        Timeline duckBlackMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.60), event -> {
                    indexBlack[0] = indexBlack[0] % 3;

                    if(DuckHunt.WIDTH - duckBlackImageView.getX() < xAddedBlack[0] || (duckBlackImageView.getX() < -xAddedBlack[0] && xAddedBlack[0] <0)){
                        if(xAddedBlack[0]>0){
                            duckBlackImageView.setScaleX(-1);
                        }else {
                            duckBlackImageView.setScaleX(1);
                        }
                        xAddedBlack[0] = -xAddedBlack[0];
                    }

                    if(DuckHunt.HEIGHT - duckBlackImageView.getY() < yAddedBlack[0] || (duckBlackImageView.getY() < -yAddedBlack[0] && yAddedBlack[0] <0)){
                        if(yAddedBlack[0]>0){
                            duckBlackImageView.setScaleY(1);
                        }else {
                            duckBlackImageView.setScaleY(-1);
                        }
                        yAddedBlack[0] = -yAddedBlack[0];
                    }

                    duckBlackImageView.setImage(blackDuckCross[indexBlack[0]]);
                    duckBlackImageView.setX(duckBlackImageView.getX()+xAddedBlack[0]);
                    duckBlackImageView.setY(duckBlackImageView.getY()+yAddedBlack[0]);
                    indexBlack[0]++;
                })
        );
        duckBlackMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        Timeline duckBlueMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.60), event -> {
                    indexBlue[0] = indexBlue[0] % 3;

                    if(DuckHunt.WIDTH - duckBlueImageView.getX() < xAddedBlue[0] || (duckBlueImageView.getX() < -xAddedBlue[0] && xAddedBlue[0] <0)){
                        if(xAddedBlue[0]>0){
                            duckBlueImageView.setScaleX(-1);
                        }else {
                            duckBlueImageView.setScaleX(1);
                        }
                        xAddedBlue[0] = -xAddedBlue[0];
                    }

                    if(DuckHunt.HEIGHT - duckBlueImageView.getY() < yAddedBlue[0] || (duckBlueImageView.getY() < -yAddedBlue[0] && yAddedBlue[0] <0)){
                        if(yAddedBlue[0]>0){
                            duckBlueImageView.setScaleY(1);
                        }else {
                            duckBlueImageView.setScaleY(-1);
                        }
                        yAddedBlue[0] = -yAddedBlue[0];
                    }

                    duckBlueImageView.setImage(blueDuckCross[indexBlue[0]]);
                    duckBlueImageView.setX(duckBlueImageView.getX()+xAddedBlue[0]);
                    duckBlueImageView.setY(duckBlueImageView.getY()+yAddedBlue[0]);
                    indexBlue[0]++;
                })
        );
        duckBlueMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely



        Timeline duckRedMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.60), event -> {
                    indexRed[0] = indexRed[0] % 3;

                    if(DuckHunt.WIDTH - duckRedImageView.getX() < xAddedRed[0] || (duckRedImageView.getX() < -xAddedRed[0] && xAddedRed[0] <0)){
                        if(xAddedRed[0]>0){
                            duckRedImageView.setScaleX(-1);
                        }else {
                            duckRedImageView.setScaleX(1);
                        }
                        xAddedRed[0] = -xAddedRed[0];
                    }

                    if(DuckHunt.HEIGHT - duckRedImageView.getY() < yAddedRed[0] || (duckRedImageView.getY() < -yAddedRed[0] && yAddedRed[0] <0)){
                        if(yAddedRed[0]>0){
                            duckRedImageView.setScaleY(1);
                        }else {
                            duckRedImageView.setScaleY(-1);
                        }
                        yAddedRed[0] = -yAddedRed[0];
                    }

                    duckRedImageView.setImage(redDuckCross[indexRed[0]]);
                    duckRedImageView.setX(duckRedImageView.getX()+xAddedRed[0]);
                    duckRedImageView.setY(duckRedImageView.getY()+yAddedRed[0]);
                    indexRed[0]++;
                })
        );
        duckRedMoveTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely



        Timeline duckBlackFallTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.35), event -> {
                    if(fallIndexBlack[0]==0){
                        fallIndexBlack[0] = 1;
                        duckBlackImageView.setImage(new Image("assets/duck_black/7.png",duckScaledBlack.getWidth(),duckScaledBlack.getHeight(),false,false));
                    }else if (fallIndexBlack[0] == 1){
                        duckBlackImageView.setImage(new Image("assets/duck_black/8.png",duckFall.getWidth()* DuckHunt.SCALE,duckFall.getHeight()* DuckHunt.SCALE,false,false));
                        duckBlackImageView.setScaleY(1);
                        duckBlackImageView.setY(duckBlackImageView.getY()+Math.abs(yAddedBlack[0]));
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
                        duckBlueImageView.setScaleY(1);
                        duckBlueImageView.setY(duckBlueImageView.getY()+Math.abs(yAddedBlue[0]));
                        if(duckBlueImageView.getY() + yAddedBlue[0] > DuckHunt.HEIGHT){
                            yAddedBlue[0] = 0;
                        }
                    }
                })
        );
        duckBlueFallTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely



        Timeline duckRedFallTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.4), event -> {
                    if(fallIndexRed[0]==0){
                        fallIndexRed[0] = 1;
                        duckRedImageView.setImage(new Image("assets/duck_red/7.png",duckScaledRed.getWidth(),duckScaledRed.getHeight(),false,false));
                    }else if (fallIndexRed[0] == 1){
                        duckRedImageView.setImage(new Image("assets/duck_red/8.png",duckFall.getWidth()* DuckHunt.SCALE,duckFall.getHeight()* DuckHunt.SCALE,false,false));
                        duckRedImageView.setScaleY(1);
                        duckRedImageView.setY(duckRedImageView.getY()+Math.abs(yAddedRed[0]));
                        if(duckRedImageView.getY() + yAddedRed[0] > DuckHunt.HEIGHT){
                            yAddedRed[0] = 0;
                        }
                    }
                })
        );
        duckRedFallTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely


        duckBlackImageView.setOnMouseClicked(event -> {
            mediaPlayerduckfalls.play();
            isKilledBlack[0] = true;
            duckBlackMoveTimeline.pause();
            duckBlackFallTimeline.play();
            if(isKilledBlue[0] && isKilledRed[0]){
                level6Pane.getChildren().addAll(winText,enterText);
                enterTimeline.play();
                nextLevel[0] = true;
                mediaPlayergamecompleted.play();
            }
        });


        duckBlueImageView.setOnMouseClicked(event -> {
            mediaPlayerduckfalls.play();
            isKilledBlue[0] = true;
            duckBlueMoveTimeline.pause();
            duckBlueFallTimeline.play();
            if(isKilledBlack[0]&&isKilledRed[0]){
                level6Pane.getChildren().addAll(winText,enterText);
                enterTimeline.play();
                nextLevel[0] = true;
                mediaPlayergamecompleted.play();
            }
        });


        duckRedImageView.setOnMouseClicked(event -> {
            mediaPlayerduckfalls.play();
            isKilledRed[0] = true;
            duckRedMoveTimeline.pause();
            duckRedFallTimeline.play();
            if(isKilledBlack[0]&&isKilledBlue[0]){
                level6Pane.getChildren().addAll(winText,enterText);
                enterTimeline.play();
                nextLevel[0] = true;
                mediaPlayergamecompleted.play();
            }
        });

        level6Pane.setOnMouseClicked(event -> {
            mediaPlayergunshot.play();
            mediaPlayergunshot.stop();
            if(ammoLeft[0]>0){
                ammoLeft[0]--;
                ammoText.setText("Ammo Left: " + ammoLeft[0]);
            }
            if(ammoLeft[0] == 0 && (!isKilledBlack[0]||!isKilledBlue[0]||!isKilledRed[0])){
                level6Pane.getChildren().addAll(gameoverText,enterAgainText,escText);
                overTimeline.play();
                nextLevel[0] = false;
            }
        });



        level6Pane.setBackground(DuckHunt.mainBackground);
        level6Pane.getChildren().addAll(duckBlackImageView,duckBlueImageView,duckRedImageView,level6Text,ammoText, DuckHunt.mainForeground);
        DuckHunt.level6Scene = new Scene(level6Pane, DuckHunt.WIDTH, DuckHunt.HEIGHT);
        DuckHunt.level6Scene.setCursor(DuckHunt.imageCursor);
        duckBlackMoveTimeline.play();
        duckBlueMoveTimeline.play();
        duckRedMoveTimeline.play();
        DuckHunt.level6Scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                enterTimeline.pause();
                if(nextLevel[0]){
                    Control.controlOperations();
                }else {
                    Control.controlOperations();
                }
            } else if (event.getCode() == KeyCode.ESCAPE) {
                Welcome.welcomeOperations();
            }
        });
        DuckHunt.window.setScene(DuckHunt.level6Scene);
    }
}
