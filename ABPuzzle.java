

import java.util.ArrayList;

public class ABPuzzle {

    public static void main(String[] args) {
        
        InputGetter ig = new InputGetter();
        ArrayList<State> unexplored = new ArrayList<>();        
        
        int willBeFromConsole = Integer.valueOf(args[0]);
       	//int willBeFromConsole = ig.getFirstNumber();
        System.out.println("firstNumber: " + willBeFromConsole);
        Board board = ig.getBoard(willBeFromConsole);
       	System.out.println("board: " + board.toString());
        State state = ig.getState(willBeFromConsole);
        
        state.setNeighbours();
        state.setFriends();
        SearchNode tmp = new SearchNode(state);
	Goal goal = new Goal();
	System.out.println("goals: " + goal.toString());
	System.out.println(goal.checkState(tmp));
        
       if (goal.checkState(tmp)) {
            System.out.println("The puzzle is solved.");
            System.exit(0);
        }
        
        if (board.allOnes() && !goal.checkState(tmp)) {
            System.out.println("There is no solution.");
            System.exit(0);
        }
        
        Search search = new Search(state);
        ArrayList<SearchNode> path = new ArrayList<>();
        
        while (!goal.checkState(tmp)) {
            // not stopping even when goal has been met?
            System.out.println(state.toString());
            search.Expand(tmp, board);
            tmp = search.getBest();
            
            //state = tmp.getCurrent();
        }
        
        while (tmp.getParent() != null) {
            path.add(tmp.getParent());
            tmp = tmp.getParent();
        }
        
        for (SearchNode n : path) {
            System.out.println(n.getCurrent().toString());
        }
        
        /*
        
        Create first Search object with parent state
        Create a temporary SearchNode
        Create a list of SearchNodes that will hold the optimal path
        
        Until Optimal path is found
            Expand the search object
            get the best Node to continue
            Check if that node is Goal
                if it is check if the solution is optimal
            Move the parent node to the list of Checked Nodes (done in Expand method)
            Best Node to continue is then used to Expand Search object.
        
        Once Optimal solution found 
            display all children state in standard out to get to the goal state
        */
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        System.out.println("Here is the state with no 0: " + state.stateWithNoZero());
        System.out.println();
        
        System.out.println("State change!\n");
    }
    
}
