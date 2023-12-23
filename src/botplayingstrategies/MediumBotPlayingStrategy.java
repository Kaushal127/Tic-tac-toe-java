package botplayingstrategies;

import Models.*;

import java.util.List;

public class MediumBotPlayingStrategy implements  BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board) {
        Cell winningMove = findWinningMove(board) ;
          if (winningMove!=null){
              return winningMove ;
          }

        Cell bolckingMove = findBlockingMove(board) ;
          if (bolckingMove!=null){
              return bolckingMove ;
          }

        return getRandomMove(board) ;
    }

    private Cell getRandomMove(Board board) {
        for (List<Cell> row : board.getBoard()){
            for (Cell cell : row){
                if (CellState.EMPTY.equals(cell.getCellState())){
                    return cell ;
                }
            }
        }
        return null ;
    }

    private Cell findBlockingMove(Board board) {
        for (List<Cell> row : board.getBoard()){
            int playerRowCount = 0 ;
            Cell emptyRowCell = null ;
            for (Cell cell : row){
                if (CellState.FILLED.equals(cell.getCellState())){
                    if (PlayerType.HUMAN.equals(cell.getPlayer().getPlayerType())) {
                        playerRowCount++;
                    }
                } else if (CellState.EMPTY.equals(cell.getCellState())){
                    emptyRowCell = cell ;
                }
            }
            if (playerRowCount==2 && emptyRowCell!=null){
                return emptyRowCell ;
            }
        }
        for (int col=0 ; col<board.getDimensions() ; col++){
            int playerColCount = 0 ;
            Cell emptyColCell = null ;
            for (List<Cell> row : board.getBoard()){
                Cell cell = row.get(col) ;
                if (CellState.FILLED.equals(cell.getCellState())){
                    if(PlayerType.HUMAN.equals(cell.getPlayer().getPlayerType())){
                        playerColCount++ ;
                    }
                } else if (CellState.EMPTY.equals(cell.getCellState())){
                    emptyColCell = cell ;
                }
            }
            if(playerColCount==2 && emptyColCell!=null){
                return emptyColCell ;
            }
        }

        return null ;
    }

    private Cell findWinningMove(Board board) {
        for (List<Cell> row : board.getBoard()){
            int ownRowCount = 0 ;
            Cell emptyRowCell = null ;
              for (Cell cell : row){
                  if (CellState.FILLED.equals(cell.getCellState())){
                     if (PlayerType.BOT.equals(cell.getPlayer().getPlayerType())) {
                         ownRowCount++;
                     }
                  } else if (CellState.EMPTY.equals(cell.getCellState())){
                      emptyRowCell = cell ;
                  }
              }
              if (ownRowCount==2 && emptyRowCell!=null){
                  return emptyRowCell ;
              }
        }
        for (int col=0 ; col<board.getDimensions() ; col++){
            int ownColCount = 0 ;
            Cell emptyColCell = null ;
             for (List<Cell> row : board.getBoard()){
                 Cell cell = row.get(col) ;
                 if (CellState.FILLED.equals(cell.getCellState())){
                     if(PlayerType.BOT.equals(cell.getPlayer().getPlayerType())){
                         ownColCount++ ;
                     }
                 } else if (CellState.EMPTY.equals(cell.getCellState())){
                     emptyColCell = cell ;
                 }
             }
             if(ownColCount==2 && emptyColCell!=null){
                 return emptyColCell ;
             }
        }
        return  null ;
    }
}
