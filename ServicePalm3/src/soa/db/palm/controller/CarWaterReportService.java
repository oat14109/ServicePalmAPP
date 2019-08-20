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
import soa.db.palm.entity.Carwaterreport;
import soa.db.palm.dao.CarWaterReportDao;
import soa.db.palm.entity.Cutleafreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class CarWaterReportService {
    private CarWaterReportDao carwater = new CarWaterReportDao();
    
    @Path("/carwater/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllCarWater() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Carwaterreport> carWaterReport = carwater.getAllCarWaterReport();
        res.setResponse(carWaterReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/carwater/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createCarWater(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Carwaterreport carWaterReport = new Carwaterreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject carWaterJSONObject = jsonObject.getJSONObject("carwater");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(carWaterJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(carWaterJSONObject.getString("date"));
                    Date dater = date.parse(carWaterJSONObject.getString("datereport"));
                    carWaterReport.setIdCarWaterReport(carWaterJSONObject.getInt("idCarWaterReport"));
                    carWaterReport.setDate(datei);
                    carWaterReport.setDatereport(dater);
             
                    carWaterReport.setFarmer(p);
                    int i = carwater.create(carWaterReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(carWaterReport);
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
    
    @Path("/carwater/delete/{id}")
    @DELETE
   @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteCarWater(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Carwaterreport carwaters = carwater.getCarWaterReport(id);
        res.setResponse(carwaters);
        carwater.delete(carwaters);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/carwater/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateCarWater(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Carwaterreport carWaterReport = new Carwaterreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject carWaterJSONObject = jsonObject.getJSONObject("carwater");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(carWaterJSONObject.getInt("Farmer_idFarmer"));
                    Date datei = date.parse(carWaterJSONObject.getString("date"));
                    Date dater = date.parse(carWaterJSONObject.getString("datereport"));
                    carWaterReport.setIdCarWaterReport(carWaterJSONObject.getInt("idCarWaterReport"));
                    carWaterReport.setDate(datei);
                    carWaterReport.setDatereport(dater);
             
                    carWaterReport.setFarmer(p);
                    int i = carwater.update(carWaterReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(carWaterReport);
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
