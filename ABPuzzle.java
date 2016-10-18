import java.util.ArrayList;

public class ABPuzzle {

    public static void main(String[] args) {
        
        InputGetter ig = new InputGetter();       
        
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
        System.out.println("Value of total goal friends: " + state.getFinalTotal());
                System.out.println("Value of total goal friends: " + state.getFriends());
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
        Object object = new Object();
        int count = 0;
        int limit = 6;
        
        while (!goal.checkState(tmp)) {
            // not stopping even when goal has been met?
            search.Expand(tmp, board);
            
            //System.out.println("Fringe: "+ search.testGetList("fringe").getEverything().size()+"\n" + search.testGetList("fringe").toString());
            //System.out.println("Closed: " + search.testGetList("closed").getEverything().size()+"\n" + search.testGetList("closed").toString());
            //System.out.println("------------------------");
            tmp = search.getBest(limit);
            if (tmp == null) { //starting limit
                System.out.println("Over Limit");
                break;
            } 

            state = tmp.getCurrent();
        }
        if (tmp != null) {    
            System.out.println("Solution is:");
            search.printTracePath(tmp);
        }
    }
}