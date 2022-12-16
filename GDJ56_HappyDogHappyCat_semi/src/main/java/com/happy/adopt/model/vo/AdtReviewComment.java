package com.happy.adopt.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AdtReviewComment {
	private int commentNo;
	private String memberId;
	private String commentWriteDate;
	private String commentContents;
	private char commentDeleteYn;
	private String commentModifyDate;
	private int adtReviewBoardNo;
}
