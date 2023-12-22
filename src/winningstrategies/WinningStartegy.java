package winningstrategies;

import Models.Board;
import Models.Move;

public interface WinningStartegy {
    boolean checkWinner(Board board , Move move) ;

    void undo(Board board, Move lastMove);

}
