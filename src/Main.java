import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	public JPanel contentXMLPane;
	public JLabel nav;
	
	public static final int width = 750;
	public static final int height = 500;

	/**
	 * Launch the application.
	 */
	Model m;
	
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public Main(String name, Model m) {
		
		init(name, m);
	}
	
	public void init(String name, Model m){
		if(!m.hasAlreadyParsed){
			//System.out.println("Parsing!!!!");
			
			try {
				XMLParser x = new XMLParser(m);
				x.parse("samplexml");
			} catch (FileNotFoundException | XMLStreamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			m.hasAlreadyParsed = true;
		}
		// GUI code:
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the warehouse, " + name + "!");
		lblWelcomeToThe.setFont(new Font(lblWelcomeToThe.getFont().getName(), Font.PLAIN, 30));
		panel.add(lblWelcomeToThe, BorderLayout.NORTH);
		lblWelcomeToThe.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		this.nav = new JLabel("All CDs->");
		nav.setFont(new Font(nav.getFont().getName(), Font.PLAIN, 25));
		nav.setHorizontalAlignment(JLabel.CENTER);
		panel.add(nav, BorderLayout.SOUTH);
		
		
		
		/*JLabel nav = new JLabel("All CDs ->");
		JPanel navPanel = new JPanel();
		navPanel.add(nav);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		*/
		
		JPanel panel_1 = new JPanel();
		//contentPane.add(panel_1, BorderLayout.SOUTH);
		
		if(!name.equals("Guest")){
			JButton btnClickHereTo = new JButton("Click here to access your wishlist");
			btnClickHereTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Cd> wishCds = new ArrayList<Cd>();
					for(CDModel cd : m.wishlist){
						wishCds.add(new Cd(cd.name, name, false, m));
					}
					new Wishlist(wishCds).setVisible(true);
				}
			});
			panel_1.add(btnClickHereTo);
		}
		
		
		
		contentXMLPane = new ContentXML(m, this, nav);
		if(m.selectedGenre == null){
			((ContentXML) contentXMLPane).addSelection("genre");
		}
		JScrollPane panel_2 = new JScrollPane();
		panel_2.setViewportView(contentXMLPane);
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		//Cd cd = new Cd((String) null);
		//panel_2.add(cd);
		
		//Cd cd_1 = new Cd((String) null);
		//panel_2.add(cd_1);
		
		JButton btnCheckout = new JButton("(Checkout)");
		panel_1.add(btnCheckout);
		JButton search = new JButton("(Search)");
		panel_1.add(search);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		JPanel navPanel = new JPanel();
		navPanel.setLayout(new BorderLayout(0,0)); 
		
		JButton goBack = new JButton("Back");
		goBack.addActionListener(new GoBackController(this, m));
		navPanel.add(goBack, BorderLayout.CENTER);
		navPanel.add(panel_1, BorderLayout.SOUTH);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		
		panel_1.add(btnExit);
	}

}
