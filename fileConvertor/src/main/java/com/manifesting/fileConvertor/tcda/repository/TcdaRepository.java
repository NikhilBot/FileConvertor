package com.manifesting.fileConvertor.tcda.repository;

import com.manifesting.fileConvertor.tcda.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TcdaRepository extends JpaRepository<TcdaModel,String> {

}
