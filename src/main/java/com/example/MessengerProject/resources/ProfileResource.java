package com.example.MessengerProject.resources;

import com.example.MessengerProject.models.Profile;
import com.example.MessengerProject.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService service;

    public ProfileResource() {
        service = ProfileService.getInstance();
    }

    @GET
    public List<Profile> getAllProfiles() {
        return service.getAllProfiles();
    }

    @Path("{name}")
    @GET
    public Profile getProfile(@PathParam("name") String name) {
        return service.getProfile(name);
    }

    @POST
    public Profile addProfile(Profile profile) {
        return service.addProfile(profile);
    }

    @Path("{name}")
    @PUT
    public Profile updateProfile(@PathParam("name") String name, Profile profile) {
        return service.updateProfile(name, profile);
    }

    @Path("{name}")
    @DELETE
    public Profile deleteProfile(@PathParam("name") String name) {
        return service.removeProfile(name);
    }
}
