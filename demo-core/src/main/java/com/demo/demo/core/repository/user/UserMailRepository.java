package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/3/30.
 */
@Repository
public interface UserMailRepository extends BaseRepository<UserMail, Integer> {
    UserMail findByMail(String mail);
    UserMail findByMailAndPwd(String mail, String password);
    UserMail findByToken(String token);
}
