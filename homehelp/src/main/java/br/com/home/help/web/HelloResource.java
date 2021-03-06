package br.com.home.help.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.home.help.dto.HelloDTO;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

	// http://localhost:8090/homehelp/rest/hello
	@GET
	public HelloDTO hello() {

		HelloDTO h = new HelloDTO();
		h.id = 1L;
		h.descricao = "olá";

		return h;
	}

}