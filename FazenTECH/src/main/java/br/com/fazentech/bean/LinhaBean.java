package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.Ordenha;
import br.com.fazentech.entidades.VacaLeiteira;

@ViewScoped
@ManagedBean(name = "linhaBean")
public class LinhaBean {
	private LineChartModel model;

	private Ordenha ordenha = new Ordenha();
	private DaoGeneric<Ordenha> dao = new DaoGeneric<Ordenha>();
	private List<Ordenha> ordenhas = new ArrayList<Ordenha>();

	private VacaLeiteira vaca = new VacaLeiteira();
	private DaoGeneric<VacaLeiteira> daovaca = new DaoGeneric<VacaLeiteira>();
	private List<VacaLeiteira> vacas = new ArrayList<VacaLeiteira>();

	public VacaLeiteira getVaca() {
		return vaca;
	}

	public void setVaca(VacaLeiteira vaca) {
		this.vaca = vaca;
	}

	public DaoGeneric<VacaLeiteira> getDaovaca() {
		return daovaca;
	}

	public void setDaovaca(DaoGeneric<VacaLeiteira> daovaca) {
		this.daovaca = daovaca;
	}

	public List<VacaLeiteira> getVacas() {
		return vacas;
	}

	public void setVacas(List<VacaLeiteira> vacas) {
		this.vacas = vacas;
	}

	public Ordenha getOrdenha() {
		return ordenha;
	}

	public void setOrdenha(Ordenha ordenha) {
		this.ordenha = ordenha;
	}

	public DaoGeneric<Ordenha> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Ordenha> dao) {
		this.dao = dao;
	}

	public List<Ordenha> getOrdenhas() {
		return ordenhas;
	}

	public void setOrdenhas(List<Ordenha> ordenhas) {
		this.ordenhas = ordenhas;
	}

	public LinhaBean() {
		model = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");
		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);
		model.addSeries(series1);
		model.setTitle("Linear Chart");
		model.setLegendPosition("e");
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	public LineChartModel getModel() {
		return model;
	}

	@PostConstruct
	private void carregarOrdenhas() {
		ordenhas = dao.getListEntenty(Ordenha.class);
	}

	@PostConstruct
	private void carregarVacas() {
		vacas = daovaca.getListEntenty(VacaLeiteira.class);
	}

}
// <p:chart type="line" model="#{linhaBean.model}" />