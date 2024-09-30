package com.amgreat.vo;

public class HtmlEditVO extends PageVO {
	public HtmlEditVO ( PageVO vo ) {
		this.setId( vo.getId() ); this.setCmdName("s");
	}
}
