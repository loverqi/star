package cn.loverqi.star.core.service;

import java.util.List;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.mybaties.example.Example;

/**
 * 逻辑处理类
 * @author LoverQi
 * @date 2018年6月03日
 */
public interface ObjectBeanService {

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    <T extends BasePojo> int insert(T record);

    /**
     * 插入对象，会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    <T extends BasePojo> int insertWithGeneratedKeys(T record);

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    <T extends BasePojo> int insertSelective(T record);

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    <T extends BasePojo> int insertSelectiveWithGeneratedKeys(T record);

    /**
     * 根据主键获取对象的方法
     * @param 对象id
     * @return 查询到的对象，查询不到返回null
     */
    <T extends BasePojo> T selectByPrimaryKey(T record);

    /**
     * 根据主键值获取对象的方法
     * @param tableName 表名
     * @param id 对象id
     * @return 查询到的对象，查询不到返回null
     */
    <T extends BasePojo> T selectByPrimaryKey(String tableName, Integer id);

    /**
     * 根据条件查询对象的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    <T extends BasePojo> List<T> selectByExample(String tableName, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    <T extends BasePojo> int selectCountByExample(Class<T> t, Example example) throws InstantiationException, IllegalAccessException;

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    <T extends BasePojo> int selectCountByExample(String tableName, Example example);

    /**
     * 根据条件查询对象的方法
     * @param record 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    <T extends BasePojo> List<T> selectByExample(Class<T> t, Example example) throws InstantiationException, IllegalAccessException;

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    <T extends BasePojo> int updateByPrimaryKey(T record);

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    <T extends BasePojo> int updateByPrimaryKeySelective(T record);

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    <T extends BasePojo> int updateByExample(T record, Example example);

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    <T extends BasePojo> int updateByExampleSelective(T record, Example example);

    /**
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    <T extends BasePojo> int deleteByPrimaryKey(String tableName, Integer id);

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    <T extends BasePojo> int deleteByPrimaryKey(T record);

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    <T extends BasePojo> int deleteByExample(Class<T> t, Example example) throws InstantiationException, IllegalAccessException;

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    <T extends BasePojo> int deleteByExample(String tableName, Example example);
}