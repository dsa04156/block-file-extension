package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.domain.entity.ExtensionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<ExtensionEntity, Integer> {
    @Query("SELECT extensionName FROM ExtensionEntity")
    public List<String> findExtensionNames();

//    public List<ExtentionEntity> deleteByExtentionName(String extensionName);
//
//    public List<ExtentionEntity> saveAll(String extentionName);
}
