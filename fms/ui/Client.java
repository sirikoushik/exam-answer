package com.capgemini.fms.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.fms.bean.Feedback;
import com.capgemini.fms.service.FeedbackService;

public class Client 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void showMap(Map<String, Integer> map)
	{	
		System.out.println("Map details:");
		System.out.println("Teacher Name\t Feedback Rating");
		if(map.isEmpty())
		{
			System.out.println("The map is Empty");
		}
		Set entryset=map.entrySet();
		Iterator i=entryset.iterator();
		while(i.hasNext())
		{
			Map.Entry<String, Integer> me=(Map.Entry<String, Integer>)i.next();
			System.out.println(me.getKey()+"\t\t\t"+me.getValue());
		}
	}
	public static void main(String[] args) 
	{
		FeedbackService service=new FeedbackService();
		Scanner scan=new Scanner(System.in);
		Map<String, Integer> map=new HashMap<String, Integer>();
		Map<String, Integer> newmap=new HashMap<String, Integer>();
		int choice;
		while(true)
		{
			System.out.println("MENU\n1) Add Feedback\n2) Print Feedback Report\n3) Exit");
			choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				try
				{
					Feedback fb=new Feedback();
					System.out.println("Enter Teacher Name:(If name contains more than one word seperate with '_')");
					fb.setTeacherName(scan.next());
					System.out.println("Enter Subject Name:");
					fb.setTopic(scan.next());
					System.out.println("Enter Rating:");
					fb.setRating(scan.nextInt());
					map=service.addFeedbackDetails(fb.getTeacherName(), fb.getRating(), fb.getTopic());
					System.out.println("Successfully added to "+fb.getTopic()+" map");
					showMap(map);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("Feedback Report:");
				newmap=service.getFeedbackReport();
				showMap(map);
				break;
			case 3:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Please Enter a Valid Choice");
				break;
			}
		}
	}

}
