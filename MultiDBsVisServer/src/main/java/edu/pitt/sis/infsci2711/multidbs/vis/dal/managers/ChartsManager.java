package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Charts;

public interface ChartsManager extends GeneralManager<Charts, Integer>{
	public Charts createNewChart(Canvases canvas, String name, String type, Integer left, Integer top, Integer depth, Integer height, Integer width, String dataInfo);
	public List<Charts> findByName(String name);
}

