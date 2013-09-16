package com.medfinder.MB;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Especialidade;

@FacesConverter(value = "ConversorEspecialidade", forClass = Especialidade.class)
public class ConversorEspecialidade implements Converter {

	EspecialidadeDAO espdao = new EspecialidadeDAO();
	Especialidade e = new Especialidade();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		/*if (id != null) {
			return espdao.find(Integer.getInteger(id));
		}*/
		
		if (id != null) {
			System.out.println(id);
			try {
				int ind = Integer.parseInt(id);
				e = espdao.find(ind);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return e;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null && object instanceof Especialidade) {
			Integer idc = ((Especialidade) object).getId_especialidade();
			return idc.toString();
		}
		return null;
	}

}
