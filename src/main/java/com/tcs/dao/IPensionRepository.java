package com.tcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.PensionerDetail;

@Repository
public interface IPensionRepository extends JpaRepository<PensionerDetail, Long> {
	
	PensionerDetail findBypan(String PAN);
	List<PensionerDetail> findByname(String name);
}
