package abpuzzle;

public class Piece {
    
    private int smallDisk;
    
    Piece (int sd) {
        smallDisk = sd;
    }
    
    public int getSmallDisk()
    {
        return smallDisk;
    }
    
    public void setSmallDisk(int value)
    {
        smallDisk = value;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(smallDisk);
    }
    
}
