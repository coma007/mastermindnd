package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
