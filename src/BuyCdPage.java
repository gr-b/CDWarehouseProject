import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class BuyCdPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyCdPage frame = new BuyCdPage();
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
	public BuyCdPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the warehouse, name!");
		panel.add(lblWelcomeToThe);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 0, 17, 194);
		panel_1.add(scrollBar);
		
		JLabel lblClassicalBach = new JLabel("Classical -> Bach");
		lblClassicalBach.setBounds(27, 11, 370, 14);
		panel_1.add(lblClassicalBach);
		
		JLabel lblAveMaria = new JLabel("Ave Maria");
		lblAveMaria.setBounds(27, 36, 88, 14);
		panel_1.add(lblAveMaria);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setBounds(125, 32, 89, 23);
		panel_1.add(btnBuyNow);
		
		JButton btnAddToWishlist = new JButton("Add to Wishlist");
		btnAddToWishlist.setBounds(224, 32, 119, 23);
		panel_1.add(btnAddToWishlist);
		
		JButton button = new JButton("Buy Now");
		button.setBounds(125, 66, 89, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Add to Wishlist");
		button_1.setBounds(224, 66, 119, 23);
		panel_1.add(button_1);
		
		JLabel lblMagnificat = new JLabel("Magnificat");
		lblMagnificat.setBounds(27, 70, 88, 14);
		panel_1.add(lblMagnificat);
		
		JButton button_2 = new JButton("Buy Now");
		button_2.setBounds(125, 100, 89, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Add to Wishlist");
		button_3.setBounds(224, 100, 119, 23);
		panel_1.add(button_3);
		
		JLabel lblCelloSuites = new JLabel("Cello Suites");
		lblCelloSuites.setBounds(27, 104, 88, 14);
		panel_1.add(lblCelloSuites);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnYourWishlist = new JButton("Your Wishlist");
		panel_2.add(btnYourWishlist);
		
		JButton btnExi = new JButton("Exit");
		panel_2.add(btnExi);
	}
}
