package com.amgreat.vo;

public class HtmlButtonVO extends PageVO {
	public HtmlButtonVO ( PageVO vo ) {
		this.setId( vo.getId() ); this.setCmdName("s");
	}
}
