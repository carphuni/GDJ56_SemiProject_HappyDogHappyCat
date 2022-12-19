package com.happy.adopt.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdoptPhoto {

	private int fileNo;
	private int adtBoardNo;
	private String adtPhotoOriName;
	private String adtPhotoRename;
		
}
