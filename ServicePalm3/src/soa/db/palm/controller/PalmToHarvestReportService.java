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
import soa.db.palm.dao.PalmToFertilizerReportDao;
import soa.db.palm.entity.Palmtoharvestreport;
import soa.db.palm.dao.PalmToHarvestReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Palmtofertilizerreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToHarvestReportService {
          private  PalmToHarvestReportDao palmToHarvestReport = new  PalmToHarvestReportDao();
    
    @Path("/palmtoharvestreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToHarvestReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtoharvestreport> palmToHarvestReports = palmToHarvestReport.getAllPalmToHarvestReport();
        res.setResponse(palmToHarvestReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtoharvestreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToHarvestReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoharvestreport palmToHarvestReports = new Palmtoharvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoharvestJSONObject = jsonObject.getJSONObject("palmtoharvestreport");
                    Farmer p =new Farmer(palmtoharvestJSONObject.getInt("Farmer_idFarmer"));
                    Harvestreport hr = new Harvestreport(palmtoharvestJSONObject.getInt("idHarvestReport"), p);
                    Addressplam ap = new Addressplam(palmtoharvestJSONObject.getInt("idAddressPlam"), p);
                    palmToHarvestReports.setIdPalmToHarvest(palmtoharvestJSONObject.getInt("idPalmToHarvest"));
                    palmToHarvestReports.setHarvestreport(hr);
                    palmToHarvestReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToHarvestReport.create(palmToHarvestReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToHarvestReports);
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
    
    @Path("/palmtoharvestreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToHarvestReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtoharvestreport palmToHarvestReports = this.palmToHarvestReport.getPalmToHarvestReport(id);
        res.setResponse(palmToHarvestReports);
        this.palmToHarvestReport.delete(palmToHarvestReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtoharvestreport/update/{id}")
        @PUT
       @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToHarvestReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoharvestreport palmToHarvestReports = new Palmtoharvestreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoharvestJSONObject = jsonObject.getJSONObject("palmtoharvestreport");
                    Farmer p =new Farmer(palmtoharvestJSONObject.getInt("Farmer_idFarmer"));
                    Harvestreport hr = new Harvestreport(palmtoharvestJSONObject.getInt("idHarvestReport"), p);
                    Addressplam ap = new Addressplam(palmtoharvestJSONObject.getInt("idAddressPlam"), p);
                    palmToHarvestReports.setIdPalmToHarvest(palmtoharvestJSONObject.getInt("idPalmToHarvest"));
                    palmToHarvestReports.setHarvestreport(hr);
                    palmToHarvestReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToHarvestReport.update(palmToHarvestReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToHarvestReports);
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
