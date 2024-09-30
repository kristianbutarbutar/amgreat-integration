package com.amgreat.vo;

public class HtmlAddVO extends PageVO {
	public HtmlAddVO ( PageVO vo ) {
		this.setId( vo.getId() ); this.setCmdName("s");
	}
}
