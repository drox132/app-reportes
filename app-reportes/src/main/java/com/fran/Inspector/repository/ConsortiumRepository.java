package com.fran.Inspector.repository;

import com.fran.Inspector.model.Consortium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsortiumRepository extends JpaRepository<Consortium,Integer> {


}
