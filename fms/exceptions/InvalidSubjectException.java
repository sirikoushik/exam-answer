package com.capgemini.fms.exceptions;

public class InvalidSubjectException extends Exception {
	public InvalidSubjectException()
	{
		super("The subject must be either 'math' or 'english'");
	}

}