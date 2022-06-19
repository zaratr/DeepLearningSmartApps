package com.abdul_Codefellowship.codefellowship.repositories;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername (String username);
}
