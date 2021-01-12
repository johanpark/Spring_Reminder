package com.gsitm.career.dto;

import lombok.Data;

@Data
public class TodoDTO {
	private String TodoID;
	private String TodoStartDate;
	private String TodoEndDate;
	private String TodoContent;
	private String userID;
	private String modifyYN;
	private String creator;
	private String createTime;
	private String updateTime;
}
