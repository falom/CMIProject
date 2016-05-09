package com.webapp.iamcmi.service;

import java.util.List;

import com.webapp.iamcmi.model.Policy;

public interface PolicyService {

	 Policy findById(int id);
	 
	 void savePolicy(Policy policy);
	     
	 void updatePolicy(Policy policy);
	 
	 List<Policy> findAllPolicy();
}
