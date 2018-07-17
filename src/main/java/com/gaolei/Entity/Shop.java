package com.gaolei.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoLei on 2018/6/25.
 */
@Entity
@Table(name = "tb_shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ; //商品id

    private String name;//商品名

    private int price;// 商品价格

    private int num;//商品数量

    private String info;//商品信息

    @ManyToOne
    @JoinColumn(name = "store_id")//外键
    private  Store store;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "custom_shop",//中间表的名称
            joinColumns = {@JoinColumn(name="shop_id")},//本表与中间表的外键对应关系
            inverseJoinColumns = {@JoinColumn(name = "custom_id")})//另一张表与中间表的外键的对应关系
    private Set<Custom> customs = new HashSet<Custom>();

    public Set<Custom> getCustoms() {
        return customs;
    }

    public void setCustoms(Set<Custom> customs) {
        this.customs = customs;
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


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }





}
