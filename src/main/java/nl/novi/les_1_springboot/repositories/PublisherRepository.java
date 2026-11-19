package nl.novi.les_1_springboot.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import nl.novi.les_1_springboot.entities.PublisherEntity;

import java.util.concurrent.Flow;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {}

