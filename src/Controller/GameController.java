package Controller;

import Exceptions.DuplicateSymbolException;
import Exceptions.MorethanOneBotException;
import Exceptions.PlayersCountMismatchException;
import Models.Game ;
import Models.Player;
import winningstrategies.WinningStartegy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList , List<WinningStartegy> winningStartegies)
            throws DuplicateSymbolException, PlayersCountMismatchException, MorethanOneBotException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStartegies(winningStartegies)
                .build() ;
    }
    public void printBoard(Game game ){
        game.printBoard() ;
    }

    public void makeMove(Game game){
        game.makeMove() ;
    }

    public void undo(Game game){
        game.undo() ;
    }

}
