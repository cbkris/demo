package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/3/30.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}
