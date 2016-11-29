import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class Cd extends JPanel {

	public String title;
	public String name;
	/**
	 * Create the panel.
	 */
	public Cd(String title, String name) {
		this.title = title;
		
		setFocusTraversalPolicyProvider(true);
		
		JLabel lblTitleTitle = new JLabel("Title: " + title);
		
		JButton btnBuyNow = new JButton("Buy Now");
		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(lblTitleTitle);
		add(btnBuyNow);
		//if(!name.equals("Guest")){
			JButton btnAddToWishlist = new JButton("Add to wishlist");
			add(btnAddToWishlist);
		//}
		

	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
