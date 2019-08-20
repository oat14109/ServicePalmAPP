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
import soa.db.palm.entity.Palmtobugreport;
import soa.db.palm.dao.PalmToBugReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Bugreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToBugReportService {
    private  PalmToBugReportDao palmToBugReport = new  PalmToBugReportDao();
    
    @Path("/palmtobugreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToBugReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtobugreport> palmToBugReports = palmToBugReport.getAllPalmToBugReport();
        res.setResponse(palmToBugReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtobugreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToBugReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtobugreport palmtobugreports = new Palmtobugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtobugreportJSONObject = jsonObject.getJSONObject("palmtobugreport");
                    Farmer p =new Farmer(palmtobugreportJSONObject.getInt("Farmer_idFarmer"));
                    Bugreport br = new Bugreport(palmtobugreportJSONObject.getInt("idBug"), p);
                    Addressplam ap = new Addressplam(palmtobugreportJSONObject.getInt("idAddressPlam"), p);
                    palmtobugreports.setIdPalmToBug(palmtobugreportJSONObject.getInt("idPalmToBug"));
                    palmtobugreports.setBugreport(br);
                    palmtobugreports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToBugReport.create(palmtobugreports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmtobugreports);
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
    
    @Path("/palmtobugreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToBugReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtobugreport palmtobugrepors = this.palmToBugReport.getPalmToBugReport(id);
        res.setResponse(palmtobugrepors);
        this.palmToBugReport.delete(palmtobugrepors);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/palmtobugreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToBugReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
          String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtobugreport palmtobugreports = new Palmtobugreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtobugreportJSONObject = jsonObject.getJSONObject("palmtobugreport");
                    Farmer p =new Farmer(palmtobugreportJSONObject.getInt("Farmer_idFarmer"));
                    Bugreport br = new Bugreport(palmtobugreportJSONObject.getInt("idBug"), p);
                    Addressplam ap = new Addressplam(palmtobugreportJSONObject.getInt("idAddressPlam"), p);
                    palmtobugreports.setIdPalmToBug(palmtobugreportJSONObject.getInt("idPalmToBug"));
                    palmtobugreports.setBugreport(br);
                    palmtobugreports.setAddressplam(ap);
                   
           
                    int i = this.palmToBugReport.update(palmtobugreports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmtobugreports);
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
