
import java.util.ArrayList;

public class Search {
    
    private FringeList fringe;
    private FringeList closed;
    private FringeList traced;
    private SearchNode rootNode;
    
    
    /*startSearch: Search.startSeach(initialstate);
    Description: creates the fringes, closed list and starts the search
    >>>>>>>>>>I Think this is not needed maybe<<<<<<<<<<<<<<<<<< 
    Input: The initialstate
    Outputs: None
    */
    public Search(State initialState){
        fringe = new FringeList();
        closed = new FringeList();
        traced = new FringeList();
        SearchNode rootNode = new SearchNode(initialState);
        fringe.addToFringe(rootNode);
    }
    
    /* Moves checked Node from Fring to Closed */
    public void movingCheckedNode(SearchNode checkedNode){
        closed.addToFringe(fringe.removeNode(checkedNode));
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
        SearchNode test = fringe.getNode(bestNodeIndex);
        fringe.removeNode(test);
        return(test);
        /*********************for Testing**********/
        //return(fringe.getNode(0));
    }
    
    public boolean isInClosed(SearchNode checkNode)
    {
        return closed.checkNode(checkNode);
    }
    
    //adds the tracepath once a goal has been made. 
    public void tracePath(SearchNode goalNode) 
    {
        //Trace the path of the goal back to root so that the complete path can be printed
        // needs to be reversed
        // Tracing the path is looking at all the parent nodes.
        SearchNode nodeForInspection; 
        nodeForInspection = goalNode;
        while (nodeForInspection.getCurrent().equals(rootNode.getCurrent())==false)
        {
            traced.addToFringe(nodeForInspection);
            nodeForInspection=nodeForInspection.getParent();
        }
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

        childrenStates = currentStateforNode.produceChildren(board);
        for (State item : childrenStates) { //for each state expand to node and add to list
            SearchNode newChildNode = new SearchNode(item , nodeToExpand);
            newChildNode.setGvalue(newChildNode.getGvalue()+1); //increase cost by 1 for children?? 
            childrenNodes.add(newChildNode);
        }
        for (SearchNode n : childrenNodes) {
            fringe.addToFringe(n);
        }
        closed.addToFringe(nodeToExpand); //add parent node to closed list
        return(childrenNodes);
    } 
    
}
