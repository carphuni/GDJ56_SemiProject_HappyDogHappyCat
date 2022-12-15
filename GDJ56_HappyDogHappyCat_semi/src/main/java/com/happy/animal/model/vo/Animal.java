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
	private char aniNeuYn;
	private char aniAdoptYn;
	private String aniSize;
	private String aniColor;
	private String[] aniChar;
	private String aniSpecial;
	private String aniReason;
	private char madDog;
	private char covid;
	private char kennel;
	private char influ;
	private char antibody;
	private char totalvac;
	private int adtViews;
}
