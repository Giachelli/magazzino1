package Model;

import java.sql.Date;

public class ProdottoModel {
		private String nome;
		private String marca;
		private Float prezzo;
		private Date inizio_offerta;
		private Date fine_offerta;
		private Boolean offerta;
		private Float prezzo_offerta;
		private Integer qta;
		private Date scadenza;
		private String scaffale;
		private String settore;
		private String reparto;
		private String img;
	
	
	public ProdottoModel(){
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
	
	public ProdottoModel(String nome){
        this.nome = nome;
        
     }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Date getInizio_offerta() {
		return inizio_offerta;
	}

	public void setInizio_offerta(Date inizio_offerta) {
		this.inizio_offerta = inizio_offerta;
	}

	public Date getFine_offerta() {
		return fine_offerta;
	}

	public void setFine_offerta(Date fine_offerta) {
		this.fine_offerta = fine_offerta;
	}

	public Boolean getOfferta() {
		return offerta;
	}

	public void setOfferta(Boolean offerta) {
		this.offerta = offerta;
	}

	public Float getPrezzo_offerta() {
		return prezzo_offerta;
	}

	public void setPrezzo_offerta(Float prezzo_offerta) {
		this.prezzo_offerta = prezzo_offerta;
	}

	public Integer getQta() {
		return qta;
	}

	public void setQta(Integer qta) {
		this.qta = qta;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public String getScaffale() {
		return scaffale;
	}

	public void setScaffale(String scaffale) {
		this.scaffale = scaffale;
	}

	public String getSettore() {
		return settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String toString(){
		return this.nome;
		
	}
	
	
}
