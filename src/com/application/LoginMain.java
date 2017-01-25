package com.application;

import Controller.LoginController;


import Model.LoginModel;

import View.LoginView;

/**
 * Classe LoginMain.java
 * permette di avviare il programma chiamando e inizializzando
 * le classi MVC: LoginView1, LoginModel, LoginController.
 * Rende infine visibile il frame della vista (theView).
 * 
 * @author Iezzi Valerio
 * 
 */
public class LoginMain {

	public static void main(String[] args) {
		LoginView theView = new LoginView();
		LoginModel theModel = new LoginModel(); 
		LoginController theController = new LoginController(theView);
		
		theView.frameLogin.setVisible(true);
		
		};
}
