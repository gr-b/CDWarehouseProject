import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class ContentXML extends JPanel {

	/**
	 * Create the panel.
	 */
	Model m;
	JLabel nav;
	//private Object ;
	private Main main;
	
	public ContentXML(Model m, Main main, JLabel nav) {
		m.printCDs();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.m = m;
		this.main = main;
		this.nav= nav;
		
		//this.nav = new JLabel("All CDs->");
		//add(nav);
		//addSelection("genre");
		if(m.selectedGenre != null){
			addSelection(m.selectedGenre);
		}
		if(m.selectedArtist != null){
			addSelection(m.selectedArtist);
		}
		//m.prevSelection = "genre";
		
		/*ArrayList<String> items = new ArrayList<String>();
		if(selection.equals("genre")){
			items = m.getGenres();
		}
		System.out.println("Selected: " + items.toString());
		
		for(String item : items){
			JButton newItemButton = new JButton(item);
			newItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			newItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton selected = (JButton)e.getSource();
					ContentXML pane = ((ContentXML) selected.getParent() );
					pane.removeAll();
					pane.addSelection(selected.getText());
					pane.repaint();
					
					//pane = new ContentXML(m, selected.getText());
					
				}

			});
			add(newItemButton);
		}*/

	}

	public void addSelection(String selection) {
		ArrayList<String> items = new ArrayList<String>();
		if(selection.equals("genre")){
			items = m.getGenres();
			//System.out.println("!!!!!!!!!!!!!!!!!!!!");
		} else {
			items = m.constrainBySelection(selection);
		}
		items.sort(new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareToIgnoreCase(b);
			}
		});
		System.out.println("Selected: " + items.toString());
		
		for(String item : items){
			if(m.selectedArtist == null){
				JButton newItemButton = new JButton(item);
				newItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				newItemButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton selected = (JButton)e.getSource();
						ContentXML pane = ((ContentXML) selected.getParent() );
						pane.removeAll();
						
						if(m.selectedGenre == null) m.selectedGenre = selected.getText();
						else m.selectedArtist = selected.getText();
						
						pane.addNavLabel();
						pane.addSelection(selected.getText());
						m.prevSelection = selected.getText();
						
						pane.revalidate();
						pane.repaint();
						//pane.getParent().getParent().repaint();
					
						//pane = new ContentXML(m, selected.getText());
					
					}

				});
				add(newItemButton);
			} else { // An artist has been selected
				// Add a Cd pane.
				CDModel toAdd = m.getCD(item);
				//System.out.println(toAdd.name);
				add(new Cd(toAdd.name, "dfse", true, m));
				
				
			}
			
		}
		
		
	}

	protected void addNavLabel() {
		String text = "All CDs -> ";
		if(m.selectedGenre != null) text += m.selectedGenre + " -> ";
		if(m.selectedArtist != null) text += m.selectedArtist;
		nav.setText(text);
		
		//JPanel navPanel = new JPanel();
		//navPanel.add(nav);
		
		//navPanel.add(goBack);
		//add(navPanel);
	}

}
