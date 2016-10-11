

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
        System.out.println("Check friends: " + state.getFriends());
                
        Goal goal = new Goal(state);
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        System.out.println("Friends: " + state.getFriends());
        System.out.println("Here is the state with no 0: " + state.stateWithNoZero());
        System.out.println();
        
        System.out.println(goal.checkState(state));
        
        System.out.println("State change!\n");

        unexplored = state.produceChildren(board);

        for (State s : unexplored) {
            System.out.println(s.toString());
        }
        
    }
    
}
