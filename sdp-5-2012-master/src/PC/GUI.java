package PC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Planning.Robot;
import Planning.Runner;


public class GUI extends JFrame{
	private JFrame frmControlPanel;
	
	private JButton dribble = new JButton("Dribble");
	private JButton nav = new JButton("Navigate");
	private JButton quit = new JButton("Quit");
	private JRadioButton yellow = new JRadioButton("Yellow");
	private JRadioButton blue = new JRadioButton("Blue");
	private JRadioButton main = new JRadioButton("Main");
	private JRadioButton side = new JRadioButton("Side");
	
	private JLabel lblPanelColour = new JLabel("Plate Colour");
	private JLabel lblPitch = new JLabel("Pitch");
	
	public static Robot r = new Robot(); 
	
	public static boolean colour = false;
	public static int pitch = 0;
	
	
	public static void main(String[] args){
		
		GUI gui = new GUI();
		gui.launch();
		gui.action();
		r.startCommunications();
		r.setConnected(false);
	}
	
	public GUI(){
		
		//r = new Robot();
		frmControlPanel = new JFrame();
		frmControlPanel.setTitle("Control Panel");
		frmControlPanel.setBackground(new Color(255, 255, 255));
		frmControlPanel.getContentPane().setBackground(new Color(0, 0, 0));
		frmControlPanel.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/afs/inf.ed.ac.uk/user/s10/s1022587/megalogo.png"));
		label.setBounds(47, 12, 422, 159);
		frmControlPanel.getContentPane().add(label);
		
		dribble.setBackground(new Color(119, 136, 153));
		dribble.setBounds(12, 183, 118, 53);
		frmControlPanel.getContentPane().add(dribble);
		
		nav.setBackground(new Color(119, 136, 153));
		nav.setBounds(166, 183, 118, 53);
		frmControlPanel.getContentPane().add(nav);
		
		lblPanelColour.setForeground(new Color(119, 136, 153));
		lblPanelColour.setBackground(new Color(119, 136, 153));
		lblPanelColour.setBounds(12, 12, 100, 15);
		frmControlPanel.getContentPane().add(lblPanelColour);
		
		yellow.setForeground(new Color(255, 255, 0));
		yellow.setBackground(new Color(119, 136, 153));
		yellow.setBounds(12, 26, 79, 23);
		frmControlPanel.getContentPane().add(yellow);
		
		blue.setForeground(new Color(0, 0, 255));
		blue.setBackground(new Color(119, 136, 153));
		blue.setBounds(12, 53, 79, 23);
		frmControlPanel.getContentPane().add(blue);

		lblPitch.setForeground(new Color(119, 136, 153));
		lblPitch.setBackground(new Color(119, 136, 153));
		lblPitch.setBounds(12, 84, 100, 15);
		frmControlPanel.getContentPane().add(lblPitch);
		
		main.setBackground(new Color(119, 136, 153));
		main.setBounds(12, 107, 79, 23);
		frmControlPanel.getContentPane().add(main);
		
		side.setBackground(new Color(119, 136, 153));
		side.setBounds(12, 132, 79, 23);
		frmControlPanel.getContentPane().add(side);
				
		quit.setBackground(new Color(119, 136, 153));
		quit.setBounds(316, 183, 118, 53);
		frmControlPanel.getContentPane().add(quit);
		frmControlPanel.setBounds(100, 100, 450, 300);
		frmControlPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup colours = new ButtonGroup();
		colours.add(yellow);
		colours.add(blue);
		
		ButtonGroup pitches = new ButtonGroup();
		pitches.add(main);
		pitches.add(side);
		
	}
	
	

	public void action(){		
		dribble.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dribble...");
			    r.dribble(30);
				
			}
			
		});
		
		nav.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Navigating...");	
				Runner run = new Runner();
								
			}
		});
		
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quit...");
				r.quit();
				System.exit(0);
			}
		});
		
		yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				colour = true;
			}
		});
		
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				colour = false;
			}
		});
		
		main.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				pitch = 0;
			}
		});
		
		side.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				pitch = 1;
			}
		});
		
	}
	
	public class ListenCloseWdw extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			r.quit();
			System.exit(0);
		}
	}
	
	public void launch(){
				frmControlPanel.setVisible(true);
	}
	
	
	
	
	
}

