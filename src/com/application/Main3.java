package com.application;

import Controller.LoginController;


import Controller.ProdottoController;
import Model.LoginModel;
import Model.ProdottoModel;
import View.LoginView1;
import View.ProdottoView;
import Controller.DipendenteController;
import Model.DipendenteModel;
import View.DipendenteView;

public class Main3 {
	public static void main(String[] args) {
		DipendenteView theView = new DipendenteView();
		DipendenteModel theModel= new DipendenteModel(); 
		DipendenteController theController= new DipendenteController(theView);
		
		theView.frame.setVisible(true);
		
		//theView.setVisible(true);
		
		};
}



