package edu.pitt.sis.infsci2711.multidbs.vis.bll;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
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
	
	/************************ user 
	 * @throws Exception ************************/

	private UserViewModel convertUsersViewModel(Users users) {
		
		HashSet<CanvasViewModel> canvasVMSet = new HashSet<CanvasViewModel>();

//		try {
//			GeneralManagerImpl.initializeField(users, "canvasSet");
//			for(Canvases canvas: users.getCanvasSet()){
//				CanvasViewModel canvasVM = convertCanvasViewModel(canvas);
//				canvasVMSet.add(canvasVM);
//			}
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		
		return new UserViewModel(users.getUserId(),users.getUserNames());
	}
	


	/************************ canvas ************************/
	private CanvasViewModel convertCanvasViewModel(Canvases canvas) {
	
		UserViewModel userVM = convertUsersViewModel(canvas.getUsers());
		
		return new CanvasViewModel(canvas.getVid(), canvas.getName(), canvas.getCdate(), 
				canvas.getMdate(), canvas.getPrivilege(), canvas.getNote(), userVM);
	}
	
	
	public CanvasViewModel createCanvase(int userId, String canvasName) throws Exception{
		UserManager userMng = new UserManagerImpl();
		Users user = userMng.findByID(userId);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases newCanvas = canvasMng.createNewCanvas(user, canvasName);
		
//		GeneralManagerImpl.initializeField(user, "canvasSet");
//		user.getCanvasSet().add(newCanvas);
//		userMng.merge(user);
		
		CanvasViewModel canvasVM = convertCanvasViewModel(newCanvas);
		
		return canvasVM;
	}
	

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
		CanvasViewModel canvasVM = new CanvasViewModel();
		try {
			story = GeneralManagerImpl.initializeField(story, "canvases");
			Canvases canvas = story.getCanvases();
			 canvasVM = convertCanvasViewModel(canvas);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new StoryViewModel(story.getSid(), story.getDid(), 
				story.getDname(), story.getTname(), canvasVM);
	}
	
	private StoryViewModel convertStoryViewModel2(Story story) {
		CanvasViewModel canvasVM = new CanvasViewModel();
		try {
			//story = GeneralManagerImpl.initializeField(story, "canvases");
			Canvases canvas = story.getCanvases();
			 canvasVM = convertCanvasViewModel(canvas);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new StoryViewModel(story.getSid(), story.getDid(), 
				story.getDname(), story.getTname(), canvasVM);
	}
	
	public StoryViewModel createStory(String did, String dname, String tname, int canvasId) throws Exception {
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(canvasId); 
		
		StoryManager storyMng = new StoryManagerImpl();
		Story newStory = storyMng.createNewStory(did, dname, tname, canvas);
		StoryViewModel storyVM = convertStoryViewModel(newStory);
		
		return storyVM;
	}
	
	public List<StoryViewModel> showAllByCanvasId(int canvasId) throws Exception{
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(canvasId);
		
		StoryManager storyMng = new StoryManagerImpl();
		List<Story> storyList = storyMng.showAllByCanvasId(canvas);
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
	public ChartViewModel createChart(int sid, String type, String did, String dname, String tname, String columns) throws Exception{
		
		StoryManager storyMng = new StoryManagerImpl();
		Story story = storyMng.findByID(sid);
		
		ChartsManager chartMng = new ChartsManagerImpl();
		Charts newChart = chartMng.createNewChart(type, did, dname, tname, columns, story);
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
	
	public List<ChartViewModel> showAllByStoryId(int sid) throws Exception{
		StoryManager storyMng = new StoryManagerImpl();
		ChartsManager chartMng = new ChartsManagerImpl();
		Story story = storyMng.findByID(sid);
		
		List<Charts> chartsList = chartMng.showAllByStoryId(story);
		Iterator<Charts> itCharts = chartsList.iterator();
		List<ChartViewModel> chartsVMList = new ArrayList<ChartViewModel>();
		
		while(itCharts.hasNext()){
			Charts chart = itCharts.next();
			
			ChartViewModel chartsVM = convertChartViewModel(chart);
			
			chartsVMList.add(chartsVM);
		}
	
		return chartsVMList;
	}
	
	private ChartViewModel convertChartViewModel(Charts chart){
	
		Story story = chart.getStory();
		StoryViewModel storyVM = convertStoryViewModel2(story);
			
		ChartViewModel chartVM = new ChartViewModel(chart.getCid(), chart.getType(),chart.getDid(), chart.getDname(), chart.getTname(), chart.getColumns(), storyVM);
			
		return chartVM;
	}

}

