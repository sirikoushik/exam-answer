package com.capgemini.fms.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capgemini.fms.dao.IFeedbackDAO;

public class FeedbackService implements IFeedbackDAO {
	Map<String, Integer> MathFeedbackMap=new HashMap<String, Integer>();
	Map<String, Integer> EnglishFeedbackMap=new HashMap<String, Integer>();
	Map<String, Integer> newFeedbackMap=new HashMap<String, Integer>();
	//adding feed back details
	public Map<String, Integer> addFeedbackDetails(String name, int rating, String subject) {
		// TODO Auto-generated method stub
		newFeedbackMap.clear();
		if(subject.equalsIgnoreCase("Math"))
		{
			MathFeedbackMap.put(name, rating);
			newFeedbackMap.putAll(MathFeedbackMap);;
		}
		else if(subject.equalsIgnoreCase("English"))
		{
			EnglishFeedbackMap.put(name, rating);
			newFeedbackMap.putAll(EnglishFeedbackMap);
		}
		return newFeedbackMap;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Integer> getFeedbackReport() {
		//retrieve feed back details
		// TODO Auto-generated method stub
		Set englishset=EnglishFeedbackMap.entrySet();
		Iterator i=englishset.iterator();
		String string;
		newFeedbackMap.putAll(MathFeedbackMap);
		while(i.hasNext())
		{
			Map.Entry<String, Integer> me=(Map.Entry<String, Integer>)i.next();
			string=me.getKey();
			if(newFeedbackMap.containsKey(string))
			{
				int temp=newFeedbackMap.get(string);
				if(temp<me.getValue())
				{
					newFeedbackMap.remove(string);
					newFeedbackMap.put(string, me.getValue());
				}
			}
			else
			{
				newFeedbackMap.put(string, me.getValue());
			}
		}
		return newFeedbackMap;
	}

}