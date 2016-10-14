
import java.util.ArrayList;

public class SearchNode {
    
    private State currentState; //state to which node corresponds to
    private SearchNode parentState; //parent State of the node
    private int HvalueForManhattanDistance; //Heuristic for Man Distance
    private int Gvalue; //Cost to reach the state
    private int FevaluationOfState; //Hvalue Man Distace+G value Parent
    
    public SearchNode(State state){ //constructor method
        currentState = state;
        parentState=null;
        HvalueForManhattanDistance = state.setFriends();
        Gvalue = 0;
        FevaluationOfState= HvalueForManhattanDistance+Gvalue;
    }

    public SearchNode(State child, SearchNode parent){ //override
        currentState = child;
        parentState = parent;
        HvalueForManhattanDistance = child.setFriends();
        Gvalue = parent.getGvalue();
        FevaluationOfState= HvalueForManhattanDistance+Gvalue;
    }
    //get Values Methods
    public int getHvalueMD () {
        return(HvalueForManhattanDistance);
    }
    public int getGvalue () {
        return(Gvalue);
    }
    public int getFevaluation() {
        return(FevaluationOfState);
    }
    public SearchNode getParent() {
        return(parentState);
    }
    public State getCurrent() {
        return(currentState);    
    }
    //set values
    public void setParent(SearchNode newParent) {
        parentState=newParent;
    }
    public void setCurrent(State newCurrent) {
        currentState = newCurrent;
    }
    public void setHvalueMD(int newHvalue) {
        HvalueForManhattanDistance=newHvalue;
    }
    public void setGvalue(int newGvalue) {
        Gvalue=newGvalue;
    }
    public void setFvalue () {
        FevaluationOfState=Gvalue+HvalueForManhattanDistance;
    }
    
    @Override
    public String toString()
    {
        //return state.toString();
        return (currentState.toString());
    }
}