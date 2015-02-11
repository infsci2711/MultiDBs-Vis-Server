package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jnr.ffi.Struct.int16_t;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCharts;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;

public class VisualizationBL {
	
	public CanvasViewModel createCanvasViewModel(Integer vid, String name, Users users){
		CanvasViewModel canvasVM = new CanvasViewModel();
		
		canvasVM.setVid(vid);
		canvasVM.setName(name);
		canvasVM.setUsers(users);
		
		return canvasVM;
		
	}

	public CanvasViewModel createCanvase(int userId, String canvasName) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases newCanvas = canvasMng.createNewCanvas(user, canvasName);
		CanvasViewModel canvasVM = createCanvasViewModel(newCanvas.getVid(), newCanvas.getName(),  newCanvas.getUsers());
		
		return canvasVM;
	}
	
	public CanvasViewModel findByCanvasId(int vid) throws Exception{
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(vid);
		CanvasViewModel canvasVM = createCanvasViewModel(canvas.getVid(), canvas.getName(),  canvas.getUsers());
	
		return canvasVM;
	}
	
	public List<CanvasViewModel> findByCanvasName(String name) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		List<Canvases> canvasesList = canvasMng.findByName(name);
		Iterator<Canvases> itCanvases = canvasesList.iterator();
		List<CanvasViewModel> canvasVMList = new ArrayList<CanvasViewModel>();
		
		while(itCanvases.hasNext()){
			Canvases canvas = itCanvases.next();
			
			CanvasViewModel canvasVM = createCanvasViewModel(canvas.getVid(), canvas.getName(),  canvas.getUsers());
			
			canvasVMList.add(canvasVM);
		}
		
		return canvasVMList;
	}
	
	public void deleteCanvas(int canvasId) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		canvasMng.delete(canvasMng.findByID(canvasId));
		
	}
	
	public ColfusionCharts createChart(int canvasId, String chartName, String type) throws Exception{
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvases = canvasMng.findByID(canvasId);
		
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

