package com.happy.admission.vo;

import com.happy.qa.vo.QaPhoto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AnimalPhoto {
	private int photoNo;
	private int aniNo;
	private String adPhotoOriName;
	private String adPhotoReName;
	private String mainPhoto;

}
