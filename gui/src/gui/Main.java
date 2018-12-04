package gui;

public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		FillerGui gui = new FillerGui();
		gui.main(args);
		for(int i = 0;i<50000000;i++) {
			System.out.println("test");
		}
		gui.printtxt("pelase just work for the love of god");
		
	}
	
}
