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

import jnr.ffi.Struct.int16_t;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import edu.pitt.sis.infsci2711.multidbs.vis.bll.VisualizationBL;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.CanvasViewModel;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels.ChartViewModel;

@Path("Visualization/")
public class VisualizationRestApi {

	@Path("canvas/new/{userId}/{canvasName}")
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
		
   @Path("canvas/{vid: [0-9]+}")
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
   public void deleteCanvas(@PathParam("vid") final int vid){
	   VisualizationBL visualization = new VisualizationBL();
	   
	   try{
		   visualization.deleteCanvas(vid);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
   @Path("chart/new/{canvasId}/{chartName}/{chartType}")
   @GET
   @ApiOperation(
		   value = "Create a new chart with provided canvas Id, chart name and chart type"
		   )
   public void createChart(@PathParam("canvasId") final int canvasId, @PathParam("chartName") final String chartName, @PathParam("chartType") final String chartType){
	   VisualizationBL visualizationBL = new VisualizationBL();
	   
	   try{
		   visualizationBL.createChart(canvasId, chartName, chartType);
	   }
	   catch(Exception e){
		   System.out.println(e.getMessage());
	   }
   }
   
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
    
   
}
