package com.demo.demo.core.repository.user;

import com.demo.demo.core.entity.Permission;
import com.demo.demo.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cb on 2017/4/1.
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission,Integer> {
}
