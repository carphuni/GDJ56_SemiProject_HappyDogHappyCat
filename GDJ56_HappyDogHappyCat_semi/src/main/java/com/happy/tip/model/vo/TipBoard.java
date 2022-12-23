package com.happy.tip.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipBoard {
	private int tipBoardNo;
	private int memberNo;
	private String tipCategory;
	private String tipTitle;
	private Date tipWriteDate;
	private int tipViews;
	private String tipContents;
	private char tipResultYn;
	private double tipLat;
	private double tipLon;
	private String memberId;
}	
