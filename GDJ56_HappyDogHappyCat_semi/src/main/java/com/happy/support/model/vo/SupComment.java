package com.happy.support.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupComment {
	
	private int supCommentNo;
	private int supBoardNo;
	private Date supCommentWriteDate;
	private String supCommentContents;
	private char supCommentDeleteYn;
	private int supUserNo;
	private int supPayAmount;
	private int supPayAmountCount;
	
	
}
