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
import soa.db.palm.dao.PalmToPlantDiseasesDao;
import soa.db.palm.entity.Palmtowaterreport;
import soa.db.palm.dao.PalmToWaterReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.entity.Palmtoplantdiseases;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Plantdiseases;
import soa.db.palm.entity.Waterreport;
/**
 *
 * @author oat
 */
public class PalmToWaterReportService {
       private  PalmToWaterReportDao palmToWaterReport = new PalmToWaterReportDao();
    
    @Path("/palmtowaterreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToWaterReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtowaterreport> palmToWaterReports = palmToWaterReport.getAllPalmToWaterReport();
        res.setResponse(palmToWaterReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtowaterreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToWaterReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtowaterreport palmToWaterReports = new Palmtowaterreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtowaterreportJSONObject = jsonObject.getJSONObject("palmtowaterreport");
                    Farmer p =new Farmer(palmtowaterreportJSONObject.getInt("Farmer_idFarmer"));
                    Waterreport wr = new Waterreport(palmtowaterreportJSONObject.getInt("idWaterReport"), p);
                    Addressplam ap = new Addressplam(palmtowaterreportJSONObject.getInt("idAddressPlam"), p);
                    palmToWaterReports.setIdPalmToWater(palmtowaterreportJSONObject.getInt("idPalmToWater"));
                    palmToWaterReports.setWaterreport(wr);
                    palmToWaterReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToWaterReport.create(palmToWaterReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToWaterReports);
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
    
    @Path("/palmtowaterreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToWaterReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtowaterreport palmToWaterReports = this.palmToWaterReport.getPalmToWaterReport(id);
        res.setResponse(palmToWaterReports);
        this.palmToWaterReport.delete(palmToWaterReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtowaterreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToWaterReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
         String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtowaterreport palmToWaterReports = new Palmtowaterreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtowaterreportJSONObject = jsonObject.getJSONObject("palmtowaterreport");
                    Farmer p =new Farmer(palmtowaterreportJSONObject.getInt("Farmer_idFarmer"));
                    Waterreport wr = new Waterreport(palmtowaterreportJSONObject.getInt("idWaterReport"), p);
                    Addressplam ap = new Addressplam(palmtowaterreportJSONObject.getInt("idAddressPlam"), p);
                    palmToWaterReports.setIdPalmToWater(palmtowaterreportJSONObject.getInt("idPalmToWater"));
                    palmToWaterReports.setWaterreport(wr);
                    palmToWaterReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToWaterReport.update(palmToWaterReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToWaterReports);
                          ObjectMapper map = new ObjectMapper();
                         result = map.writeValueAsString(res);
                        return Response.status(res.getStatusCode()).entity(result).build();
                    }
                    else
                    {
                         ResponseForm res = new ResponseForm();
                         res.setResponse("update fail");
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
