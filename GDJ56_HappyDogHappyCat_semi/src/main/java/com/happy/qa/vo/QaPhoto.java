package com.happy.qa.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class QaPhoto {
	private int photoNo;
	private int qaBoardNo;
	private String qaPhotoOriName;
	private String qaPhotoReName;

}
