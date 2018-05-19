/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author LBRENESV
 */
@Path("MyPath")
public class MyPathResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MyPathResource
     */
    public MyPathResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.MyPathResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes("text/html")
    public void postHtml(@QueryParam("tableStructure")String tableStructure){
        createTable(tableStructure);
    }
    @DELETE
    @Produces(MediaType.TEXT_HTML)
    public String deleteHtml() {
        //TODO return proper representation object
        
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MyPathResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
        System.out.println(content);
    }

    private static Boolean createTable(java.lang.String tableStructure) {
        webservicecli.MyWebService_Service service = new webservicecli.MyWebService_Service();
        webservicecli.MyWebService port = service.getMyWebServicePort();
        return port.createTable(tableStructure);
    }
}
