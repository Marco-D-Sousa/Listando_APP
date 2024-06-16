package org.alfa.listando.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBook;
    private String title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
