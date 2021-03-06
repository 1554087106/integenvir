package org.whz.securityjwt.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
@ToString
@EqualsAndHashCode
public class UmsPermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.id
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.pid
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Long pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.name
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.value
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.icon
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.type
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.uri
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private String uri;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.status
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.create_time
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_permission.sort
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    private Integer sort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.id
     *
     * @return the value of ums_permission.id
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.id
     *
     * @param id the value for ums_permission.id
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.pid
     *
     * @return the value of ums_permission.pid
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.pid
     *
     * @param pid the value for ums_permission.pid
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.name
     *
     * @return the value of ums_permission.name
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.name
     *
     * @param name the value for ums_permission.name
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.value
     *
     * @return the value of ums_permission.value
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.value
     *
     * @param value the value for ums_permission.value
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.icon
     *
     * @return the value of ums_permission.icon
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.icon
     *
     * @param icon the value for ums_permission.icon
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.type
     *
     * @return the value of ums_permission.type
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.type
     *
     * @param type the value for ums_permission.type
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.uri
     *
     * @return the value of ums_permission.uri
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.uri
     *
     * @param uri the value for ums_permission.uri
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.status
     *
     * @return the value of ums_permission.status
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.status
     *
     * @param status the value for ums_permission.status
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.create_time
     *
     * @return the value of ums_permission.create_time
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.create_time
     *
     * @param createTime the value for ums_permission.create_time
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_permission.sort
     *
     * @return the value of ums_permission.sort
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_permission.sort
     *
     * @param sort the value for ums_permission.sort
     *
     * @mbg.generated Mon Oct 12 09:22:41 CST 2020
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}