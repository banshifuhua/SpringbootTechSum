package com.eamon.springbootsecurityjwt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author eamon
 * @date 2019/08/15 15:36
 **/
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

}
