package org.whz.securityjwt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.whz.securityjwt.model.PmsProduct;
import org.whz.securityjwt.model.PmsProductExample;
import org.whz.securityjwt.model.PmsProductWithBLOBs;

public interface PmsProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    long countByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int deleteByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int insert(PmsProductWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int insertSelective(PmsProductWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    List<PmsProductWithBLOBs> selectByExampleWithBLOBs(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    List<PmsProduct> selectByExample(PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    PmsProductWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByExampleSelective(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByPrimaryKeySelective(PmsProductWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(PmsProductWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product
     *
     * @mbg.generated Thu Oct 22 10:00:04 CST 2020
     */
    int updateByPrimaryKey(PmsProduct record);
}