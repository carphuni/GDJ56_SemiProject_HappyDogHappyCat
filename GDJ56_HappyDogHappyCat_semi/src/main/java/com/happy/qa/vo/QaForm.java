package com.happy.qa.vo;

import java.sql.Date;

import com.happy.admission.vo.AdmissionForm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class QaForm {
	private int qaBoardNo;
	private int memberNo;
	private String qaTitle;
	private String qaContents;
	private Date qaWriteDate;
	private char qaDeleteYn;
	private String qaReply;
	private char qaOpenYn;
	private int qaPassword;
}
