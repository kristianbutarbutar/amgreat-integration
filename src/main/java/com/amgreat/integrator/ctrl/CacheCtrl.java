package com.amgreat.integrator.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amgreat.integrator.be.FEPageServices;
import com.amgreat.integrator.cache.CacheManagerInterface;
import com.amgreat.integrator.cache.LoadTableMapping2Cache;
import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.HtmlAddVO;
import com.amgreat.vo.HtmlButtonVO;
import com.amgreat.vo.HtmlEditVO;
import com.amgreat.vo.HtmlSearchVO;
import com.amgreat.vo.HtmlViewVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;
import com.amgreat.vo.RequestVO;

@RestController
public class CacheCtrl {

	@Autowired
	private LoadTableMapping2Cache loader;
	
	@Autowired private CacheManagerInterface cache;
	
	@Autowired private FEPageServices pageCache;
	
	@RequestMapping( "/amgreate/api/int/loadcache" )
	public boolean loadCache( ) {
		return loader.loadTableMapping2Cache("all");
	}
	
	@RequestMapping( "/amgreate/api/int/htmlpage" )
	public PageVO loadCache( @RequestBody RequestVO request ) {
		return pageCache.cacheCmd( request ); 
	}
	
	@RequestMapping( "/amgreate/api/int/page" )
	public PageVO loadCache( PageVO vo) {
		return cache.callCache(vo);
	}
	
	@RequestMapping( "/amgreate/api/int/list" )
	public ListVO loadCache( ListVO vo) {
		return cache.callCache(vo);
	}
	
	@RequestMapping( "/amgreate/api/int/attribute" )
	public AttributeVO loadCache( AttributeVO vo) {
		return cache.callCache(vo);
	}
	
	@RequestMapping( "/api/amgreat/cache/generalpage/{obj}" )
	public PageVO getCacheS( @RequestBody PageVO o, @PathVariable String obj) {
		switch(obj) {
		case "s": 
			o = cache.generalCache( new HtmlSearchVO(o) , o.getCmdName() ); break;
		case "a": 
			o = cache.generalCache( new HtmlAddVO(o), o.getCmdName() ); break;
		case "e": 
			o = cache.generalCache( new HtmlEditVO(o), o.getCmdName() ); break;
		case "v": 
			o = cache.generalCache( new HtmlViewVO(o), o.getCmdName() ); break;
		case "b": 
			o = cache.generalCache( new HtmlButtonVO(o), o.getCmdName() ); break;
		}
		return o;
	}
}
