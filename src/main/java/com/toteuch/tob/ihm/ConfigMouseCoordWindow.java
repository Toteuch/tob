package com.toteuch.tob.ihm;

import java.awt.AWTEvent;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.toteuch.tob.MouseCoord;
import com.toteuch.tob.entity.ConfigXY;
import com.toteuch.tob.service.BotNavigationService;
import com.toteuch.tob.service.ConfigXYService;
import com.toteuch.tob.service.IBotNavigationService;
import com.toteuch.tob.service.IConfigXYService;

public class ConfigMouseCoordWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JTextField tfPlayX;
	private JTextField tfPlayY;
	private JTextField tfVueGeneraleX;
	private JTextField tfVueGeneraleY;
	private JTextField tfGalaxyX;
	private JTextField tfGalaxyY;
	private JTextField tfGalaxyGalaxyX;
	private JTextField tfGalaxyGalaxyY;
	private JTextField tfGalaxySystemX;
	private JTextField tfGalaxySystemY;
	
	// Calibrage
	private AWTEventListener eventListener;
	private JTextField[] tfToSet = {new JTextField(), new JTextField()};
	
	// Services
	private IBotNavigationService navigationService;
	private IConfigXYService configXYService;
	
	private void save() {
		Map<String, ConfigXY> mapConfig = new HashMap<String, ConfigXY>();
		mapConfig.put(MouseCoord.BUTTON_PLAY.name(), new ConfigXY(IHMUtils.getCurrentUser(), MouseCoord.BUTTON_PLAY.name(), Integer.parseInt(tfPlayX.getText()), Integer.parseInt(tfPlayY.getText())));
		mapConfig.put(MouseCoord.BUTTON_GV.name(), new ConfigXY(IHMUtils.getCurrentUser(), MouseCoord.BUTTON_GV.name(), Integer.parseInt(tfVueGeneraleX.getText()), Integer.parseInt(tfVueGeneraleY.getText())));
		mapConfig.put(MouseCoord.BUTTON_GALAXY.name(), new ConfigXY(IHMUtils.getCurrentUser(), MouseCoord.BUTTON_GALAXY.name(), Integer.parseInt(tfGalaxyX.getText()), Integer.parseInt(tfGalaxyY.getText())));
		mapConfig.put(MouseCoord.FIELD_GALAXY_GALAXY.name(), new ConfigXY(IHMUtils.getCurrentUser(), MouseCoord.FIELD_GALAXY_GALAXY.name(), Integer.parseInt(tfGalaxyGalaxyX.getText()), Integer.parseInt(tfGalaxyGalaxyY.getText())));
		mapConfig.put(MouseCoord.FIELD_GALAXY_SYSTEM.name(), new ConfigXY(IHMUtils.getCurrentUser(), MouseCoord.FIELD_GALAXY_SYSTEM.name(), Integer.parseInt(tfGalaxySystemX.getText()), Integer.parseInt(tfGalaxySystemX.getText())));
		configXYService.save(mapConfig);
		this.dispose();
	}
	
	/**
	 * Wait for clic 
	 */
	private class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
        	String x = Double.toString(MouseInfo.getPointerInfo().getLocation().getX());
        	String y = Double.toString(MouseInfo.getPointerInfo().getLocation().getY());
        	x = StringUtils.substring(x, 0, x.indexOf('.'));
        	y = StringUtils.substring(y, 0, y.indexOf('.'));
            tfToSet[0].setText(x);
            tfToSet[1].setText(y);
            tfToSet[0] = null;
            tfToSet[1] = null;
            Toolkit.getDefaultToolkit().removeAWTEventListener(eventListener);
        }
    }
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ConfigMouseCoordWindow() throws Exception {
		frame = this;
		navigationService = BotNavigationService.getInstance();
		configXYService = ConfigXYService.getInstance();
		setTitle("TOB : Configuration Coordonnées Souris");
		setBounds(100, 100, 388, 232);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblBoutonPlay = new JLabel("Bouton Play");
		lblBoutonPlay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBoutonPlay.setBounds(80, 15, 57, 14);
		getContentPane().add(lblBoutonPlay);

		JButton btnSetPlay = new JButton("Set");
		btnSetPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfToSet[0] = tfPlayX;
				tfToSet[1] = tfPlayY;
				eventListener = new Listener();
				Toolkit.getDefaultToolkit().addAWTEventListener(eventListener, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
			}
		});
		btnSetPlay.setBounds(147, 11, 57, 23);
		getContentPane().add(btnSetPlay);

		tfPlayX = new JTextField();
		tfPlayX.setText("-9999");
		tfPlayX.setColumns(5);
		tfPlayX.setBounds(205, 13, 39, 20);
		getContentPane().add(tfPlayX);

		tfPlayY = new JTextField();
		tfPlayY.setText("-9999");
		tfPlayY.setColumns(5);
		tfPlayY.setBounds(248, 13, 39, 20);
		getContentPane().add(tfPlayY);

		JButton btnTestPlay = new JButton("Test");
		btnTestPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					navigationService.testCoords(Integer.parseInt(tfPlayX.getText()), Integer.parseInt(tfPlayY.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTestPlay.setBounds(289, 11, 72, 23);
		getContentPane().add(btnTestPlay);

		JLabel lblBoutonVueGnrale = new JLabel("Bouton Vue Générale");
		lblBoutonVueGnrale.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBoutonVueGnrale.setBounds(36, 44, 101, 14);
		getContentPane().add(lblBoutonVueGnrale);

		JButton btnSetVueGenerale = new JButton("Set");
		btnSetVueGenerale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfToSet[0] = tfVueGeneraleX;
				tfToSet[1] = tfVueGeneraleY;
				eventListener = new Listener();
				Toolkit.getDefaultToolkit().addAWTEventListener(eventListener, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
			}
		});
		btnSetVueGenerale.setBounds(147, 40, 57, 23);
		getContentPane().add(btnSetVueGenerale);

		tfVueGeneraleX = new JTextField();
		tfVueGeneraleX.setText("-9999");
		tfVueGeneraleX.setColumns(5);
		tfVueGeneraleX.setBounds(205, 42, 39, 20);
		getContentPane().add(tfVueGeneraleX);

		tfVueGeneraleY = new JTextField();
		tfVueGeneraleY.setText("-9999");
		tfVueGeneraleY.setColumns(5);
		tfVueGeneraleY.setBounds(248, 42, 39, 20);
		getContentPane().add(tfVueGeneraleY);

		JButton btnTestVueGenerale = new JButton("Test");
		btnTestVueGenerale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					navigationService.testCoords(Integer.parseInt(tfVueGeneraleX.getText()), Integer.parseInt(tfVueGeneraleY.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTestVueGenerale.setBounds(289, 40, 72, 23);
		getContentPane().add(btnTestVueGenerale);

		JLabel lblBoutonGalaxie = new JLabel("Bouton Galaxie");
		lblBoutonGalaxie.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBoutonGalaxie.setBounds(65, 73, 72, 14);
		getContentPane().add(lblBoutonGalaxie);

		JButton btnSetGalaxie = new JButton("Set");
		btnSetGalaxie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfToSet[0] = tfGalaxyX;
				tfToSet[1] = tfGalaxyY;
				eventListener = new Listener();
				Toolkit.getDefaultToolkit().addAWTEventListener(eventListener, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
			}
		});
		btnSetGalaxie.setBounds(147, 69, 57, 23);
		getContentPane().add(btnSetGalaxie);

		tfGalaxyX = new JTextField();
		tfGalaxyX.setText("-9999");
		tfGalaxyX.setColumns(5);
		tfGalaxyX.setBounds(205, 71, 39, 20);
		getContentPane().add(tfGalaxyX);

		tfGalaxyY = new JTextField();
		tfGalaxyY.setText("-9999");
		tfGalaxyY.setColumns(5);
		tfGalaxyY.setBounds(248, 71, 39, 20);
		getContentPane().add(tfGalaxyY);

		JButton btnTestGalaxy = new JButton("Test");
		btnTestGalaxy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					navigationService.testCoords(Integer.parseInt(tfGalaxyX.getText()), Integer.parseInt(tfGalaxyY.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTestGalaxy.setBounds(289, 69, 72, 23);
		getContentPane().add(btnTestGalaxy);

		JLabel lblChampGalaxiegalaxie = new JLabel("Champ Galaxie (Galaxie)");
		lblChampGalaxiegalaxie.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblChampGalaxiegalaxie.setBounds(20, 102, 117, 14);
		getContentPane().add(lblChampGalaxiegalaxie);

		JButton btnSetGalaxyGalaxy = new JButton("Set");
		btnSetGalaxyGalaxy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfToSet[0] = tfGalaxyGalaxyX;
				tfToSet[1] = tfGalaxyGalaxyY;
				eventListener = new Listener();
				Toolkit.getDefaultToolkit().addAWTEventListener(eventListener, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
			}
		});
		btnSetGalaxyGalaxy.setBounds(147, 98, 57, 23);
		getContentPane().add(btnSetGalaxyGalaxy);

		tfGalaxyGalaxyX = new JTextField();
		tfGalaxyGalaxyX.setText("-9999");
		tfGalaxyGalaxyX.setColumns(5);
		tfGalaxyGalaxyX.setBounds(205, 100, 39, 20);
		getContentPane().add(tfGalaxyGalaxyX);

		tfGalaxyGalaxyY = new JTextField();
		tfGalaxyGalaxyY.setText("-9999");
		tfGalaxyGalaxyY.setColumns(5);
		tfGalaxyGalaxyY.setBounds(248, 100, 39, 20);
		getContentPane().add(tfGalaxyGalaxyY);

		JButton btnTestGalaxyGalaxy = new JButton("Test");
		btnTestGalaxyGalaxy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					navigationService.testCoords(Integer.parseInt(tfGalaxyGalaxyX.getText()), Integer.parseInt(tfGalaxyGalaxyY.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTestGalaxyGalaxy.setBounds(289, 98, 72, 23);
		getContentPane().add(btnTestGalaxyGalaxy);

		JLabel lblChampSystmegalaxie = new JLabel("Champ Système (Galaxie)");
		lblChampSystmegalaxie.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblChampSystmegalaxie.setBounds(14, 131, 123, 14);
		getContentPane().add(lblChampSystmegalaxie);

		JButton btnSetGalaxySystem = new JButton("Set");
		btnSetGalaxySystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfToSet[0] = tfGalaxySystemX;
				tfToSet[1] = tfGalaxySystemY;
				eventListener = new Listener();
				Toolkit.getDefaultToolkit().addAWTEventListener(eventListener, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
			}
		});
		btnSetGalaxySystem.setBounds(147, 127, 57, 23);
		getContentPane().add(btnSetGalaxySystem);

		tfGalaxySystemX = new JTextField();
		tfGalaxySystemX.setText("-9999");
		tfGalaxySystemX.setColumns(5);
		tfGalaxySystemX.setBounds(205, 129, 39, 20);
		getContentPane().add(tfGalaxySystemX);

		tfGalaxySystemY = new JTextField();
		tfGalaxySystemY.setText("-9999");
		tfGalaxySystemY.setColumns(5);
		tfGalaxySystemY.setBounds(248, 129, 39, 20);
		getContentPane().add(tfGalaxySystemY);

		JButton btnTestGalaxySystem = new JButton("Test");
		btnTestGalaxySystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					navigationService.testCoords(Integer.parseInt(tfGalaxySystemX.getText()), Integer.parseInt(tfGalaxySystemY.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTestGalaxySystem.setBounds(289, 127, 72, 23);
		getContentPane().add(btnTestGalaxySystem);

		JButton btnSave = new JButton("Sauvegarder");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(10, 156, 351, 23);
		getContentPane().add(btnSave);
		List<ConfigXY> listConfig = configXYService.getAllByUser(IHMUtils.getCurrentUser());
		for(ConfigXY configXY : listConfig) {
			if(StringUtils.equals(MouseCoord.BUTTON_GV.name(), configXY.getLabel())) {
				tfVueGeneraleX.setText(new Integer(configXY.getX()).toString());
				tfVueGeneraleY.setText(new Integer(configXY.getY()).toString());
			} else if(StringUtils.equals(MouseCoord.BUTTON_PLAY.name(), configXY.getLabel())) {
				tfPlayX.setText(new Integer(configXY.getX()).toString());
				tfPlayY.setText(new Integer(configXY.getY()).toString());
			} else if(StringUtils.equals(MouseCoord.BUTTON_GALAXY.name(), configXY.getLabel())) {
				tfGalaxyX.setText(new Integer(configXY.getX()).toString());
				tfGalaxyY.setText(new Integer(configXY.getY()).toString());
			} else if(StringUtils.equals(MouseCoord.FIELD_GALAXY_GALAXY.name(), configXY.getLabel())) {
				tfGalaxyGalaxyX.setText(new Integer(configXY.getX()).toString());
				tfGalaxyGalaxyY.setText(new Integer(configXY.getY()).toString());
			} else if(StringUtils.equals(MouseCoord.FIELD_GALAXY_SYSTEM.name(), configXY.getLabel())) {
				tfGalaxySystemX.setText(new Integer(configXY.getX()).toString());
				tfGalaxySystemY.setText(new Integer(configXY.getY()).toString());
			} 
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            frame.dispose();
		        }
		    }
		});
	}
}
