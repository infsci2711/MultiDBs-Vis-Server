package edu.pitt.sis.infsci2711.multidbs.visapi.rest; 

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
import javax.ws.rs.core.Response;

import jnr.ffi.Struct.int16_t;

import com.wordnik.swagger.annotations.ApiOperation;

import edu.pitt.sis.exp.colfusion.utils.Gsonizer;
import edu.pitt.sis.infsci2711.multidbs.vis.bll.VisualizationBL;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.ChartViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.StoryViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.UserViewModel;

@Path("Visualization/")
public class VisualizationRestApi {
	
	/********************** user **********************/
	@Path("user/new/")
	@POST
	@ApiOperation(
			value = "Create new user in the database.",
			response = UserViewModel.class
			)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public UserViewModel createUser(UserViewModel userVM) {
		
		VisualizationBL visualization = new VisualizationBL();
		
		try{
			userVM = visualization.createUser(userVM.getUserNames());
			
			if (userVM != null) {
				return userVM;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		return null;
		
	}

	
	
	
	/********************** canvas **********************/
	
    //OK
	@Path("canvas/new/")
	@POST
	@ApiOperation(
			value = "Create new canvas in the database.",
			response = CanvasViewModel.class
			)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public CanvasViewModel createCanvas(CanvasViewModel canvasVM) {
		
		VisualizationBL visualizationBL = new VisualizationBL();
		
		try{
			canvasVM = visualizationBL.createCanvase(canvasVM.getUser().getUserId(), canvasVM.getName());
	
			if (canvasVM != null) {
				return canvasVM;
			}
        }catch(Exception e){

			System.out.println(e.getMessage());	
		}
		return null;
	
	}
	
	//OK
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
		   
//		   GenericEntity<List<CanvasViewModel>> entity = new GenericEntity<List<CanvasViewModel>>(canvasVMList) {};
		   
		   return canvasVMList; //Response.status(200).entity(canvasVMList.get(0)).build();
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
   }
   
   //OK
   @Path("canvas/{vid: [0-9]+}")  
   @GET
   @ApiOperation(
		   value = "Finds metadata for the canvas with provided canvas Id",
           response = CanvasViewModel.class
           )
   @Produces(MediaType.APPLICATION_JSON)
   public List<CanvasViewModel> canvasById(@PathParam("vid") final int vid){
	   
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   List<CanvasViewModel> canvasVMList = visualization.findByCanvasId(vid);
		   return canvasVMList;
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
   } 
   
   //OK
   @Path("canvas/delete/")
   @POST
   @ApiOperation(
		   value = "Delete metadata for the canvas with provided canvas Id"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public String deleteCanvas(CanvasViewModel canvasVM){
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   int flag = visualization.deleteCanvas(canvasVM.getVid());
		   
		   if (flag == 1) return "{\"flag\" : \"S\"}";
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   
	   return "{\"flag\" : \"F\"}";
   }
   
   
   /********************** story **********************/
   
   //OK
   @Path("story/new/") 
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @ApiOperation(
		   value = "Create new story in the database"
		   )
   public StoryViewModel createStory(StoryViewModel storyVM) {
		
	   VisualizationBL visualization = new VisualizationBL();
		 
	   try{ 
		   
		   Client client = ClientBuilder.newClient();
//		   CanvasViewModel canvasVM = client.target("http://localhost:7890/Visualization/canvas/") // check DB name and table name
//			   						.path("4")		           
//			   						.request(MediaType.APPLICATION_JSON)
//						            .get(CanvasViewModel.class);
		   
		   String result = client.target("http://localhost:7890/Visualization/canvas/")
				           .path("4")
				           .request(MediaType.APPLICATION_JSON)
				           .get(String.class);
		   
		   if(result != null){
			   storyVM = visualization.createStory(storyVM.getUser().getUserId(), storyVM.getConnInfo());
			   
			   if(storyVM != null){
				   return storyVM;
			   }
		   }
		   
	   }catch(Exception e){
		   System.out.println(e.getMessage());	
	   }
	   return null;	
   }
   
   //OK
   @Path("story/{sid:[0-9]+}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(
		   value = "Finds metadata for the story with provided story Id"
           )
   public List<StoryViewModel> findStoryById(@PathParam("sid") final int sid){
	   
	   try{
		   
	     VisualizationBL visualizationBL = new VisualizationBL();
	     List<StoryViewModel> storyVMList = visualizationBL.findStoryById(sid);
	     return storyVMList;
	     
	   }catch(Exception e){
		  System.out.println(e.getMessage());   
	   }
	   return null;
   }
   
   @Path("story/delete/") // test ok, return type should be changed to String
   @POST
   @ApiOperation(
		   value = "Delete metadata for the story with provided story Id"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public void deleteStory(StoryViewModel storyVM){
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   visualization.deleteStory(storyVM.getSid());
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
   
   /** not ok **/
  
   /********************** chart **********************/
   @Path("chart/new/")
   @POST
   @Consumes(MediaType.APPLICATION_JSON) 
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(
		   value = "Create a new chart with provided canvas Id, chart name and chart type"
		   )
   public ChartViewModel createChartT(ChartViewModel chartVM){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{

		   Client client = ClientBuilder.newClient();
		   String result = client.target("http://localhost:7890/Visualization/canvas/")
		           .path("4")
		           .request(MediaType.APPLICATION_JSON)
		           .get(String.class);
		   
		   if(result != null){
		     ChartViewModel newChartVM = visualizationBL.createChart(chartVM.getCanvas().getVid(), chartVM.getName(), chartVM.getType(),chartVM.getLeft(), chartVM.getTop(), chartVM.getDepth(),chartVM.getHeight(),chartVM.getWidth(), chartVM.getNote(), result);
	      
		     return newChartVM;
		   }
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
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
   
   
   
   
  
    

   //chart
   @Path("chart/new/{canvasId}/{chartName}/{chartType}/{left}/{top}/{depth}/{height}/{width}/{note}/{datainfo}")
   @GET
   @ApiOperation(
		   value = "Create a new chart with provided canvas Id, chart name and chart type"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   public ChartViewModel createChart(@PathParam("canvasId") final int canvasId, @PathParam("chartName") final String chartName, @PathParam("chartType") final String chartType,
		   @PathParam("left") final int left, @PathParam("top") final int top, @PathParam("depth") final int depth,
		   @PathParam("height") final int height, @PathParam("width") final int width, @PathParam("note") final String note, 
		   @PathParam("datainfo") final String datainfo){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		   ChartViewModel chartVM = visualizationBL.createChart(canvasId, chartName, chartType, left, top, depth, height, width, note, datainfo);
		   return chartVM;
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return null;
   }
//   
//   @Path("chart/{chartName}")
//   @GET
//   @ApiOperation(
//		   value = "Find charts with provided chart name"
//		   )
//   @Produces(MediaType.APPLICATION_JSON)
//   public void findChartByName(@PathParam("chartName") final String chartName){
//	   VisualizationBL visualizationBL = new VisualizationBL();
//	   
//	   try{
//		 visualizationBL.findByChartName(chartName);
//	   }
//	   catch(Exception e){
//		   System.out.println(e.getMessage());
//	   }
//   }
//   
//   @Path("chart/{chartId: [0-9]+}")
//   @GET
//   @ApiOperation(
//		   value = "Find chart with provided chart Id",
//		   response = ChartViewModel.class
//		   )
//   @Produces(MediaType.APPLICATION_JSON)
//   public void findChartById(@PathParam("chartId") final int chartId){
//	   VisualizationBL visualizationBL = new VisualizationBL();
//	   
//	   try{
//		   visualizationBL.findByChartId(chartId);
//	   }
//	   catch(Exception e){
//		   System.out.println(e.getMessage());
//	   }
//   }
//   
//   @Path("chart/delete/{chartId: [0-9]+}")
//   @GET
//   @ApiOperation(
//		   value = "Delete chart with provided chart Id"
//		   )
//   public void deleteChart(@PathParam("chartId") final int chartId){
//	   VisualizationBL visualizationBL = new VisualizationBL();
//	   
//	   try{
//		   visualizationBL.deleteChart(chartId);
//	   }
//	   catch(Exception e){
//		   System.out.println(e.getMessage());
//	   }
//   }
//    
  
}
