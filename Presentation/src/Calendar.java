import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class Calendar {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar window = new Calendar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calendar() {
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
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 11, 1228, 545);
		frame.getContentPane().add(calendar);
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		mainMenuBtn.addActionListener(new MainMenu());
		mainMenuBtn.setBounds(1030, 570, 208, 89);
		frame.getContentPane().add(mainMenuBtn);
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
