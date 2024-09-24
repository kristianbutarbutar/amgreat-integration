package com.amgreat.integrator.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amgreat.integrator.cache.CacheManagerInterface;
import com.amgreat.integrator.cache.LoadTableMapping2Cache;
import com.amgreat.integrator.cmd.CMDVO;
import com.amgreat.integrator.util.Utilities;
import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.RecordVO;
import com.amgreat.vo.RequestVO;
import com.amgreat.vo.StringVO;
import com.amgreat.vo.TemplateVO;

@Component
public class FEServices implements FEServicesInterface {

	@Autowired private DataIntegrator dataAPI;
	@Autowired private CacheIntegrator  cacheAPI;
	@Autowired private CacheManagerInterface  cacheManagerAPI;
	@Autowired private LoadTableMapping2Cache loader;
	
	@Override
	public RecordVO doCmd( RequestVO vo ) {
		
		RecordVO r = new RecordVO();
		
		if( vo!=null && vo.getCmdString()!=null && vo.getPageId() !=null && !vo.getPageId().trim().equals("") ) {
			
			AttributeVO attr = new AttributeVO();
			
			attr.setId( vo.getPageId() ); attr.setCmdName("s");
			
			attr = cacheAPI.callCache( attr );
			
			if( attr == null || attr.getTabelName() == null ) {
				
				boolean bool = loader.loadTableMapping2Cache( vo.getPageId() ); //---load to chache --
				
				if( bool )
					attr = cacheAPI.callCache( attr ); //--pull from cache--
				else
					System.out.println("[FEServices.doCmd] Cache failed for single pageId: " + vo.getPageId() );
			}
			
			if( attr != null && attr.getTabelName() != null ) {
				
				r = dataAPI.callData( attr );
				
				r.setRecordsInString( wrapIntoTemplate( r, vo.getPageId() ) );
				
				Utilities.printResponse( r );
			}
			
			AttributeVO tcache = attr;
			
			Utilities.printAttributes( tcache );
		}
		return r;
	}
	
	private StringVO wrapIntoTemplate( RecordVO r, String pageId ) {
		StringVO respond = new StringVO();
		if( r != null ) {
			
			TemplateVO t = new TemplateVO(); t.setId(pageId); t = this.getTemplateById(t);
			
			if( t != null ) {
				respond = new CMDVO().execute( r, t.getTemplate() );
			}
		}
		return respond;
	}
	
	private TemplateVO getTemplateById ( TemplateVO t ) {
		t.setTemplate("<div class=\"linkparentcss\">[[ReplaceCmd]]<div id=\"[[__ID]]\" class=\"linkcss formatcss\">[[__LABEL]]</div>[[ENDReplaceCmd]]</div>");
		return t;
		//return cacheManagerAPI.callCache(t);
	}
	
	private AttributeVO setFilter( RequestVO r, AttributeVO at) {
		if( r != null && r.getFilter() != null) {
			RequestVO rf = r; AttributeVO searchby = new AttributeVO(); at.setFilter( searchby );
			
			while( rf != null ) {
				searchby.setColumnName( rf.getName() );  
				
				searchby.setName( "__" + rf.getName() ); 
				
				searchby.setValue( rf.getVal() ); 
				
				searchby.setType( getStringType( at, rf.getName() ) );
				
				rf = rf.getNext();
			}
		}
		return at;
	}
	
	private String getStringType(AttributeVO at, String key) {
		String t = "";
		AttributeVO attemp = at;
			while( attemp != null) {
				if( attemp.getColumnName() != null && attemp.getType() != null && attemp.getColumnName().trim().equalsIgnoreCase( key ) ) {
					t = attemp.getType(); break;
				}
				attemp = attemp.getNext();
			}
		return t;
	}
}