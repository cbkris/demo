package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.Role;
import com.demo.demo.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/4/1.
 */
@Repository
public interface RoleRepository extends BaseRepository<Role,Integer> {
}
