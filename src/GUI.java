import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	JButton board[][] = new JButton[3][3];
	public GUI() {
		//basic window setup with centering based on screen size
		JFrame frame = new JFrame();

        JPanel panel = new JPanel(new GridLayout(3, 3));
        //creating the button layout
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(100, 100));
                button.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		if (button.getText().isEmpty()) {
                			button.setText("X");
                			button.setFont(new Font("Arial", Font.BOLD, 50));     
                			//check on ending the game
                			if (checkWin()) 
                			{
                				JOptionPane.showMessageDialog(null,"Player Winns");
                				reset();
                				
                			}
                			else if(checkTie()) 
                			{
                				JOptionPane.showMessageDialog(null,"Draw");
                				reset();
                			}
                			else 
                			{
                				randmomMove();
                			}
                			
                    }
                }

            });
                
                
                board[i][j] = button;
                panel.add(button);
            }
        }

        
        
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tick-Tack-To");
		frame.pack();
		frame.setVisible(true);
	}
	
	private void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText("");
            }
        }
    }
	private void randmomMove() {
		// TODO Auto-generated method stub
		//randomly generated bot moves... You can't really lose even if you try but is just a little programming thing so who cares
		
		int counter =0;
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    counter += 1;
                }
            }
        }
		Random rand = new Random();
		int n = rand.nextInt(counter)+1;
		
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    n -= 1;
                    if (n == 0) {
                    	board[i][j].setText("O");
                    	board[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                    	if (checkWin())
                    	{
                    		JOptionPane.showMessageDialog(null,"Player Loses");
                    		reset();
                    	}
                    	
                    }
                    	
                }
            }
        }
		
	}
	private boolean checkTie() {
		// TODO Auto-generated method stub
		//brute force tie check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
	}
	private boolean checkWin() {
		// TODO Auto-generated method stub
		//brute force on checking win... seems to be faster than logic
        // check is
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().isEmpty() && board[i][0].getText().equals(board[i][1].getText())
                    && board[i][1].getText().equals(board[i][2].getText())) {
                return true;
            }
        }
        // check jumns
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].getText().isEmpty() && board[0][j].getText().equals(board[1][j].getText())
                    && board[1][j].getText().equals(board[2][j].getText())) {
                return true;
            }
        }
        // check diagonals
        if (!board[0][0].getText().isEmpty() && board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())) {
            return true;
        }
        if (!board[0][2].getText().isEmpty() && board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())) {
            return true;
        }
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();


	}

}