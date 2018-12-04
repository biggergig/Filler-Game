package gui;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;


public class Player {
	
	//Color
	Color currentColor;
	
	int x;
	int y;
	Coordinate start;
	ArrayList<Coordinate> path;
	public Player(Coordinate startInp) {
		currentColor = Color.RED;
		path = new ArrayList<Coordinate>();
		start = startInp;
		x = startInp.getX();
		y = startInp.getY();
		path.add(start);
	
	}
	//hello -Jary
	
	public void dropColor() {
		int[] colorRGB = new int[3];
		colorRGB[0]=currentColor.getRed();
		colorRGB[1]=currentColor.getBlue();
		colorRGB[2]=currentColor.getGreen();
		
		for(int i = 0;i<3;i++) {
			colorRGB[i]-=10;
			if(colorRGB[i]<0)
				colorRGB[i]=0;
			
		}
		
		currentColor = new Color(colorRGB[0],colorRGB[1],colorRGB[2]);
	}
	
	public Coordinate getLoc() {
		return new Coordinate(y,x);
	
	}
	
	public Color getColor() {
		return currentColor;
		
	}
	
	public boolean checkMove(Coordinate coord, JButton[][] buttons) {
		boolean retValue = false;
		try {
			if(buttons[coord.getY()][coord.getX()].getBackground()==Color.WHITE) {
				retValue = true;
			}
		} catch(Exception E) {}
		
		
		return retValue;
	}
	
	
	public void moveDir(String dir, JButton[][] buttons) {
		Coordinate temp;
		Boolean changed = false;
		
		switch(dir) {
		case "UP":
			temp = new Coordinate(y-1,x);
			if(checkMove(temp,buttons)) {
				changed = true;
				y--;
			}
		case "DOWN":
			temp = new Coordinate(y+1,x);
			if(checkMove(temp,buttons)) {
				changed = true;
				y++;
			}
			break;
		case "RIGHT":
			temp = new Coordinate(y,x+1);
			if(checkMove(temp,buttons)) {
				changed = true;
				x++;
			}
			break;
		case "LEFT":
			temp = new Coordinate(y,x-1);
			if(checkMove(temp,buttons)) {
				changed = true;
				x--;
			}
			break;
			
		default:
			temp= new Coordinate(0,0);
		
		}
		
		if(changed)
			this.dropColor();
		
	}
	
	
}
