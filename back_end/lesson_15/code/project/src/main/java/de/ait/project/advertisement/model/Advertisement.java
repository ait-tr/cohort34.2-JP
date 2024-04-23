package de.ait.project.advertisement.model;
/*
 Long id;
    String category;
    String title;
    String description;
    String authorName;
 */

import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.ait.project.user.model.User;
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


    @ManyToOne
    @JoinColumn (name="author_id", referencedColumnName = "user_id", nullable = true)
    @JsonManagedReference
    // name - имя столбца с внешним ключом в таб. advertisement
    private User author;
}
