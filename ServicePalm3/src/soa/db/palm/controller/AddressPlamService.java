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
import soa.db.palm.entity.Addressplam;
import soa.db.palm.dao.AddressPlamDao;

import soa.db.palm.entity.Farmer;
/**
 *
 * @author oat
 */
public class AddressPlamService {
    private AddressPlamDao addressPlam = new AddressPlamDao();
    
    @Path("/addressplam/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllAddressPlam() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Addressplam> address = addressPlam.getAllAddressPlam();
        res.setResponse(address);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
    @Path("/addressplam/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createAddressPlam(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Addressplam address = new Addressplam();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject addressJSONObject = jsonObject.getJSONObject("addresspalm");
                    Farmer p =new Farmer(addressJSONObject.getInt("Farmer_idFarmer"));
                    address.setIdAddressPlam(addressJSONObject.getInt("idAddressPlam"));
                    address.setAddresss(addressJSONObject.getString("addresss"));
                    address.setName(addressJSONObject.getString("name"));
                    address.setLat(addressJSONObject.getInt("Lat"));
                    address.setLon(addressJSONObject.getInt("Lon"));
                    address.setPathImage(addressJSONObject.getString("pathImage"));
                    address.setNameImage(addressJSONObject.getString("nameImage"));
                    
                    
             
                     address.setFarmer(p);
                    int i = addressPlam.create(address);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(address);
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
    
    @Path("/addressplam/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteAddressPlam(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Addressplam address = addressPlam.getAddressPlam(id);
        res.setResponse(address);
        addressPlam.delete(address);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
    
     @Path("/addressplam/update/{id}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        public  Response updateAddressPlam(@PathParam("id") int id, InputStream incomingData) throws IOException
        {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Addressplam address = new Addressplam();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject addressJSONObject = jsonObject.getJSONObject("addresspalm");
                    Farmer p =new Farmer(addressJSONObject.getInt("Farmer_idFarmer"));
                    address.setIdAddressPlam(addressJSONObject.getInt("idCarWaterReport"));
                    address.setAddresss(addressJSONObject.getString("addresss"));
                    address.setName(addressJSONObject.getString("name"));
                    address.setLat(addressJSONObject.getInt("Lat"));
                    address.setLon(addressJSONObject.getInt("Lon"));
                    address.setPathImage(addressJSONObject.getString("pathImage"));
                    address.setNameImage(addressJSONObject.getString("nameImage"));
                    
                    
             
                     address.setFarmer(p);
                    int i = addressPlam.update(address);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("update successfully");
                         res.setResponse(address);
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
