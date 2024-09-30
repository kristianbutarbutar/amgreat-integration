package com.amgreat.vo;

public class HtmlSearchVO extends PageVO {
	public HtmlSearchVO ( PageVO vo ) {
		this.setId( vo.getId() ); this.setCmdName("s");
	}
}
