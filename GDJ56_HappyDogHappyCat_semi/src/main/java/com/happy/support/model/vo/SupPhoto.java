package com.happy.support.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SupPhoto {
	
	private int supFileNo;
	private int supBoardNo;
	private String supMainPhoto;
	private String supPhotoOriName;
	private String supPhotoRename;
	
}
