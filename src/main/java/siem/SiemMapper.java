package siem;

public class SiemMapper {
	
	private String description;
	private String requestType;
	private String status;
	private int priority;
	private String submitter;
	
	public SiemMapper(String description,String requestType,String status,int priority,String submitter) {
		super();
		this.description = description;
		this.requestType = requestType;
		this.status = status;
		this.priority = priority;
		this.submitter = submitter;
		
	}
	
	

}
