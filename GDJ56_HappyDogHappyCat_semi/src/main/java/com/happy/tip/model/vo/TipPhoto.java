package com.happy.tip.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipPhoto {
	private int tipPhotoNo;
	private int tipBoardNo;
	private String tipPhotoOriname;
	private String tipPhotoRename;
}
