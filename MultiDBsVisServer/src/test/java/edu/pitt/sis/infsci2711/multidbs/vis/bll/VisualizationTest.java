package edu.pitt.sis.infsci2711.multidbs.vis.bll; //remove "tests."

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.pitt.sis.infsci2711.multidbs.vis.test.utils.DockerTest;
//import edu.pitt.sis.ext.colfusion.docker.utils.DockerTestBase;
import edu.pitt.sis.infsci2711.multidbs.vis.bll.VisualizationBL;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManager;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.managers.CanvasesManagerImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;

public class VisualizationTest extends DockerTest{
	 
	@Test
	public void testCreateNewCanvas() throws Exception {
		
 		Users testUser = getTestUser();
		
		String canvasName = "testCanvas";
		
		VisualizationBL visualizationBL = new VisualizationBL();
		CanvasViewModel canvasesVM = visualizationBL.createCanvase(testUser.getUserId(), canvasName);
		
		assertNotNull(canvasesVM);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases actualCanvases = canvasMng.findByID(canvasesVM.getVid());
		
		
		assertEquals("Wrong canvas name", canvasesVM.getName(), actualCanvases.getName());
	}
	
	@Test
	public void testFindByCanvasName() throws Exception {
		
		Users testUser = getTestUser();
		
		String canvasName = "testCanvas";
		
		VisualizationBL visualizationBL = new VisualizationBL();
		CanvasViewModel canvasesVM = visualizationBL.createCanvase(testUser.getUserId(), canvasName);
		List<CanvasViewModel> canvasesList = visualizationBL.findByCanvasName(canvasName);
		
		assertNotNull(canvasesList);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		List<Canvases> actualCanvasesList = canvasMng.findByName(canvasName);
		
		assertEquals("Wrong canvas list", canvasesList.size(), actualCanvasesList.size());
	}
	
	@Test
	public void testFindByCanvasId() throws Exception{
        Users testUser = getTestUser();
		
		String canvasName = "testCanvas";
		int vid = 1;
		
		VisualizationBL visualizationBL = new VisualizationBL();
		CanvasViewModel canvasesVM = visualizationBL.createCanvase(testUser.getUserId(), canvasName);
		canvasesVM.setVid(vid);
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		Canvases canvas = canvasMng.findByID(vid);
		
		assertEquals("Wrong canvas", canvasesVM.getName(), canvas.getName());
	
	}
	
	@Test
    public void testDeleteCanvas() throws Exception{
		
        Users testUser = getTestUser();
		
		String canvasName = "testCanvas";
		
		VisualizationBL visualizationBL = new VisualizationBL();
		CanvasViewModel canvasVM = visualizationBL.createCanvase(testUser.getUserId(), canvasName);
		
		assertNotNull(canvasVM);
		
		visualizationBL.deleteCanvas(canvasVM.getVid());
		
		CanvasesManager canvasMng = new CanvasesManagerImpl();
		
        assertEquals(null, canvasMng.findByID(canvasVM.getVid()));
	}
}
	
