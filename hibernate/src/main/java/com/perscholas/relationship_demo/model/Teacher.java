package com.perscholas.relationship_demo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Teacher implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int tit;
	private String salary;
	private String teachername;
	@ManyToOne
    @JoinColumn(name = "fk_dep")
	private Department department;

	public Teacher() { }

	public Teacher(int tit, String salary, String teachername) {
		super();
		this.tit = tit;
		this.salary = salary;
		this.teachername = teachername;
	}

    public Department getDep() {
		return department;
	}

	public void setDep(Department department) {
		this.department = department;
	}

    public int getTit() {
        return this.tit;
    }

    public void setTit(int tit) {
        this.tit = tit;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeachername() {
        return this.teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

}
