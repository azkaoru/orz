package java8extra.service;


public interface ServiceOrder<IN> {

	
	/**
     * The type that defines the type of service.<br/>
     */
    enum SERVICE_TYPE {
    	AUTH("ejb:/java8extra-0.1-SNAPSHOT/AuthServiceWrapper!java8extra.service.BizService"),MESSAGE("ejb/apiServersManagedService");
        
        private String jndiName;
      

        private SERVICE_TYPE(String jndiName) {
        	this.jndiName = jndiName;
        }

		public String getJndiName() {
			return jndiName;
		}
        
    }
//    
//	public SERVICE_TYPE getType() {
//		return type;
//	}

	public SERVICE_TYPE getType();
	
	void setInput(IN input);
	
	
	public IN getInput();
	

	BeanFinderFactory getBeanFinderFactory();
	
	
	
}
