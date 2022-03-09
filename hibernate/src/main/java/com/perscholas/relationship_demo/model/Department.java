package com.perscholas.relationship_demo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Department implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
    private int did;
    private String dname;

    public Department() { }

    public Department(int did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return this.did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
