
import java.util.ArrayList;

public class Search {
    
    private FringeList fringe;
    private ClosedList closed;
    
    
    /*startSearch: Search.startSeach(initialstate);
    Description: creates the fringes, closed list and starts the search
    >>>>>>>>>>I Think this is not needed maybe<<<<<<<<<<<<<<<<<<
    Input: The initialstate
    Outputs: None
    */
    public Search(State initialState){
        fringe = new FringeList();
        closed = new ClosedList();
        SearchNode rootNode = new SearchNode(initialState);
        fringe.addToFringe(rootNode);
    }
    
    /* Moves checked Node from Fring to Closed */
    public void movingCheckedNode(SearchNode checkedNode){
        closed.addToClosed(fringe.removeNode(checkedNode));
    }
    
    /* getBest:  Search.getBest(fringelist)
    Description: Gets the best Node based on the Heuristics
    >>>>>>>>>>>>>>>>>>>TESTING ONLY GRABS THE FIRST NODE<<<<<<<<<<<
    Inputs: fringe: The fringe List
    Outputs: the selected node based on the Heuristics
    */
    public SearchNode getBest() {
        ArrayList<SearchNode> listOfNodes = new ArrayList<>();
        listOfNodes = fringe.getEverything();
        int bestNodeIndex = 0;
        int bestValue;
        bestValue = listOfNodes.get(0).getFevaluation();
        for (SearchNode item : listOfNodes) {
            if (item.getFevaluation() > bestValue) { //heuristic here
                bestNodeIndex = listOfNodes.indexOf(item);
                bestValue=item.getFevaluation();
            } 
        }
        return(fringe.getNode(bestNodeIndex));
        /*********************for Testing**********/
        //return(fringe.getNode(0));
    }
    
    
    /*
    Expand: method call: Search.Expand(Node, board)
    Inputs: Node-> The node to expand, Board -> The overall board
    Outputs: An arraylist of nodes expanded from the first node
    */
    public ArrayList<SearchNode> Expand(SearchNode nodeToExpand, Board board) {
        ArrayList<State> childrenStates = new ArrayList<>(); //node for input
        ArrayList<SearchNode> childrenNodes = new ArrayList<>(); //node to return
        State currentStateforNode; //extracting the node to expand (could have just called the method)
        currentStateforNode = nodeToExpand.getCurrent();
        
        System.out.println("Parent: " + currentStateforNode.toString());


        childrenStates = currentStateforNode.produceChildren(board);
        for (State s : childrenStates) {
            System.out.println("Children: " + s.toString()); 
        }
        for (State item : childrenStates) { //for each state expand to node and add to list
            SearchNode newChildNode = new SearchNode(item , nodeToExpand);
            newChildNode.setGvalue(newChildNode.getGvalue()+1); //increase cost by 1 for children?? 
            childrenNodes.add(newChildNode);
        }
        for (SearchNode n : childrenNodes) {
            fringe.addToFringe(n);
        }
        return(childrenNodes);
    } 
    
}
