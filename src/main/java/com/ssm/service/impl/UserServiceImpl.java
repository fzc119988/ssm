package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
@Service

/**
 * ����:�û�mapper�ӿ�<BR>
 * ������:<BR>
 * ʱ��:2017��7��10������6:14:22<BR>
 * @version
 */
public class UserServiceImpl implements UserService {

    /**
     * ע��UserMapper�ӿ�
     */
    @Autowired(required=true)
    private UserMapper userMapper;
 
    /**
     * �����û�
     */
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    /**
     * �����û�
     */
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * ����Idɾ���û�
     */
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    /**
     * ����id�����û�
     */
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    /**
     * ��ѯ�����û�
     */
    public List<User> findAll() {
        List<User> allUser = userMapper.findAll();
        return allUser;
    }

}

