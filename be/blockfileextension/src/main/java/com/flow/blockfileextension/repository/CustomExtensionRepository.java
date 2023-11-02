package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.domain.entity.CustomExtensionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExtensionRepository extends JpaRepository<CustomExtensionEntity, Integer> {
    List<CustomExtensionEntity> findAll();

    @Query("select count(*) from CustomExtensionEntity ")
    Long getTotalExtensions();

    public CustomExtensionEntity findByExtensionName(String extensionName);

    public CustomExtensionEntity save(String extensionName);
}
