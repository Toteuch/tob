package com.toteuch.tob.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.toteuch.tob.entity.TOBUser;
import com.toteuch.tob.service.ITOBUserService;
import com.toteuch.tob.service.TOBUserService;

public class LoginWindow {

	private JFrame frmTobLogin;
	private JTextField tfLogin;
	private JPasswordField tfPassword;
	private JButton btnLogIn; 
	private ITOBUserService tobUserService;

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public LoginWindow() throws Exception {
		initialize();
		frmTobLogin.getRootPane().setDefaultButton(btnLogIn);
		frmTobLogin.setVisible(true);
		tobUserService = TOBUserService.getInstance();
	}
	
	private void btnLogInEvent() {
		char[] passwd = this.tfPassword.getPassword();
		String sPasswd = "";
		for(int i = 0; i < passwd.length; i++) {
			sPasswd += passwd[i];
		}
		TOBUser user = tobUserService.authenticate(this.tfLogin.getText(), sPasswd);
		if(null != user) {
			TOBWindow tobWindow = new TOBWindow(user);
			this.frmTobLogin.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Authentication failed");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTobLogin = new JFrame();
		frmTobLogin.setTitle("TOB Login");
		frmTobLogin.setBounds(100, 100, 292, 154);
		frmTobLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setLabelFor(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		
		JLabel lblPasswd = new JLabel("Password : ");
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogInEvent();
			}
		});
		
		tfPassword = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frmTobLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPasswd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfPassword)
						.addComponent(btnLogIn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfLogin, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogIn)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		frmTobLogin.getContentPane().setLayout(groupLayout);
	}
}
