package com.amgreat.integrator.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.RecordVO;
import com.amgreat.vo.RequestVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class CacheIntegrator implements CacheIntegratorIntf {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${cache.attribute.uri}")
	private String cacheAttributeUri;
	
	public AttributeVO recordVO2AttributeVO( RequestVO request ) {
		
		AttributeVO rq = new AttributeVO();
		
		if( request.getPageId() != null && !request.getPageId().trim().equals("") ) {
			
		}
		return rq;
	}
	
	public AttributeVO callCache( AttributeVO req ) {
		
		AttributeVO rp = null;
		
		try {
			if ( req != null ) {
				rp = restTemplate.postForObject( cacheAttributeUri, req, AttributeVO.class );
				
				//if ( rp != null ) {
					//ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					//String json = ow.writeValueAsString( rp );
				//}
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.AttributeVO: " + e.getMessage());
			rp = null;
		}
		return rp;
	}
	
	@Override
	public RecordVO callCache(RequestVO request) {
		
		AttributeVO req = recordVO2AttributeVO( request );  RecordVO rp = null;
		
		try {
			if ( req != null ) {
						
				rp = restTemplate.postForObject( cacheAttributeUri, req, RecordVO.class );
				
				if ( rp != null ) {
					
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	
					String json = ow.writeValueAsString( rp );
					
	               // System.out.println("JSON: " + json );
				}
            }
		} catch (Exception e) {
			System.out.println("DataIntegrator.callData.RequestVO: " + e.getMessage());
		}
		return rp;
	}

	@Override
	public RecordVO load2Cache(RequestVO request) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
