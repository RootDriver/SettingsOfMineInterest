package mine.attribute;

import mine.attribute.basic_describe.Buffer;

public interface IBuffer {
	Object getBuffers();
	Object addBuffer(Buffer buff);
	void clearBuffer();
}
