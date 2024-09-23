package com.amgreat.integrator.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amgreat.integrator.be.DataIntegratorIntf;
import com.amgreat.integrator.be.FEServicesInterface;
import com.amgreat.integrator.cache.LoadTableMapping2Cache;
import com.amgreat.integrator.data.DataModellingIntf;
import com.amgreat.vo.RecordVO;
import com.amgreat.vo.RequestVO;

@RestController
public class DataCtrl {

	@Autowired
	private DataIntegratorIntf data;
	
	
	@Autowired
	private DataModellingIntf dm; 
	
	@Autowired private FEServicesInterface feAPI;
	
	@RequestMapping( "/amgreate/api/int/interface" )
	public RecordVO callData( @RequestBody RequestVO request ) {
		RecordVO r = null;
		try {
			r = data.callData(request);
		} catch (Exception e) {
			System.out.println("[DataCtrl.callData]:" + e.getMessage());
		}
		return r; 
	}
	
	@RequestMapping( "/amgreate/api/int/dm" )
	public String genDM(  ) {
		return dm.extractDBStructure();
	}
	
	@RequestMapping( "/amgreate/api/int/fe" )
	public RecordVO getQ( @RequestBody RequestVO request ) {
		RecordVO r = null;
		try {
			if(request != null && request.getPageId() != null && !request.getPageId().trim().equals("")) {
				r = feAPI.doCmd( request );
			}
		} catch (Exception e) {
			System.out.println("[DataCtrl.getQ]:" + e.getMessage());
		}
		return r; 
	}
}