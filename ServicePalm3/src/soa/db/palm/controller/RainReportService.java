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
import soa.db.palm.entity.Rainreport;
import soa.db.palm.dao.RainReportDao;
import soa.db.palm.entity.Farmer;

/**
 *
 * @author oat
 */
public class RainReportService {
     private RainReportDao rainReports = new RainReportDao();
    
    @Path("/rainreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllRainReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Rainreport> rainReport = rainReports.getAllRainReport();
        res.setResponse(rainReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/rainreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createRainReport (InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Rainreport rainReport = new Rainreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject rainReportJSONObject = jsonObject.getJSONObject("rainReport");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                     SimpleDateFormat time = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(rainReportJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(rainReportJSONObject.getString("date"));
                     Date dater = date.parse(rainReportJSONObject.getString("datereport"));
                     Date timei = date.parse(rainReportJSONObject.getString("time"));
                    rainReport.setIdRain(rainReportJSONObject.getInt("idRain"));
                    rainReport.setDate(datei);
                    rainReport.setDatereport(dater);
                    rainReport.setTime(timei);
                    rainReport.setHoursOrMinute(rainReportJSONObject.getInt("HoursOrMinute"));
                    rainReport.setVolume(rainReportJSONObject.getDouble("Volume"));
                     
                    
             
                     rainReport.setFarmer(p);
                    int i = rainReports.create(rainReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(rainReport);
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
    
    @Path("/rainreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteRainReport (@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Rainreport rainReport = rainReports.getRainReport(id);
        res.setResponse(rainReport);
        rainReports.delete(rainReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/rainreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateRainReport (@PathParam("id") int id, InputStream incomingData) throws IOException
        {
         String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Rainreport rainReport = new Rainreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject rainReportJSONObject = jsonObject.getJSONObject("rainReport");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                     SimpleDateFormat time = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(rainReportJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(rainReportJSONObject.getString("date"));
                     Date dater = date.parse(rainReportJSONObject.getString("datereport"));
                     Date timei = date.parse(rainReportJSONObject.getString("time"));
                    rainReport.setIdRain(rainReportJSONObject.getInt("idRain"));
                    rainReport.setDate(datei);
                    rainReport.setDatereport(dater);
                    rainReport.setTime(timei);
                    rainReport.setHoursOrMinute(rainReportJSONObject.getInt("HoursOrMinute"));
                    rainReport.setVolume(rainReportJSONObject.getDouble("Volume"));
                     
                    
             
                     rainReport.setFarmer(p);
                    int i = rainReports.update(rainReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(rainReport);
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
