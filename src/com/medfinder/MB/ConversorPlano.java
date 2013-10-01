package com.medfinder.MB;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Plano;

@FacesConverter(value = "ConversorPlano", forClass = Plano.class)
public class ConversorPlano implements Converter {

	PlanoDAO pdao = new PlanoDAO();
	Plano p = new Plano();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {

		if (id != null) {
			System.out.println("id vindo do conversor: "+id);
			try {
				int ind = Integer.parseInt(id);
				p = pdao.find(ind);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return p;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null && object instanceof Plano) {
			try {
				Integer idc = ((Plano) object).getId_plano();
				return idc.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
