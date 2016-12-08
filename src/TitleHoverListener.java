import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class TitleHoverListener implements MouseListener {

	private CDModel cd;
	private JLabel label;
	
	public TitleHoverListener(JLabel lblTitleTitle, CDModel cd){
		this.label = lblTitleTitle;
		this.cd = cd;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Show the Artist and genre in the label
		this.label.setText(cd.name + "|" + cd.artist + "|" + cd.genre);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// change the text back
		label.setText(cd.name);

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
