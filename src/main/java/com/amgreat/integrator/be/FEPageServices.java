package com.amgreat.integrator.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amgreat.integrator.cache.CacheManager;
import com.amgreat.vo.PageVO;
import com.amgreat.vo.RequestVO;

@Component
public class FEPageServices {
	@Autowired private CacheManager cache;
	
	public PageVO cacheCmd(RequestVO vo) {
		PageVO pvo = new PageVO();
		try {
			pvo.setId( vo.getPageId() ); pvo.setCmdName("s");
			pvo = cache.callCache(pvo);
		} catch (Exception e) {
			System.out.println("[FEPageServices.cacheCmd]: " + e.getMessage() );
		}
		return pvo;
	}
}
