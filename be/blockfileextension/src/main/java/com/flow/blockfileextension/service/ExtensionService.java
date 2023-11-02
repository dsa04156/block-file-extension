package com.flow.blockfileextension.service;

import com.flow.blockfileextension.domain.dto.ExtensionDto;
import com.flow.blockfileextension.domain.entity.CustomExtensionEntity;
import com.flow.blockfileextension.domain.entity.FixedExtensionEntity;
import com.flow.blockfileextension.repository.CustomExtensionRepository;
import com.flow.blockfileextension.repository.FixedExtensionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {
    @Autowired
    private FixedExtensionRepository fixedExtensionRepository;
    @Autowired
    private CustomExtensionRepository customExtensionRepository;

    public ExtensionDto findExtensions() {
        ExtensionDto extensionDto = new ExtensionDto();

        List<FixedExtensionEntity> fixedExtensionEntities = fixedExtensionRepository.findAll();
        List<CustomExtensionEntity> customExtensionEntities = customExtensionRepository.findAll();

        extensionDto.setFixedExtensionEntityList(fixedExtensionEntities);
        extensionDto.setCustomExtensionEntities(customExtensionEntities);
        return extensionDto;
    }

    public boolean existByExtensionName(String extensionName) {
        CustomExtensionEntity customExtensionEntity = customExtensionRepository.findByExtensionName(extensionName);
        if (customExtensionEntity == null) {
            return false;
        }
        return true;
    }

    public void enable(FixedExtensionEntity fixedExtensionEntity) {
        if (fixedExtensionEntity.getIsEnabled() == 0) {
            fixedExtensionEntity.setIsEnabled(1);
        } else {
            fixedExtensionEntity.setIsEnabled(0);
        }
    }

    public boolean countCustomExtension(String extensionName) {
        if (customExtensionRepository.getTotalExtensions() > 200) {
            return false;
        }

        return true;

    }

    public void saveCustomExtension(String extensionName) {
        CustomExtensionEntity customExtensionEntity = new CustomExtensionEntity();
        customExtensionEntity.setExtensionName(extensionName);
        customExtensionRepository.save(customExtensionEntity);
    }

    @Transactional
    public void deleteCustomExtension(String extensionName) {
        customExtensionRepository.deleteByExtensionName(extensionName);
    }

    public void activateFixedExtension(String extensionName) {
        FixedExtensionEntity fixedExtensionEntity = fixedExtensionRepository.findByExtensionName(extensionName);
        fixedExtensionEntity.setIsEnabled(1);
        fixedExtensionRepository.save(fixedExtensionEntity);


    }

    public void deActivateFixedExtension(String extensionName) {
        FixedExtensionEntity fixedExtensionEntity = fixedExtensionRepository.findByExtensionName(extensionName);
        fixedExtensionEntity.setIsEnabled(0);
        fixedExtensionRepository.save(fixedExtensionEntity);
    }
}
