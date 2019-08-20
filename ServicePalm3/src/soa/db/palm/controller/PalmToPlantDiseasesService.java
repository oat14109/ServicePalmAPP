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
import soa.db.palm.dao.PalmToHarvestReportDao;
import soa.db.palm.entity.Palmtoplantdiseases;
import soa.db.palm.dao.PalmToPlantDiseasesDao;
import soa.db.palm.entity.Addressplam;
import soa.db.palm.entity.Harvestreport;
import soa.db.palm.entity.Palmtoharvestreport;
import soa.db.palm.entity.Farmer;
import soa.db.palm.entity.Plantdiseases;
/**
 *
 * @author oat
 */
public class PalmToPlantDiseasesService {
        private  PalmToPlantDiseasesDao palmToPlantDiseases = new  PalmToPlantDiseasesDao();
    
    @Path("/palmtoplantdiseases/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllPalmToPlantDiseases() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Palmtoplantdiseases> palmToPlantDiseasess = palmToPlantDiseases.getAllPalmToPlantDiseases();
        res.setResponse(palmToPlantDiseasess);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/palmtoplantdiseases/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createPalmToPlantDiseases(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoplantdiseases palmToPlantDiseasess = new Palmtoplantdiseases();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoplantdiseasesJSONObject = jsonObject.getJSONObject("palmtoplantdiseases");
                    Farmer p =new Farmer(palmtoplantdiseasesJSONObject.getInt("Farmer_idFarmer"));
                    Plantdiseases pd = new Plantdiseases(palmtoplantdiseasesJSONObject.getInt("idPlantDiseases"), p);
                    Addressplam ap = new Addressplam(palmtoplantdiseasesJSONObject.getInt("idAddressPlam"), p);
                    palmToPlantDiseasess.setIdPalmToPlantDiseases(palmtoplantdiseasesJSONObject.getInt("idPalmToPlantDiseases"));
                    palmToPlantDiseasess.setPlantdiseases(pd);
                    palmToPlantDiseasess.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToPlantDiseases.create(palmToPlantDiseasess);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(palmToPlantDiseasess);
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
    
    @Path("/palmtoplantdiseases/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deletePalmToPlantDiseases(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Palmtoplantdiseases palmToPlantDiseasess = this.palmToPlantDiseases.getPalmToPlantDiseases(id);
        res.setResponse(palmToPlantDiseasess);
        this.palmToPlantDiseases.delete(palmToPlantDiseasess);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
        @Path("/palmtoplantdiseases/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updatePalmToPlantDiseases(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
         String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Palmtoplantdiseases palmToPlantDiseasess = new Palmtoplantdiseases();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject palmtoplantdiseasesJSONObject = jsonObject.getJSONObject("palmtoplantdiseases");
                    Farmer p =new Farmer(palmtoplantdiseasesJSONObject.getInt("Farmer_idFarmer"));
                    Plantdiseases pd = new Plantdiseases(palmtoplantdiseasesJSONObject.getInt("idPlantDiseases"), p);
                    Addressplam ap = new Addressplam(palmtoplantdiseasesJSONObject.getInt("idAddressPlam"), p);
                    palmToPlantDiseasess.setIdPalmToPlantDiseases(palmtoplantdiseasesJSONObject.getInt("idPalmToPlantDiseases"));
                    palmToPlantDiseasess.setPlantdiseases(pd);
                    palmToPlantDiseasess.setAddressplam(ap);
                    
                   
           
                    int i = this.palmToPlantDiseases.update(palmToPlantDiseasess);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(palmToPlantDiseasess);
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
