package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCanvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionUsers;

/**
 * @author xiaotingli
 *
 */
public interface CanvasesManager extends GeneralManager<ColfusionCanvases, Integer> {

	public ColfusionCanvases createNewCanvas(ColfusionUsers canvasOwner, String name);
	public List<ColfusionCanvases> findByName(String name);
}
