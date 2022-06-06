package com.example.managementapp.dao;

import com.example.managementapp.entity.DepositModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DepositRepository extends JpaRepository<DepositModel, Integer> {

    @Transactional
    @Modifying
    @Query(value= "DELETE from deposit WHERE name = :depositName", nativeQuery = true)
    void deleteDepositByName (@Param("depositName")String name);

}
