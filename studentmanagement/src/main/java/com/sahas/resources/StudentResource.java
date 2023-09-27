package com.sahas.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sahas.services.StudentService;

/**
 * Root resource (exposed at "students" path)
 */
@Path("students")
public class StudentResource {

	public StudentService studentService = new StudentService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
    	return studentService.getStudentsAsJsonString();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudent(@PathParam("id") int studentID) {
    	return studentService.getStudentAsJsonString(studentID);
    }
    
    @DELETE 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public String deleteStudent(@PathParam("id") int id){ 
    	return studentService.deleteStudent(id);
    }  
    
    @POST 
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String updateStudent(@FormParam("id") int id, @FormParam("grade") String grade) { 
    	return studentService.updateStudent(id, grade);
    }
    
    @PUT 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String createStudent(@FormParam("id") int id, @FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("grade") String grade) { 
    	return studentService.addStudent(id, firstName, lastName, grade);
    } 
}
