package com.gaolei.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoLei on 2018/6/24.
 */
@Entity
@Table(name = "tb_custom")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id ;//客户id

    private String name;//客户名

    private String  password;//客户密码

    private  String address;//客户地址

    private int tel;//客户电话

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin  admin;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "custom_shop",
            joinColumns = {@JoinColumn(name="custom_id")},
            inverseJoinColumns = {@JoinColumn(name = "shop_id")})
    private Set<Shop> shopSet = new HashSet<Shop>();


    public Set<Shop> getShopSet() {
        return shopSet;
    }

    public void setShopSet(Set<Shop> shopSet) {
        this.shopSet = shopSet;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }









}
