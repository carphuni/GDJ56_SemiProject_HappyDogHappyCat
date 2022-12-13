package com.happy.adopt.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdtBorad {
	private int adtBoardNo;
	private int memberNo;
	private String adtContents;
	private String adtRegDate;
	private char adtDeleteYn;
	private int adtViews;
	private String adtRoommate;
	private String adtExper;
	private String adtMoney;
	private String adtLive;
	private String adtAllergy;
	private String adtVisitDate;
	private int aniNo;
	
}
