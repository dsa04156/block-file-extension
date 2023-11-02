package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.domain.entity.ExtentionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<ExtentionEntity, Integer> {
    public List<ExtentionEntity> findAll();

    public List<ExtentionEntity> deleteByExtentionName(String extensionName);

    public List<ExtentionEntity> saveAll(String extentionName);
}
