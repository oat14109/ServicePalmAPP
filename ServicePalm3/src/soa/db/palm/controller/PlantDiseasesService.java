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
import soa.db.palm.entity.Plantdiseases;
import soa.db.palm.dao.PlantDiseasesDao;
import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class PlantDiseasesService {
     private PlantDiseasesDao plantDiseases = new PlantDiseasesDao();
    
    @Path("/plantdiseases/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPlantDiseases() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Plantdiseases> plantDisease = plantDiseases.getAllPlantDiseases();
        res.setResponse(plantDisease);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/plantdiseases/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPlantDiseases (InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Plantdiseases plantDisease = new Plantdiseases();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject plantDiseaseJSONObject = jsonObject.getJSONObject("plantDiseases");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(plantDiseaseJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(plantDiseaseJSONObject.getString("date"));
                     Date dater = date.parse(plantDiseaseJSONObject.getString("datereport"));
                    plantDisease.setIdPlantDiseases(plantDiseaseJSONObject.getInt("idPlantDiseases"));
                    plantDisease.setDate(datei);
                    plantDisease.setDatereport(dater);
                    plantDisease.setDiseases(plantDiseaseJSONObject.getString("diseases"));
                    plantDisease.setSymptom(plantDiseaseJSONObject.getString("symptom"));
                     
                    
             
                     plantDisease.setFarmer(p);
                    int i = plantDiseases.create(plantDisease);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(plantDisease);
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
    
    @Path("/plantdiseases/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePlantDiseases(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Plantdiseases plantDisease = plantDiseases.getPlantDiseases(id);
        res.setResponse(plantDisease);
        plantDiseases.delete(plantDisease);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/plantdiseases/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePlantDiseases(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
     String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Plantdiseases plantDisease = new Plantdiseases();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject plantDiseaseJSONObject = jsonObject.getJSONObject("plantDiseases");
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    Farmer p =new Farmer(plantDiseaseJSONObject.getInt("Farmer_idFarmer"));
                     Date datei = date.parse(plantDiseaseJSONObject.getString("date"));
                     Date dater = date.parse(plantDiseaseJSONObject.getString("datereport"));
                    plantDisease.setIdPlantDiseases(plantDiseaseJSONObject.getInt("idPlantDiseases"));
                    plantDisease.setDate(datei);
                    plantDisease.setDatereport(dater);
                    plantDisease.setDiseases(plantDiseaseJSONObject.getString("diseases"));
                    plantDisease.setSymptom(plantDiseaseJSONObject.getString("symptom"));
                     
                    
             
                     plantDisease.setFarmer(p);
                    int i = plantDiseases.update(plantDisease);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(plantDisease);
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
