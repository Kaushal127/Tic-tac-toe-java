package Models;

import java.util.Scanner;

public class Player {
    private char Symbol ;
    private String name ;
    private int id ;
    private PlayerType playerType ;
    private Scanner scanner ;


    public Player(char symbol, String name, int id, PlayerType playerType) {
        this.Symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        scanner = new Scanner(System.in) ;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cell makeMove(Board board) {
        System.out.println(this.name+", Its your turn to make a move , enter row and col");
        int row = scanner.nextInt() ;
        int col = scanner.nextInt() ;

         while(!validatMove(row, col, board)){
             System.out.println(this.name+", Invalid move, please try again ");

             row = scanner.nextInt();
             col = scanner.nextInt();
         }

         Cell cell =  board.getBoard().get(row).get(col) ;
         cell.setCellState(CellState.FILLED);
         cell.setPlayer(this);

         return  cell ;

    }

    private boolean validatMove(int row, int col ,Board board) {
        if(row>=board.getDimensions() || row<0){
            return false;
        }
        if(col>=board.getDimensions() || col<0){
            return false;
        }
        if(!CellState.EMPTY.equals(board.getBoard().get(row).get(col).getCellState())){
            return false;
        }
        return true;
    }
}
