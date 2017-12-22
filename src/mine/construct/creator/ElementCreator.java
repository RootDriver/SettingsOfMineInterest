package mine.construct.creator;

import java.util.Map;

import mine.construct.BeanFactory;
import mine.construct.integrate.Element;

public class ElementCreator implements BeanFactory<Element> {
	private Element element;
	private Map<String, ?> elementAttributeProperties;
	private Map<String, ?> essentialElementAttributeProperties;

	protected Element createEmptyElementWithoutInit()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Element) this.getObjectType().newInstance();
	}

	/**
	 * I need a way to load element attribute properties
	 */
	public void loadElementAttributeProperties() {

	}

	/**
	 * this method is to load the basic element attribute properties. those
	 * attributes , is the primary and non-addtionally to create elements. Maybe
	 * I need some essential properties to init .like those in class
	 * mine.attribute.basic_describe.Attribute private Double natural; private
	 * Double growth; private Double primary;
	 */
	public void loadEssentialElementAttributeProperties() {

	}

	/**
	 * This method can return a SIMPLE calculate model used to calculate
	 *
	 */
	public Object extractSimpleCalculateModel() {
		return null;
	}

	@Override
	public Element getObject() throws Exception {
		return this.element;
	}

	@Override
	public Class<?> getObjectType() {
		return this.element != null ? this.element.getClass() : Element.class;
	}

	public ElementCreator(Element element) {
		this.element = element;
	}

	public ElementCreator() {

	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

}
