

import java.util.ArrayList;

public class ABPuzzle {

    public static void main(String[] args) {
        
        InputGetter ig = new InputGetter();
        ArrayList<State> unexplored = new ArrayList<>();        
        
        int willBeFromConsole = ig.getFirstNumber();
        System.out.println("firstNumber: " + willBeFromConsole);
        Board board = ig.getBoard(willBeFromConsole);
        System.out.println("board: " + board.toString());
        State state = ig.getState(willBeFromConsole);
        
        state.setNeighbours();
        state.setFriends();
                
        Goal goal = new Goal(state);
        
        /*
        Check if current state is goal
            if it is then display that it is the goal and finish
        If not then continue
        
        Check if all large disks are 1 
            if all large disks are 1 and the goal is not met then no solution
        else continue
        
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
        
        System.out.println(goal.checkState(state));
        
        System.out.println("State change!\n");
        
        SearchNode tmp = new SearchNode(state);
        Search search = new Search(state);
        SearchNode tmp2;
        int count = 0;
        while (count < 5) {
            System.out.println("Next Children: ");
            
            search.Expand(tmp, board);
            tmp = search.getBest();
            search.movingCheckedNode(tmp);
            count ++;
        }
        
    }
    
}
