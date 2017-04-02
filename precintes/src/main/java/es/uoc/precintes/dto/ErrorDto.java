package es.uoc.precintes.dto;

public class ErrorDto {
	private String key;

	public ErrorDto(String key) {
		this.key=key;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	};
}
