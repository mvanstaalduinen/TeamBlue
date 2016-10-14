import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Comparator;
import java.util.Collections;

public class Goal {
    
    public boolean checkState(SearchNode orig)
    {
	for (Piece p : orig.getCurrent().getState()) {
		if (!p.checkSorted()) {
			return false;
		}
	}
	return true;
    }
}
