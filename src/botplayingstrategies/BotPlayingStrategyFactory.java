package botplayingstrategies;

import Models.DifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(DifficultyLevel difficultyLevel){
        return new EasyBotPlayingStrategy() ;
    }
}
