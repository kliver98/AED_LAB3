package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
	
	public PanelInformacionJugador() {
		init();
	}
	
	public void init() {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		int val = 50;
		for (int i = 0; i < val; i++) {
			dlm.addElement("Prueba "+(i+1));
		}
		jugadores = new JList<String>(dlm);
		jugadores.addListSelectionListener(this);
		int tb = 0, lr = 10;
		Border b2 = BorderFactory.createMatteBorder(tb,lr,tb,lr,this.getBackground());
		jugadores.setBorder(b2);
		this.setLayout(new BorderLayout());
		JPanel aux = new JPanel(new BorderLayout());
		JPanel aux2 = new JPanel(new GridLayout(2,1));
		JLabel txt = new JLabel("Jugadores encontrados");
		txt.setForeground(this.getBackground());
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		Font f = new Font("Arial",Font.BOLD,16);
		txt.setFont(f);
		aux.add(txt,BorderLayout.NORTH);
		aux.add(new JScrollPane(jugadores),BorderLayout.CENTER);
		this.add(aux,BorderLayout.EAST);
		aux.setBackground(Color.GRAY);
		this.add(aux2,BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent v) {
		System.out.println(jugadores.getSelectedValue());
	}
	
	
	
}
