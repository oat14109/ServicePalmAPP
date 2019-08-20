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
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.dao.FertilizerReportDao;
import soa.db.palm.entity.Farmer;

/**
 *
 * @author oat
 */
@Path("services")
public class FertilizerReportService {
    private FertilizerReportDao fertilizer = new FertilizerReportDao();
    
    @Path("/fertilizer/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllFertilizerReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Fertilizerreport> fertilizers = FertilizerReportDao.getAllFertilizerReport();
        res.setResponse(fertilizers);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/fertilizer/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createFertilizer(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Fertilizerreport fertilizerReport = new Fertilizerreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject fertilizerJSONObject = jsonObject.getJSONObject("fertilizer");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(fertilizerJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(fertilizerJSONObject.getString("date"));
                    Date dater = date.parse(fertilizerJSONObject.getString("datereport"));
                    fertilizerReport.setIdFertilizerReport(fertilizerJSONObject.getInt("idFertilizerReport"));
                    fertilizerReport.setDate(datei);
                    fertilizerReport.setDatereport(dater);
                    fertilizerReport.setVolume(fertilizerJSONObject.getInt("volume"));
                    fertilizerReport.setFertilizer(fertilizerJSONObject.getString("Fertilizer"));
             
                    fertilizerReport.setFarmer(p);
                    int i = fertilizer.create(fertilizerReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(fertilizerReport);
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
    
    @Path("/fertilizer/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteFertilizer(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Fertilizerreport fertilizerReport = fertilizer.getFertilizerReport(id);
        res.setResponse(fertilizerReport);
        fertilizer.delete(fertilizerReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
    
        @Path("/fertilizer/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateFertilizer(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
            String result = "";
            StringBuilder crunchifyBuilder = new StringBuilder();
            Fertilizerreport fertilizerReport = new Fertilizerreport();
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            try {

                    String line = null;
                    while ((line = in.readLine()) != null) {
                            crunchifyBuilder.append(line);
                    }
                        JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                        JSONObject fertilizerJSONObject = jsonObject.getJSONObject("fertilizer");
                        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                        Farmer p =new Farmer(fertilizerJSONObject.getInt("Farmer_idFarmer"));
                        Date datei = date.parse(fertilizerJSONObject.getString("date"));
                        Date dater = date.parse(fertilizerJSONObject.getString("datereport"));
                        fertilizerReport.setIdFertilizerReport(fertilizerJSONObject.getInt("idFertilizerReport"));
                        fertilizerReport.setDate(datei);
                        fertilizerReport.setDatereport(dater);
                        fertilizerReport.setVolume(fertilizerJSONObject.getInt("volume"));
                        fertilizerReport.setFertilizer(fertilizerJSONObject.getString("Fertilizer"));

                        fertilizerReport.setFarmer(p);
                        int i = fertilizer.update(fertilizerReport);
                        if (i==1) {
                            ResponseForm res = new ResponseForm();
                            res.setStatusCode(Response.Status.OK.getStatusCode());
                            res.setStatus("OK");
                             res.setResponse("update successfully");
                             res.setResponse(fertilizerReport);
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
