

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

    @Override
    public String toString()
    {
        return Integer.toString(smallDisk);
    }

}
