package org.whz.securityjwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.whz.securityjwt.model.UmsRole;
import org.whz.securityjwt.model.UmsRoleExample;
@Mapper
public interface UmsRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    long countByExample(UmsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int deleteByExample(UmsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int insert(UmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int insertSelective(UmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    List<UmsRole> selectByExample(UmsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    UmsRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int updateByExampleSelective(@Param("record") UmsRole record, @Param("example") UmsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int updateByExample(@Param("record") UmsRole record, @Param("example") UmsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int updateByPrimaryKeySelective(UmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_role
     *
     * @mbg.generated Tue Oct 13 10:58:15 CST 2020
     */
    int updateByPrimaryKey(UmsRole record);
}