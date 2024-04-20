package de.ait.project.advertisement.model;
/*
 Long id;
    String category;
    String title;
    String description;
    String authorName;
 */

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter

@Entity
@Table(name="advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="category")
    private String category;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="author")
    private String authorName;
}
