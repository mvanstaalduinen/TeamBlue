package abpuzzle;

import java.util.ArrayList;
import java.util.Random;

public class ABPuzzle {

    public static void main(String[] args) {
        
        State state = new State();
        Board board = new Board();
        ArrayList<State> testList = new ArrayList<>();
        
        board.addToBoard(1);
        board.addToBoard(1);
        board.addToBoard(1);
        board.addToBoard(2);
        board.addToBoard(2);
        board.addToBoard(2);
        board.addToBoard(3);
        board.addToBoard(3);
        board.addToBoard(3);
        board.addToBoard(4);
        
        Piece test = new Piece(1);
        Piece test1 = new Piece(1);
        Piece test2 = new Piece(1);
        Piece test3 = new Piece(2);
        Piece test4 = new Piece(2);
        Piece test5 = new Piece(2);
        Piece test6 = new Piece(3);
        Piece test7 = new Piece(3);
        Piece test8 = new Piece(3);
        Piece test9 = new Piece(0);
        
        state.addToState(test);
        state.addToState(test1);
        state.addToState(test2);
        state.addToState(test3);
        state.addToState(test4);
        state.addToState(test5);
        state.addToState(test6);
        state.addToState(test7);
        state.addToState(test8);
        state.addToState(test9);
        
        System.out.println("Size of state: " + state.getState().size() + " size of board: " + board.getBoard().size());
            
        testList = state.produceChildren(board);
       
        Goal goal = new Goal(state);
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        System.out.println("Here is the state with no 0: " + state.stateWithNoZero());
        System.out.println();
        
        ///System.out.println(goal.checkState(state));
        
        System.out.println("State change!\n");
        
        for (State s : testList) {
            System.out.println(s.toString());
        }
        
    }
    
}
