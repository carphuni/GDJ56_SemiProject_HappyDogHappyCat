package com.happy.adopt.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdtReviewBorad {
	private int adtBoardNo;
	private int memberNo;
	private String adtTitle;
	private String adtContents;
	private String adtViews;
}
