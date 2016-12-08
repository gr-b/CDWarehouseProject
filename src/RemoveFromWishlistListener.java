
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class RemoveFromWishlistListener implements ActionListener {

	private String title;
	private Model m;
	private Cd cd;
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		m.removeCDFromWishlistWithTitle(title);
		
		Container parent = cd.getParent();
		
		parent.remove(cd);
		if(parent.getComponents().length == 0){
			Wishlist w = (Wishlist)SwingUtilities.getWindowAncestor(parent);
			w.addNoCds((JPanel)parent);
		}
		parent.revalidate();
		parent.repaint();
	}
	
	RemoveFromWishlistListener(Model m, String title, Cd cd){
		this.title = title;
		this.m = m;
		this.cd = cd;
	}

}
