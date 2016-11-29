import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class Wishlist2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wishlist2 frame = new Wishlist2();
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
	public Wishlist2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNamesWishlist = new JLabel("name's Wishlist:");
		panel.add(lblNamesWishlist);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		panel_1.add(btnBack);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 0, 17, 194);
		panel_2.add(scrollBar);
		
		JLabel lblAveMaria = new JLabel("Ave Maria");
		lblAveMaria.setBounds(47, 0, 78, 14);
		panel_2.add(lblAveMaria);
		
		JLabel lblClassical = new JLabel("Classical");
		lblClassical.setBounds(185, 0, 46, 14);
		panel_2.add(lblClassical);
		
		JLabel lblBach = new JLabel("Bach");
		lblBach.setBounds(335, 0, 46, 14);
		panel_2.add(lblBach);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setBounds(94, 30, 89, 23);
		panel_2.add(btnBuyNow);
		
		JButton btnRemoveFromList = new JButton("Remove");
		btnRemoveFromList.setBounds(246, 34, 89, 14);
		panel_2.add(btnRemoveFromList);
	}

}
