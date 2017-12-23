/**
 * Created by Nabz on 5/26/2017.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;



public class Controller {

    private Button[][] buttonGrid;
    private Game game;
    private int p1Score, p2Score;

    @FXML
    private Label titleLabel;

    @FXML
    private Label lblP1Score;

    @FXML
    private Label lblP2Score;

    @FXML
    private GridPane mainGrid;

    @FXML
    private Button resetButton;

    @FXML
    private void initialize() {
        initGame();

        buttonGrid[0][0].setOnAction(event -> {
            game.playGame(1, 1);

            checkWin();
            updateBoard();
        });
        buttonGrid[0][1].setOnAction(event -> {
            game.playGame(1, 2);

            checkWin();
            updateBoard();
        });
        buttonGrid[0][2].setOnAction(event -> {
            game.playGame(1, 3);

            checkWin();
            updateBoard();
        });
        buttonGrid[1][0].setOnAction(event -> {
            game.playGame(2, 1);

            checkWin();
            updateBoard();
        });
        buttonGrid[1][1].setOnAction(event -> {
            game.playGame(2, 2);

            checkWin();
            updateBoard();
        });
        buttonGrid[1][2].setOnAction(event -> {
            game.playGame(2, 3);

            checkWin();
            updateBoard();
        });
        buttonGrid[2][0].setOnAction(event -> {
            game.playGame(3, 1);

            checkWin();
            updateBoard();
        });
        buttonGrid[2][1].setOnAction(event -> {
            game.playGame(3, 2);

            checkWin();
            updateBoard();
        });
        buttonGrid[2][2].setOnAction(event -> {
            game.playGame(3, 3);

            checkWin();
            updateBoard();
        });

        resetButton.setOnAction(event -> {
            game.reset();
            titleLabel.setText("");
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    buttonGrid[r][c].getStyleClass().add("buttonStyles.css");
                    buttonGrid[r][c].setStyle("");
                }
            }
            updateBoard();
        });
    }

    private void initGame(){
        p1Score = 0;
        p2Score = 0;
        game = new Game();
        initButtons();
    }

    private void initButtons() {
        buttonGrid = new Button[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttonGrid[r][c] = new Button();
                buttonGrid[r][c].setMinSize(100, 100);
                mainGrid.add(buttonGrid[r][c], r, c);
            }
        }
    }

    private void checkWin() {
        if (game.hasWon) {
            updateScore();
            switch (game.getWinningLoc()) {
                case co1One:
                    buttonGrid[0][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[0][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[0][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case colTwo:
                    buttonGrid[1][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case colThree:
                    buttonGrid[2][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case rowOne:
                    buttonGrid[0][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case rowTwo:
                    buttonGrid[0][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case rowThree:
                    buttonGrid[0][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case diagRL:
                    buttonGrid[0][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
                case diagLR:
                    buttonGrid[0][0].getStyleClass().add("buttonStyles.css");
                    buttonGrid[0][0].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[1][1].getStyleClass().add("buttonStyles.css");
                    buttonGrid[1][1].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    buttonGrid[2][2].getStyleClass().add("buttonStyles.css");
                    buttonGrid[2][2].setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
                    break;
            }
            titleLabel.setText("Winner!");
        }
    }

    private void updateScore(){
        if(game.hasWon){
            if(game.p1Turn){
                p2Score++;
                lblP2Score.setText("P2 Score: " + Integer.toString(p2Score));
            }
            else
                p1Score++;
                lblP1Score.setText("P1 Score: "+ Integer.toString(p1Score));
        }
    }

    private void updateBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char xAndO = game.toeBoard[r][c];
                String charToString = Character.toString(xAndO);
                buttonGrid[r][c].setText(charToString);
                buttonGrid[r][c].setFont(new Font("Verdana", 20));
            }
        }
    }
}
