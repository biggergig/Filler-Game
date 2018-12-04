package gui;

import java.awt.EventQueue;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JScrollBar;

public class FillerGui extends JFrame {

	/**
	 * 
	 */
	//win state
	//0- nothing 1- win 2- lose
	public int winState;
	
	//Map Reader
	MapReader mapReader = new MapReader();
	
	
	private static final long serialVersionUID = 1L;
	//Key Bindings
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MOVE_UP = "move up";
	private static final String MOVE_DOWN = "move down";
	private static final String MOVE_RIGHT = "move right";
	private static final String MOVE_LEFT = "move left";
	
	static JLabel obj1 = new JLabel();
	
	static Player player;
	
	
	//Print lines
	static int printlines;
	
	
	static JTextArea txtrTest;
	//static FillerGui frame;
	
	static JButton[][] buttons;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FillerGui frame = new FillerGui();
		EventQueue.invokeLater(new Runnable() {public void run() {
				frame.setVisible(true);			
				
			}			
		});
		//Here		
		
		
		frame.pseudoMain();
	}
	
	public void pseudoMain() {
		char[][] board = mapReader.getMap();
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				switch(board[i][j]) {
				case ' ':
					buttons[i][j].setBackground(Color.WHITE);
					break;
				case 'S':
					player = new Player(new Coordinate(i,j));
					buttons[i][j].setBackground(player.getColor());
					break;
				case '#':
					buttons[i][j].setBackground(Color.GRAY);
					break;
				}
			}
		}
		
		winState = 0;
		printlines = 0;
	}
	
	public void colorLoc(Coordinate coord, Color clr) {
		colorSquare(coord.getX(),coord.getY(),clr);
		
	}
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public FillerGui() {
		
		printlines = 0;
		
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				//pseudoMain();
				
			}
		});
		setTitle("Filler Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Key Bindings
	
		
		Action moveUp = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				player.moveDir("UP",buttons);
				if(winState == 0) {
					printtxt("moving up");
					printtxt(player.getLoc().toString());
				}
				colorLoc(player.getLoc(),player.getColor());
				checkState();
			}
		
		};
		
		Action moveDown = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				player.moveDir("DOWN",buttons);
				if(winState == 0) {
					printtxt("moving down");
					printtxt(player.getLoc().toString());
				}
				colorLoc(player.getLoc(),player.getColor());
				checkState();
			}
		
		};
		Action moveRight = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				player.moveDir("RIGHT",buttons);
				if(winState == 0) {	
					printtxt("moving right");
					printtxt(player.getLoc().toString());
				}
				colorLoc(player.getLoc(),player.getColor());
				checkState();
			}
		
		};
		
		Action moveLeft = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				player.moveDir("LEFT",buttons);
				if(winState == 0) {
					printtxt("moving left");
					printtxt(player.getLoc().toString());
				}
				colorLoc(player.getLoc(),player.getColor());
				checkState();
				
			}
		
		};
		
		
		
		//
		
		
		//obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
		bind("S",MOVE_DOWN);
		bind("D",MOVE_RIGHT);
		bind("A",MOVE_LEFT);
		bind("W",MOVE_UP);
		
	
		
		//
		putBind(MOVE_UP,moveUp);
		putBind(MOVE_DOWN,moveDown);
		putBind(MOVE_RIGHT,moveRight);
		putBind(MOVE_LEFT,moveLeft);
		
		
		//
		
		getContentPane().add(obj1);
		
		//Key Bindings
		
		
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setBackground(Color.WHITE);
		button.setBounds(10, 10, 50, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(59, 10, 50, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setEnabled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(108, 10, 50, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setEnabled(false);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(157, 10, 50, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setEnabled(false);
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(206, 10, 50, 50);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(206, 59, 50, 50);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setEnabled(false);
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(10, 59, 50, 50);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setEnabled(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(59, 59, 50, 50);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setEnabled(false);
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(108, 59, 50, 50);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setEnabled(false);
		button_9.setBackground(Color.WHITE);
		button_9.setBounds(157, 59, 50, 50);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setEnabled(false);
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(10, 157, 50, 50);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setEnabled(false);
		button_11.setBackground(Color.WHITE);
		button_11.setBounds(206, 108, 50, 50);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setEnabled(false);
		button_12.setBackground(Color.WHITE);
		button_12.setBounds(206, 157, 50, 50);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setEnabled(false);
		button_13.setBackground(Color.WHITE);
		button_13.setBounds(157, 157, 50, 50);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setEnabled(false);
		button_14.setBackground(Color.WHITE);
		button_14.setBounds(157, 108, 50, 50);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setEnabled(false);
		button_15.setBackground(Color.WHITE);
		button_15.setBounds(108, 108, 50, 50);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setEnabled(false);
		button_16.setBackground(Color.WHITE);
		button_16.setBounds(108, 157, 50, 50);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setEnabled(false);
		button_17.setBackground(Color.WHITE);
		button_17.setBounds(59, 157, 50, 50);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setEnabled(false);
		button_18.setBackground(Color.WHITE);
		button_18.setBounds(59, 108, 50, 50);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setEnabled(false);
		button_19.setBackground(Color.WHITE);
		button_19.setBounds(10, 108, 50, 50);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setEnabled(false);
		button_20.setBackground(Color.WHITE);
		button_20.setBounds(10, 206, 50, 50);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setEnabled(false);
		button_21.setBackground(Color.WHITE);
		button_21.setBounds(59, 206, 50, 50);
		contentPane.add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setEnabled(false);
		button_22.setBackground(Color.WHITE);
		button_22.setBounds(108, 206, 50, 50);
		contentPane.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setEnabled(false);
		button_23.setBackground(Color.WHITE);
		button_23.setBounds(157, 206, 50, 50);
		contentPane.add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setEnabled(false);
		button_24.setBackground(Color.WHITE);
		button_24.setBounds(206, 206, 50, 50);
		contentPane.add(button_24);
		
		txtrTest = new JTextArea();
		txtrTest.setEditable(false);
		txtrTest.setBackground(Color.LIGHT_GRAY);
		
		txtrTest.setBounds(266, 31, 168, 225);
		contentPane.add(txtrTest);
		
		
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setForeground(Color.WHITE);
		lblConsole.setBackground(Color.WHITE);
		lblConsole.setBounds(266, 10, 46, 14);
		contentPane.add(lblConsole);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pseudoMain();
				txtrTest.setText("");
			}
		});
		btnReset.setBounds(345, 6, 89, 23);
		contentPane.add(btnReset);
		
		buttons = new JButton[][]{
			{button, button_1, button_2, button_3, button_4},
			{button_6, button_7, button_8, button_9, button_5},
			{button_19, button_18, button_15, button_14, button_11},
			{button_10, button_17, button_16, button_13, button_12},
			{button_20, button_21, button_22, button_23, button_24},
		
		};
	}
	
	public void bind(KeyStroke keyStroke, String ident) {
		obj1.getInputMap(IFW).put(keyStroke, ident);
	
	}
	
	public void bind(String stroke, String ident) {
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke(stroke), ident);
	
	}
	
	public void putBind(String ident, Action method) {
		obj1.getActionMap().put(ident, method);
	
	}
	
	public boolean checkWin() {
		boolean won = true;
		
		for(int i = 0;i<buttons.length;i++) {
			for(int j = 0;j<buttons.length;j++) {
				if(buttons[i][j].getBackground()==Color.WHITE)
					won = false;
			}
		}
		
		return won;
	
	}
	
	public void checkState() {
		if(getNodes(player.getLoc(),buttons)==0) {
			
			if(checkWin()&&winState!=1){
				winState = 1;
				printtxt("You win!");
			} else if(winState == 0) {
				
				winState = 2;
				printtxt("You lose.");
			}
			
		}
		
	}
	
	
	public int getNodes(Coordinate coord, JButton[][] buttons) {
		int nodes = 0;
			
		Coordinate[] testCoords = new Coordinate[4];
		testCoords[0]=new Coordinate(coord.getX()+1,coord.getY());
		testCoords[1]=new Coordinate(coord.getX()-1,coord.getY());
		
		testCoords[2]=new Coordinate(coord.getX(),coord.getY()+1);
		testCoords[3]=new Coordinate(coord.getX(),coord.getY()-1);
		
		for(int i = 0;i<4;i++) {
			try {
				if(buttons[testCoords[i].getX()][testCoords[i].getY()].getBackground()==Color.WHITE){
					nodes++;
				}
				
			} catch(Exception e) {
			
			}
		}
		
		return nodes;		
	}
		
	
	
	public void printtxt(String inp) {
		
		printlines++;
		String current = txtrTest.getText();
		if(printlines%14==1)
			current="";
		String temp=current+"> "+inp+"\n";
		txtrTest.setText(temp);
		
		//System.out.println(txtrTest.getText());
	}
	
	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
						
		} catch(Exception e) {
			
		}
	}
	
	public void colorSquare(int x, int y, Color bgColor) {
		buttons[y][x].setBackground(bgColor);
	}
}
