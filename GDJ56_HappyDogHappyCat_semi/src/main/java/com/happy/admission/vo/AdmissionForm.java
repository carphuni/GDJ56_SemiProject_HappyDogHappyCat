package com.happy.admission.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionForm {
	private int admissionNo;
	private int memberNo;
	private int animalNo;
	private String admissionTitle;
	private Date writeDate;
	private Date hopeDate;
	private String admissionReason;
	private char admissionYN;
	private Date admissionDate;
	private char admissionDeleteYN;
	
	
	
	

}
