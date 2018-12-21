package com.antiumbo.spclouduserserver.dao;


import com.antiumbo.spclouduserserver.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author 默柴柒柒
 */
@Repository
public interface UserDao extends JpaRepository<UserModel, Long> {

    /**
     * 根据用户名查找用户
     *
     * @param name
     * @return
     */
    UserModel findUserModelByName(String name);

    /**
     * 根据用户名和密码查找用户
     *
     * @param name
     * @param password
     * @return
     */
    UserModel findByNameAndPassword(String name, String password);

    /**
     * 根据id查用户
     *
     * @param userId
     * @return
     */
    @Query(value = "SELECT c FROM UserModel c WHERE c.id=?1")
    UserModel getUserById(Integer userId);
}
