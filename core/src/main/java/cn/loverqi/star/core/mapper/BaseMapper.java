package cn.loverqi.star.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.mybaties.example.Example;

/**
 * 数据库通用操作类
 * @param <T>
 * @author loverqi
 * @date 2018年1月9日
 */
@Mapper
public interface BaseMapper<T extends BasePojo> {

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @InsertProvider(type = BaseTemplate.class, method = "insert")
    int insert(T record);

    /**
     * 插入对象，会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "keyProperty")
    @InsertProvider(type = BaseTemplate.class, method = "insert")
    int insertWithGeneratedKeys(T record);

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @InsertProvider(type = BaseTemplate.class, method = "insertSelective")
    int insertSelective(T record);

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "keyProperty")
    @InsertProvider(type = BaseTemplate.class, method = "insertSelective")
    int insertSelectiveWithGeneratedKeys(T record);

    /**
     * 根据主键获取对象的方法
     * @param 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByPrimaryKey")
    T selectByPrimaryKey(T record);

    /**
     * 根据主键值获取对象的方法
     * @param tableName 表名
     * @param id 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByPrimaryKeyValue")
    T selectByPrimaryKeyValue(String tableName, Integer id);

    /**
     * 根据条件查询对象的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByValueExample")
    List<T> selectByValueExample(String tableName, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectCountByExample")
    int selectCountByExample(Class<T> t, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectCountByValueExample")
    int selectCountByValueExample(String tableName, Example example);

    /**
     * 根据条件查询对象的方法
     * @param record 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByExample")
    List<T> selectByExample(Class<T> t, Example example);

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByPrimaryKey")
    int updateByPrimaryKey(T record);

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByExample")
    int updateByExample(Class<T> t, Example example);

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByExampleSelective")
    int updateByExampleSelective(Class<T> t, Example example);

    /**
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @UpdateProvider(type = BaseTemplate.class, method = "deleteByPrimaryKeyValue")
    int deleteByPrimaryKeyValue(String tableName, Integer id);

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @DeleteProvider(type = BaseTemplate.class, method = "deleteByPrimaryKey")
    int deleteByPrimaryKey(T record);

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @DeleteProvider(type = BaseTemplate.class, method = "deleteByExample")
    int deleteByExample(Class<T> t, Example example);

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @DeleteProvider(type = BaseTemplate.class, method = "deleteByValueExample")
    int deleteByValueExample(String tableName, Example example);
}
