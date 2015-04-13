package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Charts;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public interface ChartsManager extends GeneralManager<Charts, Integer>{
	public Charts createNewChart(String type, String did, String dname, String tname, String columns, Story story);
	public List<Charts> showAllByStoryId(Story story);
	//public List<Charts> findByName(String name);

}

