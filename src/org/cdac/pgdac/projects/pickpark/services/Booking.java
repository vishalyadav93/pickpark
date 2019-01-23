package org.cdac.pgdac.projects.pickpark.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cdac.pgdac.projects.pickpark.model.BookingSlot;
import org.cdac.pgdac.projects.pickpark.model.CustomerEntry;
import org.cdac.pgdac.projects.pickpark.model.Floor;
import org.cdac.pgdac.projects.pickpark.model.Node;
import org.cdac.pgdac.projects.pickpark.model.ParkingLoc;
import org.cdac.pgdac.projects.pickpark.model.ParkingReservation;
import org.cdac.pgdac.projects.pickpark.model.Pass;
import org.cdac.pgdac.projects.pickpark.model.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;
import org.cdac.pgdac.projects.pickpark.services.Utility;


@WebServlet("/booking")
public class Booking extends HttpServlet {
	
	SessionFactory factory = new Configuration()
	.configure("hibernate.cfg.xml")
	.addAnnotatedClass(BookingSlot.class)
	.addAnnotatedClass(ParkingReservation.class)
	.addAnnotatedClass(Node.class)
	.addAnnotatedClass(Pass.class)
	.addAnnotatedClass(Floor.class)
	.addAnnotatedClass(BookingSlot.class)
	.addAnnotatedClass(ParkingLoc.class).addAnnotatedClass(CustomerEntry.class)
	.buildSessionFactory();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String str = req.getReader().lines().collect(Collectors.joining());
		try {
			JSONObject jsonObject = new JSONObject(str);
			String type=jsonObject.getString("type");
			
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date startTime1 = simpleDateFormat1.parse(jsonObject.getString("start_time"));
			Date endTime = simpleDateFormat1.parse(jsonObject.getString("end_time"));
			ParkingReservation parkingReservation= new ParkingReservation();
			parkingReservation.setCustomerId(jsonObject.getInt("customer_id"));
			parkingReservation.setStartDate(startTime1);
			parkingReservation.setDuration((int)(endTime.getTime()-startTime1.getTime()));
			parkingReservation.setBookingDate(new Date());
			parkingReservation.setPaymentStatus("unpaid");
			int slotsToBook[] = Utility.getslot(startTime1, endTime);
			parkingReservation.setParkingSlotId(Integer.parseInt(nodeToAllot(type,jsonObject.getString("start_time"),jsonObject.getString("end_time"),slotsToBook)));
			
			
			Session session= factory.getCurrentSession();
			session.beginTransaction();
			for (int i=0;i<slotsToBook.length;i++)
			{
			BookingSlot bs=new BookingSlot();
			bs.setDate(startTime1);
			bs.setNodeid(parkingReservation.getParkingSlotId());
			bs.setTimeslot(slotsToBook[i]);
			session.save(bs);
			}
			session.save(parkingReservation);
			session.getTransaction().commit();
			
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String nodeToAllot(String type,String startTime, String endTime,int slotsToBook[])
			throws ParseException {
		
		
		String str=arrayToString(slotsToBook);
		
		System.out.println("slots to book:"+str);
	
		
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		
		List<BookingSlot> listOfBookedNodes=(List<BookingSlot>) session.createQuery("from BookingSlot b where b.timeSlot in " +str+ "").getResultList();
		System.out.println("list of booked nodes      "+listOfBookedNodes);
		
		int totalPass=session.createQuery("select count(*) from Pass p where p.startDate<='"+startTime+"' AND p.endDate>'"+startTime+"'").getFirstResult();
		System.out.println("totAL NO of passes    :"+totalPass);
        String bookedString=arrayToString(arrayOfBookedNode(listOfBookedNodes));
        System.out.println(bookedString);
		//int nodeToBeReturned=session.createQuery("select id from Node n WHERE n.id not in "+bookedString).getFirstResult();
		List nodeToBeReturned=session.createQuery("select id from Node n where n.id not in "+bookedString).getResultList();
		session.getTransaction().commit();
		if(totalPass>nodeToBeReturned.size()){
			return "We are sorry! No Space avaialable for this time";
		}else
			System.out.println(nodeToBeReturned.get(0).toString());
	    	return nodeToBeReturned.get(0).toString();
	}	
	   
	
	
	
	public static String arrayToString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "()";

        StringBuilder b = new StringBuilder();
        b.append('(');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(')').toString();
            b.append(", ");
        }
    }
	
	
	
	
	
	
	public static int [] arrayOfBookedNode(List<BookingSlot> l){
		int[] bookednode= new int[l.size()];
		for(int i=0;i<l.size();i++){
			bookednode[i]=l.get(i).getNodeid();
			
		}
		return bookednode;
		
		
	}
	
//	public static void main(String[] args) throws ParseException {
//		nodeToAllot("12-12-2019 21:00:00", 2);
//	}
}