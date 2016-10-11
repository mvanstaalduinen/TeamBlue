package TeamBlue;
import java.util.ArrayList;

public class Search {
    Search(){
    }
    public void Make_Node(State current, SearchNode parent){
      SearchNode newNode = new SearchNode();
        newNode.setCurrent(current);
        //parentState=parent;
        if (parent==null)
        {
            newNode.setGvalue(0);
        }
        else 
        {
            newNode.setGvalue(parent.getGvalue());//+cost(P.State,S)
            newNode.setHvalueMD(current.setNeighbours()); //<---needs to grab the h value from the state maybe use a heuristics class to store information?
            newNode.setFvalue();
            newNode.setParent(parent);
            newNode.setCurrent(current);
        }
    }
    /* Needs some work
    public ArrayList<SearchNode> Expand(SearchNode nodeToExpand) {
        ArrayList<State> childrenStates = new ArrayList<>();
        ArrayList<SearchNode> childrenNodes = new ArrayList<>();
        State currentStateforNode;
        
        currentStateforNode=nodeToExpand.getCurrent();
        // <----get Children from State.produceChildren
        int childrenSize,x;
        childrenSize= childrenStates.size();
        for (x=0; x<childrenSize; x++)
        {
            childrenNodes.add(Make_Node(childrenStates.get(x), nodeToExpand.getCurrent())); //change .get
            
        }
        return(childrenNodes);
    }
*/
}
