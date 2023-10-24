import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MenuWindow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow window = new MenuWindow();
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
	public MenuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel MenuTitle = new JLabel("Menu Selection");
		MenuTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		MenuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		MenuTitle.setBounds(472, 11, 312, 132);
		frame.getContentPane().add(MenuTitle);
		
		JButton JobsButton = new JButton("Jobs / Internships");
		JobsButton.addActionListener(new JobsButton());
		JobsButton.setFont(new Font("Arial", Font.PLAIN, 22));
		JobsButton.setBounds(581, 154, 248, 102);
		frame.getContentPane().add(JobsButton);
		
		JButton QuestionsButton = new JButton("Practice Questions");
		QuestionsButton.addActionListener(new QuestionsWindow());
		QuestionsButton.setFont(new Font("Arial", Font.PLAIN, 22));
		QuestionsButton.setBounds(581, 280, 248, 102);
		frame.getContentPane().add(QuestionsButton);
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new LogOut());
		logOutBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		logOutBtn.setBounds(581, 534, 248, 95);
		frame.getContentPane().add(logOutBtn);
		
		JButton calendarBtn = new JButton("Calendar");
		calendarBtn.addActionListener(new CalendarWindow());
		calendarBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		calendarBtn.setBounds(581, 407, 248, 102);
		frame.getContentPane().add(calendarBtn);
		
		JLabel jobPicLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/suitcase.png")).getImage();
		jobPicLabel.setIcon(new ImageIcon(img1));
		jobPicLabel.setBounds(416, 154, 107, 82);
		frame.getContentPane().add(jobPicLabel);
		
		JLabel questPicLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/ask.png")).getImage();
		questPicLabel.setIcon(new ImageIcon(img2));
		questPicLabel.setBounds(416, 291, 124, 88);
		frame.getContentPane().add(questPicLabel);
		
		JLabel calendarPicLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/calendar.png")).getImage();
		calendarPicLabel.setIcon(new ImageIcon(img3));
		calendarPicLabel.setBounds(416, 421, 117, 88);
		frame.getContentPane().add(calendarPicLabel);
		
		JLabel logOutPicLabel = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		logOutPicLabel.setIcon(new ImageIcon(img4));
		logOutPicLabel.setBounds(416, 547, 124, 82);
		frame.getContentPane().add(logOutPicLabel);
	}
	
	private class JobsButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			TrackerWindow userinfo;
			try {
				userinfo = new TrackerWindow();
				userinfo.frame.setVisible(true);
				userinfo.frame.setLocationRelativeTo(null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	private class QuestionsWindow implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			JavaOrC userQ = new JavaOrC();
			userQ.frame.setVisible(true);
			userQ.frame.setLocationRelativeTo(null);
		}
		
	}
	
	
	private class LogOut implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String URL = "jdbc:sqlite:/C:bin\\login.db";
			frame.dispose();
			Main login;
			try {
				login = new Main();
				login.frame.setVisible(true);
				login.frame.setLocationRelativeTo(null);
				Connection con = DriverManager.getConnection(URL);
				Statement st = con.createStatement();
				String query = "UPDATE USER SET active = '0' WHERE active = '1'";
				st.executeUpdate(query);
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	private class CalendarWindow implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			Calendar user = new Calendar();
			user.frame.setVisible(true);
			user.frame.setLocationRelativeTo(null);
		}
		
	}
}