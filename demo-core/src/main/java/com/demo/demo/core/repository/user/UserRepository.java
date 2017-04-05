package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.Role;
import com.demo.demo.core.entity.User;
import com.demo.demo.core.repository.BaseRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cb on 2017/3/30.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

}
