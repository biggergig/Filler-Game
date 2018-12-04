package gui;

import java.io.File;
import java.util.Scanner;

public class MapReader {
	
	private char[][] board = new char[5][5];
	String inputString;
	private Scanner sc;
	
	
	public static void main(String[] args) {
		MapReader mr = new MapReader();
		char[][] temp = mr.getMap();
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5; j++) {
				System.out.print(temp[i][j]);
				
			}
			System.out.println();
			
		}
	}
	//what is this code for? -Jary
	
	
	public char[][] getMap(){
		
		File folder = new File("//dohome4//home4$//Student4//1837028//Eclipse//gui//maps");
		File[] listOfFiles = folder.listFiles();
		
		File temp = listOfFiles[(int)(Math.random()*listOfFiles.length)];
		
		//System.out.println(temp.getName());
		board = convertArray(decompress(readFile(temp)));
		return board;
	}
	
	public String readFile(File file) {
		String temp = "";
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine())
				temp+=sc.nextLine();
		}catch(Exception e) {
			System.out.println("You done messed up");
		}
		
		
		return temp;
		
		
	}

	
	public String decompress(String inp) {
		String output = "";
		
		int index = 0;

		int amount;
		String temp;
		while(index<inp.length()) {
			//System.out.println(inp.charAt(index));
			amount = 0;
			temp = "";
			while(inp.charAt(index)>='0'&&inp.charAt(index)<='9') {
				temp+=inp.charAt(index++)+"";
				
				
			}
			
			amount = Integer.parseInt(temp);
			for(int i = 0;i<amount;i++) {
				output+=inp.charAt(index)+"";
			}
			index++;
		}
		
		
		
		return output;	
	}

	
	public char[][] convertArray(String inp){
		char[][] arr =new char[5][5];
		int index = 0;
		
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				arr[j][i]=inp.charAt(index++);
			}			
		}
		
		return arr;	
	}



}
