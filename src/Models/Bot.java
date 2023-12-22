package Models;

import botplayingstrategies.BotPlayingStrategy;
import botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player {
    private DifficultyLevel difficultyLevel ;
    private BotPlayingStrategy botPlayingStrategy ;

    public Bot(char symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy =
                BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(difficultyLevel) ;
    }
    @Override
    public Cell makeMove(Board board){
        System.out.println("Get ready for GPT's move ");
        Cell cell = botPlayingStrategy.makeMove(board) ;
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell ;
    }

}
