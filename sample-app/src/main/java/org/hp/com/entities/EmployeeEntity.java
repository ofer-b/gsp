package org.hp.com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by borshtei on 13-Aug-14.
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity
{
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    @Column(name="FIRSTNAME")
    private String firstname;
    @Column(name="LASTNAME")
    private String lastname;
    @Column(name="EMAIL")
    private String email;
    @Column(name="TELEPHONE")
    private String telephone;
    //Add setters and getters
}