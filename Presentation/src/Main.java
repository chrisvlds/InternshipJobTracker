import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	JFrame frame;
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	private static Connection con; // Note that Con will require us to throw an SQLException
	PreparedStatement pst = null; // Our prepared statement for the register function
	String URL = "jdbc:sqlite:/C:bin\\login.db"; // // URL to be used in making our connection. Jdbc is our protocol. Sqlite is our subprotocol. And the rest is our path

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null); // Have our window appear at the center of the screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Main() throws SQLException {
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
			st.execute("CREATE TABLE IF NOT EXISTS user" // Our table will be named product
					+ "(username VARCHAR(20) PRIMARY KEY,"
					+ "password VARCHAR(16),"
					+ "Q1 INTEGER NOT NULL,"
					+ "Q2 INTEGER NOT NULL,"
					+ "Q3 INTEGER NOT NULL,"
					+ "Q4 INTEGER NOT NULL,"
					+ "Q5 INTEGER NOT NULL,"
					+ "Q6 INTEGER NOT NULL,"
					+ "ACTIVE INT NOT NULL,"
					+ "Q7 INTEGER NOT NULL,"
					+ "Q8 INTEGER NOT NULL,"
					+ "Q9 INTEGER NOT NULL,"
					+ "Q10 INTEGER NOT NULL,"
					+ "Q11 INTEGER NOT NULL,"
					+ "Q12 INTEGER NOT NULL);"); // END OF EXECUTE
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
		
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Login Menu");
		Title.setBounds(511, 119, 267, 112);
		Title.setFont(new Font("Arial", Font.BOLD, 45));
		frame.getContentPane().add(Title);
		
		JLabel Username = new JLabel("Username:");
		Username.setBounds(435, 254, 158, 57);
		Username.setFont(new Font("Arial", Font.PLAIN, 30));
		frame.getContentPane().add(Username);
		
		JLabel Password = new JLabel(" Password:");
		Password.setBounds(435, 375, 158, 37);
		Password.setFont(new Font("Arial", Font.PLAIN, 30));
		frame.getContentPane().add(Password);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(627, 268, 188, 37);
		UsernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		frame.getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(627, 379, 188, 38);
		PasswordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		frame.getContentPane().add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new Login()); // Login/Verify on button press
		LoginBtn.setBounds(558, 455, 147, 55);
		LoginBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.getContentPane().add(LoginBtn);
		
		JButton RegisterBtn = new JButton("Register");
		RegisterBtn.addActionListener(new Register()); // Register/Add on button press
		RegisterBtn.setBounds(558, 533, 147, 57);
		RegisterBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.getContentPane().add(RegisterBtn);
		
		JLabel picLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		picLabel.setIcon(new ImageIcon(img));
		picLabel.setBounds(327, 63, 158, 193);
		frame.getContentPane().add(picLabel);
	}
	
	
	private class Login implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			// Get our values to get added, make sure to parse if needed
			String Username = UsernameTextField.getText();
			String Password = PasswordTextField.getText();
			
			// Our query to be used in our prepared statement to check if our database holds the inputed username and password combination
			// We have question marks as we do not yet know what we are checking they are equal to
			String query = "SELECT * FROM user WHERE username = ? AND password = ?";
			
			// We are using a PreparedStatement instead of just statement because we don't have the info right off the bat
			// PreparedStatement and Statement are essentially the same thing but PreparedStatement lets you add future info 
			try
			{
				Connection con = DriverManager.getConnection(URL); // Create a link to connect to our database
				pst = con.prepareStatement(query); // Giving our PreparedStatement access to the database
				pst.setString(1, Username); // Set our 1st question mark to be equal to what user input on UsernameTextField
				pst.setString(2, Password); // Set our 2nd question mark to be equal to what user input on PasswordTextField
				ResultSet rs = pst.executeQuery();
				
				
				if(rs.next()) // If the username and password combination was found display a window showing Sucess
				{
					JOptionPane.showMessageDialog(null, "Success");
					frame.dispose();
					MenuWindow menu = new MenuWindow();
					menu.frame.setVisible(true);
					
                    Statement st = con.createStatement(); // Create a link to our database so we can send query
					String query2 = "UPDATE USER SET active = '1' WHERE username = '"+Username+"'"; // set active to 1
                    st.executeUpdate(query2);
                    con.close();
				}
				else // If the combination was not found display a window detailing the error
				{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		}	// END OF OUR ACTION PERFORMED
	} // END OF ADD CLASS
	
	private class Register implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {

            // Get our values to get added, make sure to parse if needed
            String Username = UsernameTextField.getText();
            String Password = PasswordTextField.getText();

            if(Username.isEmpty() || Password.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter Correctly!");
            }
            else
            {
                try
                {
                    Connection con = DriverManager.getConnection(URL); // Create a link to connect to our database
                    Statement st = con.createStatement(); // Create a link to our database so we can send query
                    String query = "INSERT INTO user VALUES ('"+Username+"', '"+Password+"','0','0','0','0','0','0','0','0','0','0','0','0','0')"; 
                    st.executeUpdate(query); // Add our values
                    con.close();
                }
                catch(Exception e1)
                {
                    e1.printStackTrace(); // Just shows the red code in console diagnosing the problem but we know what it is
                    JOptionPane.showMessageDialog(null, "You're Already Registered!");
                }
            }

        }    // END OF OUR ACTION PERFORMED
    } // END OF REGISTER CLASS
	
}