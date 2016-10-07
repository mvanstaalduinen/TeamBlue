package abpuzzle;

import java.util.Random;

public class ABPuzzle {

    public static void main(String[] args) {
        
        State state = new State();
        Board board = new Board();
        
        board.addToBoard(1);
        board.addToBoard(2);
        board.addToBoard(3);
        board.addToBoard(4);
        board.addToBoard(1);
        board.addToBoard(2);
        board.addToBoard(3);
        board.addToBoard(1);
        board.addToBoard(2);
        board.addToBoard(3);
        
        Piece test = new Piece(1);
        Piece test1 = new Piece(1);
        Piece test2 = new Piece(1);
        Piece test3 = new Piece(3);
        Piece test4 = new Piece(2);
        Piece test5 = new Piece(2);
        Piece test6 = new Piece(3);
        Piece test7 = new Piece(3);
        Piece test8 = new Piece(0);
        Piece test9 = new Piece(2);
        
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
        
        Goal goal = new Goal(state);
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        System.out.println("Here is the state with no 0: " + state.stateWithNoZero());
        System.out.println();
        
        System.out.println(goal.checkState(state));
        
        System.out.println("State change!\n");
        
        State changedState = state.changeState(2, 3);
        
        System.out.println(changedState.toString());
        System.out.println(board.toString());
        
        int i = 0;
        Random rn = new Random();
        
        while (i < 1000) {
            changedState = state.changeState(rn.nextInt(10),rn.nextInt(10));
            if(goal.checkState(changedState)){
                i = 1001;
            }
            i++;
        }
        System.out.println("\n" + changedState.toString());
        if (goal.checkState(changedState)){
            System.out.println("Found it!");
        } else {
            System.out.println("Not this time");
        }
    }
    
}
