package com.manifesting.fileConvertor.tcda.repository;

import com.manifesting.fileConvertor.tcda.entity.TcdaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TcdaRepository extends JpaRepository<TcdaModel,String> {

    @Query(value = "SELECT tracking_id FROM tcda" , nativeQuery = true)
    List<String> findAllTrackingId();

}
