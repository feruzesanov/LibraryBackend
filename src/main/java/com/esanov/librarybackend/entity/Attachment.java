package com.esanov.librarybackend.entity;

import com.esanov.librarybackend.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "attachments")
public class Attachment extends BaseEntity {

    @Column(name = "generated_name")
    private String generatedName;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private Long size;

}
