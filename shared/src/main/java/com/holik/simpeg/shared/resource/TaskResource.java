package com.holik.simpeg.shared.resource;

import com.holik.simpeg.shared.entity.Task;

import javax.ws.rs.*;

@Path("/tasks")
@Consumes("application/json")
@Produces("application/json")
public interface TaskResource {

    @GET
    Iterable<Task> getAllTasks();
    
    @GET
    @Path("{id}")
    Task getTask(@PathParam("id") Long id);

    @PUT
    Task addTask(Task task);

    @PUT
    @Path("{id}")
    Task updateTask(@PathParam("id") Long id, Task task);

    @DELETE
    @Path("{id}")
    Void deleteTask(@PathParam("id") Long id);
    
}
