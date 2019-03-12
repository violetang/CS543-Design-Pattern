package AgentDemo;

import PoolPattern.ObjectCreation_IF;

/**
 * CIA_Agent_Creator implements ObjectCreation_IF to is a creation to 
 * create a CIA_Agent object
 * @Group: 7
 */
public class CIA_Agent_Creator implements ObjectCreation_IF{
    private CIA_Agent agent;
    @Override
    public Object create(){
        
        return agent;
    }
}
