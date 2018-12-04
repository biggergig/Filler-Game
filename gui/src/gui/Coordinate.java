package gui;

public class Coordinate {
	private int myX;
	private int myY;
	public Coordinate(int y, int x) {
		myY = y;
		myX = x;
			
	}
	//why did you do this --jary
	
	
	public int getX() {
		return myX;

	}
	public int getY() {
		return myY;
	}
	
	@Override
	public String toString() {
		return("("+myX+", "+myY+")");
		
	}
}
