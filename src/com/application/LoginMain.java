package com.application;
import Controller.LoginController;

import Model.LoginModel;

import View.LoginView1;

public class LoginMain {

	public static void main(String[] args) {
		LoginView1 theView = new LoginView1();
		LoginModel theModel = new LoginModel(); 
		LoginController theController = new LoginController(theView);
		
		theView.frame.setVisible(true);
		
		//theView.setVisible(true);
		
		};
}
