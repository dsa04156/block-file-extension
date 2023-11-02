package com.flow.blockfileextension.service;

import com.flow.blockfileextension.domain.dto.ExtensionDto;
import com.flow.blockfileextension.domain.entity.ExtensionEntity;
import com.flow.blockfileextension.repository.ExtensionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {
    @Autowired
    private ExtensionRepository extensionRepository;

    public List<ExtensionDto> findExtensions() {
        List<ExtensionDto> extensionNamesList = extensionRepository.findExtensions();
        return extensionNamesList;
    }

    public boolean existsByExtensionName(String extensionName) {
        ExtensionEntity extensionEntity = extensionRepository.findByExtensionName(extensionName);
        if (extensionEntity == null) {
            return false;
        } else {
            enable(extensionEntity);
            extensionRepository.save(extensionEntity);
            return true;
        }
    }

    public void enable(ExtensionEntity extensionEntity) {
        if (extensionEntity.getIsEnabled() == 0) {
            extensionEntity.setUseCount(extensionEntity.getUseCount() + 1);
            extensionEntity.setIsEnabled(1);
        } else {
            extensionEntity.setIsEnabled(0);
        }
    }

    public void saveExtension(String extensionName) {
        ExtensionEntity extensionEntity = new ExtensionEntity();
        extensionEntity.setExtensionName(extensionName);
        extensionEntity.setUseCount(1);
        extensionEntity.setIsEnabled(1);
        extensionRepository.save(extensionEntity);
    }


}
