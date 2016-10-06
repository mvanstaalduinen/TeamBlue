package abpuzzle;

import java.util.ArrayList;

public class Board {
    
    private final ArrayList<Integer> board = new ArrayList<>();
    
    
    public void addToBoard(int value) 
    {
        board.add(value);
    }
    
    @Override
    public String toString()
    {
        String result = "";
        for (int item : board) {
            result += item;
        }
        return result;
    }
}
