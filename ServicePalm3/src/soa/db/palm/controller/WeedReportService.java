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
import soa.db.palm.dao.WaterReportDao;
import soa.db.palm.entity.Weedreport;
import soa.db.palm.dao.WeedReportDao;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Waterreport;
/**
 *
 * @author oat
 */
public class WeedReportService {
       private WeedReportDao weedReports = new WeedReportDao();
    
    @Path("/weedreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllWeedReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Weedreport> weedReport = weedReports.getAllWeedReport();
        res.setResponse(weedReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/weedreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createWeedReport (InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Weedreport weedReport = new Weedreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject weedReportJSONObject = jsonObject.getJSONObject("weedReport");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(weedReportJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(weedReportJSONObject.getString("date"));
                     Date dater = date.parse(weedReportJSONObject.getString("datereport"));
                    weedReport.setIdWeed(weedReportJSONObject.getInt("idRain"));
                    weedReport.setDate(datei);
                    weedReport.setDatereport(dater);
                     
                    
             
                     weedReport.setFarmer(p);
                    int i = weedReports.create(weedReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(weedReport);
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
    
    @Path("/weedreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteWeedReport (@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Weedreport weedReport = weedReports.getWeedReport(id);
        res.setResponse(weedReport);
        weedReports.delete(weedReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/waterreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateWeedReport (@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Weedreport weedReport = new Weedreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject weedReportJSONObject = jsonObject.getJSONObject("weedReport");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(weedReportJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(weedReportJSONObject.getString("date"));
                     Date dater = date.parse(weedReportJSONObject.getString("datereport"));
                    weedReport.setIdWeed(weedReportJSONObject.getInt("idWeed"));
                    weedReport.setDate(datei);
                    weedReport.setDatereport(dater);
                     
                    
             
                     weedReport.setFarmer(p);
                    int i = weedReports.update(weedReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(weedReport);
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
