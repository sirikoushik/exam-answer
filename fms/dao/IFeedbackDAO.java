package com.capgemini.fms.dao;

import java.util.Map;

public interface IFeedbackDAO {
	Map<String, Integer> addFeedbackDetails(String name,int rating,String subject);
	Map<String, Integer> getFeedbackReport();
}