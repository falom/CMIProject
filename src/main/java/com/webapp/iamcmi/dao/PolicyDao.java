package com.webapp.iamcmi.dao;

import java.util.List;

import com.webapp.iamcmi.model.Policy;

public interface PolicyDao {
	 
    Policy findById(int id);
 
    void savePolicy(Policy policy);
     
    List<Policy> findAllPolicy();

}