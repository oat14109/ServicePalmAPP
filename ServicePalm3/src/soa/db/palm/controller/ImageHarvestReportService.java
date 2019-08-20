/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import soa.db.palm.entity.Imageharvestreport;
import soa.db.palm.dao.ImageHarvestReportDao;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageHarvestReportService {
     private  ImageHarvestReportDao imageHarvest = new  ImageHarvestReportDao();
    
    @Path("/imageharvestreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllImageHarvestReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Imageharvestreport> imageHarvestReports = imageHarvest.getAllImageHarvestReport();
        res.setResponse(imageHarvestReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/imageharvestreport/create")
    @POST
   @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createImageHarvestReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imageharvestreport imageHarvestReport = new Imageharvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageHarvestReportJSONObject = jsonObject.getJSONObject("imageharvestreport");
                    Farmer p =new Farmer(imageHarvestReportJSONObject.getInt("Farmer_idFarmer"));
                    Harvestreport hr = new Harvestreport(imageHarvestReportJSONObject.getInt("idHarvestReport"), p);
                    imageHarvestReport.setIdImageHarvest(imageHarvestReportJSONObject.getInt("idImageHarvest"));
                    imageHarvestReport.setImage(imageHarvestReportJSONObject.getString("image"));
                    imageHarvestReport.setUrl(imageHarvestReportJSONObject.getString("url"));
                    imageHarvestReport.setHarvestreport(hr);
           
                    int i = imageHarvest.create(imageHarvestReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(imageHarvestReport);
                          ObjectMapper map = new ObjectMapper();
                         result = map.writeValueAsString(res);
                        return Response.status(res.getStatusCode()).entity(result).build();
                    }
                    else
                    {
                         ResponseForm res = new ResponseForm();
                         res.setResponse("create fail");
                        return Response.status(res.getStatusCode()).entity(res).build();
                    }
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
                
                  
    }
    
    @Path("/imageharvestreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteImageHarvestReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Imageharvestreport imageHarvestReport = imageHarvest.getImageHarvestReport(id);
        res.setResponse(imageHarvestReport);
        imageHarvest.delete(imageHarvestReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/imageharvestreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateImageHarvestReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
         String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imageharvestreport imageHarvestReport = new Imageharvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageHarvestReportJSONObject = jsonObject.getJSONObject("imageharvestreport");
                    Farmer p =new Farmer(imageHarvestReportJSONObject.getInt("Farmer_idFarmer"));
                    Harvestreport hr = new Harvestreport(imageHarvestReportJSONObject.getInt("idHarvestReport"), p);
                    imageHarvestReport.setIdImageHarvest(imageHarvestReportJSONObject.getInt("idImageHarvest"));
                    imageHarvestReport.setImage(imageHarvestReportJSONObject.getString("image"));
                    imageHarvestReport.setUrl(imageHarvestReportJSONObject.getString("url"));
                    imageHarvestReport.setHarvestreport(hr);
           
                    int i = imageHarvest.update(imageHarvestReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(imageHarvestReport);
                          ObjectMapper map = new ObjectMapper();
                         result = map.writeValueAsString(res);
                        return Response.status(res.getStatusCode()).entity(result).build();
                    }
                    else
                    {
                         ResponseForm res = new ResponseForm();
                         res.setResponse("update faill");
                        return Response.status(res.getStatusCode()).entity(res).build();
                    }
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
                
        }

       public  static void main(String[] args) throws IOException
    {
       
    }
    
}
