

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputGetter {
    
    private final Scanner reader = new Scanner(System.in);
    
    public int getFirstNumber()
    {
        return reader.nextInt();
        
    }
    
    public Board getBoard(int num)
    {
        Board b = new Board();
        int tmp = reader.nextInt();
        
        while (tmp > 0) {
            b.addToBoard(tmp % 10);
            tmp /= 10;
        }
        b.reverseBoard();
        return b;
    }
    
    public State getState(int num)
    {
        State s = new State();
        int tmp = reader.nextInt();
        
        while (tmp > 0) {
            s.addToState(new Piece(tmp % 10));
            tmp /= 10;
        }
        s.reverseState();
        return s;
    }
}
