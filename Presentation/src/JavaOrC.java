import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class JavaOrC {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaOrC window = new JavaOrC();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaOrC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton javaBtn = new JButton("Java");
		javaBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		javaBtn.addActionListener(new JavaQ());
		javaBtn.setBounds(563, 233, 284, 89);
		frame.getContentPane().add(javaBtn);
		
		JButton cBtn = new JButton("C++");
		cBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		cBtn.addActionListener(new CplusplusQ());
		cBtn.setBounds(563, 365, 284, 89);
		frame.getContentPane().add(cBtn);
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		mainMenuBtn.addActionListener(new MainMenu());
		mainMenuBtn.setBounds(486, 505, 284, 89);
		frame.getContentPane().add(mainMenuBtn);
		
		JLabel langBtn = new JLabel("Choose Language");
		langBtn.setFont(new Font("Arial", Font.BOLD, 30));
		langBtn.setBounds(497, 108, 289, 71);
		frame.getContentPane().add(langBtn);
		
		JLabel javaPicLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/java.png")).getImage();
		javaPicLabel.setIcon(new ImageIcon(img1));
		javaPicLabel.setBounds(398, 233, 112, 89);
		frame.getContentPane().add(javaPicLabel);
		
		JLabel cPlusPlusPicLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/c-.png")).getImage();
		cPlusPlusPicLabel.setIcon(new ImageIcon(img2));
		cPlusPlusPicLabel.setBounds(398, 365, 112, 89);
		frame.getContentPane().add(cPlusPlusPicLabel);
	}
	
	private class JavaQ implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			QuestionsJava java = new QuestionsJava();
			java.frame.setVisible(true);
		}
		
	}
	
	private class CplusplusQ implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			QuestionsC cplusplus = new QuestionsC();
			cplusplus.frame.setVisible(true);
		}
		
	}
	
	private class MainMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			MenuWindow menu = new MenuWindow();
			menu.frame.setVisible(true);
		}
		
	}
}
