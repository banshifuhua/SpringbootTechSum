package com.eamon.springbootsecurityjwt.dao;

import com.eamon.springbootsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eamon
 * @date 2019/08/15 17:07
 **/
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * 通过用户名查找
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}
