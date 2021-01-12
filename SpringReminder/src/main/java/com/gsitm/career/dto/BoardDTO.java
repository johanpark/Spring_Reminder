package com.gsitm.career.dto;
import lombok.Data;

@Data
public class BoardDTO {
	private String boardID;
	private String boardTitle;
	private String userID;
	private String boardDate;
	private String boardContent;
	private String boardAvailable;
	private String modifyYN;
	private String creator;
	private String createTime;
	private String updateTime;
}
