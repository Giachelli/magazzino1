package Model;
/**
 * Classe LoginModel.java
 * In questa classe vengono generati i getters e i setters relativi.
 * @author IezziValerio
 *
 */
public class LoginModel {
    private String userName;
    private String password;
    private String codice;
   
    public String getCodice() {
		return codice;
	}

	public LoginModel(){
       
    }
   
    public LoginModel(String username, String password){
        this.userName = username;
        this.password = password;
    }
    public LoginModel(String codice){
        this.codice = codice;
       
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
