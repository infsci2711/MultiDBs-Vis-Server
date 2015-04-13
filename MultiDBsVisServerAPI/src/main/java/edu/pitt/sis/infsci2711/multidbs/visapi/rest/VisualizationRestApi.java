package edu.pitt.sis.infsci2711.multidbs.visapi.rest; 

import java.util.ArrayList;
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
			//CanvasViewModel canvasVM = visualizationBL.createCanvase(userId, name);
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
   @Path("canvas/user/{userId: [0-9]+}")
   @GET
   @ApiOperation(
		   value = "Find all the canvases created by the user with provided user Id"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   public List<CanvasViewModel> findCanvasByUser(@PathParam("userId") final int userId){
	   
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try {
		  List<CanvasViewModel> canvasVMList = visualizationBL.findCanvasByUser(userId);
		  return canvasVMList;
	} catch (Exception e) {
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
   public List<StoryViewModel> createStory(StoryViewModel storyVM) {
		
	   VisualizationBL visualizationBL = new VisualizationBL();
	   List<StoryViewModel> storyVMList = new ArrayList<StoryViewModel>();
		 
	   try{ 
		   
//		   Client client = ClientBuilder.newClient();
//		   
//		   String result = client.target("http://localhost:7890/Visualization/canvas/")
//				           .path("6")
//				           .request(MediaType.APPLICATION_JSON)
//				           .get(String.class);
		   
//		   if(!result.equals("[]")){
			   storyVM = visualizationBL.createStory(storyVM.getDid(), storyVM.getDname(), storyVM.getTname(), storyVM.getCanvasVM().getVid());
			   
			   if(storyVM != null){
				   storyVMList.add(storyVM);
				   
				   return storyVMList;
			   //}
		   }
		   
	   }catch(Exception e){
		   System.out.println(e.getMessage());	
	   }
	   return storyVMList;	
   }
   
   //OK
   @Path("story/showAll/{vid}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<StoryViewModel> showAllByCanvasId(@PathParam("vid") final int vid){
	   
	   VisualizationBL visualizationBL = new VisualizationBL();
	   List<StoryViewModel> storyVMList = new ArrayList<StoryViewModel>();
	   
	   try{
		   storyVMList = visualizationBL.showAllByCanvasId(vid);
		   return storyVMList;
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return storyVMList;
   }
  
  //OK FOR GET
   @Path("story/delete/{sid}") 
   @GET
   @ApiOperation(
		   value = "Delete metadata for the story with provided story Id"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   //@Consumes(MediaType.APPLICATION_JSON)
   public String deleteStory(@PathParam("sid") final int sid){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   
	   try{
		   int flag = visualizationBL.deleteStory(sid);
		   //int flag = visualization.deleteStory(storyVM.getSid());
		   if (flag == 1) return "{\"flag\" : \"S\"}"; 
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return "{\"flag\" : \"F\"}";
   }
   
 
  
   /********************** chart **********************/
   
 
   @Path("chart/new/{sid}/{type}/{did}/{dname}/{tname}/{columns}")
   @GET
   //@Consumes(MediaType.APPLICATION_JSON) 
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(
		   value = "Create a new chart with provided canvas Id, chart name and chart type"
		   )
   public ChartViewModel createChart(@PathParam("sid") final int sid, @PathParam("type") final String type, @PathParam("did") final String did, @PathParam("dname") final String dname, @PathParam("tname") final String tname, @PathParam("columns") final String columns){
	   
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		  ChartViewModel chartVM = visualizationBL.createChart(sid, type, did, dname, tname, columns);
	  // chartVM = visualizationBL.createChart(chartVM.getStoryVM().getSid(), chartVM.getType(), chartVM.getDid(), chartVM.getDname(), chartVM.getTname(), chartVM.getColumns());
	   if(chartVM != null){
		   return chartVM;
	   }
	  
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   }
          return null;
   }
   
   @Path("chart/showAll/{sid}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<ChartViewModel> showAllByStoryId(@PathParam("sid") final int sid){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   List<ChartViewModel> chartVMList = new ArrayList<ChartViewModel>();
	   try {
		chartVMList = visualizationBL.showAllByStoryId(sid);
		return chartVMList;
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	   return chartVMList;
   }

  
   @Path("chart/delete/{cid}")
   @GET
   @ApiOperation(
		   value = "Delete chart with provided chart Id"
		   )
   @Produces(MediaType.APPLICATION_JSON)
   public String deleteChart(@PathParam("cid") final int cid){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		   int flag = visualizationBL.deleteChart(cid);
		  //int flag =  visualizationBL.deleteChart(chartVM.getCid());
		  if(flag==1) return "{\"flag\" : \"S\"}";  
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return "{\"flag\" : \"F\"}";
   }

  
   

  
}
