package org.alfa.listando.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Book> books = new ArrayList<>();
}

