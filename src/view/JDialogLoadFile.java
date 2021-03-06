package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;




public class JDialogLoadFile extends JDialog implements ActionListener {
	
	public static final String ACCEPT = "accept";
	
	public static final String LOAD = "load";
	public static final String ADD_PLAYER = "add";
	
	private JLabel lbLoad;
	private JButton btAccept;
	private JButton btLoad;
	private JButton btAddPlayer;
	private JDialogAddPlayer jDialogAddPlayer;
	private MainWindow main;
	
	public JDialogLoadFile(MainWindow m) {
		super(m);
		main = m;
		jDialogAddPlayer = new JDialogAddPlayer(main);
		setLayout(null);
		setVisible(false);
		setSize(400, 230);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Load");
		
		
		lbLoad  = new JLabel("Add Player");
		btAccept = new JButton("Accept");
		btAccept.addActionListener(this);
		btAccept.setActionCommand(ACCEPT);
		btLoad = new JButton("Load players");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btLoad.addActionListener(this);
		btLoad.setActionCommand(LOAD);
		btAddPlayer = new JButton("Add player");
		btAddPlayer.addActionListener(this);
		btAddPlayer.setActionCommand(ADD_PLAYER);
		setLayout(null);
		lbLoad.setBounds(176,10, 70,70);
		btLoad.setBounds(158, 60, 100, 40);
		btAccept.setBounds(158, 100, 100, 40);
		btAddPlayer.setBounds(158, 140, 100, 40);
		add(lbLoad);
		add(btLoad);
		add(btAccept);
		add(btAddPlayer);
		
		
		
	}
	
	
	public void loadFile() {
		JFileChooser file = new JFileChooser();
		FileNameExtensionFilter  fileFilter = new FileNameExtensionFilter(".csv", "csv");
		file.setFileFilter(fileFilter);
		int option = file.showOpenDialog(this);
			if(option == file.APPROVE_OPTION ) {
				String filePath = file.getSelectedFile().getPath().toString();
				main.loadFile(filePath);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
			if (comand.equals(LOAD)) {
				loadFile();
			}else if (comand.equals(ACCEPT)) {
				this.dispose();
			}else if (comand.equals(ADD_PLAYER)) {
				jDialogAddPlayer.setVisible(true);
			}
		
	}

}
