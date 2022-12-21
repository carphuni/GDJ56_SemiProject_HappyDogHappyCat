package com.happy.volreview.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class VolReview {

	private int vntBoardNo;
	private int memberNo;
	private String vntTitle;
	private String vntContents;
	private int vntReviewViews;
	private Date vntReviewWriteDate;
	private String memberId;
}
