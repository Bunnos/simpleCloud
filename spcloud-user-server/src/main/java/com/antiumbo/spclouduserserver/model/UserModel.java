package com.antiumbo.spclouduserserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 默柴柒柒
 */
@Data
@Entity
@Table(name = "ls_user")
public class UserModel {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "create_date")
    private Date createDate;
}
