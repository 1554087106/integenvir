package org.whz.securityjwt.model;

public class PmsProductAttributeValue {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_attribute_value.id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_attribute_value.product_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_attribute_value.product_attribute_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    private Long productAttributeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_attribute_value.value
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_attribute_value.id
     *
     * @return the value of pms_product_attribute_value.id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_attribute_value.id
     *
     * @param id the value for pms_product_attribute_value.id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_attribute_value.product_id
     *
     * @return the value of pms_product_attribute_value.product_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_attribute_value.product_id
     *
     * @param productId the value for pms_product_attribute_value.product_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_attribute_value.product_attribute_id
     *
     * @return the value of pms_product_attribute_value.product_attribute_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public Long getProductAttributeId() {
        return productAttributeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_attribute_value.product_attribute_id
     *
     * @param productAttributeId the value for pms_product_attribute_value.product_attribute_id
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_attribute_value.value
     *
     * @return the value of pms_product_attribute_value.value
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_attribute_value.value
     *
     * @param value the value for pms_product_attribute_value.value
     *
     * @mbg.generated Thu Oct 22 15:54:32 CST 2020
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}