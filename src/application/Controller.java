package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
                button.setStyle("");
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
            String winner = checkWinner();
            if(winner != null){
                playerTurnLabel.setText(winner + " Wins!");
                disableBoard();
            }else if(boardFull()){
                playerTurnLabel.setText("Draw");
                disableBoard();
            }
        }
    }
    private String checkWinner(){
        for(int i = 0; i < 3; i++){
            Button button1 = (Button) boardGrid.getChildren().get(i*3);
            Button button2 = (Button) boardGrid.getChildren().get(i*3+1);
            Button button3 = (Button) boardGrid.getChildren().get(i*3+2);

            if(!button1.getText().isEmpty() && button1.getText().equals(button2.getText()) &&
                    button2.getText().equals(button3.getText())){
                button1.setStyle("-fx-background-color: green");
                button2.setStyle("-fx-background-color: green");
                button3.setStyle("-fx-background-color: green");
                return button1.getText();
            }
        }

        for(int j = 0; j < 3; j++){
            Button button1 = (Button) boardGrid.getChildren().get(j);
            Button button2 = (Button) boardGrid.getChildren().get(j+3);
            Button button3 = (Button) boardGrid.getChildren().get(j+6);
            if(!button1.getText().isEmpty() && button1.getText().equals(button2.getText()) &&
                    button2.getText().equals(button3.getText())){
                button1.setStyle("-fx-background-color: green");
                button2.setStyle("-fx-background-color: green");
                button3.setStyle("-fx-background-color: green");
                return button1.getText();
            }
        }

        Button button1 = (Button) boardGrid.getChildren().get(0);
        Button button2 = (Button) boardGrid.getChildren().get(4);
        Button button3 = (Button) boardGrid.getChildren().get(8);

        if(!button1.getText().isEmpty() && button1.getText().equals(button2.getText()) &&
                button2.getText().equals(button3.getText())){
            button1.setStyle("-fx-background-color: green");
            button2.setStyle("-fx-background-color: green");
            button3.setStyle("-fx-background-color: green");
            return button1.getText();
        }

        Button button4 = (Button) boardGrid.getChildren().get(2);
        Button button5 = (Button) boardGrid.getChildren().get(4);
        Button button6 = (Button) boardGrid.getChildren().get(6);

        if(!button4.getText().isEmpty() && button4.getText().equals(button5.getText()) &&
                button5.getText().equals(button6.getText())){
            button4.setStyle("-fx-background-color: green");
            button5.setStyle("-fx-background-color: green");
            button6.setStyle("-fx-background-color: green");
            return button4.getText();
        }

        return null;
    }
    private boolean boardFull(){
        for(var node: boardGrid.getChildren()) {
            if(node instanceof Button) {
                Button button = (Button)node;
                if(button.getText().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
    private void disableBoard(){
        for(var node: boardGrid.getChildren()) {
            if(node instanceof Button) {
                Button button = (Button)node;
                button.setDisable(true);
            }
        }
    }
}
