import java.awt.*;
import javax.swing.*;


public class eagleCredFrame extends JFrame{

	static int WIDTH = 244;
	static int HEIGHT = 525;
	String NAME = "GSU Credentials";
	JPanel displayPanel;
	Image background = new ImageIcon(
			rjcLoginFrame.class.getResource("gsuLogBack.png")).getImage();
	static DefaultListModel eagleCredListModel;
	public static JList eagleCredList;
	JScrollPane eagleCredScrollableList;
	
	
	public eagleCredFrame(){
		
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
		
		
		eagleCredListModel = new DefaultListModel();
		eagleCredList = new JList(eagleCredListModel);
		eagleCredList.setLayoutOrientation(0);
		eagleCredScrollableList = new JScrollPane(eagleCredList);
		eagleCredScrollableList.setBounds(10, 50, this.WIDTH-25, this.HEIGHT-85);
		driver.con.doConnection();
		
		add(eagleCredScrollableList);
		
		//render.render(displayPanel);
		add(displayPanel);
		setResizable(false);
		//displayPanel.add();
		pack();
		this.setLocation(100,100);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
	
}
