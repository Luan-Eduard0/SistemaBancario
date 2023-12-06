/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view.util;

import br.com.SistemaBancario.model.dao.ClienteDao;
import br.com.SistemaBancario.model.domain.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Pedro
 */
@FacesConverter("converterCliente")
public class converterCliente implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isBlank()) {
            var cliente = new ClienteDao().findByid(Long.valueOf(value));
            return cliente;
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
