

import java.util.ArrayList;

public class ABPuzzle {

    public static void main(String[] args) {
        
        InputGetter ig = new InputGetter();
        ArrayList<State> unexplored = new ArrayList<>();        
        
        int willBeFromConsole = Integer.valueOf(args[0]);
        System.out.println("firstNumber: " + willBeFromConsole);
        Board board = ig.getBoard(willBeFromConsole);
        System.out.println("board: " + board.toString());
        State state = ig.getState(willBeFromConsole);
        
        state.setNeighbours();
        state.setFriends();
                
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        System.out.println("Here is the state with no 0: " + state.stateWithNoZero());
        System.out.println();
        
        
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
