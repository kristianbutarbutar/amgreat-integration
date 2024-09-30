package com.amgreat.integrator.cmd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.amgreat.vo.RecordVO;
import com.amgreat.vo.ResponseVO;
import com.amgreat.vo.StringVO;

public class ParentCmd<T> {
	private String path = "com.amgreat.integrator.cmd.";
	
	private Class<T> createInstance(String cls) {
		try {
			String __class = path+cls;
			Class t = Class.forName(__class); return t;
		} catch (ClassNotFoundException e) {
			System.out.println("[ParentCmd.createInstance]: " + e.getMessage() );
		}
		return null;
	}
	
	public StringVO executeCmd(String cls, ResponseVO r, String template) {
		StringVO response = new StringVO();
		try {
			String __class = path+cls;
			
			Class<?> c = Class.forName( __class );
			
			Object obj = c.getDeclaredConstructor().newInstance();
			
			Class<?> classObj = obj.getClass();
			
			if( c != null ) {
				
				Method method = classObj.getDeclaredMethod("execute", ResponseVO.class, String.class);
			
				response = (StringVO)method.invoke( classObj.newInstance(), r, template);
				
				System.out.println("response row string : " + (response != null && response.getRow() != null ? response.getRow() : "NULL" ) );
				
				return response;
				
			} else System.out.println("c is null");
		    
		} catch (InstantiationException e) {
			System.out.println("[ParentCmd.createInstance.InstantiationException]: " + e.getMessage() );
		} catch (ClassNotFoundException e) {
			System.out.println("[ParentCmd.createInstance.ClassNotFoundException]: " + e.getMessage() );
		}catch (SecurityException e) { 
			System.out.println("[ParentCmd.createInstance.SecurityException]: " + e.getMessage() );
		} catch (NoSuchMethodException e) { 
			  System.out.println("[ParentCmd.createInstance.NoSuchMethodException]: " + e.getMessage() );
		} catch (IllegalArgumentException e) { 
			System.out.println("[ParentCmd.createInstance.IllegalArgumentException]: " + e.getMessage() );
		} catch (IllegalAccessException e) { 
			  System.out.println("[ParentCmd.createInstance.IllegalAccessException]: " + e.getMessage() );
		} catch (InvocationTargetException e) { 
			  System.out.println("[ParentCmd.createInstance.InvocationTargetException]: " + e.getMessage() );
		}
		return response;
	}
}
