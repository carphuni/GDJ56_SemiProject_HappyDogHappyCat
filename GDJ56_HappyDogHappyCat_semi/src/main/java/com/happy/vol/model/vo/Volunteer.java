package com.happy.vol.model.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class Volunteer {

	private int vntBoardNo;
	private int vntAgencyNo;
	private String vntRecName;
	private String vntManagerName;
	private Date vntRecPeriod;
	private Date vntRecPeriodEnd;
	private Date vntActPeriod;
	private Date vntActPeriodEnd;
	private String vntActDay;
	private Date vntActWriteDate;
	private String vntActContents;
	private int vntActViews;
	private int vntSetPerson;
	private int vntEnrPerson;
	private Date vntActDline;
	
}
