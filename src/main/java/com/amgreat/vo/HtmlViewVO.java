package com.amgreat.vo;

public class HtmlViewVO extends PageVO {
	public HtmlViewVO ( PageVO vo ) {
		this.setId( vo.getId() ); this.setCmdName("s");
	}
}
