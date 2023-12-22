package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimensions ;
    private List<List<Cell>> board ;
    public Board(int dimensions) {
        this.dimensions = dimensions;
        board = new ArrayList<>() ;
          for (int i=0 ; i<dimensions ; i++){
              board.add(new ArrayList<>());
                for (int j=0 ; j<dimensions ; j++){
                    board.get(i).add(new Cell(i,j));
                }
          }
    }
    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard() {
        for (List<Cell> row : board){
            for (Cell cell : row){
                cell.display() ;
            }
            System.out.println();
        }
    }
}
