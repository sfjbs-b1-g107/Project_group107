package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.PensionerDetail;

@Repository
public interface IPensionRepository extends JpaRepository<PensionerDetail, Integer> {

}
