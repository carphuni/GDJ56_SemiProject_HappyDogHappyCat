package com.happy.adopt.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalPick {
	private int aniNo;
	private int memberNo;
}
