package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.awt.Canvas;
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
		
//		HashSet<StoryViewModel> storyVMSet = new HashSet<StoryViewModel>();
//		for(Story story: users.getStorySet()){
//			StoryViewModel storyVM = convertStoryViewModel(story);
//			storyVMSet.add(storyVM);
//		}
		return new UserViewModel(users.getUserId(), users.getUserModification(), users.getUserDate(),
				users.getUserEmail(), users.getUserNames(), users.getUserLastlogin());
	}
	
	private Users convertUsers(UserViewModel userVM){
		return new Users(userVM.getUserId(), userVM.getUserModification(), userVM.getUserDate(),
				userVM.getUserEmail(), userVM.getUserNames(), userVM.getUserLastlogin());
	}
	

	/************************ canvas ************************/
	private CanvasViewModel convertCanvasViewModel(Canvases canvas) {
	
		UserViewModel userVM = convertUsersViewModel(canvas.getUsers());
		
		return new CanvasViewModel(canvas.getVid(), canvas.getName(), canvas.getCdate(), 
				canvas.getMdate(), canvas.getPrivilege(), canvas.getNote(), userVM);
	}
	
	private Canvases convertCanvas(CanvasViewModel canvasVM) {
		
		Users user = convertUsers(canvasVM.getUser());
		
		return new Canvases(canvasVM.getVid(), user ,canvasVM.getName(), canvasVM.getNote(), 
				canvasVM.getMdate(), canvasVM.getCdate(), canvasVM.getPrivilege());
	}
	
	public CanvasViewModel createCanvase(int userId, String canvasName) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases newCanvas = canvasMng.createNewCanvas(user, canvasName);
		CanvasViewModel canvasVM = convertCanvasViewModel(newCanvas);
		
		return canvasVM;
	}
	
	public List<CanvasViewModel> findByCanvasId(int vid) throws Exception {
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(vid);
		
		List<CanvasViewModel> canvasVMList = new ArrayList<CanvasViewModel>();
		
		if(canvas != null){//add
		  canvas = GeneralManagerImpl.initializeField(canvas, "users"); // lazy
		  CanvasViewModel canvasVM = convertCanvasViewModel(canvas);
		  canvasVMList.add(canvasVM);
		
		return canvasVMList;
		}
		else{
			return canvasVMList;//add
		}
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
	
	//add, may need to delete
	public List<CanvasViewModel> findCanvasByUser(int userId) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		List<Canvases> canvasesList = canvasMng.findCanvasByUser(user);
		
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
	
	private Story convertStory(StoryViewModel storyVM){
		
		Users user = convertUsers(storyVM.getUser());
		
		return new Story(storyVM.getSid(), user, storyVM.getCdate(), storyVM.getMdate(), storyVM.getConnInfo());
	}
	
	
	public StoryViewModel createStory(int userId, String connInfo) throws Exception {
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId); // need to check whether user is null
		
		StoryManager storyMng = new StoryManagerImpl();
		Story newStory = storyMng.createNewStory(user, connInfo);
		StoryViewModel storyVM = convertStoryViewModel(newStory);
		
		return storyVM;
	}
	
	public List<StoryViewModel> findStoryById(int storyId) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		Story story = storyMng.findByID(storyId);
		
		List storyVMList = new ArrayList<StoryViewModel>();
		
//		StoryViewModel storyVM = convertStoryViewModel(story);
//		storyVMList.add(storyVM);
//		
//		return storyVMList; 
		if(story != null){
			story = GeneralManagerImpl.initializeField(story, "user");
			StoryViewModel storyVM = convertStoryViewModel(story);
			storyVMList.add(storyVM);
			return storyVMList;
		}
		
		
			else{
				return storyVMList;//add
			}
	}
	
	
	//add, may need to delete
	public List<StoryViewModel> findStoryByUser(int userId) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		StoryManager storyMng = new StoryManagerImpl();
		List<Story> storyList = storyMng.findStoryByUser(user);
		
		Iterator<Story> itStory = storyList.iterator();
		List<StoryViewModel> storyVMList = new ArrayList<StoryViewModel>();
		
		while(itStory.hasNext()){
			Story story = itStory.next();
			
			StoryViewModel storyVM = convertStoryViewModel(story);
			
			storyVMList.add(storyVM);
		}
		
		return storyVMList;
		
		
	}
	
	
	public int deleteStory(int storyId) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		try {
			storyMng.delete(storyMng.findByID(storyId));
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	

	
	/************************ chart ************************/
	public ChartViewModel createChart(Integer vid, String name, String type, Integer left, Integer top, Integer depth, Integer height, Integer width, String dataInfo) throws Exception{
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvases = canvasMng.findByID(vid);
		
		ChartsManager chartMng = new ChartsManagerImpl();
		Charts newChart = chartMng.createNewChart(canvases, name, type, left, top, depth, height, width, dataInfo);
		//newChart = GeneralManagerImpl.initializeField(newChart, "canvases"); // lazy
		
		ChartViewModel chartVM = convertChartViewModel(newChart);
		
		return chartVM;
		
	}
	
	public int deleteChart(int chartId) throws Exception{
		
		ChartsManager chartMng = new ChartsManagerImpl();
		try {
			chartMng.delete(chartMng.findByID(chartId));
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
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
		chartsVM = GeneralManagerImpl.initializeField(chartsVM, "canvasVM");//add, may delete
		CanvasViewModel canvasVM = chartsVM.getCanvas();
		canvasVM = GeneralManagerImpl.initializeField(canvasVM, "users");//add, may delete
		
		return chartsVM;
	}
	
	private ChartViewModel convertChartViewModel(Charts chart){
		
		
//		HashSet<StoryViewModel> storyVMs = new HashSet<StoryViewModel>();
//		for (Story story : chart.getStorySet()) {
//			StoryViewModel storyVM = convertStoryViewModel(story);
//			storyVMs.add(storyVM);
//		}
		try{
			Canvases canvas = chart.getCanvases();
			
		  if(canvas != null){
			canvas = GeneralManagerImpl.initializeField(canvas, "users");
		  }
			CanvasViewModel canvasVM = convertCanvasViewModel(canvas);
			
		  if(canvasVM != null){
			ChartViewModel chartVM = new ChartViewModel(canvasVM, chart.getName(), chart.getType(), chart.getLeft(), chart.getTop(), chart.getDepth(), chart.getHeight(), chart.getWidth(), chart.getDatainfo());
			//chartVM = GeneralManagerImpl.initializeField(chartVM, "canvasVM"); // lazy
			
			return chartVM;
		  }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}

