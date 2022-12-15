package com.happy.support.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Support {
	private int supBoardNo;
	private String supTitle;
	private int supTargetAmount;
	private String supContents;
	private char supApvYn;
	int supAgencyNo;
	
	
}
