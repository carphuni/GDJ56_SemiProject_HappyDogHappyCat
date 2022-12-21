package com.happy.volreview.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class VolComment {

	private int vntCommentNo;
	private String memberId;
	private Date vntCommentWrite;
	private String vntCommentContents;
	private char vntCommentDeleteYn;
	private Date vntCommentModifyDate;
	private int vntBoardNo;
}
