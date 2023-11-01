package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PvP extends JFrame {
	// THE LOGIC BEHIND THE GAME, THIS ARRAY WILL BE USEFUL LATER
	int[][] game = new int[3][3];
	
	// THIS DETERMINES WHOSE TURN IS IT
	char turn = 'O';
	
	// DISPLAYS WHOSE TURN IS IT
	JLabel guide = new JLabel(turn + "'s turn");
	
	// CREATES THE BUTTON
	JButton col1Row1 = new JButton("-");
    JButton col1Row2 = new JButton("-");
    JButton col1Row3 = new JButton("-");
    JButton col2Row1 = new JButton("-");
    JButton col2Row2 = new JButton("-");
    JButton col2Row3 = new JButton("-");
    JButton col3Row1 = new JButton("-");
    JButton col3Row2 = new JButton("-");
    JButton col3Row3 = new JButton("-");
    
    // STORES THE BUTTONS IN AN ARRAY FOR LATER USE
    JButton[][] buttons = {
			{col1Row1, col1Row2, col1Row3},
			{col2Row1, col2Row2, col2Row3},
			{col3Row1, col3Row2, col3Row3}
	};
    
    // CREATES THE FRAME FOR PVP GAME
    PvP() {
    	
    	// DICTATES WHAT THE GAME WILL LOOK LIKE
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 750);
        this.setResizable(false);
        
        
        JPanel title = new JPanel(new FlowLayout());
        guide.setFont(new Font("", Font.BOLD, 50));
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        
        
        // SETS WHAT THE BUTTON WILL LOOK LIKE AND ADDS FUNCTIONALITY
        // THIS APPLIES TO EVERY OTHER BUTTONS AS WELL
        col1Row1.setFocusPainted(false);
        col1Row1.setForeground(Color.BLACK);
        col1Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        col1Row1.addActionListener(e -> {
        	if(check()) {
        		game[0][0] = 1;
        		col1Row1.setEnabled(false);
        		col1Row1.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[0][0] = 2;
        		col1Row1.setEnabled(false);
        		col1Row1.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });
        
        col1Row2.setFocusPainted(false);
        col1Row2.setForeground(Color.BLACK);
        col1Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col1Row2.addActionListener(e -> {
        	if(check()) {
        		game[0][1] = 1;
        		col1Row2.setEnabled(false);
        		col1Row2.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[0][1] = 2;
        		col1Row2.setEnabled(false);
        		col1Row2.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });

        col1Row3.setFocusPainted(false);
        col1Row3.setForeground(Color.BLACK);
        col1Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col1Row3.addActionListener(e -> {
        	if(check()) {
        		game[0][2] = 1;
        		col1Row3.setEnabled(false);
        		col1Row3.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[0][2] = 2;
        		col1Row3.setEnabled(false);
        		col1Row3.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });

        col2Row1.setFocusPainted(false);
        col2Row1.setForeground(Color.BLACK);
        col2Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row1.addActionListener(e -> {
        	if(check()) {
        		game[1][0] = 1;
        		col2Row1.setEnabled(false);
        		col2Row1.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[1][0] = 2;
        		col2Row1.setEnabled(false);
        		col2Row1.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });

        col2Row2.setFocusPainted(false);
        col2Row2.setForeground(Color.BLACK);
        col2Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row2.addActionListener(e -> {
        	if(check()) {
        		game[1][1] = 1;
        		col2Row2.setEnabled(false);
        		col2Row2.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[1][1] = 2;
        		col2Row2.setEnabled(false);
        		col2Row2.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });
        
        col2Row3.setFocusPainted(false);
        col2Row3.setForeground(Color.BLACK);
        col2Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col2Row3.addActionListener(e -> {
        	if(check()) {
        		game[1][2] = 1;
        		col2Row3.setEnabled(false);
        		col2Row3.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[1][2] = 2;
        		col2Row3.setEnabled(false);
        		col2Row3.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });

        col3Row1.setFocusPainted(false);
        col3Row1.setForeground(Color.BLACK);
        col3Row1.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row1.addActionListener(e -> {
        	if(check()) {
        		game[2][0] = 1;
        		col3Row1.setEnabled(false);
        		col3Row1.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[2][0] = 2;
        		col3Row1.setEnabled(false);
        		col3Row1.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });
        
        col3Row2.setFocusPainted(false);
        col3Row2.setForeground(Color.BLACK);
        col3Row2.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row2.addActionListener(e -> {
        	if(check()) {
        		game[2][1] = 1;
        		col3Row2.setEnabled(false);
        		col3Row2.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[2][1] = 2;
        		col3Row2.setEnabled(false);
        		col3Row2.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });

        col3Row3.setFocusPainted(false);
        col3Row3.setForeground(Color.BLACK);
        col3Row3.setFont(new Font("MV Boli", Font.BOLD, 50));
        col3Row3.addActionListener(e -> {
        	if(check()) {
        		game[2][2] = 1;
        		col3Row3.setEnabled(false);
        		col3Row3.setText("O");
        		x();
        		if(winO()) {
        			JOptionPane.showMessageDialog(this, "O Player win!");
        			resetGame();
        		}
        	}
        	else {
        		game[2][2] = 2;
        		col3Row3.setEnabled(false);
        		col3Row3.setText("X");
        		o();
        		if(winX()) {
        			JOptionPane.showMessageDialog(this, "X Player win!");
        			resetGame();
        		}
        	}
        });
        
        // ADDS THE BUTTONS TO THE PANEL 
        panel.add(col1Row1);
        panel.add(col1Row2);
        panel.add(col1Row3);
        panel.add(col2Row1);
        panel.add(col2Row2);
        panel.add(col2Row3);
        panel.add(col3Row1);
        panel.add(col3Row2);
        panel.add(col3Row3);
        
        // ADDS EVERYTHING TO THE PVP FRAME
        title.add(guide);
        this.add(title, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        Border border = new LineBorder(Color.WHITE, 10);
        this.getRootPane().setBorder(border);
        this.setLocationRelativeTo(null);
        this.setTitle("PvP");
        
    }
    
    // FUNCTION TO CHECK WHICH TURN IS IT
    boolean check() {
    	return turn == 'O';
    }
    
    // FUNCTION THAT SETS THE LABEL BACK TO "O"
    void o() {
    	turn = 'O';
    	guide.setText(turn + "'s turn");
    }
    
    // FUNCTION THAT SETS THE LABEL TO "X"
    void x() {
    	turn = 'X';
    	guide.setText(turn + "'s turn");
    }
    
    // CHECKS IF PLAYER "O" WINS
    boolean winO() {
    	return winOHorizontal(game) || winOVertical(game) || winODiagonal(game);
    }
    
    
    // CHECKS IF PLAYER "X"
    boolean winX() {
    	return winXHorizontal(game) || winXVertical(game) || winXDiagonal(game);
    }
    
    // THIS HELPER CLASSES CHECKS IF PLAYER "O" HAS ALREADY WON
	private boolean winOHorizontal(int[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			int count = 0;
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == 1) count++;
			}
			if(count == 3) return true;
		}
		return false;
	}

	private boolean winOVertical(int[][] arr) {
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

	private boolean winODiagonal(int[][] arr) {
	    if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return true;
	    if (arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) return true;
		return false;
	}
	
	// THIS HELPER CLASSES CHECKS IF PLAYER "X" HAS ALREADY WON
	private boolean winXHorizontal(int[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			int count = 0;
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == 2) count++;
			}
			if(count == 3) return true;
		}
		return false;
	}

	private boolean winXVertical(int[][] arr) {
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

	private boolean winXDiagonal(int[][] arr) {
	    if (arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) return true;
	    if (arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2) return true;
		return false;
	}
	
	// THIS FUNCTION RESETS EACH BUTTON AND EACH NUMBERS IN THE GAME ARRAY
	private void resetGame() {
	    for (int row = 0; row < game.length; row++) {
	        for (int col = 0; col < game[row].length; col++) {
	            game[row][col] = 0;
	            buttons[row][col].setEnabled(true);
	            buttons[row][col].setText("-");
	        }
	    }
	    o();
	}
}
