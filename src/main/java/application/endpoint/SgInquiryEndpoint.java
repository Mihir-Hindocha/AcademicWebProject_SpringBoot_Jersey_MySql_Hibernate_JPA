package application.endpoint;

import application.response.SgInquiryDto;
import application.service.SgInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/admin")
public class SgInquiryEndpoint {
    @Autowired
    private SgInquiryService sgResponseService;

    @GET
    @Path("/totalinquiries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalInquiries() {

        List<SgInquiryDto> sgTotalInquiriesDto = sgResponseService.getTotalInquiries();
        return Response.ok(sgTotalInquiriesDto).build();
    }

    @GET
    @Path("/inquiries/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInquiriesByStatus(@PathParam("status") String status) {

        List<SgInquiryDto> sgPendingInquiriesDtoList = sgResponseService.getInquiriesByStatus(status);
        return Response.ok(sgPendingInquiriesDtoList).build();
    }

    @POST
    @Path("/changestatus/{status}")
    public Response changeInquiryStatus(@PathParam("status") String status, @QueryParam("email") String email) {
        boolean statusChanged = sgResponseService.changeInquiryStatus(status, email);
        if (statusChanged) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    @GET
    @Path("/delete")
    public Response deleteInquiry(@QueryParam("email") String email) {
        boolean inquiryDeleted = sgResponseService.deleteInquiry(email);
        if (inquiryDeleted) {
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }

}
