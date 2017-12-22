package mine.attribute.basic_describe;


import mine.attribute.IAttribute;

public class Attribute implements IAttribute {

	/**
	 * this three attribute(natural,growth,primary) is the essential element of
	 * attribute
	 */
	private Double natural;
	private Double growth;
	private Double primary;

	/**
	 * this two attribute(inital,border) is describable in other attribute
	 */
	private Double inital;
	private Double border;

	/**
	 * this two attribute describe the border and so on
	 */
	private Double quality;
	private Double quantity;

	/**
	 * primaryValue,currentValue,count is to calculate.
	 * currentValue can calculate from the primaryValue and buffers
	 */
	private Double primaryValue;
	private Integer count;


	private String attributeName;

	/**
	 * 
	 * @return the border
	 */
	public Double getBorder() {
		this.border = this.getQuality() * this.getQuantity();
		return border;
	}

	/**
	 * @return the primaryValue
	 */
	public Double getPrimaryValue() {
		this.primaryValue = this.getNatural() * Math.log(this.getGrowth() * this.getCount() + this.getPrimary());
		return primaryValue;
	}

	/**
	 * @return the inital
	 */
	public Double getInital() {
		this.inital = this.getNatural() * Math.log(this.getPrimary());
		return inital;
	}

	/**
	 * @param quality
	 *            the quality to set
	 */
	public void setQuality(Double quality) {
		this.quality = quality;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quality
	 */
	public Double getQuality() {
		return quality;
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @return the natural
	 */
	public Double getNatural() {
		return natural;
	}

	/**
	 * @param natural
	 *            the natural to set
	 */
	public void setNatural(Double natural) {
		this.natural = natural;
	}

	/**
	 * @return the growth
	 */
	public Double getGrowth() {
		return growth;
	}

	/**
	 * @param growth
	 *            the growth to set
	 */
	public void setGrowth(Double growth) {
		this.growth = growth;
	}

	/**
	 * @return the primary
	 */
	public Double getPrimary() {
		return primary;
	}

	/**
	 * @param primary
	 *            the primary to set
	 */
	public void setPrimary(Double primary) {
		this.primary = primary;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

}
