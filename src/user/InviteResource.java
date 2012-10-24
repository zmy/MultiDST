package user;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("invite")
public class InviteResource {

	@GET
	@Path("link")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getInviteLink() {
		//TODO: mechanism for random generation and record
		return "aTestOne";
	}

}
