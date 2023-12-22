package winningstrategies;

import Models.Board;
import Models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStartegy{

    Map<Integer , Map<Character,Integer>> map = new HashMap<>() ;
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol() ;
        char symbol = move.getPlayer().getSymbol();

           if(!map.containsKey(col)){
                map.put(col , new HashMap<>()) ;
           }
        Map<Character , Integer> colMap = map.get(col) ;
            if (!colMap.containsKey(symbol)){
                colMap.put(symbol , 0) ;
            }
            colMap.put(symbol , colMap.get(symbol)+1) ;
         if (board.getBoard().size()==(colMap.get(symbol))){
             System.out.println("Winning via col "+col);
             return true ;
         }

        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {

    }
}
