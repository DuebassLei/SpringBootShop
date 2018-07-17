package com.gaolei.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Entity
@Table(name = "tb_store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;//商铺号

    private String name;//商铺姓名

    private String address;//商铺地址

    private int tel ;//商铺联系

    private String info;//商铺信息

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private Set<Shop> shops  = new HashSet<Shop>();

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

}
