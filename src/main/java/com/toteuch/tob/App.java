package com.toteuch.tob;

import java.awt.EventQueue;

import com.toteuch.tob.ihm.LoginWindow;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
