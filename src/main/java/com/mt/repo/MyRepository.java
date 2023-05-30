package com.mt.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mt.entity.Actor;

public interface MyRepository extends JpaRepository<Actor, Integer> {

	
}
