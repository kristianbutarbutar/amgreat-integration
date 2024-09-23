package com.amgreat.integrator.be;

import com.amgreat.vo.RecordVO;
import com.amgreat.vo.RequestVO;

public interface CacheIntegratorIntf {
	public RecordVO callCache( RequestVO request );
	public RecordVO load2Cache( RequestVO request );
}
