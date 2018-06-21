package com.login.bean;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptAndDecrypt extends PropertyPlaceholderConfigurer{
	private String[] vals={"jdbc.user","jdbc.passwd"};
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if(isEncryptProp(propertyName)){
			String decrypt = DESUtils.getDecrypt(propertyValue);
			return decrypt;
		}else{
			return propertyValue;
		}
	}
	private boolean isEncryptProp(String propertyName){
		for(String target:vals){
			if(target.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}
