package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.domain.dto.ExtensionDto;
import com.flow.blockfileextension.domain.entity.ExtensionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<ExtensionEntity, Integer> {
    @Query("SELECT new com.flow.blockfileextension.domain.dto.ExtensionDto(e.extensionName, e.isEnabled) FROM ExtensionEntity e ORDER BY e.useCount DESC")
    List<ExtensionDto> findExtensions();

    public ExtensionEntity findByExtensionName(String extensionName);

    public ExtensionEntity save(String extensionName);


}
