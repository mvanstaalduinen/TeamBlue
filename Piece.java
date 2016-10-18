public class Piece {

    private int smallDisk;
    private Piece rightNeighbour;
    private Piece leftNeighbour;

    Piece (int sd)
    {
        smallDisk = sd;
    }

    public int getSmallDisk()
    {
        return smallDisk;
    }
    
    public void setSmallDisk(int sd)
    {
        smallDisk = sd;
    }

    public void setRightNeighbour(Piece right)
    {
	rightNeighbour = right;
    }

    public void setLeftNeighbour(Piece left)
    {
	leftNeighbour = left;    
    }
    
    public boolean checkSorted(int n) 
    {
        if ((smallDisk == 1) && (smallDisk <= rightNeighbour.getSmallDisk()) && ((smallDisk == leftNeighbour.getSmallDisk())  || (n == leftNeighbour.getSmallDisk()) )) {
            return true;
        } else if ((smallDisk <= rightNeighbour.getSmallDisk()) && (smallDisk >= leftNeighbour.getSmallDisk())) {
            return true;
        } else if ((smallDisk == 0)) {
	    if ((rightNeighbour.getSmallDisk()) == (leftNeighbour.getSmallDisk())) {
	        return false;
	    }
            else if ((smallDisk < rightNeighbour.getSmallDisk()) && (smallDisk < leftNeighbour.getSmallDisk())) {
                return true;
            } return false;
            
         } else if (0 == leftNeighbour.getSmallDisk()) {
             //if (leftNeighbour.getLeftNeighbour() < smallDisk) {
               //  return true;
              if (leftNeighbour.getLeftNeighbour() == n) {
                return true;
            }
         } else if (0 == rightNeighbour.getSmallDisk()) {
            //if ((rightNeighbour.getRightNeighbour() > smallDisk) ) {
             //    return true;
             if ((smallDisk == n) && (rightNeighbour.getRightNeighbour() == 1)) {
                return true;
         }  else {
                return false; }
         } 
          else if ((smallDisk == n) && (1 == rightNeighbour.getSmallDisk())) {
             return true;
         }
            return false;
    }
    
    public int getRightNeighbour()
    {
	return rightNeighbour.getSmallDisk();
    }

    public int getLeftNeighbour()
    {
	return leftNeighbour.getSmallDisk();
    }
    
    public boolean isZero()
    {
        if (smallDisk == 0) {
            return true;
        }
        return false;
    }
    
    public boolean isEqual(Piece p) 
    {
        return smallDisk == p.getSmallDisk();
    }

    @Override
    public String toString()
    {
        return Integer.toString(smallDisk);
    }

}

