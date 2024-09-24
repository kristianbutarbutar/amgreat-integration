package com.amgreat.integrator.cache;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;
import com.amgreat.vo.TemplateVO;

public interface CacheManagerInterface {
	public AttributeVO callCache(AttributeVO req) ;
	public ListVO callCache(ListVO req) ;
	public PageVO callCache(PageVO req) ;
	public TemplateVO callCache(TemplateVO req);
}
