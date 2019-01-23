package org.cdac.pgdac.projects.pickpark.services;

import java.util.Date;

public class Utility {

	public static int[] getslot(Date startTime, Date endTime) {

		int startSlot;
		int endSlot;

		if (startTime.getMinutes() == 0)
			startSlot = startTime.getHours() * 2;
		else
			startSlot = (startTime.getHours() * 2) + 1;
		if (endTime.getMinutes() == 0)
			endSlot = endTime.getHours() * 2;
		else
			endSlot = (endTime.getHours() * 2) + 1;
		int count=endSlot - startSlot;
		int[] array = new int[endSlot - startSlot ];
		for (int i = 0; i < count; i++, startSlot++) {
			array[i] = startSlot;
		}
		
		return array;

	}

	public static void main(String[] args) {

		int[] ref=getslot(new Date(2019, 1, 22, 20, 30), new Date(2019, 1, 22, 23, 30));
		for (int i = 0; i < ref.length; i++) {
			System.out.println(ref[i]);

		}
		
	}
}
