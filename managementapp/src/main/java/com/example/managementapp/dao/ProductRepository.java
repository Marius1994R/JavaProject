package com.example.managementapp.dao;

import com.example.managementapp.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query(value = "SELECT * FROM managementapp where name like :startWith%", nativeQuery = true)
    List<ProductModel> searchByName(@Param("startWith") String param);


}
