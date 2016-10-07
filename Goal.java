package abpuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Goal {
    
    private static final List<Integer> goalState = new ArrayList<>();
    
    Goal(ArrayList<Piece> orig)
    {
        ArrayList<Piece> tmp = (ArrayList<Piece>) orig;
        Collections.sort(tmp, (Piece o1, Piece o2) -> o1.getSmallDisk() - (o2.getSmallDisk()));
        
        System.out.println(orig.toString());
        
    }
}
