package org.cdac.pgdac.projects.pickpark.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cdac.pgdac.projects.pickpark.model.Customer;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/register")
public class Reserve extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
System.out.println("hello");
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String body = req.getReader().lines().collect(Collectors.joining());
try {
	JSONObject o= new JSONObject(body);
	if(!validate(o))
	{
		resp.sendError(400);
		return;
	}
	Customer customer= new Customer();
	customer.setAddress(o.getString("address"));
	customer.setContact(new BigInteger(o.getString("contact")));
	customer.setFirstName(o.getString("first_name"));
	customer.setLastName(o.getString("last_name"));
	customer.setVehicleNo(o.getString("vehicle_no"));
	RegisterCustomer registerCustomer= new RegisterCustomer();
	boolean success=registerCustomer.register(customer);
	success=false;
	if(!success)
	{
		resp.sendError(500);
	}
	System.out.println(o.toString());
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	private boolean validate(JSONObject o) {
		return !(o.isNull("contact")||
		o.isNull("first_name")||
		o.isNull("last_name")||
		o.isNull("vehicle_no")||
		o.isNull("address"));
	}
	
	
}
