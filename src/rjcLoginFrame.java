import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class rjcLoginFrame extends JFrame{

		static int WIDTH = 840;
		static int HEIGHT = 525;
		String NAME = "Rocket Jump Cafe Login";
		JPanel displayPanel;
		JPanel logoutPanel;
		Image background = new ImageIcon(
				rjcLoginFrame.class.getResource("mainBack.png")).getImage();
		JTextField usernameField;
		JTextField passwordField;
		JLabel usernameLabel;
		JLabel passwordLabel;
		JButton loginButton;
		
		public rjcLoginFrame(){
			setTitle(NAME);
			setMinimumSize(new Dimension(WIDTH, HEIGHT ));
			setMaximumSize(new Dimension(WIDTH , HEIGHT));
			setPreferredSize(new Dimension(WIDTH , HEIGHT));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			displayPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(background, 0, 0, null);
				}	
			};
			displayPanel.setLayout(null);
			displayPanel.setBounds(0, 0, rjcLoginFrame.WIDTH, rjcLoginFrame.HEIGHT);
			displayPanel.setFocusable(true);
			displayPanel.setVisible(true);
						
			
			usernameField = new JTextField();
			usernameField.setSize(180,20);
			usernameField.setLocation(WIDTH/2-(usernameField.getWidth()/2)+30, 300);	
			displayPanel.add(usernameField);
			
			passwordField = new JPasswordField();
			passwordField.setSize(180,20);
			passwordField.setLocation(WIDTH/2-(passwordField.getWidth()/2)+30, 330);	
			displayPanel.add(passwordField);

			
			usernameLabel = new JLabel("Username:");
			usernameLabel.setSize(80,20);
			usernameLabel.setLocation(WIDTH/2-(usernameLabel.getWidth()/2) -85, 300);	
			displayPanel.add(usernameLabel);
			
			passwordLabel = new JLabel("Password:");
			passwordLabel.setSize(80,20);
			passwordLabel.setLocation(WIDTH/2-(passwordLabel.getWidth()/2) -85, 330);	
			displayPanel.add(passwordLabel);
			
			
			loginButton = new JButton("Login");
			loginButton.setSize(70, 20);
			loginButton.setLocation(470, 355);
			loginButton.setFocusable(false);
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
						try {
							if(driver.con.loginCheck(usernameField.getText(), passwordField.getText())){
									setVisible(false);
									driver.logout.setVisible(true);
									driver.login.usernameField.setText("");
									driver.login.passwordField.setText("");
							}else{
								JOptionPane.showMessageDialog(null,
					    	            "Your username of password was not valid.\nTry again.",
					    	            "Invalid", JOptionPane.ERROR_MESSAGE);	
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
		    }); 
			displayPanel.add(loginButton);		
	
	
			add(displayPanel);
			setResizable(false);
			//displayPanel.add();	
			pack();
			this.setLocation(354,100);
			setVisible(true);
		}	
	
}
