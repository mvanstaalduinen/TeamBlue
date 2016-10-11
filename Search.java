
import java.util.ArrayList;

public class Search {
    Search(){
    }
    
    public void startSearch(State initialState){
        FringeList fringe = new FringeList();
        ClosedList closed = new ClosedList();
        SearchNode rootNode = new SearchNode(initialState);
        fringe.addToFringe(rootNode);
      
      

    }
    
    public SearchNode getBest(FringeList fringe) {
        ArrayList<SearchNode> listOfNodes = new ArrayList<>();
        listOfNodes=fringe.getEverything();
        for (SearchNode item : listOfNodes) {
            //compare function
        }
        
        /*********************for Testing**********/
        return(fringe.getNode(0));
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
