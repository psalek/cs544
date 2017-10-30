package cs544.sample;

public class NoSuchResourceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private long resourceId;
	private String resourceType;

	public NoSuchResourceException(String resourceType, long resourceId) {
		super();
		this.resourceType = resourceType;
		this.resourceId = resourceId;
	}
	
	public long getResourceId() {
		return resourceId;
	}
	
	public String getResourceType() {
		return resourceType;
	}

}
