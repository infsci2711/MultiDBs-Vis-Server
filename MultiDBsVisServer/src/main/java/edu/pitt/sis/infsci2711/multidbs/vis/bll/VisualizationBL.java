package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.CanvasesDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.ChartsManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.GeneralManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.StoryManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.StoryManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.UserManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Charts;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.ChartViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.StoryViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.UserViewModel;

public class VisualizationBL {
	
	private CanvasViewModel createCanvasViewModel(Integer vid, String name, Users users){
		CanvasViewModel canvasVM = new CanvasViewModel();
		
		canvasVM.setVid(vid);
		canvasVM.setName(name);
		canvasVM.setUsers(convertUsersViewModel(users));
		
		return canvasVM;
		
	}
	
	private UserViewModel convertUsersViewModel(Users users) {
		
		return new UserViewModel(users.getUserId(), users.getUserModification(), users.getUserDate(),
				users.getUserEmail(), users.getUserNames(), users.getUserLastlogin());
	}

	private StoryViewModel createStoryViewModel(Story story){
		StoryViewModel storyVM = new StoryViewModel();
		
		storyVM.setSid(story.getSid());
		storyVM.setUser(story.getUser());;
		storyVM.setConnInfo(story.getConnInfo());
//		storyVM.setCdate(story.getCdate());
//		storyVM.setMdate(story.getMdate());
		
		return storyVM;
	}
	
	private ChartViewModel createChartViewModel(Integer cid, String name, String type, Canvases canvases){
		ChartViewModel chartVM = new ChartViewModel();
		
		chartVM.setCid(cid);
		chartVM.setName(name);
		chartVM.setType(type);
		chartVM.setCanvases(canvases);
		
		return chartVM;
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
		canvas = GeneralManagerImpl.initializeField(canvas, "users");
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
	
	public StoryViewModel createStory(int userId, String connInfo) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
	
		StoryManager storyMng = new StoryManagerImpl();
		Story newStory = storyMng.createNewStory(user, connInfo);
		StoryViewModel storyVM = createStoryViewModel(newStory);
		
		return storyVM;	
	}
	
//	public StoryViewModel findStoryById(int storyId) throws Exception{
//		StoryManager storyMng = new StoryManagerImpl();
//		Story story = storyMng.findByID(storyId);
//		
//		StoryViewModel storyVM = createStoryViewModel(storyId, story.getUser());
//		
//		return storyVM;
//	}
	
	public void deleteStory(int storyId) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		storyMng.delete(storyMng.findByID(storyId));
	}
	
	public ChartViewModel createChart(int canvasId, String chartName, String type) throws Exception{
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvases = canvasMng.findByID(canvasId);
		
		ChartsManager chartManager = new ChartsManagerImpl();
		Charts newChart = chartManager.createNewChart(canvases, chartName, type);
		ChartViewModel chartVM = createChartViewModel(newChart.getCid(), newChart.getName(), newChart.getType(), newChart.getCanvases());
		
		return chartVM;
		
	}
	
	public void deleteChart(int chartId) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		chartMng.delete(chartMng.findByID(chartId));
		
	}
	
	public List<ChartViewModel> findByChartName(String name) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		List<Charts> chartsList = chartMng.findByName(name);
		Iterator<Charts> itCharts = chartsList.iterator();
		List<ChartViewModel> chartsVMList = new ArrayList<ChartViewModel>();
		
		while(itCharts.hasNext()){
			Charts charts = itCharts.next();
			
			ChartViewModel chartsVM = createChartViewModel(charts.getCid(), charts.getName(), charts.getType(), charts.getCanvases());
			
			chartsVMList.add(chartsVM);
		}
	
		return chartsVMList;
	}
	
	public ChartViewModel findByChartId(int id) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		Charts chart = chartMng.findByID(id);
		
		ChartViewModel chartsVM = createChartViewModel(chart.getCid(), chart.getName(), chart.getType(), chart.getCanvases());
		
		return chartsVM;
	}
}

