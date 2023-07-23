package de.fhws.fiw.fds.sutton.server.api.binaryDataSupport.api.services;

import de.fhws.fiw.fds.sutton.server.api.binaryDataSupport.api.states.*;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractService;
import de.fhws.fiw.fds.sutton.server.api.binaryDataSupport.models.BinaryDataModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("binaryData")
public class BinaryDataService extends AbstractService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllBinaryData() {
        return new GetAllBinaryData.Builder()
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSingleBinaryData(@PathParam("id") final long id) {
        return new GetSingleBinaryData.GetBinaryDataStateBuilder()
                .setRequestedId(id)
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSingleBinaryData(final BinaryDataModel binaryDataModel) {
        return new PostBinaryData.Builder()
                .setModelToCreate(binaryDataModel)
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

    @POST
    @Consumes({MediaType.APPLICATION_OCTET_STREAM})
    public Response createSingleBinaryData(final byte[] binaryData) {
        return new PostRawBinaryData.Builder()
                .setBinaryData(binaryData)
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

    @PUT
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateSingleBinaryData(@PathParam("id") final long id, final BinaryDataModel binaryDataModel) {
        return new PutBinaryData.Builder()
                .setRequestedId(id)
                .setModelToUpdate(binaryDataModel)
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

    @DELETE
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteSingleBinaryData(@PathParam("id") final long id) {
        return new DeleteSingleBinaryData.Builder()
                .setRequestedId(id)
                .setUriInfo(this.uriInfo)
                .setRequest(this.request)
                .setHttpServletRequest(this.httpServletRequest)
                .setContext(this.context)
                .build()
                .execute();
    }

}
