import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class Control {

    public static void controlOperations(){
        Background[] controlBackground = new Background[1];
        ImageView[] controlForeground = new ImageView[1];
        ImageView[] controlCrosshair = new ImageView[1];
        Pane controlPane = new Pane();
        DuckHunt.controlScene = null;
        Text arrowNavigateText, enterStartText, escStartText;
        BackgroundSize backgroundSize = new BackgroundSize(DuckHunt.WIDTH, DuckHunt.HEIGHT,false,false,true,false);
        final int[] k = {0}, l = {0};

        File audioFile = new File("assets/effects/Intro.mp3");
        String mediaPath = audioFile.toURI().toString();
        Media media = new Media(mediaPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(DuckHunt.volume);


        arrowNavigateText = new Text("USE ARROW KEYS TO NAVİGATE");
        enterStartText = new Text("PRESS ENTER TO START");
        escStartText = new Text("PRESS ESC TO EXIT");
        arrowNavigateText.setFont(Font.font(9* DuckHunt.SCALE));
        enterStartText.setFont(Font.font(9* DuckHunt.SCALE));
        escStartText.setFont(Font.font(9* DuckHunt.SCALE));
        arrowNavigateText.setFill(Color.ORANGE);
        enterStartText.setFill(Color.ORANGE);
        escStartText.setFill(Color.ORANGE);
        arrowNavigateText.setX((DuckHunt.WIDTH - arrowNavigateText.getLayoutBounds().getWidth()) / 2);
        arrowNavigateText.setY(DuckHunt.HEIGHT*0.08);
        enterStartText.setX((DuckHunt.WIDTH - enterStartText.getLayoutBounds().getWidth()) / 2);
        enterStartText.setY(DuckHunt.HEIGHT*0.08 + (10* DuckHunt.SCALE));
        escStartText.setX((DuckHunt.WIDTH - escStartText.getLayoutBounds().getWidth()) / 2);
        escStartText.setY(DuckHunt.HEIGHT*0.08 + (20* DuckHunt.SCALE));


        Background[] controlBackgrounds = new Background[6];
        for(int i = 0; i<6; i++){
            controlBackgrounds[i] = new Background(new BackgroundImage(new Image("assets/background/"+(i+1)+".png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));
        }
        controlBackground[0] = controlBackgrounds[k[0]];


        ImageView[] controlForegrounds = new ImageView[6];
        for(int i = 0;i<6;i++){
            controlForegrounds[i] = new ImageView(new Image("assets/foreground/"+(i+1)+".png", DuckHunt.WIDTH, DuckHunt.HEIGHT, false, false));
        }


        ImageView[] controlCrosshairs = new ImageView[7];
        for(int i = 0; i<7;i++){
            controlCrosshairs[i] = new ImageView(new Image("assets/crosshair/" + (i+1) + ".png"));
        }
        controlCrosshair[0] = new ImageView(new Image("assets/crosshair/1.png"));


        controlCrosshair[0].setX((DuckHunt.WIDTH-controlCrosshair[0].getLayoutBounds().getWidth())/2);
        controlCrosshair[0].setY((DuckHunt.HEIGHT-controlCrosshair[0].getLayoutBounds().getHeight())/2);
        controlCrosshair[0].setFitWidth(11* DuckHunt.SCALE); // Set the desired width
        controlCrosshair[0].setFitHeight(11* DuckHunt.SCALE); // Set the desired height

        controlPane.setBackground(controlBackground[0]);
        controlPane.getChildren().addAll(arrowNavigateText,enterStartText,escStartText,controlCrosshair[0]);
        DuckHunt.controlScene = new Scene(controlPane, DuckHunt.WIDTH, DuckHunt.HEIGHT);
        DuckHunt.controlScene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.RIGHT){
                if(k[0]==5){
                    controlPane.setBackground(controlBackgrounds[0]);
                    k[0]=0;
                }else {
                    controlPane.setBackground(controlBackgrounds[k[0]+1]);
                    k[0]++;
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if(k[0]==0){
                    controlPane.setBackground(controlBackgrounds[5]);
                    k[0]=5;
                }else {
                    controlPane.setBackground(controlBackgrounds[k[0]-1]);
                    k[0]--;
                }
            } else if (event.getCode() == KeyCode.UP) {
                controlPane.getChildren().remove(controlPane.getChildren().size()-1);
                if(l[0]==6){
                    controlCrosshair[0].setImage(controlCrosshairs[0].getImage());
                    l[0]=0;
                }
                else {
                    controlCrosshair[0].setImage(controlCrosshairs[l[0]+1].getImage());
                    l[0]++;
                }
                controlPane.getChildren().add(controlCrosshair[0]);
            } else if (event.getCode() == KeyCode.DOWN) {
                controlPane.getChildren().remove(controlPane.getChildren().size()-1);
                if(l[0]==0){
                    controlCrosshair[0].setImage(controlCrosshairs[6].getImage());
                    l[0]=6;
                }
                else {
                    controlCrosshair[0].setImage(controlCrosshairs[l[0]-1].getImage());
                    l[0]--;
                }
                controlPane.getChildren().add(controlCrosshair[0]);
            } else if (event.getCode() == KeyCode.ESCAPE) {
                Welcome.welcomeOperations();
                mediaPlayer.pause();
            } else if (event.getCode() == KeyCode.ENTER) {
                controlBackground[0] = controlBackgrounds[k[0]];
                controlForeground[0] = controlForegrounds[k[0]];
                DuckHunt.mainBackground = controlBackground[0];
                DuckHunt.mainForeground = controlForeground[0];
                DuckHunt.mainCrosshair = controlCrosshair[0];
                Image cursorImage = new Image("assets/crosshair/"+(l[0]+1)+".png",10* DuckHunt.SCALE,10* DuckHunt.SCALE,false,false);
                DuckHunt.imageCursor = new ImageCursor(cursorImage);
                mediaPlayer.pause();
                Level1.level1Operations();
            }
        });
        DuckHunt.window.setScene(DuckHunt.controlScene);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

    }
}
