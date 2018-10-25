package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Player;

@SuppressWarnings("serial")
public class PanelPlayerInformation extends JPanel implements ListSelectionListener {

	ArrayList<Player> ps;
	private JList<String> players;
	private JTextField[] dataPlayer;
	
	public PanelPlayerInformation() {
		init();
	}
	
	public void updateListPlayers(ArrayList<Player> pls) {
		ps = pls;
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (int i = 0; i < ps.size(); i++) {
			dlm.addElement(ps.get(i).getName());
		}
		players.setModel(dlm);
		if (ps.size()>0)
			updateFieldsPlayerInformation(ps.get(0));
	}
	
	public void updateFieldsPlayerInformation(Player p) {
		dataPlayer[0].setText(p.getName());
		dataPlayer[1].setText(p.getAge()+"");
		dataPlayer[2].setText(p.getTeam());
		dataPlayer[3].setText(p.getPointsPerGame()+"");
		dataPlayer[4].setText(p.getReboundsPerGame()+"");
		dataPlayer[5].setText(p.getAssistsPerGame()+"");
		dataPlayer[6].setText(p.getRobberiesByGames()+"");
		dataPlayer[7].setText(p.getBlockingByGames()+"");
		this.repaint();
	}
	
	public void init() {
		players = new JList<String>();
		players.addListSelectionListener(this);
		int tb = 0, lr = 10;
		Border b2 = BorderFactory.createMatteBorder(tb,lr,tb,lr,this.getBackground());
		players.setBorder(b2);
		this.setLayout(new BorderLayout());
		JPanel aux = new JPanel(new BorderLayout());
		JPanel aux2 = new JPanel();
		initAux2(aux2);
		JLabel txt = new JLabel("Jugadores encontrados");
		txt.setForeground(this.getBackground());
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		Font f = new Font("Arial",Font.BOLD,16);
		txt.setFont(f);
		aux.add(txt,BorderLayout.NORTH);
		aux.add(new JScrollPane(players),BorderLayout.CENTER);
		this.add(aux,BorderLayout.EAST);
		aux.setBackground(Color.GRAY);
		this.add(aux2,BorderLayout.CENTER);
	}
	
	public void initAux2(JPanel aux2) {
		int tb = 3, lr = 6;
		Border b2 = BorderFactory.createMatteBorder(tb,lr,tb,lr,this.getBackground());
		Border b = BorderFactory.createLineBorder(Color.BLACK,1);
		aux2.setBorder(b2);
		int numberInfo = 8;
		dataPlayer = new JTextField[numberInfo];
		for (int i = 0; i < dataPlayer.length; i++) {
			dataPlayer[i] = new JTextField();
			dataPlayer[i].setEditable(false);
			dataPlayer[i].setBorder(b);
			dataPlayer[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		aux2.setLayout(new GridLayout(numberInfo,2));
		JLabel lblName = new JLabel("Nombre del Jugador:");
		JLabel lblAge = new JLabel("Edad del Jugador:");
		JLabel lblTeam = new JLabel("Equipo del Jugador:");
		JLabel lblPoints = new JLabel("Puntos del Jugador:");
		JLabel lblRebounds = new JLabel("Rebotes por juegos:");
		JLabel lblAssists = new JLabel("Asistencias por juegos:");
		JLabel lblRobberies = new JLabel("Robos por juegos:");
		JLabel lblBlocking = new JLabel("Bloqueos por juegos:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblRebounds.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssists.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobberies.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlocking.setHorizontalAlignment(SwingConstants.CENTER);
		aux2.add(lblName);
		aux2.add(lblAge);
		aux2.add(dataPlayer[0]);
		aux2.add(dataPlayer[1]);
		aux2.add(lblTeam);
		aux2.add(lblPoints);
		aux2.add(dataPlayer[2]);
		aux2.add(dataPlayer[3]);
		aux2.add(lblRebounds);
		aux2.add(lblAssists);
		aux2.add(dataPlayer[4]);
		aux2.add(dataPlayer[5]);
		aux2.add(lblRobberies);
		aux2.add(lblBlocking);
		aux2.add(dataPlayer[6]);
		aux2.add(dataPlayer[7]);
	}

	@Override
	public void valueChanged(ListSelectionEvent v) {
		updateFieldsPlayerInformation(ps.get(players.getSelectedIndex()));
	}
	
}
