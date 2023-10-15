package com.example.blog.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name="Tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", unique = true)
    @NotNull
    private String title;
    @Column(name="description")
    private String description;
    @Column(name = "completed")
    private boolean completed=false;
}
