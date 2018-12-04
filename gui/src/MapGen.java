import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class MapGen extends JFrame {

	public Color[] possible;
	public char[] possibleChar;
	
	public JButton[][] buttons;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MapGen frame = new MapGen();
		EventQueue.invokeLater(new Runnable() {public void run() {
				frame.setVisible(true);			
				
			}			
		});
		
		
		frame.possible = new Color[] {Color.WHITE,Color.GRAY,Color.GREEN};
		frame.possibleChar = new char[] {' ','#','S'};
		
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				frame.buttons[i][j].setBackground(Color.GRAY);
			}
		}
		
	}

	
	public void changeColor(JButton button) {
		if(button.getBackground()==Color.GREEN) {
			button.setBackground(Color.GRAY);
		} 
		else if(button.getBackground()==Color.GRAY) {
			button.setBackground(Color.WHITE);
		}
		else if(button.getBackground()==Color.WHITE) {
			button.setBackground(Color.GREEN);
		}
	}
	
	public File newMapFile() {
		File folder = new File("//dohome4//home4$//Student4//1837028//Eclipse//gui//maps");
		File[] listOfFiles = folder.listFiles();
		String name = "Map"+(listOfFiles.length+1);
		File file = new File("//dohome4//home4$//Student4//1837028//Eclipse//gui//maps//"+name+".txt");
		try {
			if(file.createNewFile()) {
				//System.out.println("Made file");
			}
			else {
				System.out.println("File already exists with name "+name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	
	public char colorToChar(JButton button) {
		if(button.getBackground()==Color.GREEN) {
			return 'S';
		}
		if(button.getBackground()==Color.GRAY) {
			return '#';
		}
		if(button.getBackground()==Color.WHITE) {
			return ' ';
		}
		
		return 'a';
	}
	
	public String compressMap(JButton[][] buttons) {
		String arr = "";
		for(int i= 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				arr+=colorToChar(buttons[i][j]);
			}
		}
		String temp = "";
		int index =0;
		char tempChar;
		int counter = 0;
		while(index<arr.length()) {
			
			tempChar = arr.charAt(index);
			while(index<arr.length()&&arr.charAt(index)==tempChar) {
				counter++;
				index++;
				
			}
			temp+=""+counter+tempChar;
			counter = 0;
			
			
		}
		
		return temp;
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public MapGen() {
		setTitle("Map Creator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(btnNewButton);
			}
		});
		btnNewButton.setBounds(10, 10, 50, 50);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button);
			}
		});
		button.setBounds(59, 10, 50, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_1);
			}
		});
		button_1.setBounds(108, 10, 50, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(Color.GRAY);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_2);
			}
		});
		button_2.setBounds(157, 10, 50, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(Color.GRAY);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_3);
			}
		});
		button_3.setBounds(206, 10, 50, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBackground(Color.GRAY);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_4);
			}
		});
		button_4.setBounds(10, 59, 50, 50);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBackground(Color.GRAY);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_5);
			}
		});
		button_5.setBounds(59, 59, 50, 50);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBackground(Color.GRAY);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_6);
			}
		});
		button_6.setBounds(108, 59, 50, 50);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBackground(Color.GRAY);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_7);
			}
		});
		button_7.setBounds(157, 59, 50, 50);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBackground(Color.GRAY);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_8);
			}
		});
		button_8.setBounds(206, 59, 50, 50);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setBackground(Color.GRAY);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_9);
			}
		});
		button_9.setBounds(206, 108, 50, 50);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBackground(Color.GRAY);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_10);
			}
		});
		button_10.setBounds(157, 108, 50, 50);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setBackground(Color.GRAY);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_11);
			}
		});
		button_11.setBounds(108, 108, 50, 50);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setBackground(Color.GRAY);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_12);
			}
		});
		button_12.setBounds(59, 108, 50, 50);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setBackground(Color.GRAY);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeColor(button_13);
			}
		});
		button_13.setBounds(10, 108, 50, 50);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setBackground(Color.GRAY);
		button_14.setBounds(206, 157, 50, 50);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setBackground(Color.GRAY);
		button_15.setBounds(157, 157, 50, 50);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setBackground(Color.GRAY);
		button_16.setBounds(108, 157, 50, 50);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setBackground(Color.GRAY);
		button_17.setBounds(59, 157, 50, 50);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setBackground(Color.GRAY);
		button_18.setBounds(10, 157, 50, 50);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setBackground(Color.GRAY);
		button_19.setBounds(206, 206, 50, 50);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setBackground(Color.GRAY);
		button_20.setBounds(157, 206, 50, 50);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setBackground(Color.GRAY);
		button_21.setBounds(108, 206, 50, 50);
		contentPane.add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setBackground(Color.GRAY);
		button_22.setBounds(59, 206, 50, 50);
		contentPane.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setBackground(Color.GRAY);
		button_23.setBounds(10, 206, 50, 50);
		contentPane.add(button_23);
		
		buttons = new JButton[][] {
			{btnNewButton,button,button_1,button_2,button_3},
			{button_4,button_5,button_6,button_7,button_8},
			{button_13,button_12,button_11,button_10,button_9},
			{button_18,button_17,button_16,button_15,button_14},
			{button_23,button_22,button_21,button_20,button_19}
			
		};
		
		for(int i = 3;i<5;i++) {
			for(int j = 0;j<5;j++) {
				JButton tempButton = buttons[i][j];
				tempButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						changeColor(tempButton);
					}
				});
			}
		}
		
		JButton btnSaveMap = new JButton("Save map");
		btnSaveMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File temp = newMapFile();
				FileWriter writer;
				try {
					writer = new FileWriter(temp);
					writer.write(compressMap(buttons));
					textField.setText(compressMap(buttons));
					writer.close();
				} catch (IOException e1) {
					System.out.println("Did not write");
					e1.printStackTrace();
				}
			}
		});
		btnSaveMap.setBackground(new Color(255, 255, 225));
		btnSaveMap.setBounds(266, 10, 138, 23);
		contentPane.add(btnSaveMap);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(266, 236, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCompressedString = new JLabel("Compressed String");
		lblCompressedString.setBounds(266, 211, 116, 14);
		contentPane.add(lblCompressedString);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0;i<5;i++) {
					for(int j = 0;j<5;j++) {
						buttons[i][j].setBackground(Color.GRAY);
					}
				}
			}
		});
		btnNewButton_1.setBounds(266, 37, 138, 23);
		contentPane.add(btnNewButton_1);
	}
}
