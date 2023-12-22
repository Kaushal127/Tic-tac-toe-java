package winningstrategies;

import Models.Board;
import Models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStartegy{
    Map<Character,Integer> rightDiagonalMap = new HashMap<>() ;
    Map<Character,Integer> leftDiaginalMap = new HashMap<>() ;
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow() ;
        int col = move.getCell().getCol() ;
        char symbol = move.getPlayer().getSymbol();

          if (row==col){
              if (!leftDiaginalMap.containsKey(symbol)){
                  leftDiaginalMap.put(symbol,0) ;
              }
              leftDiaginalMap.put(symbol , leftDiaginalMap.get(symbol)+1) ;

              if (board.getDimensions()==leftDiaginalMap.get(symbol)) {
                  System.out.println("Winning via left diagonal");
                  return true ;
              }
          }

          if ((row+col)==(board.getDimensions()-1)){
              if (!rightDiagonalMap.containsKey(symbol)){
                  rightDiagonalMap.put(symbol,0) ;
              }
              rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1) ;

              if (board.getDimensions()==rightDiagonalMap.get(symbol)){
                  System.out.println("Winning via right diagonal");
                  return true ;
              }
          }

        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {
            int row = lastMove.getCell().getRow() ;
            int col = lastMove.getCell().getCol() ;
            char symbol = lastMove.getPlayer().getSymbol();

            if (row==col){
                leftDiaginalMap.put(symbol , leftDiaginalMap.get(symbol)-1) ;
            }
             if ((row+col)==(board.getDimensions()-1)){
                rightDiagonalMap.put(symbol , rightDiagonalMap.get(symbol)-1) ;
            }
    }
}
