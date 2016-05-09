package com.webapp.iamcmi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webapp.iamcmi.model.Policy;

@Repository("policyDao")
public class PolicyDaoImpl extends AbstractDao<Integer, Policy> implements PolicyDao {

	@Override
	public Policy findById(int id) {
		return getByKey(id);
	}

	@Override
	public void savePolicy(Policy policy) {
		persist(policy);
	}

	@Override
	public List<Policy> findAllPolicy() {
		Criteria criteria = createEntityCriteria();
        return (List<Policy>) criteria.list();
	}

}
