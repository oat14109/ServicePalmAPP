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
import soa.db.palm.entity.Bugreport;
import soa.db.palm.entity.Imagebugreport;
import soa.db.palm.dao.ImageBugReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageBugReportService {
       private  ImageBugReportDao imageBug = new  ImageBugReportDao();
    
    @Path("/imagebugreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllImageBugReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Imagebugreport> imageBugReports = imageBug.getAllImageBugReport();
        res.setResponse(imageBugReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/addressplam/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createImageBugReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imagebugreport imageBugReport = new Imagebugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageBugReportJSONObject = jsonObject.getJSONObject("imagebugreport");
                    Farmer p =new Farmer(imageBugReportJSONObject.getInt("Farmer_idFarmer"));
                    Bugreport br = new Bugreport(imageBugReportJSONObject.getInt("idBug"), p);
                    imageBugReport.setIdImageBug(imageBugReportJSONObject.getInt("idImageBug"));
                    imageBugReport.setImage(imageBugReportJSONObject.getString("image"));
                    imageBugReport.setUrl(imageBugReportJSONObject.getString("url"));
                    imageBugReport.setBugreport(br);
           
                    int i = imageBug.create(imageBugReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(imageBugReport);
                          ObjectMapper map = new ObjectMapper();
                         result = map.writeValueAsString(res);
                        return Response.status(res.getStatusCode()).entity(result).build();
                    }
                    else
                    {
                         ResponseForm res = new ResponseForm();
                         res.setResponse("create faill");
                        return Response.status(res.getStatusCode()).entity(res).build();
                    }
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
                
                  
    }
    
    @Path("/addressplam/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteImageBugReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Imagebugreport imageBugReport = imageBug.getImageBugReport(id);
        res.setResponse(imageBugReport);
        imageBug.delete(imageBugReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/addressplam/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateImageBugReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
      String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imagebugreport imageBugReport = new Imagebugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageBugReportJSONObject = jsonObject.getJSONObject("imagebugreport");
                    Farmer p =new Farmer(imageBugReportJSONObject.getInt("Farmer_idFarmer     "));
                    Bugreport br = new Bugreport(imageBugReportJSONObject.getInt("idBug"), p);
                    imageBugReport.setIdImageBug(imageBugReportJSONObject.getInt("idImageBug"));
                    imageBugReport.setImage(imageBugReportJSONObject.getString("image"));
                    imageBugReport.setUrl(imageBugReportJSONObject.getString("url"));
                    imageBugReport.setBugreport(br);
           
                    int i = imageBug.update(imageBugReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(imageBugReport);
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
