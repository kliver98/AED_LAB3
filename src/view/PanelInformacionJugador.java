package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class PanelInformacionJugador extends JPanel implements ListSelectionListener {

	private JList<String> jugadores;
	private VentanaPrincipal vent;
	
	public PanelInformacionJugador(VentanaPrincipal v) {
		vent = v;
		init();
	}
	
	public void init() {
		String[] data = new String[100];
		for (int i = 0; i < data.length; i++) {
			data[i] = "Prueba "+i;
		}
		jugadores = new JList<String>(data);
		jugadores.addListSelectionListener(this);
		int tb = 0, lr = 10;
		Border b2 = BorderFactory.createMatteBorder(tb,lr,tb,lr,this.getBackground());
		jugadores.setBorder(b2);
		this.setLayout(new BorderLayout());
		jugadores.setPreferredSize(new Dimension((int)(vent.getPreferredSize().width/3.5),vent.getPreferredSize().height));
		JPanel aux = new JPanel(new BorderLayout());
		JPanel aux2 = new JPanel(new GridLayout(2,1));
		JLabel txt = new JLabel("Jugadores encontrados");
		txt.setForeground(this.getBackground());
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		Font f = new Font("Arial",Font.BOLD,16);
		txt.setFont(f);
		aux.add(txt,BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane(jugadores);
		aux.add(scroll,BorderLayout.CENTER);
		this.add(aux,BorderLayout.EAST);
		aux.setBackground(Color.GRAY);
		this.add(aux2,BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent v) {
		System.out.println(jugadores.getSelectedValue());
	}
	
	
	
}
