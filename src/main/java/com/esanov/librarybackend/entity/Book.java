package com.esanov.librarybackend.entity;

import com.esanov.librarybackend.base.BaseEntity;
import com.esanov.librarybackend.enums.Genre;
import com.esanov.librarybackend.enums.Lang;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "page", nullable = false)
    private Integer page;

    @Column(name = "publisher_day")
    private LocalDateTime publishDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "lang")
    private Lang lang;

    private String description;

    private Integer price;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "publisher_id", referencedColumnName = "id",
//            nullable = false,
//            insertable = false,
//            updatable = false)
//    private Publisher publisher;
//
//    @Column(name = "publisher_id", insertable = false, updatable = false)
//    private Long publisherId;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "attachment_id", referencedColumnName = "id",
//            nullable = false,
//            insertable = false,
//            updatable = false)
//    private Attachment attachment;
//
//    @Column(name = "attachment_id", insertable = false, updatable = false)
//    private Long attachmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;

    @Column(name = "author_id")
    private Long authorId;

}
