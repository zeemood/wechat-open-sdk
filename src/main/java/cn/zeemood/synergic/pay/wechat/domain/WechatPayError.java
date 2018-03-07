package cn.zeemood.synergic.pay.wechat.domain;

public class WechatPayError {
	
	private String err_code_des;
	private String err_cause;
	private String err_resolve;
	
	public WechatPayError(String err_code_des,String err_cause,String err_resolve){
		this.err_code_des=err_code_des;
		this.err_cause=err_cause;
		this.err_resolve=err_resolve;
	}
	
	public static WechatPayErrorBuilder builder(){
		return new WechatPayErrorBuilder();
	}
	
	public static class WechatPayErrorBuilder{
		private String err_code_des;
		private String err_cause;
		private String err_resolve;
		
		public WechatPayErrorBuilder err_code_des(String err_code_des){
			this.err_code_des=err_code_des;
			return this;
		}
		
		public WechatPayErrorBuilder err_cause(String err_cause){
			this.err_cause=err_cause;
			return this;
		}
		
		public WechatPayErrorBuilder err_resolve(String err_resolve){
			this.err_resolve = err_resolve;
			return this;
		}

		@Override
		public String toString(){
			return "WechatPayErrorBuilder[err_code_des="+this.err_code_des+",err_cause="+this.err_cause+",err_resolve="+err_resolve+"]";
		}
		
		public WechatPayError build(){
			return new WechatPayError(this.err_code_des, this.err_cause, this.err_resolve);
		}
	}
	
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getErr_cause() {
		return err_cause;
	}
	public void setErr_cause(String err_cause) {
		this.err_cause = err_cause;
	}
	public String getErr_resolve() {
		return err_resolve;
	}
	public void setErr_resolve(String err_resolve) {
		this.err_resolve = err_resolve;
	}

}
