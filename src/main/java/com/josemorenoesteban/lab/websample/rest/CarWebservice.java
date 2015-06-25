package com.josemorenoesteban.lab.websample.rest;

import com.josemorenoesteban.lab.websample.service.CarsService;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Car resource
 */
@Path("/car")
public class CarWebservice {
    @Inject private CarsService service;
    
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    
    /**
     * Gets a car info by its car id
     *
     * @param asyncResponse jax-rs async response context
     * @param id car identifier
     */
    @GET @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void getCar(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final String id) {
        executorService.submit(() -> { asyncResponse.resume(service.getCar(id)); });
    } 
}
