package com.amgreat.integrator.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amgreat.integrator.cache.CacheManagerInterface;
import com.amgreat.integrator.cache.LoadTableMapping2Cache;
import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;

@RestController
public class CacheCtrl {

	@Autowired
	private LoadTableMapping2Cache loader;
	
	@Autowired
	private CacheManagerInterface cache;
	
	@RequestMapping( "/amgreate/api/int/loadcache" )
	public boolean loadCache( ) {
		return loader.loadTableMapping2Cache("all");
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
}
