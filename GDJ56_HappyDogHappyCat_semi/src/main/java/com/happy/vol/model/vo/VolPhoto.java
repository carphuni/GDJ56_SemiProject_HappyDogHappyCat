package com.happy.vol.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class VolPhoto {

	private int fileNo;
	private int vntBoardNo;
	private String mainPhoto;
	private String vntPhotoOriName;
	private String vntPhotoRename;
		
}
