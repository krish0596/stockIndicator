package com.stock.stockindicator.testingburp.persistence;

import com.stock.stockindicator.testingburp.persistence.entity.RegisteredUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredUsersRepository extends JpaRepository<RegisteredUsersEntity, String> {

    // Custom query method by email
    Optional<RegisteredUsersEntity> findByEmail(String email);

    // Custom query method by phone number
    Optional<RegisteredUsersEntity> findByPhone(String phone);
}
