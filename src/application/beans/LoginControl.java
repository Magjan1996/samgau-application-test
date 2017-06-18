package application.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginControl implements Serializable {

    private String _LOGIN = "admin";
    private String _PASSWORD = "admin";

    private String login;
    private String pass;

    /**
     * sign button click actionMenthod
     * @return if 'ok' then overdose pages /pages/view.xhtml
     */
    public String signClick(){
        if(login.equals(_LOGIN) && pass.equals(_PASSWORD)){
            return "ok";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Не правильные данные",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}