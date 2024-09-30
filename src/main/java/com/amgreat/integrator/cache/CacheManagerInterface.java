package com.amgreat.integrator.cache;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.HtmlAddVO;
import com.amgreat.vo.HtmlButtonVO;
import com.amgreat.vo.HtmlEditVO;
import com.amgreat.vo.HtmlSearchVO;
import com.amgreat.vo.HtmlViewVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;
import com.amgreat.vo.TemplateVO;

public interface CacheManagerInterface {
	public AttributeVO callCache(AttributeVO req) ;
	public ListVO callCache(ListVO req) ;
	public PageVO callCache(PageVO req) ;
	public TemplateVO callCache(TemplateVO req);
	public PageVO generalCache(HtmlSearchVO o, String cmd);
	public PageVO generalCache(HtmlAddVO o, String cmd);
	public PageVO generalCache(HtmlEditVO o, String cmd);
	public PageVO generalCache(HtmlViewVO o, String cmd);
	public PageVO generalCache(HtmlButtonVO o, String cmd);
}
