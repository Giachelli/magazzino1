package Model;
import java.sql.Date;



public class DipendenteModel {
	public String NomeDipendente;
	public String CognomeDipendente;
	public String CodiceFisc;
	public String Indirizzo;
	public String Email;
	public Date AnnoNascita;
	public String Mansione;
    public Date Data_Ass;
	public Date Data_Lic;
	public Integer id;
	public String Telefono;
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
	
	public DipendenteModel(String NomeDipendente, String CognomeDipendente, String CodiceFisc, String Indirizzo, 
			String Email, Date AnnoNascita, String Mansione, Date Data_Ass,
			Date Data_Lic, Integer id, String Telefono, String immag)
	
	{
		this.NomeDipendente= NomeDipendente;
		this.CognomeDipendente= CognomeDipendente;
		this.CodiceFisc= CodiceFisc;
		this.Indirizzo=Indirizzo;
		this.Email=Email;
		this.AnnoNascita=AnnoNascita;
		this.Mansione= Mansione;
        this.Data_Ass=Data_Ass;
	    this.Data_Lic=Data_Lic;
	    this.id=id;
	    this.Telefono=Telefono;
	    this.immag=immag;
	    
        
        
     }
	
	public DipendenteModel(String NomeDipendente, String Mansione){
        this.NomeDipendente = NomeDipendente;
        this.Mansione=Mansione;
      
        
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

	public String getMansione() {
		return Mansione;
	}

	public void setMansione( String Mansione) {
		this.Mansione= Mansione;
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
	
	public String getTelefono()
	{
		return Telefono;
	}

	public void setTelefono(String Telefono)
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
	
	public String toString1(){
		return this.Mansione;
	}
	

	
}
