package br.com.SistemaBancario.core.view.util;

import br.com.SistemaBancario.model.dao.ContaCorrenteDao;
import br.com.SistemaBancario.model.domain.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterCorrente")
public class converterContaC implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isBlank()) {
            var conta = new ContaCorrenteDao().findByid(Long.valueOf(value));
            return conta;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Cliente) {
            Cliente cliente = (Cliente) value;
            return cliente.getIdCliente().toString();
        }
        return null;
    }

}
