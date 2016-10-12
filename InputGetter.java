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
        String tmp = reader.next();
        
        for (int i = 0; i < tmp.length(); i++){
            b.addToBoard(Character.getNumericValue(tmp.charAt(i)));
        }
        return b;
    }
    
    public State getState(int num)
    {
        State s = new State();
        String tmp = reader.next();
        
        for (int i = 0; i < tmp.length(); i++) {
            s.addToState(new Piece(Character.getNumericValue(tmp.charAt(i))));
        }
        return s;
    }
}
