package cn.loverqi.star.core.mapper.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.mybaties.example.Example;

/**
 * 数据库通用操作类,生成map对象
 * @param <BasePojo>
 * @author loverqi
 * @date 2018年1月9日
 */
@Mapper
public interface BaseMapMapper {

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @InsertProvider(type = BaseTemplate.class, method = "insert")
    int insert(BasePojo record);

    /**
     * 插入对象，会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "keyProperty")
    @InsertProvider(type = BaseTemplate.class, method = "insert")
    int insertWithGeneratedKeys(BasePojo record);

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @InsertProvider(type = BaseTemplate.class, method = "insertSelective")
    int insertSelective(BasePojo record);

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Options(useGeneratedKeys = true, keyProperty = "keyProperty")
    @InsertProvider(type = BaseTemplate.class, method = "insertSelective")
    int insertSelectiveWithGeneratedKeys(BasePojo record);

    /**
     * 根据主键获取对象的方法
     * @param 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByPrimaryKey")
    Map<String, Object> selectByPrimaryKey(BasePojo record);

    /**
     * 根据主键值获取对象的方法
     * @param tableName 表名
     * @param id 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByPrimaryKeyValue")
    Map<String, Object> selectByPrimaryKeyValue(String tableName, Integer id);

    /**
     * 根据条件查询对象的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectByValueExample")
    List<Map<String, Object>> selectByValueExample(String tableName, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectCountByExampleBean")
    int selectCountByExample(BasePojo record, Example example);

    /**
     * 根据sql查询对象的方法
     * @param sql sql件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectBySql")
    List<Map<String, Object>> selectBySql(String sql);

    /**
     * 根据条件查询页面数据个数的方法
     * @param sql sql件
     * @return 所有符合条件的对象
     */
    @SelectProvider(type = BaseTemplate.class, method = "selectCountBySql")
    int selectCountBySql(String sql);

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
    @SelectProvider(type = BaseTemplate.class, method = "selectByExampleBean")
    List<Map<String, Object>> selectByExample(BasePojo record, Example example);

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByPrimaryKey")
    int updateByPrimaryKey(BasePojo record);

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BasePojo record);

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByExample")
    int updateByExample(BasePojo record, Example example);

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @UpdateProvider(type = BaseTemplate.class, method = "updateByExampleSelective")
    int updateByExampleSelective(BasePojo record, Example example);

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
    int deleteByPrimaryKey(BasePojo record);

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @DeleteProvider(type = BaseTemplate.class, method = "deleteByExampleBean")
    int deleteByExample(BasePojo record, Example example);

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @DeleteProvider(type = BaseTemplate.class, method = "deleteByValueExample")
    int deleteByValueExample(String tableName, Example example);
}
