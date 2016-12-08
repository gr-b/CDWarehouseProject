import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class Wishlist extends JFrame {

	private JPanel contentPane;
	public ArrayList<Cd> cds;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Wishlist frame = new Wishlist();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Wishlist(ArrayList<Cd> cds) {
		//setDefaultCloseOperation(defaultCloseOperation);
		this.cds = cds;
		init(cds);
		
	}
	
	public void init(ArrayList<Cd> cds){
		setBounds(100, 100, Main.width, Main.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		
		JLabel lblWishlist = new JLabel("Wishlist");
		panel.add(lblWishlist);
		
		JPanel panel_1 = new JPanel();
		
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		panel_1.add(btnDone);
		
		
		
		JPanel panel_2 = new JPanel();
		
		JButton goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				dispose();
			}
			
		});
		
		
		if(cds.size() == 0){
			addNoCds(panel_2);
			
			//panel_2.add(goBack);
			
		}
		
		//contentPane.add(panel_2, BorderLayout.CENTER);
		JScrollPane scrollPanel = new JScrollPane(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
	
		cds.sort(new Comparator<Cd>(){
			public int compare(Cd a, Cd b){
				return a.title.compareToIgnoreCase(b.title);
			}
		});
		
		for(Cd cd : cds){
			panel_2.add(cd);
		}
		
		//panel_2.add(goBack);
		
		//scrollPanel.add(panel_2, BorderLayout.CENTER);
		
		scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//panel_2.add(scrollPanel);
		contentPane.add(scrollPanel, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		JPanel bottomBar = new JPanel();
		bottomBar.setLayout(new BoxLayout(bottomBar, BoxLayout.Y_AXIS));
		JLabel hoverLbl = new JLabel("Hover over a cd to see more information");
		hoverLbl.setHorizontalAlignment(JLabel.CENTER);
		bottomBar.add(hoverLbl);
		
		
		bottomBar.add(panel_1);
		
		contentPane.add(bottomBar, BorderLayout.SOUTH);
		
		
	}

	public void addNoCds(JPanel parent) {
		// TODO Auto-generated method stub
		JLabel noCds = new JLabel("You have no CDs on your wishlist.");
		parent.add(noCds);
		noCds.setHorizontalAlignment(JLabel.CENTER);
	}

}
