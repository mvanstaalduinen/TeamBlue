package abpuzzle;

public class ABPuzzle {

    public static void main(String[] args) {
        
        State state = new State();
        Board board = new Board();
        
        board.addToBoard(1);
        board.addToBoard(2);
        board.addToBoard(3);
        board.addToBoard(4);
        board.addToBoard(1);
        board.addToBoard(3);
        
        Piece test = new Piece(1);
        Piece test1 = new Piece(2);
        Piece test2 = new Piece(0);
        Piece test3 = new Piece(1);
        Piece test4 = new Piece(3);
        Piece test5 = new Piece(2);
        
        state.addToState(test);
        state.addToState(test1);
        state.addToState(test2);
        state.addToState(test3);
        state.addToState(test4);
        state.addToState(test5);
        
        System.out.println(state.toString());
        System.out.println(board.toString());
        
        System.out.println();
        
        System.out.println("State change!\n");
        
        State changedState = state.changeState(2, 3);
        
        System.out.println(changedState.toString());
        System.out.println(board.toString());
    }
    
}
