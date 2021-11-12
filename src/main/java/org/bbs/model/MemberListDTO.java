package org.bbs.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberListDTO {
	
	private long mem_no;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	private String mem_age;
	private String mem_gender;
	private Timestamp mem_reg_date;
}
