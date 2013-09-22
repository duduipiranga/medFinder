package com.medfinder.MB;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

@FacesConverter(value = "ConversorOperadora", forClass = Operadora.class)
public class ConversorOperadora implements Converter {

	OperadoraDAO opdao = new OperadoraDAO();
	Operadora p = new Operadora();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {

		if (id != null) {
			System.out.println("ID é :"+id);
			try {
				int ind = Integer.parseInt(id);
				p = opdao.find(ind);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return p;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null && object instanceof Operadora) {
			try {
				Integer idc = ((Operadora) object).getId_operadora();
				return idc.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
