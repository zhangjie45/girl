package com.example.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {
    @Id
    @GeneratedValue//表示自增
    private Integer id;
    private String cpuSize;
    @Min(value = 18, message = "年龄不够，不能注册")
    private Integer age;
    @NotNull(message = "金额必填")
    private Double money;

    public Girl() {

    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpuSize() {
        return cpuSize;
    }

    public void setCpuSize(String cpuSize) {
        this.cpuSize = cpuSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cpuSize='" + cpuSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
