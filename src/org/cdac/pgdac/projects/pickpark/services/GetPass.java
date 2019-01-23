package org.cdac.pgdac.projects.pickpark.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cdac.pgdac.projects.pickpark.model.Pass;
import org.cdac.pgdac.projects.pickpark.model.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/pass")
public class GetPass extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	Pass pass= new Pass();
	String str=req.getReader().lines().collect(Collectors.joining());
	try {
		JSONObject jsonObject= new JSONObject(str);
		pass.setCustomerId(jsonObject.getInt("customer_id"));
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		pass.setStartDate(sdf1.parse(jsonObject.getString("start_date")));
		pass.setEndDate(sdf1.parse(jsonObject.getString("end_date")));
		pass.setPurchaseDate(new java.util.Date());
		String type=jsonObject.getString("type");
		
		SessionFactory factory = new Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(Pass.class).addAnnotatedClass(Price.class)
		.buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Price price = (Price) session.createQuery("from Price p where p.type='"+type+"'").getSingleResult();
		long duration  = pass.getEndDate().getTime() - pass.getStartDate().getTime();
		long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
		pass.setCost(new BigDecimal(price.getBaseprice().multiply(new BigDecimal(diffInDays)).toString()));	
		pass.setType(type);
		session.save(pass);
		session.getTransaction().commit();
		factory.close();
	
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


}
