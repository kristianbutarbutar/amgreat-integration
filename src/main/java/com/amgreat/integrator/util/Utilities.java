package com.amgreat.integrator.util;

import java.util.Random;

import com.amgreat.vo.AttributeVO;
import com.amgreat.vo.RecordVO;
import com.amgreat.vo.ResponseVO;

public class Utilities {
    public static String getRandomText(int len) {
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i<len;i++) {
            char c = (char)(65+r.nextInt(25));
            b.append(c);
        }
        return b.toString();
    }
    public static void printAttributes ( AttributeVO vo ) {
		while( vo != null ) {
			System.out.println( vo.getColumnName() + " : " + vo.getType() );
			vo = vo.getNext();
		}
	}
    
    public static void printResponse( RecordVO vo) {
    	if( vo != null && vo.getResponse() != null) {
    		RecordVO recs = vo; int i = 1;
    		while( recs != null ) {
    				ResponseVO rvo = recs.getResponse();
    				System.out.println("RecordNo["+i+"]");
	    		while ( rvo != null ) {
	    			System.out.println(  (rvo.getName()!=null ? rvo.getName():"") + " / " + (rvo.getLabel()!=null ? rvo.getLabel():"") + " : " + (rvo.getVal()!=null ? rvo.getVal(): "") );
	    			rvo = rvo.getNext();
	    		}
	    		recs = recs.getNext(); i++;
    		}
    	}
    }
}
