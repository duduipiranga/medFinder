package com.medfinder.MB;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Plano;



@FacesConverter(value="ConversorEspecialidade", forClass=Especialidade.class)
public class ConversorEspecialidade implements Converter{
	
	EspecialidadeDAO espdao = new EspecialidadeDAO();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		 if(id != null) {  
	            return espdao.find(Integer.getInteger(id));
		 }
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		 if(object != null && object instanceof Plano) {  
			 Integer idc = ((Especialidade)object).getId_especialidade();
	            return idc.toString();  
	        }
		return null;
	}

}
