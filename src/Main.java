import Controller.GameController;
import Exceptions.DuplicateSymbolException;
import Exceptions.MorethanOneBotException;
import Exceptions.PlayersCountMismatchException;
import Models.*;
import winningstrategies.ColWinningStrategy;
import winningstrategies.DiagonalWinningStrategy;
import winningstrategies.RowWinningStrategy;
import winningstrategies.WinningStartegy;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountMismatchException, MorethanOneBotException {
        GameController gameController = new GameController() ;
        Scanner scanner = new Scanner(System.in) ;
        int dimension = 3 ;
        List<Player> playerList = new ArrayList<>() ;
        List<WinningStartegy> winningStartegies = new ArrayList<>() ;


        playerList.add(new Player('X', "Kaushal", 1, PlayerType.HUMAN));
        playerList.add(new Bot('0', "GPT", 2, PlayerType.BOT , DifficultyLevel.MEDIUM) ) ;

        winningStartegies.add(new RowWinningStrategy());
        winningStartegies.add(new ColWinningStrategy());
        winningStartegies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension , playerList ,winningStartegies) ;
        // Ygame.printBoard();

        while (GameState.IN_PROG.equals(game.getGameState())){
            game.printBoard();

            System.out.println("Does anyone want to undo ? (y/n)");
            String undo = scanner.next() ;
            if (undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        if (GameState.SUCCESS.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", Congrats You won the Game !!! ");
        }
        if (GameState.DRAW.equals(game.getGameState())){
            System.out.println("Match tied !");
        }
    }
}