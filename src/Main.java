import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Model m;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main("null", new Model());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main(String name, Model m) {
		
		XMLParser x = new XMLParser(m);
		x.parse("samplexml");
		// GUI code:
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the warehouse, " + name + "!");
		panel.add(lblWelcomeToThe);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		if(!name.equals("Guest")){
			JButton btnClickHereTo = new JButton("Click here to access your wishlist");
			btnClickHereTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Cd> wishCds = new ArrayList<Cd>();
					for(CDModel cd : m.wishlist){
						wishCds.add(new Cd(cd.name, name));
					}
					new Wishlist(wishCds).setVisible(true);
				}
			});
			panel_1.add(btnClickHereTo);
		}
		
		
		
		JPanel contentXMLPane = new ContentXML(m);
		JScrollPane panel_2 = new JScrollPane();
		panel_2.setViewportView(contentXMLPane);
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		//Cd cd = new Cd((String) null);
		//panel_2.add(cd);
		
		//Cd cd_1 = new Cd((String) null);
		//panel_2.add(cd_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel_1.add(btnExit);
	}

}
