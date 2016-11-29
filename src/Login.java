import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	Model m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		m = new Model();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the CD Warehouse!");
		panel.add(lblWelcomeToThe);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(106, 8, 86, 14);
		panel_2.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(197, 5, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 33, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(106, 33, 86, 14);
		panel_2.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateWishlist(textField.getText());
				Main myMain = new Main(textField.getText(), m);
				myMain.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		panel_1.add(btnLogin);
		
		
		JButton btnContinueAsGuest = new JButton("Continue as Guest");
		btnContinueAsGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main myMain = new Main("Guest", m);
				myMain.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		panel_1.add(btnContinueAsGuest);
		
		
	}

	protected void updateWishlist(String username) {
		new XMLParser(m).parse(username);
	}
}
