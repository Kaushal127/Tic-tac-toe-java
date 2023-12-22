package winningstrategies;

import Models.Board;
import Models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStartegy{
    Map<Integer , Map<Character,Integer>> map = new HashMap<>() ;
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow() ;
        char symbol = move.getPlayer().getSymbol() ;

        if (!map.containsKey(row)){
            map.put(row , new HashMap<>()) ;
        }
        Map<Character , Integer> rowMap = map.get(row) ;
        if (!rowMap.containsKey(symbol)){
            rowMap.put(symbol , 0 ) ;
        }
        rowMap.put(symbol,rowMap.get(symbol)+1) ;

        if (board.getBoard().size()==(rowMap.get(symbol))) {
            System.out.println(" winning via row "+row);
            return true ;
        }
        return false ;
    }



    @Override
    public void undo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow() ;
        char symbol = lastMove.getPlayer().getSymbol() ;

        Map<Character , Integer> rowMap = map.get(row) ;
        rowMap.put(symbol , rowMap.get(symbol)-1) ;

    }
}
