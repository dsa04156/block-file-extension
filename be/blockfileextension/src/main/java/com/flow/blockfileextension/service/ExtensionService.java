package com.flow.blockfileextension.service;

import com.flow.blockfileextension.repository.ExtensionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtensionService {
    @Autowired
    private ExtensionRepository extensionRepository;

    public List<String> findExtensionNames() {
        List<String> extensionDtos = extensionRepository.findExtensionNames();
        return extensionDtos;
    }

}
