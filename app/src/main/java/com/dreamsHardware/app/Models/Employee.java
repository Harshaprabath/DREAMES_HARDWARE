package com.dreamsHardware.app.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Integer id;

    @Column(name ="Name",nullable = false)
    private String Name;

    //@Column(name ="PhotoFiledName",nullable = false, unique = true, length = 45)

    @Column(name ="PhotoFiledName")
    private String PhotoFiledName;

    @Column(name ="DateOfJoin")
    private Date DateOfJoin;

    @Column(name ="work")
    private boolean work;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhotoFiledName() {
        return PhotoFiledName;
    }

    public void setPhotoFiledName(String photoFiledName) {
        PhotoFiledName = photoFiledName;
    }

    public Date getDateOfJoin() {
        return DateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        DateOfJoin = dateOfJoin;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }



}
