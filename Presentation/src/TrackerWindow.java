import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TrackerWindow {

	JFrame frame;
	private JTable table;
	private JTextField EntryTextField;
	private JTextField CompanyTextField;
	private JTextField RoleTextField;
	private JTextField SalaryTextField;
	private JTextField AppliedTextField;
	private JTextField InterviewTextField;
	private JTextField StatusTextField;
	private JCheckBox RemoteCheckBox;
	private DefaultTableModel dm;
	private Object[] columnNames = {"Entry", "Company", "Role", "Salary", "Date Applied", "Interview Date", "Status", "Location", "Remote"};
	private final int COLUMN_SIZE = 9;
	private static Connection con;
	String URL = "jdbc:sqlite:bin\\trackers.db"; // // URL to be used in making our connection. Jdbc is our protocol. Sqlite is our subprotocol. And the rest is our path
	private JTextField LocationTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ADD THROWS ANYWHERE U ARE ACCESSING A DATABASE
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TrackerWindow() throws SQLException
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		
		// In case our database/table does not exist we will create it with this try catch statement
		try
		{
			con = DriverManager.getConnection(URL);
			Statement st = con.createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS tracks" // Our table will be named product
					+ "(Entry INT PRIMARY KEY,"
					+ "Company VARCHAR,"
					+ "Role VARCHAR,"
					+ "Salary INT,"
					+ "Applied VARCHAR,"
					+ "Interview VARCHAR,"
					+ "Status VARCHAR,"
					+ "Location VARCHAR,"
					+ "Remote VARCHAR);"); // END OF EXECUTE
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		frame = new JFrame();
		
		// When we close our window close the connection too
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try
				{
					con.close();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		/////////////////////////////////////////////////////
		
		frame.setBounds(100, 100, 1056, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 34, 971, 248);
		frame.getContentPane().add(scrollPane);
		
		//     WHERE OUR TABLE STARTS     //
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		ResultSet rs = Search.searchAll(); // Statically call our searchAll method
		ResultSet rss = Search.searchAll();

		int j = 0;
		while(rss.next())
		{
			j++;
		}
		
		System.out.println(j);

		
		
		// If 10 errors are caused
		Object[][] rows = new Object[j][COLUMN_SIZE];
		
		
		// What will be populating our rows
		int i = 0;
		while(rs.next())
		{
			rows[i][0] = rs.getString("ENTRY");
			rows[i][1] = rs.getString("COMPANY");
			rows[i][2] = rs.getString("ROLE");
			rows[i][3] = rs.getString("SALARY");
			rows[i][4] = rs.getString("APPLIED");
			rows[i][5] = rs.getString("INTERVIEW");
			rows[i][6] = rs.getString("STATUS");
			rows[i][7] = rs.getString("LOCATION");
			rows[i][8] = rs.getString("REMOTE");
			i++;
		}
		
		dm = new DefaultTableModel(rows, columnNames);
		table.setModel(dm); // 
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(472, 149, 17, 48);
		frame.getContentPane().add(scrollBar);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchBtn.addActionListener(new Search()); // Implements our Search class function when button pressed
		searchBtn.setBounds(67, 331, 89, 23);
		frame.getContentPane().add(searchBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.addActionListener(new Delete()); // Delete on button press
		deleteBtn.setBounds(178, 331, 89, 23);
		frame.getContentPane().add(deleteBtn);
		
		JButton addBtn = new JButton("Add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addBtn.addActionListener(new Add()); // Add on button press
		addBtn.setBounds(287, 331, 89, 23);
		frame.getContentPane().add(addBtn);
		
		JButton editBtn = new JButton("Edit");
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editBtn.setBounds(400, 331, 89, 23);
		frame.getContentPane().add(editBtn);
		
		JButton mainBtn = new JButton("MainMenu");
		mainBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mainBtn.setBounds(513, 331, 89, 23);
		frame.getContentPane().add(mainBtn);
		
		EntryTextField = new JTextField();
		EntryTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EntryTextField.setBounds(126, 383, 96, 20);
		frame.getContentPane().add(EntryTextField);
		EntryTextField.setColumns(10);
		
		CompanyTextField = new JTextField();
		CompanyTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CompanyTextField.setBounds(126, 429, 96, 20);
		frame.getContentPane().add(CompanyTextField);
		CompanyTextField.setColumns(10);
		
		RoleTextField = new JTextField();
		RoleTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RoleTextField.setBounds(299, 383, 96, 20);
		frame.getContentPane().add(RoleTextField);
		RoleTextField.setColumns(10);
		
		SalaryTextField = new JTextField();
		SalaryTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SalaryTextField.setBounds(299, 429, 96, 20);
		frame.getContentPane().add(SalaryTextField);
		SalaryTextField.setColumns(10);
		
		AppliedTextField = new JTextField();
		AppliedTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AppliedTextField.setBounds(484, 383, 96, 20);
		frame.getContentPane().add(AppliedTextField);
		AppliedTextField.setColumns(10);
		
		InterviewTextField = new JTextField();
		InterviewTextField.setBounds(484, 429, 96, 20);
		frame.getContentPane().add(InterviewTextField);
		InterviewTextField.setColumns(10);
		
		StatusTextField = new JTextField();
		StatusTextField.setBounds(660, 429, 96, 20);
		frame.getContentPane().add(StatusTextField);
		StatusTextField.setColumns(10);
		
		RemoteCheckBox = new JCheckBox("Remote");
		RemoteCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RemoteCheckBox.setBounds(782, 428, 99, 23);
		frame.getContentPane().add(RemoteCheckBox);
		
		JLabel entryLabel = new JLabel("    Entry");
		entryLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		entryLabel.setBounds(67, 386, 49, 14);
		frame.getContentPane().add(entryLabel);
		
		JLabel companyLabel = new JLabel("Company");
		companyLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		companyLabel.setBounds(61, 432, 55, 14);
		frame.getContentPane().add(companyLabel);
		
		JLabel roleLabel = new JLabel("     Role");
		roleLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		roleLabel.setBounds(240, 386, 49, 14);
		frame.getContentPane().add(roleLabel);
		
		JLabel SalaryLabel = new JLabel("  Salary");
		SalaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SalaryLabel.setBounds(240, 432, 49, 14);
		frame.getContentPane().add(SalaryLabel);
		
		JLabel appliedLabel = new JLabel("Applied");
		appliedLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		appliedLabel.setBounds(425, 385, 49, 14);
		frame.getContentPane().add(appliedLabel);
		
		JLabel interviewLabel = new JLabel("Interview");
		interviewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		interviewLabel.setBounds(412, 431, 62, 14);
		frame.getContentPane().add(interviewLabel);
		
		JLabel statusLabel = new JLabel("   Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		statusLabel.setBounds(601, 431, 49, 14);
		frame.getContentPane().add(statusLabel);
		
		JLabel locationLabel = new JLabel("  Location");
		locationLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		locationLabel.setBounds(590, 386, 60, 14);
		frame.getContentPane().add(locationLabel);
		
		LocationTextField = new JTextField();
		LocationTextField.setColumns(10);
		LocationTextField.setBounds(660, 383, 96, 20);
		frame.getContentPane().add(LocationTextField);
	}
	
	private class Search implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			ResultSet rss = Search.searchAll();
			
			int j = 0;
			try {
				while(rss.next())
				{
					j++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			ResultSet rs = searchAll(); // Gives us everything inside ResultSet
			Object[][] rows = new Object[j][COLUMN_SIZE];
			
//			String Entry = EntryTextField.getText();
//			String Company = CompanyTextField.getText();
//			String Role = RoleTextField.getText();
//			String Salary = SalaryTextField.getText();
//			String Applied = AppliedTextField.getText();
//			String Interview = InterviewTextField.getText();
//			String Status = StatusTextField.getText();
//			String Location = LocationTextField.getText();
//			
//			boolean checked = RemoteCheckBox.isSelected();
			
			// If the user did not input anything on any field when clicking search
//			if(Entry.isEmpty() && Company.isEmpty() && Role.isEmpty() && Salary.isEmpty() && Applied.isEmpty() && Interview.isEmpty() && Status.isEmpty() && Location.isEmpty() && checked == false)
//			{
			
				// What will be populating our rows
				int i = 0;
				
				try 
				{
					while(rs.next())
					{
						rows[i][0] = rs.getString("ENTRY");
						rows[i][1] = rs.getString("COMPANY");
						rows[i][2] = rs.getString("ROLE");
						rows[i][3] = rs.getString("SALARY");
						rows[i][4] = rs.getString("APPLIED");
						rows[i][5] = rs.getString("INTERVIEW");
						rows[i][6] = rs.getString("STATUS");
						rows[i][7] = rs.getString("LOCATION");
						rows[i][8] = rs.getString("REMOTE");
						i++;
					}
					// Changes the 
					dm.setDataVector(rows, columnNames);
					dm.fireTableDataChanged();
					
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
//			}
			
			// Else if the user input only Entry
			
			// Else if the user input only Company
			
			// Else if the user input only Role
			
			// Else if the user input only Salary
			
			// Else if the user input only Applied
			
			// Else if the user input only Interview
			
			// Else if the user input only Status
			
			// Else if the user input only Location
			
			// Else if the user input only Remote

			// Else the user input more than one thing. Just a general catch all statement. We'll display an JOptionPane
		}
		
		public static ResultSet searchAll() 
		{
			// Url we need to connect to our database. Jdbc is our protocol. Sqlite is our subprotocol. And the rest is our path
			// Our full path in case needed | /C:\\Users\\chikipichi\\eclipse-workspace\\Group Project\\bin\\carmax.db
			String url = "jdbc:sqlite:bin\\trackers.db";
			
			try
			{
				Connection con = DriverManager.getConnection(url); // Create a link to connect to our database
				Statement st = con.createStatement(); // Create a link to our database so we can send query
				String query = "SELECT * FROM tracks"; // The query we are going to send to our database
				ResultSet rs = st.executeQuery(query);
				return rs;
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}	
			
			return null; // If we were not able to return the ResultSet return null
	
		}
		
	} // END OF SEARCH CLASS
	
	
	private class Delete implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// Url we need to connect to our database. Jdbc is our protocol. Sqlite is our subprotocol. And the rest is our path
			// Our full path in case needed | /C:\\Users\\chikipichi\\eclipse-workspace\\Lab14\\bin\\carmax.db
			String url = "jdbc:sqlite:bin\\trackers.db";
			
			try
			{
				Connection con = DriverManager.getConnection(url); // Create a link to connect to our database
				Statement st = con.createStatement(); // Create a link to our database so we can send query
				String query = "DELETE FROM tracks where ENTRY = ('"+EntryTextField.getText()+"');"; // How we delete in SQL. cars is the table in our carmax.db
				st.execute(query);
				
				
				refresh();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		}
		
		public void refresh() throws SQLException
		{
			
			ResultSet rss = Search.searchAll();
			
			int j = 0;
			while(rss.next())
			{
				j++;
			}
			
			ResultSet rs = Search.searchAll(); // Gives us everything inside ResultSet
			Object[][] rows = new Object[j][COLUMN_SIZE];
			
			// What will be populating our rows
			int i = 0;
			
				try 
				{
					while(rs.next())
					{
						rows[i][0] = rs.getString("ENTRY");
						rows[i][1] = rs.getString("COMPANY");
						rows[i][2] = rs.getString("ROLE");
						rows[i][3] = rs.getString("SALARY");
						rows[i][4] = rs.getString("APPLIED");
						rows[i][5] = rs.getString("INTERVIEW");
						rows[i][6] = rs.getString("STATUS");
						rows[i][7] = rs.getString("LOCATION");
						rows[i][8] = rs.getString("REMOTE");
						i++;
					}
					// Changes the 
					dm.setDataVector(rows, columnNames);
					dm.fireTableDataChanged();
					
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}	
		}
		
	}
	
	private class Add implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// Url we need to connect to our database. Jdbc is our protocol. Sqlite is our subprotocol. And the rest is our path
			// Our full path in case needed | /C:\\Users\\chikipichi\\eclipse-workspace\\Group Project\\bin\\carmax.db
			String url = "jdbc:sqlite:bin\\trackers.db";
			
			// Get our values to get added, make sure to parse accordingly
			
			int Entry = Integer.parseInt(EntryTextField.getText());
			String Company = CompanyTextField.getText();
			String Role = RoleTextField.getText();
			int Salary = Integer.parseInt(SalaryTextField.getText());
			String Applied = AppliedTextField.getText();
			String Interview = InterviewTextField.getText();
			String Status = StatusTextField.getText();
			String Location = LocationTextField.getText();
			
			boolean checked = RemoteCheckBox.isSelected();
			
			try
			{
				Connection con = DriverManager.getConnection(url); // Create a link to connect to our database
				Statement st = con.createStatement(); // Create a link to our database so we can send query
				String query = "INSERT INTO tracks VALUES ('"+Entry+"', '"+Company+"', '"+Role+"', '"+Salary+"', '"+Applied+"', '"+Interview+"', '"+Status+"', '"+Location+"', '"+checked+"')"; 
				// Check if PRIMARY KEY already exists
//				Boolean validEntry = st.execute("SELECT * from tracks WHERE ENTRY = '"+Entry+"'");
//				if(validEntry == false)
//				{
//					JOptionPane.showMessageDialog(null, "Entry already exists!");
//				}
//				else
//				{
					st.executeUpdate(query); // Add our values
//				}
				
				refresh();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		}
		
		public void refresh() throws SQLException
		{
			
			ResultSet rss = Search.searchAll();
			
			int j = 0;
			while(rss.next())
			{
				j++;
			}
			
			ResultSet rs = Search.searchAll(); // Gives us everything inside ResultSet
			Object[][] rows = new Object[j][COLUMN_SIZE];
			
			// What will be populating our rows
			int i = 0;
			
				try 
				{
					while(rs.next())
					{
						rows[i][0] = rs.getString("ENTRY");
						rows[i][1] = rs.getString("COMPANY");
						rows[i][2] = rs.getString("ROLE");
						rows[i][3] = rs.getString("SALARY");
						rows[i][4] = rs.getString("APPLIED");
						rows[i][5] = rs.getString("INTERVIEW");
						rows[i][6] = rs.getString("STATUS");
						rows[i][7] = rs.getString("LOCATION");
						rows[i][8] = rs.getString("REMOTE");
						i++;
					}
					// Changes the 
					dm.setDataVector(rows, columnNames);
					dm.fireTableDataChanged();
					
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}	
		}
		
		private class MainM implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MenuWindow menu = new MenuWindow();
				menu.frame.setVisible(true);
			}
		}
		private class MainMenuuu implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				MenuWindow menu = new MenuWindow();
				menu.frame.setVisible(true);
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

		
	} // END OF ADD CLASS
}