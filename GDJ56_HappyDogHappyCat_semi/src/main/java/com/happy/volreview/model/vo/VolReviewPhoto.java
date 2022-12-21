package com.happy.volreview.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class VolReviewPhoto {
	
	private int fileNo;
	private int vntBoardNo;
	private String mainPhoto;
	private String vntPhotoOriName;
	private String vntPhotoRename;
	
	
	

}
