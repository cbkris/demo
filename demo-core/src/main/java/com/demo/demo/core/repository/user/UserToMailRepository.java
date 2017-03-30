package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.UserToMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/3/30.
 */
@Repository
public interface UserToMailRepository extends JpaRepository<UserToMail,Integer>{
}
