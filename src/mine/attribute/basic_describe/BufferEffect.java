package mine.attribute.basic_describe;

public class BufferEffect {

	/**
	 * it is recommend to set value larger than 0.0
	 */
	private Double pulsCoefficient;
	/**
	 * it is recommend to set the value between 0.0 and 1.0
	 */
	private Double multiplyCoefficient;

	/**
	 * @return the pulsCoefficient
	 */
	public Double getPulsCoefficient() {
		return pulsCoefficient;
	}

	/**
	 * @param pulsCoefficient
	 *            the pulsCoefficient to set
	 */
	public void setPulsCoefficient(Double pulsCoefficient) {
		this.pulsCoefficient = pulsCoefficient;
	}

	/**
	 * @return the multiplyCoefficient
	 */
	public Double getMultiplyCoefficient() {
		return multiplyCoefficient;
	}

	/**
	 * @param multiplyCoefficient
	 *            the multiplyCoefficient to set
	 */
	public void setMultiplyCoefficient(Double multiplyCoefficient) {
		this.multiplyCoefficient = multiplyCoefficient;
	}

	public BufferEffect(Double multiplyCoefficient, Double pulsCoefficient) {
		super();
		this.pulsCoefficient = pulsCoefficient;
		this.multiplyCoefficient = multiplyCoefficient;
	}

	public BufferEffect() {
		super();
		// TODO Auto-generated constructor stub
	}

}
