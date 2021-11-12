package org.bbs.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	
	private long bod_no;
	private String bod_title;
	private String bod_writer;
	private int bod_password;
	private String bod_content;
	private Timestamp bod_reg_date;
	private String bod_hits;
	
	
}
