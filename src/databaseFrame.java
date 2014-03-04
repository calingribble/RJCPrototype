import java.awt.*;
import javax.swing.*;

public class databaseFrame extends JFrame{
static int WIDTH = 244;
static int HEIGHT = 525;
String NAME = "RJC Database";
JPanel displayPanel;
Image background = new ImageIcon(
		rjcLoginFrame.class.getResource("rjcDataBack.png")).getImage();
static DefaultListModel logDBListModel;
public static JList logDBList;
JScrollPane logDBScrollableList;

public databaseFrame(){
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
	
	logDBListModel = new DefaultListModel();
	logDBList = new JList(logDBListModel);
	logDBScrollableList = new JScrollPane(logDBList);
	logDBScrollableList.setBounds(10, 70, this.WIDTH-25, this.HEIGHT-110);

	add(logDBScrollableList);
	
	add(displayPanel);
	setResizable(false);
	pack();
	this.setLocation(1205,100);
	setVisible(true);
}


}
