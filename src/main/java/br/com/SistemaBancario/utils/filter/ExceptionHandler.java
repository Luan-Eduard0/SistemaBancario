package br.com.SistemaBancario.utils.filter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ExceptionHandler {

    public static void erro(FacesContext context, String mensagem) {
        erro(context, mensagem, null);
    }

    public static void erro(FacesContext context, String mensagem, String detalhe) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalhe));
    }
}
