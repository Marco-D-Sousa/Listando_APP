package org.alfa.listando.repositories;

import org.alfa.listando.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
