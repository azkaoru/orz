package java8extra.service.config;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton(name="ConfigrationBean")
@Startup
@DependsOn({"AuthServiceWrapper"})
public class ConfigrationBean {

	private Context envCtx;
	private String profileEnv;

	public ConfigrationBean() {
		super();
	}
	
	@PostConstruct
	public void init(){
		try {
			InitialContext initialContext = new InitialContext();
			this.envCtx = (Context) initialContext.lookup("java:comp/env");
			this.profileEnv = (String) this.envCtx.lookup("PROFILE_ENV");
		} catch (Exception e) {
			throw new IllegalStateException("envCtx create failed",e.getCause());
		}
	}
	
	public String getProfile() {
		return this.profileEnv;
	}

	public Object getEnv(String name){
		Object obj = null;
		try {
			obj = envCtx.lookup(this.profileEnv +"."+name);
		} catch (NamingException e) {
			throw new IllegalStateException("getEnv failed(name = "+name+")",e.getCause());
		}
		return obj;
	}
	
	
	public Object getProp(String key){
		Object obj = null;
		try {
			this.envCtx.lookup(key);
		} catch (NamingException e) {
			throw new IllegalStateException("getProp failed(key = "+key+")",e.getCause());
		}
		return obj;
	}
	 
}
