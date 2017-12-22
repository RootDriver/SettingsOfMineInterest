package mine.attribute.basic_describe;

import java.util.Map;

public class Buffer {
	private Integer bufferId;
	private String bufferDescribe;
	private Map<Attribute, BufferEffect> bufferEffects;
	

	public Integer getBufferId() {
		return bufferId;
	}

	public void setBufferId(Integer bufferId) {
		this.bufferId = bufferId;
	}

	public String getBufferDescribe() {
		return bufferDescribe;
	}

	public void setBufferDescribe(String bufferDescribe) {
		this.bufferDescribe = bufferDescribe;
	}

	public Map<Attribute, BufferEffect> getBufferEffects() {
		return bufferEffects;
	}

	public void setBufferEffects(Map<Attribute, BufferEffect> bufferEffects) {
		this.bufferEffects = bufferEffects;
	}

}
