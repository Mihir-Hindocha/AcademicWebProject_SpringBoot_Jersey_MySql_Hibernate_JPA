package application.endpoint;

import application.response.SgInquiryDto;
import application.service.SgInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("/admin")
public class SgInquiryEndpoint {
    @Autowired
    private SgInquiryService sgResponseService;

    @GET
    @Path("/totalinquiries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalInquiries() {

        SgInquiryDto sgTotalInquiriesDto = sgResponseService.getTotalInquiries();
        return Response.ok(sgTotalInquiriesDto).build();
    }
}
