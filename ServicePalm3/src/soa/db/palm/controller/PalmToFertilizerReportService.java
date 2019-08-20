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
import soa.db.palm.dao.PalmToCutLeafReportDao;
import soa.db.palm.entity.Palmtofertilizerreport;
import soa.db.palm.dao.PalmToFertilizerReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Palmtocutleafreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToFertilizerReportService {
      private  PalmToFertilizerReportDao palmToFertilizerReport = new  PalmToFertilizerReportDao();
    
    @Path("/palmtofertilizerreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToFertilizerReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtofertilizerreport> palmToFertilizerReports = palmToFertilizerReport.getAllPalmToFertilizerReport();
        res.setResponse(palmToFertilizerReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtofertilizerreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToFertilizerReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtofertilizerreport palmToFertilizerReports = new Palmtofertilizerreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtofertilizerJSONObject = jsonObject.getJSONObject("palmtofertilizerreport");
                    Farmer p =new Farmer(palmtofertilizerJSONObject.getInt("Farmer_idFarmer"));
                    Fertilizerreport fr = new Fertilizerreport(palmtofertilizerJSONObject.getInt("idFertilizerReport"), p);
                    Addressplam ap = new Addressplam(palmtofertilizerJSONObject.getInt("idAddressPlam"), p);
                    palmToFertilizerReports.setIdPalmToFertilizer(palmtofertilizerJSONObject.getInt("idPalmToFertilizer"));
                    palmToFertilizerReports.setFertilizerreport(fr);
                    palmToFertilizerReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToFertilizerReport.create(palmToFertilizerReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToFertilizerReports);
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
    
    @Path("/palmtofertilizerreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToFertilizerReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtofertilizerreport palmToFertilizerReports = this.palmToFertilizerReport.getPalmToFertilizerReport(id);
        res.setResponse(palmToFertilizerReports);
        this.palmToFertilizerReport.delete(palmToFertilizerReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtofertilizerreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToFertilizerReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
         String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtofertilizerreport palmToFertilizerReports = new Palmtofertilizerreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtofertilizerJSONObject = jsonObject.getJSONObject("palmtofertilizerreport");
                    Farmer p =new Farmer(palmtofertilizerJSONObject.getInt("Farmer_idFarmer"));
                    Fertilizerreport fr = new Fertilizerreport(palmtofertilizerJSONObject.getInt("idFertilizerReport"), p);
                    Addressplam ap = new Addressplam(palmtofertilizerJSONObject.getInt("idAddressPlam"), p);
                    palmToFertilizerReports.setIdPalmToFertilizer(palmtofertilizerJSONObject.getInt("idPalmToFertilizer"));
                    palmToFertilizerReports.setFertilizerreport(fr);
                    palmToFertilizerReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToFertilizerReport.update(palmToFertilizerReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToFertilizerReports);
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
