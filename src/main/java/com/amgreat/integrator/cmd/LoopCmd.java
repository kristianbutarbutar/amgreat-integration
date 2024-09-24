package com.amgreat.integrator.cmd;

import com.amgreat.vo.ResponseVO;
import com.amgreat.vo.StringVO;

public class LoopCmd  extends ParentCmd<LoopCmd> implements CMDInterface<ResponseVO> {
	private String cmdName;
	public String getCmdName() { return cmdName; }
	public void setCmdName(String cmdName) { this.cmdName = cmdName; }
	
	@Override
	public StringVO execute(ResponseVO r, String template) {
		// TODO Auto-generated method stub
		return null;
	}
}
