

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
    
    public boolean checkRightNeighbour() 
    {
        if ( smallDisk == rightNeighbour.getSmallDisk()) {
            return true;
        }
        else
            return false;
    }

    public int getRightNeighbout()
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
