package AgentDemo;

import PoolPattern.ObjectCreation_IF;

/**
 * FBI_Agent_Creator implements ObjectCreation_IF to is a creation to 
 * create a FBI_Agent object
 * @Group: 7
 */
public class FBI_Agent_Creator implements ObjectCreation_IF {
    private FBI_Agent agent;
    @Override
    public Object create(){
        return agent;
    }
}
