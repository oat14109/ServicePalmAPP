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
import soa.db.palm.entity.Palmtocutleafreport;
import soa.db.palm.dao.PalmToCutLeafReportDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.entity.Palmtocarwaterreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PalmToCutLeafReportService {
      private  PalmToCutLeafReportDao palmToCutLeafReport = new  PalmToCutLeafReportDao();
    
    @Path("/palmtocutleafreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToCutLeafReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtocutleafreport> palmToCutLeafReports = palmToCutLeafReport.getAllPalmToCutLeafReport();
        res.setResponse(palmToCutLeafReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtocutleafreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToCutLeafReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtocutleafreport palmToCutLeafReports = new Palmtocutleafreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtocarwaterJSONObject = jsonObject.getJSONObject("palmtocutleafreport");
                    Farmer p =new Farmer(palmtocarwaterJSONObject.getInt("Farmer_idFarmer"));
                    Cutleafreport clr = new Cutleafreport(palmtocarwaterJSONObject.getInt("idCutLeafReport"), p);
                    Addressplam ap = new Addressplam(palmtocarwaterJSONObject.getInt("idAddressPlam"), p);
                    palmToCutLeafReports.setIdPalmToCutLeaf(palmtocarwaterJSONObject.getInt("idPalmToCutLeaf"));
                    palmToCutLeafReports.setCutleafreport(clr);
                    palmToCutLeafReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToCutLeafReport.create(palmToCutLeafReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToCutLeafReports);
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
    
    @Path("/palmtocutleafreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToCutLeafReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtocutleafreport palmToCutLeafReports = this.palmToCutLeafReport.getPalmToCutLeafReport(id);
        res.setResponse(palmToCutLeafReports);
        this.palmToCutLeafReport.delete(palmToCutLeafReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtocutleafreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToCutLeafReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
          String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtocutleafreport palmToCutLeafReports = new Palmtocutleafreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtocarwaterJSONObject = jsonObject.getJSONObject("palmtocutleafreport");
                    Farmer p =new Farmer(palmtocarwaterJSONObject.getInt("Farmer_idFarmer"));
                    Cutleafreport clr = new Cutleafreport(palmtocarwaterJSONObject.getInt("idCutLeafReport"), p);
                    Addressplam ap = new Addressplam(palmtocarwaterJSONObject.getInt("idAddressPlam"), p);
                    palmToCutLeafReports.setIdPalmToCutLeaf(palmtocarwaterJSONObject.getInt("idPalmToCutLeaf"));
                    palmToCutLeafReports.setCutleafreport(clr);
                    palmToCutLeafReports.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToCutLeafReport.update(palmToCutLeafReports);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToCutLeafReports);
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
