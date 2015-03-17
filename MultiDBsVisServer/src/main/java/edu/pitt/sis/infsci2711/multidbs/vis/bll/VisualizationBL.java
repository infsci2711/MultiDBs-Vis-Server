package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.kenai.jnr.x86asm.Logger;

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
	
	/************************ user ************************/
	public UserViewModel createUser(String name) {
		UserManager userMng = new UserManagerImpl();
		Users newUser = userMng.createNewUser(name);
		
		UserViewModel userVM = convertUsersViewModel(newUser);
		return userVM;
	}
	
	private UserViewModel convertUsersViewModel(Users users) {
		
		return new UserViewModel(users.getUserId(), users.getUserModification(), users.getUserDate(),
				users.getUserEmail(), users.getUserNames(), users.getUserLastlogin());
	}


	
	/************************ canvas ************************/
	private CanvasViewModel convertCanvasViewModel(Canvases canvas) {
	
		UserViewModel userVM = convertUsersViewModel(canvas.getUsers());
		
		return new CanvasViewModel(canvas.getVid(), canvas.getName(), canvas.getCdate(), 
				canvas.getMdate(), canvas.getPrivilege(), canvas.getNote(), userVM);
	}
	
//	private Canvases convertCanvas(CanvasViewModel canvasVM) {
//		
//		Users user = convertUsers(canvasVM.getUser());
//		
//		return new Canvases(canvasVM.getVid(), user ,canvasVM.getName(), canvasVM.getNote(), 
//				canvasVM.getMdate(), canvasVM.getCdate(), canvasVM.getPrivilege());
//	}
	
	public CanvasViewModel createCanvase(int userId, String canvasName) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases newCanvas = canvasMng.createNewCanvas(user, canvasName);
		CanvasViewModel canvasVM = convertCanvasViewModel(newCanvas);
		
		return canvasVM;
	}
	
	public CanvasViewModel findByCanvasId(int vid) throws Exception {
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(vid);
		
		
		
		
		canvas = GeneralManagerImpl.initializeField(canvas, "users"); // lazy
		CanvasViewModel canvasVM = convertCanvasViewModel(canvas);
	
		return canvasVM;
	}
	
	public List<CanvasViewModel> findByCanvasName(String name) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		List<Canvases> canvasesList = canvasMng.findByName(name);
		
		Iterator<Canvases> itCanvases = canvasesList.iterator();
		List<CanvasViewModel> canvasVMList = new ArrayList<CanvasViewModel>();
		
		while(itCanvases.hasNext()){
			Canvases canvas = itCanvases.next();
			
			CanvasViewModel canvasVM = convertCanvasViewModel(canvas);
			
			canvasVMList.add(canvasVM);
		}
		
		return canvasVMList;
	}
	
	public int deleteCanvas(int canvasId) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		try {
			canvasMng.delete(canvasMng.findByID(canvasId));
			
			return 1;
		} catch (Exception e){
			
		}
		
		return 0;
		
	}
	

	
	/************************ story ************************/
	private StoryViewModel convertStoryViewModel(Story story) {
		
		UserViewModel userVM = convertUsersViewModel(story.getUser());
		
		return new StoryViewModel(story.getSid(), story.getCdate(), 
				story.getMdate(), story.getConnInfo(), userVM);
	}
	
//	private Story convertStory(StoryViewModel storyVM){
//		
//		Users user = convertUsers(storyVM.getUser());
//		
//		return new Story(storyVM.getSid() ,user, storyVM.getCdate(), storyVM.getMdate(), storyVM.getConnInfo());
//	}
	
	
	public StoryViewModel createStory(int userId, String connInfo) throws Exception {
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId); // need to check whether user is null
		
		StoryManager storyMng = new StoryManagerImpl();
		Story newStory = storyMng.createNewStory(user, connInfo);
		StoryViewModel storyVM = convertStoryViewModel(newStory);
		
		return storyVM;
	}
	
	public StoryViewModel findStoryById(int storyId) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		Story story = storyMng.findByID(storyId);
		
		StoryViewModel storyVM = convertStoryViewModel(story);
		
		return storyVM;
	}
	
	public void deleteStory(int storyId) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		storyMng.delete(storyMng.findByID(storyId));
	}
	

	
	/************************ chart ************************/
//	public ChartViewModel createChart(ChartViewModel chartVm) throws Exception{
//		CanvasesManager canvasMng = new CanvasesManagerImpl();
//		Canvases canvases = canvasMng.findByID(chartVm.getCanvas().getVid());
//		
//		
//		
//		ChartsManager chartManager = new ChartsManagerImpl();
//		Charts newChart = chartManager.createNewChart(canvases, chartName, type);
//		ChartViewModel chartVM = convertChartViewModel(newChart);
//		
//		return chartVM;
//		
//	}
	
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
			Charts chart = itCharts.next();
			
			ChartViewModel chartsVM = convertChartViewModel(chart);
			
			chartsVMList.add(chartsVM);
		}
	
		return chartsVMList;
	}
	
	public ChartViewModel findByChartId(int id) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		Charts chart = chartMng.findByID(id);
		
		ChartViewModel chartsVM = convertChartViewModel(chart);
		
		return chartsVM;
	}
	
	private ChartViewModel convertChartViewModel(Charts chart){
		
		CanvasViewModel canvasVM = convertCanvasViewModel(chart.getCanvases());
		HashSet<StoryViewModel> storyVMs = new HashSet<StoryViewModel>();
		for (Story story : chart.getStorySet()) {
			StoryViewModel storyVM = convertStoryViewModel(story);
			storyVMs.add(storyVM);
		}
		
		return new ChartViewModel(chart.getName(), chart.getType(), chart.getLeft(), chart.getTop(), chart.getDepth(),
				chart.getHeight(), chart.getWidth(), chart.getDatainfo(), chart.getNote(), 
				canvasVM, storyVMs);
	}
	
//	private Charts convertChart(ChartViewModel chartVM){
//		
//		Canvases canvas = convertCanvas(chartVM.getCanvas());
//		HashSet<Story> storys = new HashSet<Story>();
//		for (StoryViewModel storyVM : chartVM.getStories()) {
//			Story story = convertStory(storyVM);
//			storys.add(story);
//		}
//		
//		return new Charts(canvas, chartVM.getName(), chartVM.getType(), chartVM.getLeft(), chartVM.getTop(), 
//				chartVM.getTop(), chartVM.getHeight(), chartVM.getWidth(), 
//				chartVM.getDatainfo(), chartVM.getNote(), storys);
//	}
}

