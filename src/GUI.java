import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	public GUI() {
		//basic window setup with centering based on screen size
		JFrame frame = new JFrame();
		JButton board[][] = new JButton[3][3];
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();


	}

}