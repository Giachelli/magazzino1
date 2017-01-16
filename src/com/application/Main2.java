package com.application;
import Controller.LoginController;

import Controller.ProdottoController;
import Model.LoginModel;
import Model.ProdottoModel;
import View.LoginView1;
import View.ProdottoView;

public class Main2 {
	public static void main(String[] args) {
		ProdottoView theView = new ProdottoView();
		ProdottoModel theModel= new ProdottoModel(); 
		ProdottoController theController= new ProdottoController(theView);
		
		theView.main.setVisible(true);
		
		//theView.setVisible(true);
		
		};
}


