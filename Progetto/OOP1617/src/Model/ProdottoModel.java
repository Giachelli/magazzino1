package Model;

import java.sql.Date;

/**
 * Classe ProdottoModel.java
 * In questa classe vengono generati i getters e i setters relativi.
 * @author IezziValerio
 *
 */
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
	
	public ProdottoModel(String nome, String marca, Float prezzo,Float prezzo_offerta,Integer qta,
			String settore,String reparto,Boolean offerta,Date scadenza,
			String scaffale,Date inizio_offerta,Date fine_offerta,String img)
	{
        this.nome = nome;
        this.marca = marca;
        this.prezzo=prezzo;
        this.prezzo_offerta=prezzo_offerta;
        this.qta=qta;
        this.settore=settore;
        this.reparto=reparto;
        this.offerta=offerta;
        this.scadenza=scadenza;
        this.scaffale=scaffale;
        this.inizio_offerta=inizio_offerta;
        this.fine_offerta=fine_offerta;
        this.img=img;
     }
	
	
	public ProdottoModel(String nome,String reparto){
        this.nome = nome;
        this.reparto=reparto;   
    }

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public Date getInizio_offerta() {
		return inizio_offerta;
	}

	public Date getFine_offerta() {
		return fine_offerta;
	}

	public Boolean getOfferta() {
		return offerta;
	}

	public Float getPrezzo_offerta() {
		return prezzo_offerta;
	}

	public Integer getQta() {
		return qta;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public String getScaffale() {
		return scaffale;
	}

	public String getSettore() {
		return settore;
	}

	public String getReparto() {
		return reparto;
	}

	public String getImg() {
		return img;
	}
	
}
