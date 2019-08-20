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
import java.time.Instant;
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
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.dao.HarvestReportDao;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
@Path("services")
public class HarvestReportService {
    private HarvestReportDao harvest = new HarvestReportDao();
    
    @Path("/harvest/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllHarvestReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Harvestreport> harvests = HarvestReportDao.getAllHarvestReport();
        res.setResponse(harvests);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
   @Path("/harvest/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createHarvest(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Harvestreport harvestReport = new Harvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject harvestJSONObject = jsonObject.getJSONObject("harvest");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(harvestJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(harvestJSONObject.getString("date"));
                    Date dater = date.parse(harvestJSONObject.getString("datereport"));
                    harvestReport.setIdHarvestReport(harvestJSONObject.getInt("idHarvestReport"));
                    harvestReport.setDate(datei);
                    harvestReport.setDatereport(dater);
                    harvestReport.setNumber(harvestJSONObject.getInt("number"));
                    harvestReport.setNumToMoney(harvestJSONObject.getInt("numToMoney"));
                    harvestReport.setMoney(harvestJSONObject.getInt("money"));
                    harvestReport.setFarmer(p);
                    int i = harvest.create(harvestReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(harvestReport);
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
    
    
     @Path("/harvest/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteHarvest(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Harvestreport harvestReport = harvest.getHarvestReport(id);
        res.setResponse(harvestReport);
        harvest.delete(harvestReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
    
    @Path("/harvest/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response updateHarvest(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
   String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Harvestreport harvestReport = new Harvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject harvestJSONObject = jsonObject.getJSONObject("harvest");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(harvestJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(harvestJSONObject.getString("date"));
                    Date dater = date.parse(harvestJSONObject.getString("datereport"));
                    harvestReport.setIdHarvestReport(harvestJSONObject.getInt("idHarvestReport"));
                    harvestReport.setDate(datei);
                    harvestReport.setDatereport(dater);
                    harvestReport.setNumber(harvestJSONObject.getInt("number"));
                    harvestReport.setNumToMoney(harvestJSONObject.getInt("numToMoney"));
                    harvestReport.setMoney(harvestJSONObject.getInt("money"));
                    harvestReport.setFarmer(p);
                    int i = harvest.update(harvestReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(harvestReport);
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
