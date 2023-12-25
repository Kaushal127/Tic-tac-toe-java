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
            if (playerRowCount== board.getDimensions()-1 && emptyRowCell!=null){
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
            if(playerColCount== board.getDimensions()-1 && emptyColCell!=null){
                return emptyColCell ;
            }
        }

        int playerRightDiaCount = 0 ;
        Cell emptyRightDiaCell = null ;
        for (int i=0 ; i< board.getDimensions();i++){

            for (int j=0 ; j< board.getDimensions();j++){

                if (i==j){
                    Cell cell = board.getBoard().get(i).get(j) ;
                    if (CellState.FILLED.equals(cell.getCellState())){
                        if (PlayerType.HUMAN.equals(cell.getPlayer().getPlayerType())){
                            playerRightDiaCount++;
                        }
                    } else if (CellState.EMPTY.equals(cell.getCellState())){
                        emptyRightDiaCell = cell ;
                    }
                }
            }
        }
        if(playerRightDiaCount== board.getDimensions()-1 && emptyRightDiaCell!=null){
            return emptyRightDiaCell ;
        }

        int playerleftDiaCount = 0 ;
        Cell emptyleftDiaCell = null ;
        for (int i=0 ; i< board.getDimensions();i++){

            for (int j=0 ; j< board.getDimensions();j++){
                if (i + j == board.getDimensions() - 1){
                    Cell cell = board.getBoard().get(i).get(j) ;
                    if (CellState.FILLED.equals(cell.getCellState())){
                        if (PlayerType.HUMAN.equals(cell.getPlayer().getPlayerType())){
                            playerleftDiaCount++;
                        }
                    } else if (CellState.EMPTY.equals(cell.getCellState())){
                        emptyleftDiaCell = cell ;
                    }
                }
            }
        }
        if(playerleftDiaCount== board.getDimensions()-1 && emptyleftDiaCell!=null){
            return emptyleftDiaCell ;
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
              if (ownRowCount==board.getDimensions()-1 && emptyRowCell!=null){
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
             if(ownColCount==board.getDimensions()-1 && emptyColCell!=null){
                 return emptyColCell ;
             }
        }
        int ownRightDiaCount = 0 ;
        Cell emptyRightDiaCell = null ;
        for (int i=0 ; i< board.getDimensions();i++){

            for (int j=0 ; j< board.getDimensions();j++){

                if (i==j){
                    Cell cell = board.getBoard().get(i).get(j) ;
                    if (CellState.FILLED.equals(cell.getCellState())){
                        if (PlayerType.BOT.equals(cell.getPlayer().getPlayerType())){
                            ownRightDiaCount++;
                        }
                    } else if (CellState.EMPTY.equals(cell.getCellState())){
                        emptyRightDiaCell = cell ;
                    }
                }
            }
        }
        if(ownRightDiaCount==board.getDimensions()-1 && emptyRightDiaCell!=null){
            return emptyRightDiaCell ;
        }

        int ownleftDiaCount = 0 ;
        Cell emptyleftDiaCell = null ;
        for (int i=0 ; i< board.getDimensions();i++){

            for (int j=0 ; j< board.getDimensions();j++){
                if (i + j == board.getDimensions() - 1){
                    Cell cell = board.getBoard().get(i).get(j) ;
                    if (CellState.FILLED.equals(cell.getCellState())){
                        if (PlayerType.BOT.equals(cell.getPlayer().getPlayerType())){
                            ownleftDiaCount++;
                        }
                    } else if (CellState.EMPTY.equals(cell.getCellState())){
                        emptyleftDiaCell = cell ;
                    }
                }
            }
        }
        if(ownleftDiaCount==board.getDimensions()-1 && emptyleftDiaCell!=null){
            return emptyleftDiaCell ;
        }

        return  null ;
    }
}
