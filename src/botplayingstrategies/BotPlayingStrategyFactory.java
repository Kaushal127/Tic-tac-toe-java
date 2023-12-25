package botplayingstrategies;

import Models.DifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(DifficultyLevel difficultyLevel){
        if(difficultyLevel==DifficultyLevel.EASY){
            return new EasyBotPlayingStrategy() ;
        } else if(difficultyLevel==DifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy() ;
        } else {
            return new HardBotPlayingStrategy() ;
        }
    }
}
