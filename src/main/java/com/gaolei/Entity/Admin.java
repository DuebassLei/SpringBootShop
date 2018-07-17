package com.gaolei.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Entity
@Table(name = "tb_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;//管理员id

    private String name;//管理员name

    private String password;//管理员pwd

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "admin")
    private Set<Custom>customs = new HashSet<Custom>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Custom> getCustoms() {
        return customs;
    }

    public void setCustoms(Set<Custom> customs) {
        this.customs = customs;
    }






}
