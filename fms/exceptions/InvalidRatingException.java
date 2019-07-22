package com.capgemini.fms.exceptions;

public class InvalidRatingException extends Exception {
	public InvalidRatingException()
	{
		super("The rating must be between 1 and 5");
	}

}