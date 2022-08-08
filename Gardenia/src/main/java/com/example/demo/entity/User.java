package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "login", nullable = false, length = 20)
	private String login;
	
	@Column(name = "firstName", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "emp_code", nullable = false, length = 20)
	private String emp_code;
	
	@Column(name = "team", nullable = false, length = 20)
	private String team;
	
	@Column(name = "roles", nullable = false, length = 20)
	private String roles;
	
	@Column(name = "status", nullable = false, length = 20)
	private String status;
	
	@Column(name = "create_date", nullable = false, length = 20)
	private String create_date;
	
	@Column(name = "resign_date", nullable = false, length = 20)
	private String resign_date;
	
	@Column(name = "region_name", nullable = false, length = 20)
	private String region_name;

	@Column(name = "region_id", nullable = false, length = 20)
	private String region_id;
	
	@Column(name = "state_name", nullable = false, length = 20)
	private String state_name;
	
	@Column(name = "state_id", nullable = false, length = 20)
	private String state_id;
	
	@Column(name = "hq_name", nullable = false, length = 20)
	private String hq_name;
	
	@Column(name = "hq_id", nullable = false, length = 20)
	private String hq_id;
	
	@Column(name = "documents", nullable = false, length = 20)
	private String documents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getResign_date() {
		return resign_date;
	}

	public void setResign_date(String resign_date) {
		this.resign_date = resign_date;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getHq_name() {
		return hq_name;
	}

	public void setHq_name(String hq_name) {
		this.hq_name = hq_name;
	}

	public String getHq_id() {
		return hq_id;
	}

	public void setHq_id(String hq_id) {
		this.hq_id = hq_id;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}
	

	public User(Long id,String login, String lastName, String emp_code,
			String team, String roles, String status, String create_date, String resign_date, String region_name,
			String region_id, String state_name, String state_id, String hq_name, String hq_id, String documents) {
		super();
		this.id = id;
		this.login = login;
		this.lastName = lastName;
		this.emp_code = emp_code;
		this.team = team;
		this.roles = roles;
		this.status = status;
		this.create_date = create_date;
		this.resign_date = resign_date;
		this.region_name = region_name;
		this.region_id = region_id;
		this.state_name = state_name;
		this.state_id = state_id;
		this.hq_name = hq_name;
		this.hq_id = hq_id;
		this.documents = documents;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
		
}
