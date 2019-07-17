package com.yldzmamak.issuemanagement.repository;

import com.yldzmamak.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
        User findByUsername(String username);
}
