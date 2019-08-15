package com.eamon.springbootsecurityjwt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author eamon
 * @date 2019/08/15 15:37
 **/
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<Permission> permissions;
}
