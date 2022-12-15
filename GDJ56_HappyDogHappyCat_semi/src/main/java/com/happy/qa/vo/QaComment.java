package com.happy.qa.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class QaComment {
	private int qaCommentNo;
	private int qaBoardNo;
	private Date qaCommentWriteDate;
	private String qaCommentWriteContent;
	private char qaCommentDelYn;
	private Date qaCommentModDate;
	

}
