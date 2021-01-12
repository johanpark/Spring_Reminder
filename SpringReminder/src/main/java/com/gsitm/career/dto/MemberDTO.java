package com.gsitm.career.dto;
import lombok.Data;

@Data
public class MemberDTO {
	private String userID;
	private String userPassword;
	private String userName;
	private String userMail;
	private String modify_YN;
	private String creator;
	private String create_time;
	private String update_time;
}
