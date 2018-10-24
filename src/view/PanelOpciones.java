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
public class PanelOpciones extends JPanel implements ActionListener {
	
	public static final String BUSCAR = "Buscar"; 
	public static final String CARGAR = "Cargar Datos";
	
	private JTextField campoPuntos;
	private JTextField campoRebotes;
	private JTextField campoAsistencias;
	private JTextField campoRobos;
	private JTextField campoBloqueos;
	private JButton botonBuscar;
	private JButton botonCargar;
	private JDialogLoadFile jDialogLoadFile;
	private VentanaPrincipal principal;
	
	public PanelOpciones(VentanaPrincipal c) {
		principal = c;
		this.setLayout(new GridLayout(2,1));
		cargarPanel();
	}
	
	public void cargarPanel() {
		campoPuntos = new JTextField();
		campoRebotes = new JTextField();
		campoAsistencias = new JTextField();
		campoRobos = new JTextField();
		campoBloqueos = new JTextField();
		botonBuscar = new JButton(BUSCAR);
		botonCargar = new JButton(CARGAR);
		botonBuscar.addActionListener(this);
		botonCargar.addActionListener(this);
		jDialogLoadFile = new JDialogLoadFile(principal);
		TextPrompt tp1 = new TextPrompt("Puntos",campoPuntos);
		TextPrompt tp2 = new TextPrompt("Rebotes",campoRebotes);
		TextPrompt tp3 = new TextPrompt("Asistencias",campoAsistencias);
		TextPrompt tp4 = new TextPrompt("Robos",campoRobos);
		TextPrompt tp5 = new TextPrompt("Bloqueos",campoBloqueos);
		tp1.changeAlpha(0.75f);
	    tp1.changeStyle(Font.PLAIN);
	    tp2.changeAlpha(0.75f);
	    tp2.changeStyle(Font.PLAIN);
	    tp3.changeAlpha(0.75f);
	    tp3.changeStyle(Font.PLAIN);
	    tp4.changeAlpha(0.75f);
	    tp4.changeStyle(Font.PLAIN);
	    tp5.changeAlpha(0.75f);
	    tp5.changeStyle(Font.PLAIN);
	    JLabel principal = new JLabel("*Solo se permite buscar por un (1) campo y recuerde, solo n�meros.*");
	    add(principal);
	    principal.setHorizontalAlignment(SwingConstants.CENTER);
	    JPanel aux = new JPanel(new GridLayout(1,7));
	    aux.add(campoPuntos);
	    aux.add(campoRebotes);
	    aux.add(campoAsistencias);
	    aux.add(campoRobos);
	    aux.add(campoBloqueos);
	    aux.add(botonBuscar);
	    aux.add(botonCargar);
	    add(aux);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if (c.equals(BUSCAR)) {
			System.out.println(BUSCAR);
		} else if (c.equals(CARGAR)) {
			jDialogLoadFile.setVisible(true);
		}
	}
	
}
