package action;

import java.io.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("action")
public class ActionResource {

	static final int MAX_ENTRY_RETURN = 50;

	static final String LIST_PATH = "D:/Projects/NetSci/ActionData/"; //TODO: put this config into a file

	/*
	 * returns a xml list of actions
	 */
	@GET
	@Path("list")
	@Produces("text/xml")
	public String getActionList() {
		return getXMLFile(LIST_PATH+"list.xml");
	}

	@GET
	@Path("{id}/detail")
	@Produces("text/xml")
	public String getActionDescription(@PathParam("id") String id) {
		return getXMLFile(LIST_PATH+"actions/"+id+"/define.xml");
	}

	@GET
	@Path("{id}/res/{res}")
	public Response getActionAttachment(@PathParam("id") String id) {
		;
		return null;
	}
	
	String getXMLFile(String path) {
		File file = new File(path);
		BufferedReader reader = null;
		String xml = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null)
				xml += tempString+"\n";
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			//TODO: how to report error?
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return xml;
	}
}
