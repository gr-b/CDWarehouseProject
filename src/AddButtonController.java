import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddButtonController implements ActionListener{

	private JButton source;
	private Cd cd;
	private Model m;
	
	public AddButtonController(JButton source, Cd cd, Model m){
		this.source = source;
		this.cd = cd;
		this.m = m;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println(source.getText());
		if(!source.getText().equals("Add to Cart!")){
			CDModel newCD = m.getCDModelWithTitle(cd.title);
		
			m.addToWishlist(newCD);
		}
		
		this.source.setText("Added!");
		this.source.setEnabled(false);
		
		
		
		
	}

}
