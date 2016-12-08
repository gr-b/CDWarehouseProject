import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBackController implements ActionListener {

	private Main main;
	private Model m;
	
	public GoBackController(Main main, Model m){
		this.main = main;
		this.m = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//main.contentXMLPane = new ContentXML(m, main);
		//main.setVisible(false);
		//main.dispose();
		
		if(m.selectedGenre == null){
			
		} else if(m.selectedGenre != null && m.selectedArtist == null){
			m.selectedGenre = null;
		} else if(m.selectedGenre != null && m.selectedArtist != null){
			m.selectedArtist = null;
		}
		main.init(m.username, m);
		main.revalidate();
		main.repaint();
		
//		m.selectedGenre = null;
//		m.selectedArtist = null;
		
		
		//main = new Main(m.username, m);
		/*main.getContentPane().removeAll();
		main.init(m.username, m);
		main.revalidate();
		main.repaint();
		*/
		
		
		
		
	}

}
