package org.whz.securityjwt.model;

public class UmsAdminPermissionRelation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_admin_permission_relation.id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_admin_permission_relation.admin_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    private Long adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_admin_permission_relation.permission_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    private Long permissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_admin_permission_relation.type
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_admin_permission_relation.id
     *
     * @return the value of ums_admin_permission_relation.id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_admin_permission_relation.id
     *
     * @param id the value for ums_admin_permission_relation.id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_admin_permission_relation.admin_id
     *
     * @return the value of ums_admin_permission_relation.admin_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_admin_permission_relation.admin_id
     *
     * @param adminId the value for ums_admin_permission_relation.admin_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_admin_permission_relation.permission_id
     *
     * @return the value of ums_admin_permission_relation.permission_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_admin_permission_relation.permission_id
     *
     * @param permissionId the value for ums_admin_permission_relation.permission_id
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_admin_permission_relation.type
     *
     * @return the value of ums_admin_permission_relation.type
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_admin_permission_relation.type
     *
     * @param type the value for ums_admin_permission_relation.type
     *
     * @mbg.generated Tue Oct 13 10:57:23 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }
}