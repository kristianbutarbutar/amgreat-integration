package com.amgreat.integrator.cmd;

import com.amgreat.vo.RecordVO;
import com.amgreat.vo.ResponseVO;
import com.amgreat.vo.StringVO;

public class ReplaceCmd  extends ParentCmd<ReplaceCmd> implements CMDInterface<ResponseVO> {
	private String cmdName;
	public String getCmdName() { return cmdName; }
	public void setCmdName(String cmdName) { this.cmdName = cmdName; }
	
	@Override
	public StringVO execute( ResponseVO r, String template ) {
		
		StringVO svo = new StringVO();
		
		if(r != null) {
			
			ResponseVO rr = r; svo.setRow( template );
			
			while ( rr != null ) {
				
				if(rr.getName()!=null && !rr.getName().trim().equals("")) {
					
					String strVO = this.replace( svo.getRow(), rr.getName().trim().toUpperCase(), rr.getVal().trim() );
					
					svo.setRow( (strVO != null && !strVO.trim().equals("") ? strVO : svo.getRow() ) );
					
					System.out.println("Final Row: " + strVO);
				}
				
				rr = rr.getNext();
			}
		}
		
		return svo;
	}
	
	public String replace( String str, String src, String tar ) {
		System.out.println("in replace: template = " + str + ", src = " + src + ", tar = " + tar);
		String s = "";
		if( src != null && tar != null ){
			
			String srcc = "[["+ src.trim() +"]]";
			
			int idx = str.indexOf( srcc.trim() );
			if(idx >= 0 ) {
				s =str.substring(0, idx );
				s+=tar.trim();
				s+=str.substring( (idx + srcc.trim().length()), str.trim().length() );
			}
			
			idx = s.indexOf( srcc.trim() );
			
			System.out.println("after checked again: " + srcc + " at index = " + idx );
			
			if( idx >= 0 ) {
				return replace( s, src, tar );
			}
		}
		return s;
	}
}
