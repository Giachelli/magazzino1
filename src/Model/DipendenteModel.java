package Model;
import java.sql.Date;



public class DipendenteModel {
	public String NomeDipendente;
	public String CognomeDipendente;
	public String CodiceFisc;
	public String Indirizzo;
	public String Email;
	public Date AnnoNascita;
	public enum Mansione{ 
		Cassa,
		Sala,
		Banco,
	};
	public Mansione MansioneDipendente;
	public Date Data_Ass;
	public Date Data_Lic;
	public Integer id;
	public Integer Telefono;
	public String immag;
	
	
	public DipendenteModel(){
	}
	
	/*public ProdottoModel(String nome, String marca, Float prezzo,Date inizio_offerta,Date fine_offerta,
			Boolean offerta,Float prezzo_offerta,Integer qta,Date scadenza, String scaffale,String settore,
			String reparto,String img){
        this.nome = nome;
        this.marca = marca;
        this.prezzo=prezzo;
        this.inizio_offerta=inizio_offerta;
        this.fine_offerta=fine_offerta;
        this.offerta=offerta;
        this.prezzo_offerta=prezzo_offerta;
        this.qta=qta;
        this.scadenza=scadenza;
        this.scaffale=scaffale;
        this.settore=settore;
        this.reparto=reparto;
        this.img=img;
     }*/
	
	public DipendenteModel(String NomeDipendente){
		this.NomeDipendente= NomeDipendente;
        
        
     }

	public String getNomeDipendente() {
		return NomeDipendente;
	}

	public void setNomeDipendente(String NomeDipendente) {
		this.NomeDipendente = NomeDipendente;
	}

	public String getCognomeDipendente() {
		return CognomeDipendente;
	}

	public void setCognomeDipendente(String CognomeDipendente) {
		this.CognomeDipendente = CognomeDipendente;
	}

	public String getCodiceFisc() {
		return CodiceFisc;
	}

	public void setCodiceFisc(String CodiceFisc) {
		this.CodiceFisc = CodiceFisc;
	}
	
	
	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String Indirizzo) {
		this.Indirizzo = Indirizzo;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public Date getAnnoNascita() {
		return AnnoNascita;
	}

	public void setAnnoNascita(Date AnnoNascita) {
		this.AnnoNascita = AnnoNascita;
	}

	public Mansione getMansioneDipendente() {
		return MansioneDipendente;
	}

	public void setMansioneDipendente(Mansione MansioneDipendente) {
		this.MansioneDipendente= MansioneDipendente;
	}
	
	public Date getData_Ass() {
		return Data_Ass;
	}

	public void setData_Ass(Date Data_Ass) {
		this.Data_Ass = Data_Ass;
	}
	
	public Date getData_Lic() {
		return Data_Lic;
	}

	public void setData_Lic(Date Data_Lic) {
		this.Data_Lic = Data_Lic;
	}
	
	public Integer getid() {
		return id;
	}

	public void setid(Integer id)
	{
		this.id=id;
	}
	
	public Integer getTelefono()
	{
		return Telefono;
	}

	public void setTelefono(Integer Telefono)
	{
		this.Telefono=Telefono;
	}
	
	
	public String getImmag() {
		return immag;
	}

	public void setImmag(String immag) {
		this.immag = immag;
	}

	public String toString(){
		return this.NomeDipendente;
		}
	
	
}
