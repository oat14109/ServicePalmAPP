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
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.dao.CutLeafReportDao;
import soa.db.palm.entity.Event;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class CutLeafReportService {
     private CutLeafReportDao cutleaf = new CutLeafReportDao();
    
    @Path("/cutleaf/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllCutLeaf() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Cutleafreport> cutLeafReport = cutleaf.getAllCutLeafReport();
        res.setResponse(cutLeafReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/cutleaf/create")
    @POST
   @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createCutLeaf(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Cutleafreport cutLeafReport = new Cutleafreport ();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject cutLeafJSONObject = jsonObject.getJSONObject("cutleaf");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(cutLeafJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(cutLeafJSONObject.getString("date"));
                    Date dater = date.parse(cutLeafJSONObject.getString("datereport"));
                    cutLeafReport.setIdCutLeafReport(cutLeafJSONObject.getInt("idCutLeafReport"));
                    cutLeafReport.setDate(datei);
                    cutLeafReport.setDatereport(dater);
                    
             
                    cutLeafReport.setFarmer(p);
                    int i = cutleaf.create(cutLeafReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(cutLeafReport);
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
    
    @Path("/cutleaf/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteCutLeaf(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Cutleafreport cutLeafs = cutleaf.getCutLeafReport(id);
        res.setResponse(cutLeafs);
        cutleaf.delete(cutLeafs);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/cutleaf/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        public  Response updateCutLeaf(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Cutleafreport cutLeafReport = new Cutleafreport ();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject cutLeafJSONObject = jsonObject.getJSONObject("cutleaf");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(cutLeafJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(cutLeafJSONObject.getString("date"));
                    Date dater = date.parse(cutLeafJSONObject.getString("datereport"));
                    cutLeafReport.setIdCutLeafReport(cutLeafJSONObject.getInt("idCutLeafReport"));
                    cutLeafReport.setDate(datei);
                    cutLeafReport.setDatereport(dater);
             
                    cutLeafReport.setFarmer(p);
                    int i = cutleaf.update(cutLeafReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(cutLeafReport);
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
