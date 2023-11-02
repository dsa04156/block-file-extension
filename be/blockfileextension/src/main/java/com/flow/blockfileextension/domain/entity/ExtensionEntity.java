package com.flow.blockfileextension.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "extensions")
public class ExtensionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "extension", columnDefinition = "TEXT", length = 200, nullable = false, unique = true)
    private String extensionName;

    @Column(columnDefinition = "int", nullable = false)
    @ColumnDefault("0")
    private int useCount;

    @Builder
    public ExtensionEntity(String extensionName) {
        this.extensionName = extensionName;
    }


}
