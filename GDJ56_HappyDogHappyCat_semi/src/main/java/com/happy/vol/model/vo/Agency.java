package com.happy.vol.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Agency {
	private int agencyNo;
	private int memberNo;
	private String agencyName;
	private String agencyAddress;
	private String agencyPhone;
	

}
