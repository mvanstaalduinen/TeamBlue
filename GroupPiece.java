

public class GroupPiece {

	private int sum;
	private int totalTokens;
	private int smallDisk;
	private boolean complete;

	GroupPiece (Piece token)
	// pass the circular array. from the circular array can count the
	// number of like tokens.
	{
		smallDisk = token.getSmallDisk();
		complete = false;
		// totalTokens = count from circle array
	}

	public int getSum()
	{
		return sum;
	}

	public void setComplete()
	{
		complete = true;
	}

	public void removeComplete()
	{
		complete = false;
	}

	public boolean isComplete()
	{
		return complete;
	}



}
