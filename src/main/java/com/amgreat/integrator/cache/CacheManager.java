package com.amgreat.integrator.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.HtmlAddVO;
import com.amgreat.vo.HtmlButtonVO;
import com.amgreat.vo.HtmlEditVO;
import com.amgreat.vo.HtmlSearchVO;
import com.amgreat.vo.HtmlViewVO;
import com.amgreat.vo.ListVO;
import com.amgreat.vo.PageVO;
import com.amgreat.vo.TemplateVO;

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
	
	@Value("${cache.template.uri}")
	private String cacheTemplateUri;

	@Override
	public TemplateVO callCache(TemplateVO req) {
		TemplateVO rp = null;
		try {
			if ( req != null ) {
				rp = restTemplate.postForObject( cacheTemplateUri, req, TemplateVO.class );
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.TemplateVO: " + e.getMessage());
		}
		return rp;
	}
	
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

	@Override
	public PageVO generalCache(HtmlSearchVO o, String cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageVO generalCache(HtmlAddVO o, String cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageVO generalCache(HtmlEditVO o, String cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageVO generalCache(HtmlViewVO o, String cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageVO generalCache(HtmlButtonVO o, String cmd) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
