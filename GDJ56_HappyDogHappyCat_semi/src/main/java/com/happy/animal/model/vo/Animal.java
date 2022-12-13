package com.happy.animal.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
	private int aniNo;
	private String aniName;
	private String aniType;
	private String aniKind;
	private char aniGender;
	private int aniAge;
	private String[] vcnStat;
	private char aniNeuYn;
	private char aniAdoptYn;
	private String aniSize;
	private String aniColor;
	private String aniChar;
	private String aniSpecial;
	private String aniReason;
	
}
