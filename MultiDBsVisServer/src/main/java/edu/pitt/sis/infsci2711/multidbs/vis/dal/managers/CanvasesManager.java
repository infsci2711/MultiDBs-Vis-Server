package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

/**
 * @author xiaotingli
 *
 */
public interface CanvasesManager extends GeneralManager<Canvases, Integer> {

	public Canvases createNewCanvas(Users canvasOwner, String name);
	public List<Canvases> findByName(String name);
	public List<Canvases> findCanvasByUser(Users canvasOwner); //add, may need to delete
}
