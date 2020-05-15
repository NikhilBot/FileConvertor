package com.manifesting.fileConvertor.dms.repository;

import com.manifesting.fileConvertor.dms.entity.DMSModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DMSRepository extends JpaRepository<DMSModel,String> {

    public DMSModel findByAttributeId ( String attributeId );
}
