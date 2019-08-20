/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.controller;



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import soa.db.palm.entity.Farmer;
import soa.db.palm.dao.FarmerDao;


/**
 *
 * @author oat
 */
@Path("services")
public class FarmerService {
   private FarmerDao Farmer = new FarmerDao();
    @Path("/Farmer/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllFarmers() throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        ArrayList<Farmer> users = Farmer.getAllFarmer();
        res.setResponse(users);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
    
     @Path("/Farmer/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getFarmer(@PathParam("id") int id) throws IOException{
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Farmer users = Farmer.getFarmer(id);
        res.setResponse(users);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    
    }
  
    @Path("/Farmer/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response createFarmer(InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Farmer user = new Farmer();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject FarmerJSONObject = jsonObject.getJSONObject("Farmer");
                    user.setIdFarmer(FarmerJSONObject.getInt("idFarmer"));
                    user.setIdCard(FarmerJSONObject.getLong("idCard"));
                    user.setFname(FarmerJSONObject.getString("fname"));
                    user.setLname(FarmerJSONObject.getString("lname"));
                    user.setAddress(FarmerJSONObject.getString("address"));
                    user.setCity(FarmerJSONObject.getString("city"));
                    user.setPhoneNumber(FarmerJSONObject.getString("PhoneNumber"));
                    user.setImage(FarmerJSONObject.getString("Image"));
                    user.setUrl(FarmerJSONObject.getString("url"));
                    user.setStatus(FarmerJSONObject.getInt("status"));
                    
                    int i = Farmer.create(user);
                    if (i==1) {
                        ResponseForm res = new ResponseForm();
                        res.setStatusCode(Response.Status.OK.getStatusCode());
                        res.setStatus("OK");
                         res.setResponse("create successfully");
                         res.setResponse(user);
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
                
                        /*
               int i = Farmer.create(user);
                if (i==1) {
                    ResponseForm res = new ResponseForm();
                    res.setStatusCode(Response.Status.OK.getStatusCode());
                    res.setStatus("OK");
                     res.setResponse("create successfully");
                    return Response.status(res.getStatusCode()).build();
                }
                else
                {
                     ResponseForm res = new ResponseForm();
                     res.setResponse("create faill");
                    return Response.status(res.getStatusCode()).build();
                }*/
    }
    @Path("/Farmer/getFarmerByIdCard")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response getFarmerByIdCard(InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");
        StringBuilder crunchifyBuilder = new StringBuilder();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject FarmerJSONObject = jsonObject.getJSONObject("Farmer");
                    Long id = (FarmerJSONObject.getLong("idCard"));
                    
                     Farmer user = Farmer.getFarmerByIdCard(id);
                     res.setResponse(user);
                     ObjectMapper map = new ObjectMapper();
                     result = map.writeValueAsString(res);
                     return Response.status(res.getStatusCode()).entity(result).build();
                   
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
                        return null ;
		}
		
                
                        
            
    }
    @Path("/Farmer/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response deleteFarmer(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        ResponseForm res = new ResponseForm();
        res.setStatusCode(Response.Status.OK.getStatusCode());
        res.setStatus("OK");

        Farmer user = Farmer.getFarmer(id);
        res.setResponse(user);
        Farmer.delete(user);
        ObjectMapper map = new ObjectMapper();
        result = map.writeValueAsString(res);
        return Response.status(res.getStatusCode()).entity(result).build();
    }
     @Path("/Farmer/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public  Response updateFarmer(@PathParam("id") int id, InputStream incomingData) throws IOException
    {
        String result = "";
        StringBuilder crunchifyBuilder = new StringBuilder();
        Farmer user = new Farmer();
        BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
        try {
			
		String line = null;
		while ((line = in.readLine()) != null) {
			crunchifyBuilder.append(line);
		}
                    JSONObject jsonObject = new JSONObject(crunchifyBuilder.toString());
                    JSONObject FarmerJSONObject = jsonObject.getJSONObject("Farmer");
                    if(id == FarmerJSONObject.getInt("idFarmer"))
                    {
                        user.setIdFarmer(FarmerJSONObject.getInt("idFarmer"));
                        user.setIdCard(FarmerJSONObject.getLong("idCard"));
                        user.setFname(FarmerJSONObject.getString("fname"));
                        user.setLname(FarmerJSONObject.getString("lname"));
                        user.setAddress(FarmerJSONObject.getString("address"));
                        user.setCity(FarmerJSONObject.getString("city"));
                        user.setPhoneNumber(FarmerJSONObject.getString("PhoneNumber"));
                        user.setImage(FarmerJSONObject.getString("Image"));
                        user.setUrl(FarmerJSONObject.getString("url"));
                        user.setStatus(FarmerJSONObject.getInt("status"));
                        int i = Farmer.update(user);
                        if (i==1) {
                            ResponseForm res = new ResponseForm();
                            res.setStatusCode(Response.Status.OK.getStatusCode());
                            res.setStatus("OK");
                             res.setResponse("update successfully");
                             res.setResponse(user);
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
                    }
                    else
                    {
                        ResponseForm res = new ResponseForm();
                             res.setResponse("update faill id false");
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
        
        FarmerService p = new FarmerService();
        InputStream incomingData = new InputStream() {
            @Override
            public int read() throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } ;
        p.createFarmer(incomingData);
    }
    
    
}
