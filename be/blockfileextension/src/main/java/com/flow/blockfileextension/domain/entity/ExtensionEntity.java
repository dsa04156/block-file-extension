package com.flow.blockfileextension.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@Data
@Entity
@Table(name = "extensions")
public class ExtensionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "extension_name", columnDefinition = "VARCHAR(200)", unique = true, nullable = false)
    private String extensionName;

    @Column(name = "use_count", columnDefinition = "int")
    @ColumnDefault("0")
    private int useCount;

    @Column(name = "is_enabled", columnDefinition = "TINYINT(1)")
    @ColumnDefault("0")
    private Integer isEnabled;


}
