package com.amgreat.integrator.cmd;

import com.amgreat.vo.RecordVO;
import com.amgreat.vo.ResponseVO;
import com.amgreat.vo.StringVO;

public class CMDVO extends ParentCmd<CMDVO> implements CMDInterface<RecordVO>{
	
	/**
	 *  wrap the template content for records
	 */
	@Override
	public StringVO execute( RecordVO r, String template ) {
		
		StringVO respond = new StringVO();
		
		StringVO[] resparr = new StringVO[ r.getRecNo() ] ;
		
		if( r != null) {
		
			RecordVO rvo = r; int idx = 0; String cmdName = null;
			
			while( rvo != null ) {
				
				ResponseVO resvo = rvo.getResponse();
				
				resparr[idx] = this.executeCommand( resvo, template, cmdName );
				
				cmdName = resparr[idx].getCmdName();
				
				System.out.println("Result Text: " + resparr[idx].getRow() );
				System.out.println("Result Command: " + cmdName );
				
				if( idx <=0 ) {
					template =  new ReplaceCmd().replace( template, cmdName, " " );
					template =  new ReplaceCmd().replace( template, "END"+cmdName, " " );
					
					System.out.println("latest template: " + template);
					
					resparr[0].setRow( new ReplaceCmd().replace( resparr[0].getRow(), cmdName, " " ));
					resparr[0].setRow( new ReplaceCmd().replace( resparr[0].getRow(), "END"+cmdName, " " ));
				}
				
				rvo = rvo.getNext(); idx++;
			}
			respond.setRows( resparr );
			
		}
		return respond;
	}
	
	private String cmdName = "main";
	public String getCmdName() { return cmdName; }
	public void setCmdName(String cmdName) { this.cmdName = cmdName; }
	
	private StringVO executeCommand(ResponseVO r, String t, String cmdName) {
		
		StringVO row = new StringVO();
		
		if( t != null ) {
			
			int idx = t.indexOf("Cmd]]"); String sr = ""; 
			
			if( cmdName != null ) { idx = 0; sr = cmdName; }
			
			for ( int i = idx; i > 0; i-- ) {
		
				sr = t.substring( i, (i+2) );
				
				
				if( sr.equals("[[") ) {
					
					sr = t.substring( (i+2), (idx+3) ).trim();
					
					break;
				}
			}
			
			if( sr != null && sr.length() > 1 ) {
				
				row = super.executeCmd( sr, r, t ); row.setCmdName( sr );
				
				System.out.println("row string : " + row.getRow() );
			}
		}
		return row;
	}
}
