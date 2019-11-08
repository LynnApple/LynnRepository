package cn.ngmc.entity;

public class JsonResult<T> {
	
	private String status;//ok 正确，取data  err错误，取errMsg
	private T data;
	private String errMsg;

	public JsonResult(){

	}
	public JsonResult(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
