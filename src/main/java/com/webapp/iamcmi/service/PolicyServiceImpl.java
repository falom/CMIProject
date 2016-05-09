package com.webapp.iamcmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.iamcmi.dao.PolicyDao;
import com.webapp.iamcmi.model.Policy;

@Service("policyService")
@Transactional
public class PolicyServiceImpl implements PolicyService {

	@Autowired
    private PolicyDao dao;
	
	@Override
	public Policy findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void savePolicy(Policy policy) {
		dao.savePolicy(policy);
	}

	@Override
	public void updatePolicy(Policy policy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Policy> findAllPolicy() {
		return dao.findAllPolicy();
	}

}
