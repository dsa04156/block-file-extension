package com.flow.blockfileextension.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class ExtentionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String extentionName;

    @Builder
    public ExtentionEntity(String extentionName) {
        this.extentionName = extentionName;
    }

    public void extentionNameUpdate(String extentionName) {
        this.extentionName = extentionName;
    }

}
