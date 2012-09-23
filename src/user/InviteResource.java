package user;

import javax.ws.rs.*;

@Path("invite")
public class InviteResource {

	@GET
	@Path("link")
	@Produces("text/plain")
	@Consumes("application/json")
	public String getInviteLink() {
		//TODO: mechanism for random generation and record
		return "aTestOne";
	}

}
