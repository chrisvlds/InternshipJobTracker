import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import java.util.HashMap;


public class QuestionsC {
	JFrame frame;
	private JTextArea textArea;
	private JButton aBtn;
	private JButton bBtn;
	private JButton cBtn;
	private JButton dBtn;
	private JLabel aLabel;
	private JLabel bLabel;
	private JLabel cLabel;
	private JLabel dLabel;
	private JLabel wrongLabel;
	private JButton mainMenuBtn;
	private static Connection con;
	private String url = "jdbc:sqlite:/C:bin\\login.db";
//--------------------------------------------------------

	// HashMaps goes Key then Value
	// If we want to retrieve the data we would call the key
	HashMap<String, Integer> quest = new HashMap<String, Integer>();
	
	// Our Questions 🤮
	public final String equest1 = "What is the output of the following code?\n\n"
            + "   double num1 = 6.9, num2 = 7.9; \n\n"
            + "   cout << (static_cast<int>(num1) + static_cast<int>(num2)) / 3\n";
	public final String equest2 = "Suppose that x = 55.69. What is the output of the following statements?\n\n"
            + "   cout << fixed << setprecision(3);"
            + "   cout << x;\n";
	public final String mquest1 = "Suppose that ch1 and ch2 are char variables, alpha is an int variable, and the input is:\n\n"
			+ "   A 18\n\n"
			+ "   What are the values after the following statement executes?\n\n"
			+ "   cin.get(ch1);\"\r\n"
			+ "   cin.get(ch1);\"\r\n"
			+ "   cin >> alpha;\"\r\n"
			+ "   cout << ch1 << '-' << ch2 << '-' << alpha;";
	public final String mquest2 = "If the code of main( ) shown below is executed, the output will be: \n"
            + "   void enigma(int& val1, int& val2)"
            + "   {"
            + "      int temp:"
            + "      temp = val1;"
            + "      val1 = val2;"
            + "      val2 = temp;"
            + "   }\n"
            + "   int main()"
            + "   {"
            + "      int num1 = 3, num2 = 4;"
            + "      enigma(num1, num2);"
            + "      cout << num1 << '&' << num2;"
            + "      return 0;"
            + "   }";
	public final String hquest1 = "If the code of main( ) shown below is executed, the output will be:\n\n"
            + "   int enigma(int val1, intval2);"
            + "   {"
            + "      return (val1 + val2);"
            + "   }\n\n"
            + "   int main()"
            + "   {"
            + "      int num = 5;"
            + "      cout << enigma(enigma(num, num), num);"
            + "      return 0;"
            + "   }";
	public final String hquest2 = "If the code of main( ) shown below is executed, the output will be:\n\n"
            + "   int enigma(int val1, int val2)"
            + "   {"
            + "      return val1++ * ++val2;"
            + "   }\n"
            + "   int main()"
            + "   {"
            + "      int num1 = 3, num2 = 2;"
            + "      cout << enigma(num1, num2) << '&' << enigma(num2, num1);"
            + "      return 0;"
            + "   }";
	
	
//--------------------------------------------------------
  
	public int var1; // Easy Mode
	public int var2; // Medium Mode
	public int var3; // Hard Mode
	public int var4; // Our review
	public int EQ; // Easy Question
	public int MQ; // Medium Question
	public int HQ; // Hard Question
	private JLabel langLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionsJava window = new QuestionsJava();
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
	public QuestionsC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
  
		// Easy Question 1
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q7 FROM USER WHERE active = '1'");
			int q7 = ((Number) rs.getObject(1)).intValue();
			quest.put(equest1, q7);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Easy Question 2
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q8 FROM USER WHERE active = '1'");
			int q8 = ((Number) rs.getObject(1)).intValue();
			quest.put(equest2, q8);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Medium Question 1
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q9 FROM USER WHERE active = '1'");
			int q9 = ((Number) rs.getObject(1)).intValue();
			quest.put(mquest1, q9);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Medium Question 2
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q10 FROM USER WHERE active = '1'");
			int q10 = ((Number) rs.getObject(1)).intValue();
			quest.put(mquest2, q10);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Hard Question 1
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q11 FROM USER WHERE active = '1'");
			int q11 = ((Number) rs.getObject(1)).intValue();
			quest.put(hquest1, q11);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Hard Question 2
		try {
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Q12 FROM USER WHERE active = '1'");
			int q12 = ((Number) rs.getObject(1)).intValue();
			quest.put(hquest2, q12);
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Label1 = new JLabel("Choose a Difficulty");
		Label1.setFont(new Font("Arial", Font.BOLD, 24));
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(30, 27, 248, 53);
		frame.getContentPane().add(Label1);
		
		JButton eastyBtn = new JButton("Easy");
		eastyBtn.addActionListener(new Easy());
		eastyBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		eastyBtn.setBackground(Color.YELLOW);
		eastyBtn.setForeground(Color.BLACK);
		eastyBtn.setBounds(30, 91, 248, 130);
		frame.getContentPane().add(eastyBtn);
		
		JButton mediumBtn = new JButton("Medium");
		mediumBtn.addActionListener(new Medium());
		mediumBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		mediumBtn.setBackground(Color.ORANGE);
		mediumBtn.setBounds(30, 232, 248, 130);
		frame.getContentPane().add(mediumBtn);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.addActionListener(new Hard());
		hardBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		hardBtn.setBackground(Color.RED);
		hardBtn.setBounds(30, 374, 248, 130);
		frame.getContentPane().add(hardBtn);
		
		JButton randomBtn = new JButton("Random");
		randomBtn.addActionListener(new Random());
		randomBtn.setForeground(Color.BLACK);
		randomBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		randomBtn.setBackground(Color.GREEN);
		randomBtn.setBounds(30, 515, 248, 152);
		frame.getContentPane().add(randomBtn);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(309, 91, 926, 404);
		frame.getContentPane().add(textArea);
		
		aBtn = new JButton("a");
		aBtn.setFont(new Font("Arial", Font.BOLD, 18));
		aBtn.addActionListener(new EMH());
		aBtn.setBackground(Color.LIGHT_GRAY);
		aBtn.setBounds(309, 519, 91, 39);
		frame.getContentPane().add(aBtn);
		
		bBtn = new JButton("b");
		bBtn.setFont(new Font("Arial", Font.BOLD, 18));
		bBtn.addActionListener(new EMH());
		bBtn.setBackground(Color.LIGHT_GRAY);
		bBtn.setBounds(474, 519, 91, 39);
		frame.getContentPane().add(bBtn);
		
		cBtn = new JButton("c");
		cBtn.setFont(new Font("Arial", Font.BOLD, 18));
		cBtn.addActionListener(new EMH());
		cBtn.setBackground(Color.LIGHT_GRAY);
		cBtn.setBounds(641, 519, 91, 39);
		frame.getContentPane().add(cBtn);
		
		dBtn = new JButton("d");
		dBtn.setFont(new Font("Arial", Font.BOLD, 18));
		dBtn.addActionListener(new EMH());
		dBtn.setBackground(Color.LIGHT_GRAY);
		dBtn.setBounds(791, 519, 91, 39);
		frame.getContentPane().add(dBtn);
		
		aLabel = new JLabel("");
		aLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		aLabel.setBounds(309, 589, 155, 45);
		frame.getContentPane().add(aLabel);
		
		bLabel = new JLabel("");
		bLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		bLabel.setBounds(474, 589, 139, 45);
		frame.getContentPane().add(bLabel);
		
		cLabel = new JLabel("");
		cLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		cLabel.setBounds(641, 581, 139, 53);
		frame.getContentPane().add(cLabel);
		
		dLabel = new JLabel("");
		dLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		dLabel.setBounds(791, 581, 139, 53);
		frame.getContentPane().add(dLabel);
		
		mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setFont(new Font("Arial", Font.PLAIN, 22));
		mainMenuBtn.addActionListener(new MainMenu());
		mainMenuBtn.setBackground(Color.LIGHT_GRAY);
		mainMenuBtn.setBounds(988, 510, 248, 158);
		frame.getContentPane().add(mainMenuBtn);
		
		wrongLabel = new JLabel("Wrong: ");
		wrongLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		wrongLabel.setBounds(1091, 41, 117, 39);
		frame.getContentPane().add(wrongLabel);
		
		JLabel picLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/c-.png")).getImage();
		picLabel.setIcon(new ImageIcon(img));
		picLabel.setBounds(369, 11, 99, 69);
		frame.getContentPane().add(picLabel);
		
		langLabel = new JLabel("Lang:");
		langLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		langLabel.setBounds(309, 35, 65, 39);
		frame.getContentPane().add(langLabel);

	}
	
	private class Easy implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				
			var1 = (int)(Math.random()*2+1);
			
			if(var1 == 1)
			{
				textArea.setText(equest1);
				
				aLabel.setText("4");
				bLabel.setText("5");
				cLabel.setText("6");
				dLabel.setText("None");
				
				//
				EQ = 1;
				MQ = 0;
				HQ = 0;
			}	
			
			if(var1 == 2)
			{
				textArea.setText(equest2);
				
				aLabel.setText("A 18");
				bLabel.setText("A18");
				cLabel.setText("A- -18");
				dLabel.setText("A--18");

				//
				EQ = 2;
				MQ = 0;
				HQ = 0;
			}
			
			
		} // END OF ACTION PERFORMED
		
	} // END OF EASY CLASS
	
	private class Medium implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				
			var2 = (int)(Math.random()*2+1);
			
			if(var2 == 1)
			{
				textArea.setText(mquest1);
				
				aLabel.setText("55.680");
				bLabel.setText("55");
				cLabel.setText("55.68");
				dLabel.setText("None");
							
				//
				MQ = 1;
				EQ = 0;
				HQ = 0;
			}	
			
			if(var2 == 2)
			{
				textArea.setText(mquest2);
				
				aLabel.setText("5&4");
				bLabel.setText("4&3");
				cLabel.setText("8&6");
				dLabel.setText("None");
				
				//
				MQ = 2;
				EQ = 0;
				HQ = 0;
			}
			
			
		} // END OF ACTION PERFORMED
		
	} // END OF EASY CLASS
	
	private class Hard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				
			var3 = (int)(Math.random()*2+1);
			
			if(var3 == 1)
			{
				textArea.setText(hquest1);
				
				aLabel.setText("12");
				bLabel.setText("16");
				cLabel.setText("13");
				dLabel.setText("15");
				
				//
				HQ = 1;
				EQ = 0;
				MQ = 0;
			}	
			
			if(var3 == 2)
			{
				textArea.setText(hquest2);
				
				aLabel.setText("8&9");
				bLabel.setText("3&4");
				cLabel.setText("9&8");
				dLabel.setText("None");
				
				// 
				HQ = 2;
				EQ = 0;
				MQ = 0;
			}
			
			
		} // END OF ACTION PERFORMED
		
	} // END OF EASY CLASS

  // private class Review implements ActionListener
  // {
  //   @Override
  //   public void actionPerformed(ActionEvent e)
  //   {
  //     do
  //     {
  //       // Sorts our array from largest to 
  //       Arrays.sort(arr, Collections.reverseOrder());
        
  //       for(int i = 0; i < array.length; i++)
  //       {
           
  //       }
        
  //     }while(var4 == 4) // While the user has not clicked Easy, Medium, or Hard buttons we keep reviewing
  //   }
    
  // }
		private class Random implements ActionListener {
	
			@Override
			public void actionPerformed(ActionEvent e) {
			
			int question = (int)(Math.random()*6+1);
			
			// Invoke a random question from Easy, Medium, or Hard
				
			if(question == 1)
			{
				textArea.setText(equest1);
				
				aLabel.setText("i i i i i");
				bLabel.setText("0 1 2 3 4");
				cLabel.setText("i j k l m");
				dLabel.setText("None");
					
				//
				EQ = 1;
				MQ = 0;
				HQ = 0;
			}
				
			if(question == 2)
			{
				textArea.setText(equest2);
	
				aLabel.setText("38");
				bLabel.setText("39");
				cLabel.setText("40");
				dLabel.setText("41");
				
				//
				EQ = 2;
				MQ = 0;
				HQ = 0;
			}
				
			if(question == 3)
			{
				textArea.setText(mquest1);
					
				aLabel.setText("0 2 4 6 8");
				bLabel.setText("1 3 5 7 9");
				cLabel.setText("0 1 2 3 4");
				dLabel.setText("1 2 3 4 5");
				
				//
				MQ = 1;
				EQ = 0;
				HQ = 0;
			}
				
			if(question == 4)
			{
				textArea.setText(mquest2);
					
				aLabel.setText("8");
				bLabel.setText("9");
				cLabel.setText("10");
				dLabel.setText("11");
				
				//
				MQ = 2;
				EQ = 0;
				HQ = 0;
			}
				
			if(question == 5)
			{
				textArea.setText(hquest1);
					
				aLabel.setText("3 2 4");
				bLabel.setText("3 2 3");
				cLabel.setText("2 3 4");
				dLabel.setText("3 4 4");
				
				//
				HQ = 1;
				EQ = 0;
				MQ = 0;
			}
				
			if(question == 6)
			{
				textArea.setText(hquest2);
				
				aLabel.setText("10");
				bLabel.setText("11");
				cLabel.setText("12");
				dLabel.setText("56");
					
				// 
				HQ = 2;
				EQ = 0;
				MQ = 0;
			}		
				
				
			} // END OF ACTION PERFORMED
			
		} // END OF REVIEW CLASS
		
		
	private class EMH implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
    {
			
			
//--------------------------------Easy-------------------------------------
			
			//-------------------Easy Question 1---------------------------
			if(EQ == 1)
			{
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(equest1, (quest.get(equest1)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(equest1) == -1)
					{
						quest.put(equest1, (quest.get(equest1)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					

					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q7 = '"+quest.get(equest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest1));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest1, (quest.get(equest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q7 = '"+quest.get(equest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest1));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest1, (quest.get(equest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q7 = '"+quest.get(equest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest1));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest1, (quest.get(equest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q7 = '"+quest.get(equest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest1));
				}
			}
			
			//-------------------Easy Question 2---------------------------
			if(EQ == 2)
			{		
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest2, (quest.get(equest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q8 = '"+quest.get(equest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest2));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest2, (quest.get(equest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q8 = '"+quest.get(equest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest2));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(equest2, (quest.get(equest2)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(equest2) == -1)
					{
						quest.put(equest2, (quest.get(equest2)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q8 = '"+quest.get(equest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest2));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(equest2, (quest.get(equest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q8 = '"+quest.get(equest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(equest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(equest2));
				}
			}
			
//--------------------------------Medium-------------------------------------
			
			//-------------------Medium Question 1---------------------------
			if(MQ == 1)
			{
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(mquest1, (quest.get(mquest1)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(mquest1) == -1)
					{
						quest.put(mquest1, (quest.get(mquest1)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q9 = '"+quest.get(mquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest1));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest1, (quest.get(mquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q9 = '"+quest.get(mquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest1));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest1, (quest.get(mquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q9 = '"+quest.get(mquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest1));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest1, (quest.get(mquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q9 = '"+quest.get(mquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest1));
				}
			}
			
			//-------------------Medium Question 2---------------------------
			if(MQ == 2)
			{		
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest2, (quest.get(mquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q10 = '"+quest.get(mquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest2));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(mquest2, (quest.get(mquest2)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(mquest2) == -1)
					{
						quest.put(mquest2, (quest.get(mquest2)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q10 = '"+quest.get(mquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest2));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest2, (quest.get(mquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q10 = '"+quest.get(mquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest2));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(mquest2, (quest.get(mquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q10 = '"+quest.get(mquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(mquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(mquest2));
				}
			}
			
//---------------------------------Hard--------------------------------------
			
			//---------------------Hard Question 1---------------------------
			if(HQ == 1)
			{
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest1, (quest.get(hquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q11 = '"+quest.get(hquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest1));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest1, (quest.get(hquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q11 = '"+quest.get(hquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest1));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest1, (quest.get(hquest1)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q11 = '"+quest.get(hquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest1));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(hquest1, (quest.get(hquest1)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(hquest1) == -1)
					{
						quest.put(hquest1, (quest.get(hquest1)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q11 = '"+quest.get(hquest1)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest1));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest1));
				}
			}
			
			//---------------------Hard Question 2---------------------------
			if(HQ == 2)
			{		
				if(e.getSource() == aBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest2, (quest.get(hquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q12 = '"+quest.get(hquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest2));
				}
					
				if(e.getSource() == bBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest2, (quest.get(hquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q12 = '"+quest.get(hquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest2));
				}
					
				if(e.getSource() == cBtn)
				{
					JOptionPane.showMessageDialog(null, "Right Answer");
					quest.put(hquest2, (quest.get(hquest2)) - 1);
					
					// If subtracting 1 from the value would put it at -1 add 1 to it making it 0
					if(quest.get(hquest2) == -1)
					{
						quest.put(hquest2, (quest.get(hquest2)) + 1);
					}
					
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q12 = '"+quest.get(hquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest2));
				}
					
				if(e.getSource() == dBtn)
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
					quest.put(hquest2, (quest.get(hquest2)) + 1);
					var1 = 0;
					var2 = 0;
					var3 = 0;
					
					try {
						con = DriverManager.getConnection(url);
						Statement st = con.createStatement();
						String query = "UPDATE USER SET Q12 = '"+quest.get(hquest2)+"' WHERE active = '1'";
						st.executeUpdate(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wrongLabel.setText("Wrong: " + quest.get(hquest2));
					
					// DELETE OR COMMENT AFTER U FINISH TESTING PROGRAM
					System.out.println(quest.get(hquest2));
				}
			}
			
		} // END OF ACTION PERFORMED
		
	} // END OF EMH CLASS

	private class MainMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			MenuWindow menu = new MenuWindow();
			menu.frame.setVisible(true);
		}
		
	}
} // END OF QUESTIONS PROGRAM