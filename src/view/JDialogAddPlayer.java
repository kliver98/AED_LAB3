package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogAddPlayer extends JDialog implements ActionListener {
	
	
	public static final String ADD = "add";
	public static final String CANCEL = "cancel";
	
	private JLabel lbName;
	private JLabel lbAge;
	private JLabel lbTeam;
	
	private JLabel lbRointsPerGame;
	private JLabel lbReboundsPerGame;
	private JLabel lbAssistsPerGame;
	private JLabel lbRobberiesByGames;
	private JLabel lbBlockingByGames;
	
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtTeam;
	
	private JTextField  txtRointsPerGame;
	private JTextField  txtReboundsPerGame;
	private JTextField  txtAssistsPerGame;
	private JTextField  txtRobberiesByGames;
	private JTextField  txtBlockingByGames;
	
	private JButton btAdd;
	private JButton btCancel;
	public JDialogAddPlayer() {
		
		
		setSize(300,350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(18, 2));
		
		
		setVisible(false);

		this.lbName = new JLabel("                                Name");
		this.lbAge = new JLabel("                                  Age");
		this.lbTeam = new JLabel("                              		Team");
		this.lbRointsPerGame = new JLabel("                      	    RointsPerGame");
		this.lbReboundsPerGame = new JLabel("                    	   ReboundsPerGame");
		this.lbAssistsPerGame = new JLabel("                    	 	  AssistsPerGame ");
		this.lbRobberiesByGames = new JLabel("                			  RobberiesByGames");
		this.lbBlockingByGames = new JLabel("                 	   		BlockingByGames");
		this.txtName = new JTextField();
		this.txtAge = new JTextField();
		this.txtTeam = new JTextField();
		this.txtRointsPerGame = new JTextField();
		this.txtReboundsPerGame = new JTextField();
		this.txtAssistsPerGame = new JTextField();
		this.txtRobberiesByGames = new JTextField();
		this.txtBlockingByGames = new JTextField();
		this.btAdd = new JButton("Add player");
		this.btAdd.addActionListener(this);
		this.btAdd.setActionCommand(ADD);
		this.btCancel = new JButton("Cancel");
		this.btCancel.addActionListener(this);
		this.btCancel.setActionCommand(CANCEL);
	

		add(lbName);		
		add(txtName);
		add(lbAge);
		add(txtAge);
		add(lbTeam);
		add(txtTeam);
		add(lbRointsPerGame);
		add(txtRointsPerGame);
		add(lbReboundsPerGame);
		add(txtReboundsPerGame);
		add(lbAssistsPerGame);
		add(txtAssistsPerGame);
		add(lbRobberiesByGames);
		add(txtRobberiesByGames);
		add(lbBlockingByGames);
		add(txtBlockingByGames);
		add(btAdd);
		add(btCancel);
	}
	
	public void addPlayer() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
			if(comand.equals(ADD)) {
				System.out.println("Player added");
			}else if (comand.equals(CANCEL)) {
				System.out.println("Cancel");
			}
		
	}
	

	
	

}
