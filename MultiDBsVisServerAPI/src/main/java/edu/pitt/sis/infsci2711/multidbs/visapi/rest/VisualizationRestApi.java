package edu.pitt.sis.infsci2711.multidbs.visapi.rest; 

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import edu.pitt.sis.infsci2711.multidbs.vis.bll.VisualizationBL;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;

@Path("Visualization/")
public class VisualizationRestApi {

	@Path("metadata/new/{userId}/{canvasName}")
	@GET
	@ApiOperation(
			value = "Create new canvas in the database.",
			response = CanvasViewModel.class
			)
    public CanvasViewModel createCanvas(@PathParam("userId") final int userId, @PathParam("canvasName") final String canvasName) {
		
		VisualizationBL visualization = new VisualizationBL();
		
		try{
			CanvasViewModel canvasVM = visualization.createCanvase(userId, canvasName);
			
			if(canvasVM != null){
				return canvasVM;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}
		return null;
		
	}
	
   @Path("metadata/{canvasName}")
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
		
   @Path("metadata/{vid: [0-9]+}")
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
   
}
