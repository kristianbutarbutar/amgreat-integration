package com.amgreat.integrator.cmd;

import com.amgreat.vo.PageVO;
import com.amgreat.vo.RecordVO;
import com.amgreat.vo.ResponseVO;
import com.amgreat.vo.StringVO;

public interface CMDInterface<T> {
	public StringVO execute( T r, String template );
}
