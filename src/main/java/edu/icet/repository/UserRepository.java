package edu.icet.repository;

import edu.icet.entity.UserEntity;
import edu.icet.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    Optional<UserEntity> findByRole(UserRoles role);

    Optional<UserEntity> findById(Long userId);

    Optional<UserEntity>findByName(String username);

}

