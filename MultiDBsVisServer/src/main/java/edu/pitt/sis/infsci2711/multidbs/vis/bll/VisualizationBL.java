package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCanvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCharts;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionUsers;

public class VisualizationBL {

	public ColfusionCanvases createCanvase(int userId, String canvasName) throws Exception{
		UserManager userMng = new UserManagerImpl();
		ColfusionUsers user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		ColfusionCanvases newCanvas = canvasMng.createNewCanvas(user, canvasName);
	   
		return newCanvas;
	}
	
	public List<ColfusionCanvases> findByCanvasName(String name) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		List<ColfusionCanvases> canvasesList = canvasMng.findByName(name);
		
		return canvasesList;
	}
	
	public void deleteCanvas(int canvasId) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		canvasMng.delete(canvasMng.findByID(canvasId));
		
	}
	
	public ColfusionCharts createChart(int canvasId, String chartName, String type) throws Exception{
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		ColfusionCanvases canvases = canvasMng.findByID(canvasId);
		
		ChartsManager chartManager = new ChartsManagerImpl();
		ColfusionCharts newChart = chartManager.createNewChart(canvases, chartName, type);
		
		return newChart;
		
	}
	
	public void deleteChart(int chartId) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		chartMng.delete(chartMng.findByID(chartId));
		
	}
	
	public List<ColfusionCharts> findByChartName(String name) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		List<ColfusionCharts> chartsList = chartMng.findByName(name);
		
		return chartsList;
	}
}

