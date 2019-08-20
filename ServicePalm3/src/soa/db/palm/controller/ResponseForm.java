/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soa.db.palm.controller;

import org.codehaus.jackson.map.annotate.JsonSerialize;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseForm {
    private String status;
    private int statusCode;
    private Object response;
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
    
    
    
}
