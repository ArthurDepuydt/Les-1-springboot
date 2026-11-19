package nl.novi.les_1_springboot.repositories;

import nl.novi.les_1_springboot.entities.GenreEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {}
