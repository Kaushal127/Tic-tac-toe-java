package botplayingstrategies;

import Models.Board;
import Models.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board) ;
}
