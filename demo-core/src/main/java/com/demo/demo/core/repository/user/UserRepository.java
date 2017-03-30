package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.User;
import com.demo.demo.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/3/30.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
}
