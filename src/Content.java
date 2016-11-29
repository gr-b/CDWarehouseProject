import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Content extends JPanel {

	public String name;
	/**
	 * Create the panel.
	 */
	public Content(String name) {
		setLayout(null);
		
		JLabel lblSelectAGenre = new JLabel("Select a Genre:");
		lblSelectAGenre.setBounds(148, 5, 114, 14);
		add(lblSelectAGenre);
		
		JButton btnNewButton = new JButton("Classical");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(53, 30, 89, 23);
		add(btnNewButton);
		
		JButton btnEarly = new JButton("Early");
		btnEarly.setBounds(173, 30, 89, 23);
		add(btnEarly);
		
		JButton btnFolk = new JButton("Folk");
		btnFolk.setBounds(305, 30, 89, 23);
		add(btnFolk);
		
		JButton btnNewButton_1 = new JButton("World");
		btnNewButton_1.setBounds(53, 84, 89, 23);
		add(btnNewButton_1);
		
		JButton btnBlues = new JButton("Blues");
		btnBlues.setBounds(173, 84, 89, 23);
		add(btnBlues);
		
		JButton btnJazz = new JButton("Jazz");
		btnJazz.setBounds(305, 84, 89, 23);
		add(btnJazz);
		
		JButton btnNewButton_2 = new JButton("Rap");
		btnNewButton_2.setBounds(53, 138, 89, 23);
		add(btnNewButton_2);
		
		JButton btnRock = new JButton("Rock");
		btnRock.setBounds(173, 138, 89, 23);
		add(btnRock);
		
		JButton btnAlternative = new JButton("Alternative");
		btnAlternative.setBounds(305, 138, 89, 23);
		add(btnAlternative);

	}
}
