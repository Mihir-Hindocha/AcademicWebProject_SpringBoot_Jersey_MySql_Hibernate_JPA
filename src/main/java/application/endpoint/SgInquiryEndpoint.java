package application.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import application.response.SgInquiryDto;
import application.service.SgInquiryService;

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
