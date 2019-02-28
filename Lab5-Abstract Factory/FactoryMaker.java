package game;
/**
 * FactoryMaker is the utility class to create a Mode factory
 * @Group: 7
 */
public class FactoryMaker {
    
    /**
     * Mode type, for now we have three modes
     */
    public enum ModeType{
        BEGINNER, INTERMEDIATE, ADVANCED
    }
    
    /**
     * makeFactory method to create a factory
     * @param type -- the mode 
     * @return a modeFactory
     */
    public static ModeIF makeFactory(ModeType type){
        switch(type){
            case BEGINNER:
                return new BeginModeFactory();
            case INTERMEDIATE:
                return new IntermediateModeFactory();
            case ADVANCED:
                return new AdvancedModeFactory();
            default:
                throw new IllegalArgumentException("ModeType is not supported");
        }
    }
}
