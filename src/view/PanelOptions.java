package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelOptions extends JPanel implements ActionListener {
	
	public static final String SEARCH = "Buscar"; 
	public static final String LOAD = "Cargar Datos";
	
	private JTextField fieldRebounds;
	private JTextField fieldAssistents;
	private JTextField fieldRobberies;
	private JTextField fieldBlocking;
	private JButton buttonSearch;
	private JButton buttonLoad;
	private JDialogLoadFile jDialogLoadFile;
	private MainWindow mainWindow;
	
	public PanelOptions(MainWindow m) {
		this.setLayout(new GridLayout(2,1));
		mainWindow = m;
		LoadPanel();
	}
	
	public void LoadPanel() {
		fieldRebounds = new JTextField();
		fieldAssistents = new JTextField();
		fieldRobberies = new JTextField();
		fieldBlocking = new JTextField();
		buttonSearch = new JButton(SEARCH);
		buttonLoad = new JButton(LOAD);
		buttonSearch.addActionListener(this);
		buttonLoad.addActionListener(this);
		
		jDialogLoadFile = new JDialogLoadFile(mainWindow);
		TextPrompt tp2 = new TextPrompt("Rebounds",fieldRebounds);
		TextPrompt tp3 = new TextPrompt("Assistents",fieldAssistents);
		TextPrompt tp4 = new TextPrompt("Robberies",fieldRobberies);
		TextPrompt tp5 = new TextPrompt("Blocking",fieldBlocking);
	    tp2.changeAlpha(0.75f);
	    tp2.changeStyle(Font.PLAIN);
	    tp3.changeAlpha(0.75f);
	    tp3.changeStyle(Font.PLAIN);
	    tp4.changeAlpha(0.75f);
	    tp4.changeStyle(Font.PLAIN);
	    tp5.changeAlpha(0.75f);
	    tp5.changeStyle(Font.PLAIN);
	    JLabel principal = new JLabel("*Solo se permite buscar por un (1) campo y recuerde, solo números.*");
	    add(principal);
	    principal.setHorizontalAlignment(SwingConstants.CENTER);
	    JPanel aux = new JPanel(new GridLayout(1,6));
	    aux.add(fieldRebounds);
	    aux.add(fieldAssistents);
	    aux.add(fieldRobberies);
	    aux.add(fieldBlocking);
	    aux.add(buttonSearch);
	    aux.add(buttonLoad);
	    add(aux);
	}
	
	public boolean onlyOnePutted() {
		boolean rst2 = (!fieldRebounds.getText().isEmpty() && fieldAssistents.getText().isEmpty() && fieldRobberies.getText().isEmpty() && fieldBlocking.getText().isEmpty());
		boolean rst3 = (fieldRebounds.getText().isEmpty() && !fieldAssistents.getText().isEmpty() && fieldRobberies.getText().isEmpty() && fieldBlocking.getText().isEmpty());
		boolean rst4 = (fieldRebounds.getText().isEmpty() && fieldAssistents.getText().isEmpty() && !fieldRobberies.getText().isEmpty() && fieldBlocking.getText().isEmpty());
		boolean rst5 = (fieldRebounds.getText().isEmpty() && fieldAssistents.getText().isEmpty() && fieldRobberies.getText().isEmpty() && !fieldBlocking.getText().isEmpty());
		return rst2 || rst3 || rst4 || rst5;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if (c.equals(SEARCH)) {
			if (onlyOnePutted()) {
				double val = 0;
				if (!fieldAssistents.getText().isEmpty()) {
					val = Double.parseDouble(fieldAssistents.getText().trim());
					mainWindow.playerWithASTGreaterAVLTree(val);
				} else if (!fieldBlocking.getText().isEmpty()) {
					val = Double.parseDouble(fieldBlocking.getText().trim());
					mainWindow.playerWithBLKGreaterBSTTree(val);
				} else if (!fieldRobberies.getText().isEmpty()) {
					val = Double.parseDouble(fieldRobberies.getText().trim());
					mainWindow.playerWithSTLGreaterBSTTree(val);
				} else { //It's rebounds
					val = Double.parseDouble(fieldRebounds.getText().trim());
					mainWindow.playerWithTRBGreaterAVLTree(val);
				}
				System.out.println("Press");
			}
		} else if (c.equals(LOAD)) {
			jDialogLoadFile.setVisible(true);
		}
	}
	
}
