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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import soa.db.palm.dao.BugReportDao;
import soa.db.palm.dao.CarWaterReportDao;
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class BugReportService {
    private BugReportDao bug = new BugReportDao();
    
    @Path("/bug/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllBug() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Bugreport> bugReport = bug.getAllBugReport();
        res.setResponse(bugReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/bug/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createBug(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Bugreport bugReport = new Bugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject bugJSONObject = jsonObject.getJSONObject("bug");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(bugJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(bugJSONObject.getString("date"));
                    Date dater = date.parse(bugJSONObject.getString("datereport"));
                    bugReport.setIdBug(bugJSONObject.getInt("idBug"));
                    bugReport.setDate(datei);
                    bugReport.setDatereport(dater);
            
                    bugReport.setFarmer(p);
                    int i = bug.create(bugReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(bugReport);
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
    
    @Path("/bug/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteBug(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Bugreport bugReport = bug.getBugReport(id);
        res.setResponse(bugReport);
        bug.delete(bugReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/bug/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateBug(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Bugreport bugReport = new Bugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject bugJSONObject = jsonObject.getJSONObject("bug");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(bugJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(bugJSONObject.getString("date"));
                    Date dater = date.parse(bugJSONObject.getString("datereport"));
                    bugReport.setIdBug(bugJSONObject.getInt("idCarWaterReport"));
                    bugReport.setDate(datei);
                    bugReport.setDatereport(dater);
             
                    bugReport.setFarmer(p);
                    int i = bug.update(bugReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(bugReport);
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

       public  static void main(String[] args) throws IOException
    {
       
    }
    
    
}
