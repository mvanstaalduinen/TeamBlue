import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Comparator;
import java.util.Collections;

public class Goal {
    
    public boolean checkState(SearchNode orig)
    {
	double d = (orig.getCurrent().getState().size())-1;
	d = Math.sqrt(d);
	int n = (int) d;
	for (Piece p : orig.getCurrent().getState()) {
		if (!p.checkSorted(n)) {
                    return false;
		}
	}
	return true;
    }
}
