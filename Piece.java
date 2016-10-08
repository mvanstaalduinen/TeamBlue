package abpuzzle;

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

    public setRightNeighbour(Piece right)
    {
	rightNeighbour = right;
    }

    public setLeftNeighbour(Piece left)
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

    @Override
    public String toString()
    {
        return Integer.toString(smallDisk);
    }

}
