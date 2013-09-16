package com.medfinder.MB;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;
import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

@ManagedBean
@ViewScoped
public class CadastroMedicoMB {

	private Medico medico;

	private List<Plano> todosPlanos;

	private List<Plano> escolhidosPlanos;

	private DualListModel<Plano> dualPlanos;

	private List<Especialidade> todasEspecialidades;

	private List<Especialidade> especialidades;

	private DualListModel<Especialidade> dualEspecialidades;

	MedicoDAO medao = new MedicoDAO();
	PlanoDAO pldao = new PlanoDAO();

	EspecialidadeDAO espdao = new EspecialidadeDAO();

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public DualListModel<Especialidade> getDualEspecialidades() {
		return dualEspecialidades;
	}

	public void setDualEspecialidades(
			DualListModel<Especialidade> dualEspecialidades) {
		this.dualEspecialidades = dualEspecialidades;
	}

	public DualListModel<Plano> getDualPlanos() {
		return dualPlanos;
	}

	public void setDualPlanos(DualListModel<Plano> dualPlanos) {
		this.dualPlanos = dualPlanos;
	}

	public List<Plano> getEscolhidosPlanos() {
		return escolhidosPlanos;
	}

	public void setEscolhidosPlanos(List<Plano> escolhidosPlanos) {
		this.escolhidosPlanos = escolhidosPlanos;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Plano> getTodosPlanos() {
		return todosPlanos;
	}

	public void setTodosPlanos(List<Plano> todosPlanos) {
		this.todosPlanos = todosPlanos;
	}

	public List<Especialidade> getTodasEspecialidades() {
		return todasEspecialidades;
	}

	public void setTodasEspecialidades(List<Especialidade> todasEspecialidades) {
		this.todasEspecialidades = todasEspecialidades;
	}

	@PostConstruct
	public void init() {

		medico = new Medico();
		todosPlanos = pldao.listAll();
		escolhidosPlanos = new ArrayList<Plano>();

		dualPlanos = new DualListModel<Plano>(todosPlanos, escolhidosPlanos);

		todasEspecialidades = espdao.listAll();

		especialidades = new ArrayList<Especialidade>();

		dualEspecialidades = new DualListModel<Especialidade>(
				todasEspecialidades, especialidades);
	}

	public void salvarMedico() {

		escolhidosPlanos = this.dualPlanos.getTarget();

		medico.setPlanos(escolhidosPlanos);

		for (Plano p : escolhidosPlanos) {
			System.out.println(p.getDs_plano());
		}

		especialidades = this.dualEspecialidades.getTarget();

		medico.setEspecialidades(especialidades);

		for (Especialidade e : especialidades) {
			System.out.println(e.getDs_especialidade());
		}

		medao.insert(medico);

	}
}
