package edu.pitt.sis.infsci2711.multidbs.visapi.rest; 

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.ApiOperation;

import edu.pitt.sis.infsci2711.multidbs.vis.bll.VisualizationBL;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.ChartViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.StoryViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.UserViewModel;

@Path("Visualization/")
public class VisualizationRestApi {
	
	/********************** user **********************/
	@Path("user/new/{userName}/")
	@GET
	@ApiOperation(
			value = "Create new user in the database.",
			response = UserViewModel.class
			)
	@Produces(MediaType.APPLICATION_JSON)
    public UserViewModel createUser(@PathParam("userName") final String userName) {
		
		VisualizationBL visualization = new VisualizationBL();
		
		try{
			UserViewModel userVM = visualization.createUser(userName);
			
			if (userVM != null) {
				return userVM;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		return null;
		
	}

	
	
	
	/********************** canvas **********************/
	@Path("canvas/new/{userId}/{canvasName}")
	@GET
	@ApiOperation(
			value = "Create new canvas in the database.",
			response = CanvasViewModel.class
			)
	@Produces(MediaType.APPLICATION_JSON)
    public CanvasViewModel createCanvas(@PathParam("userId") final int userId, @PathParam("canvasName") final String canvasName) {
		
		VisualizationBL visualization = new VisualizationBL();
		
		try{
			CanvasViewModel canvasVM = visualization.createCanvase(userId, canvasName);
			
			if (canvasVM != null) {
				return canvasVM;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		return null;
		
	}
	
	
   @Path("canvas/{canvasName}")
   @GET
   @ApiOperation(
		   value = "Finds metadata for the canvases with provided canvas name"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   public List<CanvasViewModel> canvasByName(@PathParam("canvasName") final String canvasName){
	 
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   List<CanvasViewModel> canvasVMList=  visualization.findByCanvasName(canvasName);
		   
		   if(canvasVMList != null){
			   return canvasVMList;
		   }
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
   }
   
   @Path("canvas/{vid: [0-9]+}")  // the uri should change
   @GET
   @ApiOperation(
		   value = "Finds metadata for the canvas with provided canvas Id",
           response = CanvasViewModel.class
           )
   @Produces(MediaType.APPLICATION_JSON)
   public CanvasViewModel canvasById(@PathParam("vid") final int vid){
	   
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   CanvasViewModel canvasVM = visualization.findByCanvasId(vid);
		   
		   if(canvasVM != null){
			   return canvasVM;
		   }
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
   } 
 
   @Path("canvas/delete/{vid: [0-9]+}")
   @GET
   @ApiOperation(
		   value = "Delete metadata for the canvas with provided canvas Id"
		   )
   public String deleteCanvas(@PathParam("vid") final int vid){
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   int flag = visualization.deleteCanvas(vid);
		   
		   if (flag == 1) return "{\"flag\" : \"S\"}";
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   
	   return "{\"flag\" : \"F\"}";
   }
   
   
   /** not ok **/
  
   /********************** chart **********************/
//   @Path("chart/new")
//   @POST
//   @Consumes(MediaType.APPLICATION_JSON) 
//   @Produces(MediaType.APPLICATION_JSON)
//   @ApiOperation(
//		   value = "Create a new chart with provided canvas Id, chart name and chart type"
//		   )
//   public void createChart(ChartViewModel chartVM){
//	   VisualizationBL visualizationBL = new VisualizationBL();
//	   
//	   try{
//		   
//		   visualizationBL.createChart(canvasId, chartName, chartType);
//	   }
//	   catch(Exception e){
//		   System.out.println(e.getMessage());
//	   }
//   }
   
   @Path("chart/{chartName}")
   @GET
   @ApiOperation(
		   value = "Find charts with provided chart name"
		   )
   public void findChartByName(@PathParam("chartName") final String chartName){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		 visualizationBL.findByChartName(chartName);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
   @Path("chart/{chartId: [0-9]+}")
   @GET
   @ApiOperation(
		   value = "Find chart with provided chart Id",
		   response = ChartViewModel.class
		   )
   public void findChartById(@PathParam("chartId") final int chartId){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		   visualizationBL.findByChartId(chartId);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
   @Path("chart/delete/{chartId: [0-9]+}")
   @GET
   @ApiOperation(
		   value = "Delete chart with provided chart Id"
		   )
   public void deleteChart(@PathParam("chartId") final int chartId){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		   visualizationBL.deleteChart(chartId);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
   
   
   
   /********************** story **********************/
   @Path("story/new/{userId}/{connInfo}") // test ok
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(
		   value = "Create new story in the database"
		   )
   public StoryViewModel createStory(@PathParam("userId") final int userId, @PathParam("connInfo") final String connInfo) {
		
	   VisualizationBL visualization = new VisualizationBL();
		 
	   try{ 
		   
		   Client client = ClientBuilder.newClient();
		   CanvasViewModel canvasVM = client.target("http://localhost:7777/Visualization/canvas/") // check DB name and table name
			   						.path("3")		           
			   						.request(MediaType.APPLICATION_JSON)
						            .get(CanvasViewModel.class);
		   
		   if(canvasVM != null){
			   StoryViewModel storyVM = visualization.createStory(userId, connInfo);
			   
			   if(storyVM != null){
				   return storyVM;
			   }
		   }
		   
	   }catch(Exception e){
		   System.out.println(e.getMessage());	
	   }
	   return null;	
   }
   
   
   @Path("story/delete/{sid: [0-9]+}") // test ok
   @GET
   @ApiOperation(
		   value = "Delete metadata for the story with provided story Id"
		   )
   public void deleteStory(@PathParam("sid") final int sid){
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   visualization.deleteStory(sid);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
    
   
}
