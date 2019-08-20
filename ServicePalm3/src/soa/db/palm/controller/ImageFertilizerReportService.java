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
import soa.db.palm.entity.Imagefertilizerreport;
import soa.db.palm.dao.ImageFertilizerReportDao;
import soa.db.palm.entity.Fertilizerreport;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class ImageFertilizerReportService {
       private  ImageFertilizerReportDao imageFertilizer = new  ImageFertilizerReportDao();
    
    @Path("/imagefertilizerreport/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllImageFertilizerReport() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Imagefertilizerreport> imageFertilizerReports = imageFertilizer.getAllImageFertilizerReport();
        res.setResponse(imageFertilizerReports);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/imagefertilizerreport/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createImageFertilizerReport(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imagefertilizerreport imageFertilizerReport = new Imagefertilizerreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageFertilizerReportJSONObject = jsonObject.getJSONObject("imagefertilizerreport");
                    Farmer p =new Farmer(imageFertilizerReportJSONObject.getInt("Farmer_idFarmer"));
                    Fertilizerreport fr = new Fertilizerreport(imageFertilizerReportJSONObject.getInt("idFertilizerReport"), p);
                    imageFertilizerReport.setIdImageFertilizer(imageFertilizerReportJSONObject.getInt("idImageFertilizer"));
                    imageFertilizerReport.setImage(imageFertilizerReportJSONObject.getString("image"));
                    imageFertilizerReport.setUrl(imageFertilizerReportJSONObject.getString("url"));
                    imageFertilizerReport.setFertilizerreport(fr);
           
                    int i = imageFertilizer.create(imageFertilizerReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(imageFertilizerReport);
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
    
    @Path("/imagefertilizerreport/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteImageFertilizerReport(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Imagefertilizerreport imageFertilizerReport = imageFertilizer.getImageFertilizerReport(id);
        res.setResponse(imageFertilizerReport);
        imageFertilizer.delete(imageFertilizerReport);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/imagefertilizerreport/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateImageFertilizerReport(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Imagefertilizerreport imageFertilizerReport = new Imagefertilizerreport();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject imageFertilizerReportJSONObject = jsonObject.getJSONObject("imagefertilizerreport");
                    Farmer p =new Farmer(imageFertilizerReportJSONObject.getInt("Farmer_idFarmer"));
                    Fertilizerreport fr = new Fertilizerreport(imageFertilizerReportJSONObject.getInt("idFertilizerReport"), p);
                    imageFertilizerReport.setIdImageFertilizer(imageFertilizerReportJSONObject.getInt("idImageFertilizer"));
                    imageFertilizerReport.setImage(imageFertilizerReportJSONObject.getString("image"));
                    imageFertilizerReport.setUrl(imageFertilizerReportJSONObject.getString("url"));
                    imageFertilizerReport.setFertilizerreport(fr); 
           
                    int i = imageFertilizer.update(imageFertilizerReport);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(imageFertilizerReport);
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