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
import soa.db.palm.dao.PalmToWaterReportDao;
import soa.db.palm.entity.Palmtoweedreport;
import soa.db.palm.dao.PalmToWeedReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Palmtowaterreport;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Waterreport;
import soa.db.palm.entity.Weedreport;
/**
 *
 * @author oat
 */
public class PalmToWeedService {
       private  PalmToWeedReportDao palmToWeedReport = new PalmToWeedReportDao();
    
    @Path("/palmtoweedreportt/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToWeedReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtoweedreport> palmToWeedReports = palmToWeedReport.getAllPalmToWeedReport();
        res.setResponse(palmToWeedReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtoweedreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToWeedReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoweedreport palmToWeedReports = new Palmtoweedreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoweedreportJSONObject = jsonObject.getJSONObject("palmtoweedreport");
                    Farmer p =new Farmer(palmtoweedreportJSONObject.getInt("Farmer_idFarmer"));
                    Weedreport wr = new Weedreport(palmtoweedreportJSONObject.getInt("idWeed"), p);
                    Addressplam ap = new Addressplam(palmtoweedreportJSONObject.getInt("idAddressPlam"), p);
                    palmToWeedReports.setIdPalmToWeedReport(palmtoweedreportJSONObject.getInt("idPalmToWeedReport"));
                    palmToWeedReports.setWeedreport(wr);
                    palmToWeedReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToWeedReport.create(palmToWeedReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToWeedReports);
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
    
    @Path("/palmtoweedreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToWeedReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtoweedreport palmToWeedReports = this.palmToWeedReport.getPalmToWeedReport(id);
        res.setResponse(palmToWeedReports);
        this.palmToWeedReport.delete(palmToWeedReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtoweedreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToWeedReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoweedreport palmToWeedReports = new Palmtoweedreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoweedreportJSONObject = jsonObject.getJSONObject("palmtoweedreport");
                    Farmer p =new Farmer(palmtoweedreportJSONObject.getInt("Farmer_idFarmer"));
                    Weedreport wr = new Weedreport(palmtoweedreportJSONObject.getInt("idWeed"), p);
                    Addressplam ap = new Addressplam(palmtoweedreportJSONObject.getInt("idAddressPlam"), p);
                    palmToWeedReports.setIdPalmToWeedReport(palmtoweedreportJSONObject.getInt("idPalmToWeedReport"));
                    palmToWeedReports.setWeedreport(wr);
                    palmToWeedReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToWeedReport.update(palmToWeedReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToWeedReports);
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
