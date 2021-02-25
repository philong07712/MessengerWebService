package com.example.MessengerProject.resources;

import com.example.MessengerProject.models.Message;
import com.example.MessengerProject.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService service;

    public MessageResource() {
        service = MessageService.getInstance();
    }

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean)
    {
        if (filterBean.getYear() > 0) {
            return service.getAllMessagesForYear(filterBean.getYear());
        }
        if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
            return service.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }
        System.out.println("year: " + filterBean.getYear() + " start: " + filterBean.getStart() + " size: "
                + filterBean.getSize());
        return service.getAllMessages();
    }

    @POST
    public Message addMessage(Message message)
    {
        System.out.println("addMessage called");
        return service.addMessage(message);
    }

    @PUT
    @Path("{id}")
    public Message updateMessage(@PathParam("id") Long id, Message message) {
        System.out.println("updateMessage called");
        message.setId(id);
        return service.updateMessage(message);
    }

    @DELETE
    @Path("{id}")
    public Message deleteMessage(@PathParam("id") Long id)
    {
        System.out.println("deleteMessage called");
        return service.removeMessage(id);
    }

    @GET
    @Path("{id}")
    public Message getMessage(@PathParam("id") Long id) {
        System.out.println("getMessage by Id called");
        return service.getMessage(id);
    }
}