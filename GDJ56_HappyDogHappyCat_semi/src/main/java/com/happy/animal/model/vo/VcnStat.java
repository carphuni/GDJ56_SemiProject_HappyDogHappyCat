package com.happy.animal.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VcnStat {
	private int aniNo;
	private char madDog;
	private char covid;
	private char kennel;
	private char influ;
	private char antibody;
	private char totalvac;
}
