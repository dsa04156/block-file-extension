package com.flow.blockfileextension.service;

import com.flow.blockfileextension.domain.entity.ExtentionEntity;
import com.flow.blockfileextension.repository.ExtensionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {
    @Autowired
    private ExtensionRepository extensionRepository;

    public List<ExtentionEntity> findAll() {
        List<ExtentionEntity> extentionEntities = extensionRepository.findAll();
        return extentionEntities;
    }

}
