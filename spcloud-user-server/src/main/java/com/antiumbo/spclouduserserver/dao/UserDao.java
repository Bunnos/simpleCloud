package com.antiumbo.spclouduserserver.dao;


import com.antiumbo.spclouduserserver.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 默柴柒柒
 */
@Repository
public interface UserDao extends JpaRepository<UserModel, Long> {

    /**
     * @param name
     * @return
     */
    UserModel findUserModelByName(String name);
}
