package org.whz.securityjwt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.whz.securityjwt.model.UmsAdminRoleRelation;
@Mapper
public interface UmsAdminRoleRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    int insert(UmsAdminRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    int insertSelective(UmsAdminRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    UmsAdminRoleRelation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    int updateByPrimaryKeySelective(UmsAdminRoleRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin_role_relation
     *
     * @mbg.generated Tue Oct 13 09:54:25 CST 2020
     */
    int updateByPrimaryKey(UmsAdminRoleRelation record);
}