import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class rjcLogoutFrame extends JFrame{

		static int WIDTH = 840;
		static int HEIGHT = 525;
		String NAME = "Rocket Jump Cafe logout";
		JPanel displayPanel;
		JPanel logoutPanel;

		JButton logoutButton;
		
		public rjcLogoutFrame(){
			
			setTitle(NAME);
			setMinimumSize(new Dimension(WIDTH, HEIGHT ));
			setMaximumSize(new Dimension(WIDTH , HEIGHT));
			setPreferredSize(new Dimension(WIDTH , HEIGHT));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			getContentPane().setBackground(Color.BLACK);
			
			displayPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g;
					try{
						g2d.setColor(Color.BLACK);
						g2d.fillRect(0, 0, rjcLogoutFrame.WIDTH, rjcLogoutFrame.HEIGHT);
						g2d.setColor(Color.WHITE);
						g2d.drawString("Successful login "+driver.con.curLog, 100, 100);
						g2d.drawString("This is the VHD.", 100, 140);
					}catch(Exception e23){
						System.out.println("YO");
					}
				}	
			};
			displayPanel.setLayout(null);
			displayPanel.setBounds(0, 0, rjcLogoutFrame.WIDTH, rjcLogoutFrame.HEIGHT);
			displayPanel.setFocusable(true);
			displayPanel.setVisible(true);
			render.render(displayPanel);			
			
			
			
			
			logoutButton = new JButton("logout");
			logoutButton.setSize(70, 20);
			logoutButton.setLocation(WIDTH/2-(logoutButton.getWidth()/2), 355);
			logoutButton.setFocusable(false);
			logoutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
						try {
							driver.con.logOut();
							setVisible(false);
							driver.login.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
		    }); 
			displayPanel.add(logoutButton);		
	
			add(displayPanel);
			setResizable(false);
			
			//displayPanel.add();	
			pack();
			this.setLocation(354,100);
			setVisible(false);
		}	
	
}