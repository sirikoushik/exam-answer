package com.capgemini.fms.service;


import com.capgemini.fms.exceptions.InvalidRatingException;
import com.capgemini.fms.exceptions.InvalidSubjectException;

public class Validate {
	public void validateData(String name, int rating, String subject) throws Exception{
		try
		{
			validateRating(rating);
			validateSubject(subject);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	private void validateSubject(String subject) throws InvalidSubjectException {
		// TODO Auto-generated method stub
		if(subject.equalsIgnoreCase("Math") || subject.equalsIgnoreCase("English")) {
			
		}
		else
		{
			throw new InvalidSubjectException();
		}
	}

	private void validateRating(int rating) throws InvalidRatingException {
		// TODO Auto-generated method stub
		if(rating<=0 || rating>5)
		{
			throw new InvalidRatingException();
		}
	}

}