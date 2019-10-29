package com.qyb.service.impl;

import com.qyb.service.PermissionService;
import com.qyb.dao.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryAllPermissionByUsername(String username) {
        return permissionMapper.queryPermissionByName(username);
    }
}
