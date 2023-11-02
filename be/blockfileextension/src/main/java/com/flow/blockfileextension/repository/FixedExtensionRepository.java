package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.domain.entity.FixedExtensionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedExtensionRepository extends JpaRepository<FixedExtensionEntity, Integer> {
    List<FixedExtensionEntity> findAll();


}
