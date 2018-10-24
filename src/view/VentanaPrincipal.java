package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
	public static final int WIDTH = 620;
	public static final int HEIGHT = 650;
	public static final String TITLE = "Base de datos de jugadores de baloncesto";
	
	private PanelInformacionJugador pInfJugador;
	private PanelOpciones pOpciones;
	private JDialogDatos jDialogDatos;
	
	public VentanaPrincipal() {
		this.setLayout(new BorderLayout());
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation((int)(dm.width/(3.8)),dm.height/15);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		agregarPaneles();
		this.setVisible(true);
	}
	
	public void agregarPaneles() {
		pInfJugador = new PanelInformacionJugador();
		pOpciones = new PanelOpciones();
		jDialogDatos = new JDialogDatos(this);
		add(pInfJugador,BorderLayout.CENTER);
		add(pOpciones,BorderLayout.SOUTH);
		pack();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VentanaPrincipal main = new VentanaPrincipal();
	}

}
