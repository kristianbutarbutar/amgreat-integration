package com.amgreat.integrator.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;

@Component
public class CacheManager implements CacheManagerInterface{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${cache.attribute.uri}")
	private String cacheAttributeUri;
	
	@Value("${cache.list.uri}")
	private String cacheListUri;
	
	@Value("${cache.page.uri}")
	private String cachePageUri;
	
	@Override
	public ListVO callCache(ListVO req) {
		
		ListVO rp = null;
		
		try {
			if ( req != null ) {
				rp = restTemplate.postForObject( cacheListUri, req, ListVO.class );
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.ListVO: " + e.getMessage());
		}
		return rp;
	}
	
	@Override
	public PageVO callCache(PageVO req) {
		
		PageVO rp = null;
		
		try {
			if ( req != null ) {
				rp = restTemplate.postForObject( cachePageUri, req, PageVO.class );
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.PageVO: " + e.getMessage());
		}
		return rp;
	}
	
	@Override
	public AttributeVO callCache(AttributeVO req) {
		
		AttributeVO rp = null;
		
		try {
			if ( req != null ) {
				rp = restTemplate.postForObject( cacheAttributeUri, req, AttributeVO.class );
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.AttributeVO: " + e.getMessage());
		}
		return rp;
	}
	
}
