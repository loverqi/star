package cn.loverqi.star.core.service.base;

import java.util.List;
import java.util.Map;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mybaties.example.Example;

/**
 * BasePojoMap逻辑处理类
 * @author LoverQi
 * @date 2018年6月04日
 */
public interface BaseMapService {

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    int insert(BasePojo record);

    /**
     * 插入对象，会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    int insertWithGeneratedKeys(BasePojo record);

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    int insertSelective(BasePojo record);

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    int insertSelectiveWithGeneratedKeys(BasePojo record);

    /**
     * 根据主键获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    Map<String, String> selectByPrimaryKey(BasePojo record);

    /**
     * 根据主键值获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    Map<String, String> selectByPrimaryKey(String tableName, Integer id);

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    List<Map<String, String>> selectByExample(String tableName, Example example);

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    List<Map<String, String>> selectByExample(BasePojo record, Example example);

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    ResponsePageData<Map<String, String>> selectByExampleWithRowbounds(BasePojo record, Example example, int page,
            int pageSize);

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    ResponsePageData<Map<String, String>> selectByExampleWithRowbounds(String tableName, Example example, int page,
            int pageSize);

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    int updateByPrimaryKey(BasePojo record);

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    int updateByPrimaryKeySelective(BasePojo record);

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    int updateByExample(BasePojo record, Example example);

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    int updateByExampleSelective(BasePojo record, Example example);

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    int deleteByPrimaryKey(BasePojo record);

    /**
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    int deleteByPrimaryKey(String tableName, Integer id);

    /**
     * 根据条件删除对象的方法
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    int deleteByExample(BasePojo record, Example example);

    /**
     * 根据条件删除对象的方法
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    int deleteByExample(String tableName, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    int selectCountByExample(String tableName, Example example);

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    int selectCountByExample(BasePojo record, Example example);

}