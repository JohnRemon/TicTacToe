package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Controller {
    @FXML
    private Button startButton;
    @FXML
    private GridPane boardGrid;
    @FXML
    private Label playerTurnLabel;

    private boolean isXTurn;

    public void initialize() {
        startGame();
    }
    @FXML
    private void startGame(ActionEvent event) {
        startGame();
    }
    private void startGame() {
        int randomNum = (int)(Math.random()*2);
        isXTurn = (randomNum == 1);
        playerTurnLabel.setText(isXTurn ? "Player X's Turn" : "Players O's Turn");
        clearBoard();
    }
    private void clearBoard() {
        for(var node: boardGrid.getChildren()) {
            if(node instanceof Button) {
                Button button = (Button)node;
                button.setText("");
                button.setDisable(false);
            }
        }
    }
    public void handleButtonPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        if(button.getText().isEmpty()){
            if(isXTurn) {
                playerTurnLabel.setText("Player O's Turn");
                button.setText("X");
            }else{
                playerTurnLabel.setText("Player X's Turn");
                button.setText("O");
            }
            isXTurn = !isXTurn;
            checkWinner();
        }
    }
    private void checkWinner(){
        for(int i = 0; i < boardGrid.getChildren().size(); i++){

        }
    }
}
