package org.satyam.jerseyadapi.adapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.satyam.jerseyadapi.adapi.controller.Seller;
import org.satyam.jerseyadapi.adapi.controller.SellerController;


@Path("seller")
public class restSeller {
	
	SellerController service=new SellerController();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seller> sendMessage() {
		List<Seller> l=new ArrayList<Seller>();
		System.out.println("called");
		Seller obj=new Seller(1,"sa","sa");
		l.add(obj);
		System.out.println("called");
		return l;
	}
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addSeller(Seller obj) {
		int res=service.addSeller(obj);
		if(res==1) {
			return "1";
		}else {
			return "0";
		}
	}
	
}
