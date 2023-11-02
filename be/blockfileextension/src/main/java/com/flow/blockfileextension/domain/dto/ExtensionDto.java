package com.flow.blockfileextension.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtensionDto {
    private String extensionName;

    private Integer isEnabled;
}
