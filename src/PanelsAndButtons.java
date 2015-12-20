
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

 class PanelsAndButtons implements ActionListener {
	public patternComputer computer=new patternComputer();
	public patternUser user =new patternUser();
	public gameProcessing process=new gameProcessing();
	int count=0;
	int VR=7;
	int VC=0;
	JFrame window = new JFrame();
	int newRow = 7;
	int newCol = 0;

	String wonMsg = "CONGRATULATIONS YOU WON!!";
	String lostMsg = "Game Over!";

	String nameRequest = "You must enter your name!";
	int boardRow = 0;
	int boardCol = 0;
	JButton[][] Board;
	JButton[] ColoredButtons;
	JButton[][] VerificationBoard;
	JButton RESTART;
	JButton CHECK;
	JButton PLAY;
	JButton UNDO;
	JTextField textField;
	LineBorder Textborder;
	LineBorder PanelBorder;

	String name;
	JPanel panel1;
	JPanel panelKeyInside1;
	JPanel panelBoardInside1;
	JPanel panelVerificationBoardInside1;

	public PanelsAndButtons() {
		int countColors = 0;
		int NameOfColor = 0;

		Color colors[] = { Color.red, Color.green, Color.blue, Color.cyan,
				Color.magenta, Color.yellow, Color.pink, Color.orange };

		String ColorsName[] = { "Red", "Green", "Blue", "Cyan", "Magenta",
				"Yellow", "Pink", "Orange" };

		panel1 = new JPanel();
		panelKeyInside1 = new JPanel();
		panelBoardInside1 = new JPanel();
		PanelBorder = new LineBorder(Color.BLACK);
		JPanel panelVerificationBoardInside1 = new JPanel();
		JPanel RestartButtonPanel = new JPanel();
		JPanel ColoredButtonsPanel = new JPanel();

		ColoredButtons = new JButton[8];
		Board = new JButton[8][4];
		VerificationBoard = new JButton[8][4];

		RESTART = new JButton("RESTART");
		CHECK = new JButton("CHECK IT!");
		UNDO= new JButton("Undo"); 
		textField = new JTextField(10);
		Textborder = new LineBorder(Color.RED, 2);
		name = textField.getText();
		PLAY = new JButton("Play");

		// Set colors and names to Colored Buttons

		for (int c = 0; c < 8; c++) {
			ColoredButtons[c] = new JButton(ColorsName[NameOfColor]);
			ColoredButtons[c].setBackground(colors[countColors]);
			ColoredButtons[c].setForeground(Color.BLACK);
			countColors++;
			NameOfColor++;
		}

		// Draw the Board
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 4; c++) {
				Board[r][c] = new JButton();
				Board[r][c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int r = 0; r < 8; r++) {
							for (int c = 0; c < 4; c++) {
								Board[r][c].setBackground(null);
							}
						}
					}
				});
			}
		}

		// Draw the Verification Board
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 4; c++) {
				VerificationBoard[r][c] = new JButton();
			}
		}

		panel1.setLayout(new GridLayout(1, 6, 5, 5));
		panelKeyInside1.setLayout(new GridLayout(10, 1, 30, 30));
		panelBoardInside1.setLayout(new GridLayout(8, 4, 5, 5));
		panelVerificationBoardInside1.setLayout(new GridLayout(16, 2, 3, 3));

		panelKeyInside1.add((new JLabel("")));
		panelKeyInside1.add((new JLabel("")));
		panelKeyInside1.add(textField);
		panelKeyInside1.add(PLAY);
		panelKeyInside1.add(CHECK);
		panelKeyInside1.add(UNDO);

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 4; c++) {
				panelBoardInside1.add(Board[r][c]);

			}
		}

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 4; c++) {
				panelVerificationBoardInside1.add(VerificationBoard[r][c]);
			}
		}

		panel1.add(panelKeyInside1, BorderLayout.WEST);
		panel1.add(panelBoardInside1, BorderLayout.CENTER);
		panel1.add(panelVerificationBoardInside1, BorderLayout.EAST);

		RestartButtonPanel.add(RESTART);

		ColoredButtonsPanel.setLayout(new GridLayout(1, 6, 3, 3));

		for (int c = 0; c < 8; c++) {
			ColoredButtonsPanel.add(ColoredButtons[c]);

		}
		window.add(panel1, BorderLayout.WEST);
		window.add(RestartButtonPanel, BorderLayout.NORTH);
		window.add(ColoredButtonsPanel, BorderLayout.SOUTH);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		ColoredButtons[0].setEnabled(false);
		ColoredButtons[1].setEnabled(false);
		ColoredButtons[2].setEnabled(false);
		ColoredButtons[3].setEnabled(false);
		ColoredButtons[4].setEnabled(false);
		ColoredButtons[5].setEnabled(false);
		ColoredButtons[6].setEnabled(false);
		ColoredButtons[7].setEnabled(false);
		RESTART.setEnabled(false);
		CHECK.setEnabled(false);
		UNDO.setEnabled(false);

		// ActionListener
		ColoredButtons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.Red);
				count++;
			//	System.out.println(user.patternList.size());
			//	System.out.println("count is "+count);
				
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[0].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[0].setEnabled(false);
				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.RED);
				newCol++;

			}
		});

		ColoredButtons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				user.patternList.add(count,pattern.colors.green);
				count++;
		//		System.out.println(user.patternList.size());
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[1].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[1].setEnabled(false);
				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.GREEN);
				newCol++;

			}
		});
		ColoredButtons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.blue);
				count++;
			//	System.out.println(user.patternList.size());
			//	System.out.println("count is"+count);
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[2].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[2].setEnabled(false);

				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.BLUE);
				newCol++;

			}

		});
		ColoredButtons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.cyan);
				count++;
			//	System.out.println(user.patternList.size());
			
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[3].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[3].setEnabled(false);
				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.CYAN);
				newCol++;

			}
		});

		ColoredButtons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.magenta);
				count++;
				//System.out.println(user.patternList.size());
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[4].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[4].setEnabled(false);
				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.MAGENTA);
				newCol++;

			}
		});
		ColoredButtons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.yellow);
				count++;
			//	System.out.println(user.patternList.size());
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[5].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[5].setEnabled(false);
				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.YELLOW);
				newCol++;

			}
		});
		ColoredButtons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.pink);
				count++;
			//	System.out.println(user.patternList.size());
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[6].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[6].setEnabled(false);

				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.PINK);
				newCol++;

			}
		});
		ColoredButtons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.patternList.add(count,pattern.colors.orange);
				count++;
				//System.out.println(user.patternList.size());
				
				if (newCol == 4) {
					newCol = 0;
					newRow--;
					ColoredButtons[7].setEnabled(false);

				} else if (newCol == 3) {
					ColoredButtons[0].setEnabled(false);
					ColoredButtons[1].setEnabled(false);
					ColoredButtons[2].setEnabled(false);
					ColoredButtons[3].setEnabled(false);
					ColoredButtons[4].setEnabled(false);
					ColoredButtons[5].setEnabled(false);
					ColoredButtons[6].setEnabled(false);
					ColoredButtons[7].setEnabled(false);

				} else
					ColoredButtons[7].setEnabled(false);

				if (Board[newRow][newCol].getBackground() != null)
					Board[newRow][newCol].setBackground(Color.ORANGE);

				newCol++;

			}
		});
		RESTART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PanelsAndButtons();
				PanelsAndButtons.this.window.dispose();
			}

		});
		CHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j;
				int k=0;
				//for(int i=0;i<=3;i++)
					//System.out.println("user Pattern " +i +user.patternList.get(i));
				//for(int i=0;i<=3;i++)
					//System.out.println("computer pattern "+i+ computer.patternList.get(i));
				int ValColor=process.validateColor(user, computer);
			//	System.out.println("valColor is" +ValColor);
				for( k=0;k<ValColor;k++)
				{	VerificationBoard[VR][k].setBackground(Color.black);
				}
				
				int ValOrder=process.validateOrder(user, computer);
				//System.out.println("VOrder "+ValOrder);
				for( j=0;j<ValOrder;j++)
				{	
					VerificationBoard[VR][k].setBackground(Color.white);
					k++;
				}
				if(process.isWinning())
					JOptionPane.showMessageDialog(window, wonMsg, "Name",
							JOptionPane.INFORMATION_MESSAGE);
				VR--;
				count=0;
				if (newRow==0 && newCol==4 && true)
					JOptionPane.showMessageDialog(window, lostMsg, "Sorry!!",JOptionPane.INFORMATION_MESSAGE);
				
				ColoredButtons[0].setEnabled(true);
				ColoredButtons[1].setEnabled(true);
				ColoredButtons[2].setEnabled(true);
				ColoredButtons[3].setEnabled(true);
				ColoredButtons[4].setEnabled(true);
				ColoredButtons[5].setEnabled(true);
				ColoredButtons[6].setEnabled(true);
				ColoredButtons[7].setEnabled(true);
				
				// call the verification function
				// according to the function algorithm , we will loop on the no.
				// of "true"s
				// true order&color -> white
				// VerificationBoard[newRow][newCol].setBackground(Color.WHITE);
				// true color and false order ->
				// VerificationBoard[newRow][newCol].setBackground(Color.BLACK);


			}
		});
		PLAY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PLAY.setEnabled(false);
				computer.generatePattern();
				if (textField.getText().trim().length() == 0) {
					textField.setBorder(Textborder);
					JOptionPane.showMessageDialog(window, nameRequest, "Name",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					RESTART.setEnabled(true);
					CHECK.setEnabled(true);
					UNDO.setEnabled(true);
					ColoredButtons[0].setEnabled(true);
					ColoredButtons[1].setEnabled(true);
					ColoredButtons[2].setEnabled(true);
					ColoredButtons[3].setEnabled(true);
					ColoredButtons[4].setEnabled(true);
					ColoredButtons[5].setEnabled(true);
					ColoredButtons[6].setEnabled(true);
					ColoredButtons[7].setEnabled(true);
					textField.setBorder(null);
					textField.setEnabled(false);

				}

			}
		});

	
	
	UNDO.addActionListener(new ActionListener(){ //updated
		public void actionPerformed(ActionEvent e){
			// when the user click this button
			//the last element entered in the array will be deleted
			//and the color is deleted 
			
			
			if (newCol==0){
			ColoredButtons[0].setEnabled(true);
			ColoredButtons[1].setEnabled(true);
			ColoredButtons[2].setEnabled(true);
			ColoredButtons[3].setEnabled(true);
			ColoredButtons[4].setEnabled(true);
			ColoredButtons[5].setEnabled(true);
			ColoredButtons[6].setEnabled(true);
			ColoredButtons[7].setEnabled(true);}
		
			else if(newCol!=0){
				
			//	 (user.patternList.get((user.patternList.size()-1))){}*/
				if (user.patternList.get(count-1)==pattern.colors.Red)// count-1
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.Red);
			count--;
			ColoredButtons[0].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				
				else	if (user.patternList.get(count-1)==pattern.colors.green)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.green);
			count--;
			ColoredButtons[1].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				else	if (user.patternList.get(count-1)==pattern.colors.blue)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.blue);
			count--;
			ColoredButtons[2].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				else	if (user.patternList.get(count-1)==pattern.colors.cyan)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.cyan);
			count--;
			ColoredButtons[3].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				
				else	if (user.patternList.get(count-1)==pattern.colors.magenta)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.magenta);
			count--;
			ColoredButtons[4].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				
				else	if (user.patternList.get(count-1)==pattern.colors.yellow)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.yellow);
			count--;
			ColoredButtons[5].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				else	if (user.patternList.get(count-1)==pattern.colors.pink)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.pink);
			count--;
			ColoredButtons[6].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
				
				else	if (user.patternList.get(count-1)==pattern.colors.orange)
				{	//user.patternList.remove(user.patternList.size() - 1); 
					
					user.patternList.remove(pattern.colors.orange);
			count--;
			ColoredButtons[7].setEnabled(true);
		
				Board[newRow][newCol-1].setBackground(Color.gray);//UIManager.getColor("Button.background"));
			newCol--;
				}
					
			}	
		}	
		});
		
	}	
	


	// ActionListener to Board buttons

	public static void main(String[] arg) {
		
		ArrayList list=new ArrayList();
PanelsAndButtons p=new PanelsAndButtons();
list=p.user.getPattern();
//System.out.println(list.size());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

}
