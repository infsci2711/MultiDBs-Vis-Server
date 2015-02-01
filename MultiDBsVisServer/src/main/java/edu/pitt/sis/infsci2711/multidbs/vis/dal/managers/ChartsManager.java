package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCanvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCharts;

public interface ChartsManager extends GeneralManager<ColfusionCharts, Integer>{
	public ColfusionCharts createNewChart(ColfusionCanvases canvas, String name, String type);
	public List<ColfusionCharts> findByName(String name);
}

