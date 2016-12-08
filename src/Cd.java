import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class Cd extends JPanel {

	public String title;
	public String name;
	public boolean inWishlist;
	public Model m;
	private Wishlist w;
	
	/**
	 * Create the panel.
	 */
	public Cd(String title, String name, boolean inWishlist, Model m) {
		this.inWishlist = inWishlist;
		this.title = title;
		this.m = m;
		
		setFocusTraversalPolicyProvider(true);
		
		CDModel cd = m.getCDModelWithTitle(title);
		
		JLabel lblTitleTitle = new JLabel(title);
		//lblTitleTitle.addMouseListener(new TitleHoverListener(lblTitleTitle, cd));
		
		String tip = "Artist: " + cd.artist + " | Genre: " + cd.genre;
		lblTitleTitle.setToolTipText(tip);
		
		JButton btnBuyNow = new JButton("Add to Cart!");
		btnBuyNow.addActionListener(new AddButtonController(btnBuyNow, this, m));
		btnBuyNow.setToolTipText(tip);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(lblTitleTitle);
		add(btnBuyNow);
		//if(!name.equals("Guest")){
		//System.out.println(inWishlist);
		
			
		
		if(inWishlist){
			JButton btnAddToWishlist = new JButton("Add to wishlist");
			
			btnAddToWishlist.addActionListener(new AddButtonController(btnAddToWishlist, this, m));
			btnAddToWishlist.setEnabled(!m.wishlist.contains(m.getCDModelWithTitle(title)));
			btnAddToWishlist.setToolTipText(tip);
			add(btnAddToWishlist);
			
			if(m.username.equals("Guest")){
				btnAddToWishlist.setText("Log in to add to wishlist");
				btnAddToWishlist.setEnabled(false);
			}
		//}
		} else {
			// We are in the wishlist, let them remove it.
			JButton remove = new JButton("Remove from list");
			remove.addActionListener(new RemoveFromWishlistListener(m, this.title, this));
			add(remove);
			
		}
		

	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
