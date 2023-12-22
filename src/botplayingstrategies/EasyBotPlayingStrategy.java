package botplayingstrategies;

import Models.Board;
import Models.Cell;
import Models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board) {
        for (List<Cell> row : board.getBoard()){
            for (Cell cell : row){
                if (CellState.EMPTY.equals(cell.getCellState())){
                    return cell ;
                }
            }
        }
        return null ;
    }
}
