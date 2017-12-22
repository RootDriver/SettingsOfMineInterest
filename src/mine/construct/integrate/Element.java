package mine.construct.integrate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mine.attribute.basic_describe.Attribute;
import mine.attribute.basic_describe.Buffer;
import mine.attribute.basic_describe.BufferEffect;
import mine.evolution.Evolution;
import mine.evolution.proceed_path.Qualitative;
import mine.evolution.proceed_path.Quantitative;
import mine.exception.InitAttributeException;
import mine.exception.PrimaryAttributeException;

public class Element implements Evolution {
	private Map<String, Double> currentAttributeValue = new HashMap<>();
	private Map<String, Double> primaryAttributeValue = new HashMap<>();

	private Map<String, Attribute> attributes;
	private List<Buffer> buffers;
	/**
	 * this attribute : allBuffEffects may be use
	 */
	private Map<Attribute, List<BufferEffect>> allBuffEffects = new HashMap<Attribute, List<BufferEffect>>();
	/**
	 * this attribute : expectBufferEffects might be useful
	 */
	private Map<Attribute, BufferEffect> expectBufferEffects = new HashMap<>();

	/**
	 * init attribute take key and value from the map attributes
	 * 
	 * @throws InitAttributeException
	 */
	public void initPrimaryAttribute() throws InitAttributeException {
		if (isCountable(attributes)) {
			for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
				Attribute attribute = entry.getValue();
				String attributeName = attribute.getAttributeName();
				Double primaryValue = attribute.getPrimaryValue();
				primaryAttributeValue.put(attributeName, primaryValue);
			}
		} else {
			throw new InitAttributeException("Init Attributes failed,pls check the Character's attributes");
		}
	}

	public void initCurrentAttribute() {
		List<Buffer> list = this.getBuffers();
		Map<Attribute, List<BufferEffect>> map = this.getAllBuffEffects();

		initAllBufferEffects(list, map);

		initExpectBufferEffects(map);

		initCurrentAttributeValue();

	}

	/**
	 * You can overrider this method,but the primary way is to calculate effect of buffers.
	 * This calculate way is fix multiply coefficient first , then add  plus coefficient .
	 * May be 'coefficient' , this word , is not very perty to describe plus,but for now ,just that. 
	 */
	public void initCurrentAttributeValue() {
		Map<Attribute, BufferEffect> expectMap = this.getExpectBufferEffects();
		Map<String, Double> primaryMap = this.getPrimaryAttributeValue();
		Map<String, Double> currentMap = this.getCurrentAttributeValue();

		if (isCountable(expectMap)) {
			if (isCountable(primaryMap)) {
				for (Entry<String, Double> entryPrimary : primaryMap.entrySet()) {
					String primaryKey = entryPrimary.getKey();
					Double primaryValue = entryPrimary.getValue();
					// for each to get variable value
					for (Entry<Attribute, BufferEffect> entry : expectMap.entrySet()) {
						Attribute attribute = entry.getKey();
						BufferEffect effect = entry.getValue();
						if (primaryKey.equalsIgnoreCase(attribute.getAttributeName())) {
							primaryValue = primaryValue * effect.getMultiplyCoefficient() + effect.getPulsCoefficient();
						}
					}
					currentMap.put(primaryKey, primaryValue);
				}
			} else {
				throw new PrimaryAttributeException("Primary Attribute not init");
			}
		} else {
			copyMap(primaryMap, currentMap);
		}

	}

	public <K, V> void copyMap(Map<K, V> map1, Map<K, V> map2) {
		if (!map1.isEmpty()) {
			for (Map.Entry<K, V> entry : map1.entrySet()) {
				map2.put(entry.getKey(), entry.getValue());
			}
		}
	}

	public void initExpectBufferEffects(Map<Attribute, List<BufferEffect>> map) {
		Map<Attribute, BufferEffect> expectEffects = this.getExpectBufferEffects();
		// get the expect buffer effect
		// the map ,I mean , the allBuffEffects,is countable,
		// add this condition may be faster
		if (isCountable(map)) {
			for (Entry<Attribute, List<BufferEffect>> entry : map.entrySet()) {
				Double multiCoefficient = 1.0;
				Double plusCoefficient = 0.0;
				Attribute key = entry.getKey();
				List<BufferEffect> value = entry.getValue();
				// for each to get expect
				if (isCountable(value)) {
					for (BufferEffect buffEffect : value) {
						multiCoefficient *= buffEffect.getMultiplyCoefficient();
						plusCoefficient += buffEffect.getPulsCoefficient();
					}
				}

				expectEffects.put(key, new BufferEffect(multiCoefficient, plusCoefficient));

			}
		}
		// if map not countable ,do nothing
	}

	public void initAllBufferEffects(List<Buffer> list, Map<Attribute, List<BufferEffect>> map) {
		if (isCountable(list)) {
			for (Buffer buff : list) {
				Map<Attribute, BufferEffect> bufferEffects = buff.getBufferEffects();
				if (isCountable(bufferEffects)) {
					for (Map.Entry<Attribute, BufferEffect> entry : bufferEffects.entrySet()) {

						// get key and value
						Attribute key = entry.getKey();
						BufferEffect value = entry.getValue();

						// put the attribute as key and buffereffect as value
						// into the Map allBufferEffects
						putElementsInAllBuffEffects(map, key, value);

					}
				}
			}
		} // if
	}

	public void clearCalculateData() {
		this.getAllBuffEffects().clear();
		this.getExpectBufferEffects().clear();
		this.getCurrentAttributeValue().clear();
	}

	public Boolean isCountable(Collection<?> collection) {
		if (null != collection && !collection.isEmpty()) {
			return true;
		}
		return false;
	}

	public Boolean isCountable(Map<?, ?> map) {
		if (null != map && !map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * if allbuffeffects not contains the attribute, put a new Arraylist
	 * <BufferEffect> into allbuffeffects if allbuffeffects contains the
	 * attribute , get the value and add the element value -- Buffereffect;
	 */
	public void putElementsInAllBuffEffects(Map<Attribute, List<BufferEffect>> map, Attribute key, BufferEffect value) {
		if (!map.containsKey(key)) {
			ArrayList<BufferEffect> arrayList = new ArrayList<BufferEffect>();
			arrayList.add(value);
			map.put(key, arrayList);
		} else {
			map.get(key).add(value);
		}
	}

	public Map<String, Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Buffer> getBuffers() {
		return buffers;
	}

	public void setBuffers(List<Buffer> buffers) {
		this.buffers = buffers;
	}

	@Override
	public Qualitative getQualitive() {
		return null;
	}

	@Override
	public Quantitative getQuantitative() {
		return null;
	}

	@Override
	public Boolean isBreakBorder() {
		return null;
	}

	public Map<Attribute, List<BufferEffect>> getAllBuffEffects() {
		return allBuffEffects;
	}

	public void setAllBuffEffects(Map<Attribute, List<BufferEffect>> allBuffEffects) {
		this.allBuffEffects = allBuffEffects;
	}

	public Map<String, Double> getCurrentAttributeValue() {
		return currentAttributeValue;
	}

	public Map<String, Double> getPrimaryAttributeValue() {
		return primaryAttributeValue;
	}

	public Map<Attribute, BufferEffect> getExpectBufferEffects() {
		return expectBufferEffects;
	}

}
