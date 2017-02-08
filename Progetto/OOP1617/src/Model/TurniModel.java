package Model;

public class TurniModel {

	String Nome_Turno; 	
	String Lunedi; 		
	String Martedi;		
	String Mercoledi;	
	String Giovedi;		
	String Venerdi;
	String Sabato;

	public TurniModel (String Nome_Turno, String Lunedi, String Martedi, 
			String Mercoledi, String Giovedi, String Venerdi, String Sabato) {
		this.Nome_Turno=Nome_Turno;
		this.Lunedi=Lunedi;
		this.Martedi=Martedi;
		this.Mercoledi=Mercoledi;
		this.Giovedi=Giovedi;
		this.Venerdi=Venerdi;
		this.Sabato=Sabato;
	}
	
	public TurniModel () {
		
	}

	
	public String getNomeTurno () {
		return this.Nome_Turno;
	}
	public String getLunedi () {
		return this.Lunedi;
	}
	public String getMartedi () {
		return this.Martedi;
	}
	public String getMercoledi () {
		return this.Mercoledi;
	}
	public String getGiovedi () {
		return this.Giovedi;
	}
	public String getVenerdi () {
		return this.Venerdi;
	}
	public String getSabato () {
		return this.Sabato;
	}

	public String toString () {
		return ("Turno " + Nome_Turno+ "Lunedi " + Lunedi + ", Martedi " + Martedi + ", Mercoledi " + Mercoledi + ", Giovedi " +Giovedi+ ", Venerdi " +Venerdi+ ", Sabato " +Sabato+".");
	}

	public int Calcola_ore () {
		int x = 0;
		if (this.Lunedi == "Mattina" || this.Lunedi == "Pomeriggio") 
			x = x + 5;
		if (this.Martedi == "Mattina" || this.Martedi == "Pomeriggio") 
			x = x + 5;
		if (this.Mercoledi == "Mattina" || this.Mercoledi == "Pomeriggio") 
			x = x + 5;
		if (this.Giovedi == "Mattina" || this.Giovedi == "Pomeriggio") 
			x = x + 5;
		if (this.Venerdi == "Mattina" || this.Venerdi == "Pomeriggio") 
			x = x + 5;
		if (this.Sabato == "Mattina" || this.Sabato == "Pomeriggio") 
			x = x + 5;
		return x;
	} 
}
