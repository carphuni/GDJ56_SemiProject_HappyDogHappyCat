package com.happy.Hospital.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Hospital {
	private String hosName;
	private String hosAddr;
	private double hosXx;
	private double hosYy;
	private String hosPhone;
	private String hosOff;
}
