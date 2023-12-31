package main;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

// TIC TAC TO GAME

// FUTURE UPDATES TO DO:
// MAKE UI BETTER

// CURRENT PENDING TASK:
// ADD STALEMATE FUNCTION TO PVP MODE



public class main {
	public static void main(String[] args) {
		
		   	JFrame game = new JFrame();
	        JPanel panel = new JPanel(new GridBagLayout());
	        JLabel title = new JLabel("Tic-Tac-Toe");
	        JButton player = new JButton("Player vs Player");
	        JButton bot = new JButton("Player vs Bot");
	        JButton ai = new JButton("Player vs AI");
	        
	        bot.setFocusPainted(false);
	        bot.addActionListener(e -> {
	        	game.dispose();
	        	new MyFrame();
	        });
	        
	        player.setFocusPainted(false);
	        player.addActionListener(e -> {
	        	game.dispose();
	        	new PvP();
	        });
	        
	        ai.setFocusable(false);
	        ai.addActionListener(e -> {
	        	game.dispose();
	        	new HardBot();
	        });

	        title.setFont(new Font("", Font.BOLD, 30));

	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 0, 10, 0);

	        player.setPreferredSize(new Dimension(200, 40));
	        bot.setPreferredSize(new Dimension(200, 40));
	        ai.setPreferredSize(new Dimension(200, 40));

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        panel.add(title, gbc);

	        gbc.gridy = 1;
	        panel.add(player, gbc);

	        gbc.gridy = 2;
	        panel.add(bot, gbc);
	        
	        gbc.gridy = 3;
	        panel.add(ai, gbc);
	        
	        game.setTitle("Tic-Tac-Toe");
	        game.setVisible(true);
	        game.setSize(300, 550);
	        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.setResizable(false);
	        game.add(panel);
	        game.setLocationRelativeTo(null);
		
	}
}