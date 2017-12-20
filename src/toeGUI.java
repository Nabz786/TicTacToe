import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Nabeel Vali on 5/26/2017.
 */
public class toeGUI extends Application {


    private Stage mainWindow;
    private Scene mainMenu;
    private Button startButton;
    private Button quitButton;
    private Label iMadeIt;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Style.fxml"));


        mainWindow = primaryStage;
        startButton = new Button("Start");
        quitButton = new Button("Quit");
        iMadeIt = new Label("Proudly Coded by Nabeel V");

        startButton.setPrefSize(70, 50);
        quitButton.setPrefSize(70, 50);


        quitButton.setOnAction(event -> Platform.exit());


        VBox startMenuLayout = new VBox(20);
        startMenuLayout.setPadding(new Insets(100, 0, 0, 10));
        startMenuLayout.getChildren().addAll(startButton, quitButton, iMadeIt);

        mainMenu = new Scene(startMenuLayout, 500, 500);

        //mainMenu.getStylesheets().add("textStuff..css");


        mainWindow.setScene(mainMenu);
        mainWindow.setTitle("Tic Tac Toe");
        mainWindow.show();
        startButton.setOnAction(event -> mainWindow.setScene(new Scene(root, 500, 500)));


    }

    public static void main(String args[]) {launch(args);}
}
