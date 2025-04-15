package com.itz.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itz.demo.demo.model.Dummy;

public interface DummyRepository extends JpaRepository<Dummy, Long>{

}
