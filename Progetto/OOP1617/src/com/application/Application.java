package com.application;

import Controller.LoginController;
import Model.LoginModel;
import View.LoginView;

/**
 * Classe Application.java
 * permette di avviare il programma chiamando e inizializzando
 * le classi MVC: LoginView, LoginModel, LoginController.
 * Rende infine visibile il frame (frameLogin) della vista (theView).
 * 
 * @author Iezzi Valerio
 * 
 */
public class Application {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LoginView theView = new LoginView();
		
		LoginModel theModel = new LoginModel(); 
		LoginController theController = new LoginController(theView);
		
		theView.frameLogin.setVisible(true);
		
		};
}
