package br.com.fazentech.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.fazentech.dao.DaoGeneric;
import br.com.fazentech.entidades.VacaLeiteira;

@ViewScoped
@ManagedBean(name = "graficoBarraBean")
public class GraficoBarraBean {

	private BarChartModel model;

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

	public GraficoBarraBean() {
		carregarVacas();
		model = new BarChartModel();
		ChartSeries vaquinhas = new ChartSeries();
		for (VacaLeiteira vacaLeiteira : vacas) {
			vaquinhas.setLabel(vacaLeiteira.getIdentificacaoNominal());
			vaquinhas.set(vacaLeiteira.getNumeroDePartos(), vacaLeiteira.getProducaoTotal());
			model.addSeries(vaquinhas);
			vaquinhas = new ChartSeries();
		}
		model.setTitle("Produção Leiteira");
		model.setLegendPosition("ne");
		Axis xAxis = model.getAxis(AxisType.X);
		xAxis.setLabel("Número de Partos");
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Litros");

	}

	public BarChartModel getModel() {
		return model;
	}

	@PostConstruct
	private void carregarVacas() {
		vacas = daovaca.getListEntenty(VacaLeiteira.class);
	}
}
