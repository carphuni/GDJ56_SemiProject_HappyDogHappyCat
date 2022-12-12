package com.happy.member.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	private int MemberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private Date memberBirthDate;
	private String memberEmail;
	private String memberAddress;
	private String memberDelYn;
	private Date memberDelDate;
	private Date memberEnrollDate;
	private String memberLikeType;
	private String memberLikeSize;
	private String memberLikeColor;
	private String memberLikeChar;
	private String memberPhone;
}
