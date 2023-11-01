package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyFrame extends JFrame {
	// THE LOGIC BEHIND THE GAME
	// IF THE TILE IS NOT HIT IT IS 0
	// IF PLAYER HITS THE TILE, IT IS 1
	// IF BOT HITS THE TILE, IT IS 2
	int[][] game = new int[3][3];
	
	//CREATE TILES FOR THE GAME
    JButton col1Row1 = new JButton("-");
    JButton col1Row2 = new JButton("-");
    JButton col1Row3 = new JButton("-");
    JButton col2Row1 = new JButton("-");
    JButton col2Row2 = new JButton("-");
    JButton col2Row3 = new JButton("-");
    JButton col3Row1 = new JButton("-");
    JButton col3Row2 = new JButton("-");
    JButton col3Row3 = new JButton("-");
    
    // STORE THE CREATED BUTTONS IN AN ARRAY FOR LATER LOGIC
    // THIS WILL MAKE THE ACCESS FOR BUTTONS LATER EASIER
	JButton[][] buttons = {
			{col1Row1, col1Row2, col1Row3},
			{col2Row1, col2Row2, col2Row3},
			{col3Row1, col3Row2, col3Row3}
	};
	
	// CREATES A FRAME FOR THE GAME
    MyFrame() {
    	
    	// DICTATES WHAT THE FRAME SHOULD LOOK LIKE
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 750);
        this.setResizable(false);
        
        // CREATES A PANEL FOR THE BUTTONS TO BE IN AND THE DIPLAY IS 3X3
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        
        // SETS THE SETTING FOR EACH BUTTON
        col1Row1.setForeground(Color.BLACK);
        col1Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        
        // A LAMBDA EXPRESSION TO CHECK WHETHER WHO WINS, THIS APPLIES TO EVERY OTHER BUTTON
        col1Row1.addActionListener(e -> {
        	game[0][0] = 1;
        	col1Row1.setText("O");
        	col1Row1.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	
        	// IF PLAYER DOESN'T WIN IN THIS INSTANCE, THE BOT IS VALID TO MOVE
        	else botTurn();
        });
        
        col1Row2.setForeground(Color.BLACK);
        col1Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col1Row2.addActionListener(e -> {
        	game[0][1] = 1;
        	col1Row2.setText("O");
        	col1Row2.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col1Row3.setForeground(Color.BLACK);
        col1Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col1Row3.addActionListener(e -> {
        	game[0][2] = 1;
        	col1Row3.setText("O");
        	col1Row3.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col2Row1.setForeground(Color.BLACK);
        col2Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row1.addActionListener(e -> {
        	game[1][0] = 1;
        	col2Row1.setText("O");
        	col2Row1.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col2Row2.setForeground(Color.BLACK);
        col2Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row2.addActionListener(e -> {
        	game[1][1] = 1;
        	col2Row2.setText("O");
        	col2Row2.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	botTurn();
        });
        
        col2Row3.setForeground(Color.BLACK);
        col2Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row3.addActionListener(e -> {
        	game[1][2] = 1;
        	col2Row3.setText("O");
        	col2Row3.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col3Row1.setForeground(Color.BLACK);
        col3Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row1.addActionListener(e -> {
        	game[2][0] = 1;
        	col3Row1.setText("O");
        	col3Row1.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col3Row2.setForeground(Color.BLACK);
        col3Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row2.addActionListener(e -> {
        	game[2][1] = 1;
        	col3Row2.setText("O");
        	col3Row2.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        col3Row3.setForeground(Color.BLACK);
        col3Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row3.addActionListener(e -> {
        	game[2][2] = 1;
        	col3Row3.setText("O");
        	col3Row3.setEnabled(false);
        	if(win()) {
        		JOptionPane.showMessageDialog(this, "You win!");
        		resetGame();
        	}
        	else botTurn();
        });
        
        // ADDS EACH BUTTON TO THE PANEL
        panel.add(col1Row1);
        panel.add(col1Row2);
        panel.add(col1Row3);
        panel.add(col2Row1);
        panel.add(col2Row2);
        panel.add(col2Row3);
        panel.add(col3Row1);
        panel.add(col3Row2);
        panel.add(col3Row3);

        
        // ADDS THE PANEL TO THE FRAME
        this.add(panel);
        
        // CREATES A BORDER FOR THE FRAME
        Border border = new LineBorder(Color.WHITE, 10);
        this.getRootPane().setBorder(border);
        
        
    }
    
    // THIS IS WHERE THE LOGIC OF THE GAME LIES
    
    
    // THE BOT'S LOGIC
	private void botTurn() {
		boolean check = false;
		
		// THIS CHUNK OF CODE WILL NEVER STOP UNTIL THE ALGORITHM FINDS A ZERO IN THE "GAME" ARRAY
		while(check != true) {
			int randomRow = (int) (3 * Math.random());
			int randomCol = (int) (3 * Math.random());
			if(game[randomRow][randomCol] == 0) {
				game[randomRow][randomCol] = 2;
				buttons[randomRow][randomCol].setText("X");
				buttons[randomRow][randomCol].setEnabled(false);
				check = !check;
			}
			
		}
		
		// CHECKS IF THE BOT HAS WON, IF TRUE THE PLAYER WILL LOSE AND THE GAME WILL RESET
		if(opponentWin()) {
			JOptionPane.showMessageDialog(this, "You Lose!");
			resetGame();
		}
	}
    
	// THE VALIDATOR IF THE PLAYER HAS WON
    boolean win() {
		return checkHorizontal(game) || checkVertical(game) || checkDiagonal(game);
    }
    
    // THE VALIDATOR IF THE BOT HAS WON
    boolean opponentWin() {
    	return checkHorizontalOp(game) || checkVerticalOp(game) || checkDiagonalOp(game);
    }
    
    // TO UPDATE
    boolean stalemate() {
        return !win() && !opponentWin() && isBoardFull();
    }
    
    // CHECKS IF THERE ARE TILES LEFT TO TURN
    boolean isBoardFull() {
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[row].length; col++) {
                if (game[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // CHECKS FOR ANY VALID DIAGONAL PATTERN FOR THE BOT
	private boolean checkDiagonalOp(int[][] arr) {
	    if (arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) return true;
	    if (arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2) return true;
		return false;
	}
	
	// CHECKS FOR ANY VALID HORIZONTAL PATTERN FOR THE BOT
	private boolean checkHorizontalOp(int[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			int count = 0;
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == 2) count++;
			}
			if(count == 3) return true;
		}
		return false;
	}

	// CHECKS FOR ANY VALID VERTICAL PATTERN FOR THE BOT
	private boolean checkVerticalOp(int[][] arr) {
	    for (int col = 0; col < arr.length; col++) {
	        int count = 0;
	        for (int row = 0; row < arr[col].length; row++) {
	            if (arr[row][col] == 2) {
	                count++;
	            }
	        }
	        if (count == 3) return true;
	    }
	    return false;
	}

	// CHECKS FOR ANY VALID HORIZONTAL PATTERN FOR THE PLAYER
	private boolean checkHorizontal(int[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			int count = 0;
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == 1) count++;
			}
			if(count == 3) return true;
		}
		return false;
	}

	// CHECKS FOR ANY VALID VERTICAL PATTERN FOR THE PLAYER
	private boolean checkVertical(int[][] arr) {
	    for (int col = 0; col < arr.length; col++) {
	        int count = 0;
	        for (int row = 0; row < arr[col].length; row++) {
	            if (arr[row][col] == 1) {
	                count++;
	            }
	        }
	        if (count == 3) return true;
	    }
	    return false;
	}

	// CHECKS FOR ANY VALID DIAGONAL PATTERN FOR THE PLAYER
	private boolean checkDiagonal(int[][] arr) {
	    if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return true;
	    if (arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) return true;
		return false;
	}
	
	// RESETS THE BOARD TO THEIR DEFAULT SETTINGS / RESETS THE GAME
	private void resetGame() {
	    for (int row = 0; row < game.length; row++) {
	        for (int col = 0; col < game[row].length; col++) {
	            game[row][col] = 0;
	            buttons[row][col].setEnabled(true);
	            buttons[row][col].setText("-");
	        }
	    }
	}
}