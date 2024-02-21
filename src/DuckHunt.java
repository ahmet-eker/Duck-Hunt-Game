import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;


public class DuckHunt extends Application {
    public static Background mainBackground;
    public static ImageView mainForeground, mainCrosshair;
    public static Cursor imageCursor;
    public static Stage window;
    public static Scene welcomeScene, controlScene, level1Scene, level2Scene, level3Scene, level4Scene, level5Scene, level6Scene;
    public static int level;
    public static final double SCALE = 2;
    public static final double WIDTH = 256*SCALE;
    public static final double HEIGHT = 240*SCALE;
    public static double volume = 0.90;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("HUBBM Duck Hunt");
        window.getIcons().add(new Image("assets/favicon/1.png"));

        Welcome.welcomeOperations();

        window.show();

    }

}
