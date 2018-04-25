package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mapper.BaseMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.BaseService;

/**
 * 通用操作的
 * @param <T>
 * @author loverqi
 * @date 2018年1月19日
 */
public abstract class BaseServiceImpl<T extends BasePojo> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insert(T record) {
        int insert = baseMapper.insert(record);

        return insert;
    }

    /**
     * 插入对象, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertWithGeneratedKeys(T record) {
        int insertWithGeneratedKeys = baseMapper.insertWithGeneratedKeys(record);

        return insertWithGeneratedKeys;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertSelective(T record) {
        int insertSelective = baseMapper.insertSelective(record);

        return insertSelective;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertSelectiveWithGeneratedKeys(T record) {
        int insertSelectiveWithGeneratedKeys = baseMapper.insertSelectiveWithGeneratedKeys(record);

        return insertSelectiveWithGeneratedKeys;
    }

    /**
     * 根据主键获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    public T selectByPrimaryKey(T record) {
        T selectByPrimaryKey = baseMapper.selectByPrimaryKey(record);

        return selectByPrimaryKey;
    }

    /**
     * 根据主键值获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    public T selectByPrimaryKey(String tableName, Integer id) {
        T selectByPrimaryKey = baseMapper.selectByPrimaryKeyValue(tableName, id);

        return selectByPrimaryKey;
    }

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public List<T> selectByExample(String tableName, Example example) {
        List<T> selectByExample = baseMapper.selectByValueExample(tableName, example);

        return selectByExample;
    }

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public List<T> selectByExample(Class<T> t, Example example) {
        List<T> selectByExample = baseMapper.selectByExample(t, example);

        return selectByExample;
    }

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public ResponsePageData<T> selectByExampleWithRowbounds(Class<T> t, Example example, int page, int pageSize) {

        //添加分页属性
        PageHelper.startPage(page, pageSize);
        List<T> selectByExampleWithRowbounds = baseMapper.selectByExample(t, example);

        //用PageInfo对结果进行包装
        PageInfo<T> pageInfo = new PageInfo<T>(selectByExampleWithRowbounds);

        return new ResponsePageData<T>(pageInfo);
    }

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public ResponsePageData<T> selectByExampleWithRowbounds(String tableName, Example example, int page, int pageSize) {
        //添加分页属性
        PageHelper.startPage(1, 10);
        List<T> selectByExampleWithRowbounds = baseMapper.selectByValueExample(tableName, example);

        //用PageInfo对结果进行包装
        PageInfo<T> pageInfo = new PageInfo<T>(selectByExampleWithRowbounds);

        return new ResponsePageData<T>(pageInfo);
    }

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    @Override
    public int updateByPrimaryKey(T record) {
        int updateByPrimaryKey = baseMapper.updateByPrimaryKey(record);

        return updateByPrimaryKey;
    }

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    @Override
    public int updateByPrimaryKeySelective(T record) {
        int updateByPrimaryKeySelective = baseMapper.updateByPrimaryKeySelective(record);

        return updateByPrimaryKeySelective;
    }

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @Override
    public int updateByExample(Class<T> t, Example example) {
        int updateByExample = baseMapper.updateByExample(t, example);

        return updateByExample;
    }

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @Override
    public int updateByExampleSelective(Class<T> t, Example example) {
        int updateByExampleSelective = baseMapper.updateByExampleSelective(t, example);

        return updateByExampleSelective;
    }

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @Override
    public int deleteByPrimaryKey(T record) {
        int deleteByPrimaryKey = baseMapper.deleteByPrimaryKey(record);

        return deleteByPrimaryKey;
    }

    /**
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @Override
    public int deleteByPrimaryKey(String tableName, Integer id) {
        int deleteByPrimaryKey = baseMapper.deleteByPrimaryKeyValue(tableName, id);

        return deleteByPrimaryKey;
    }

    /**
     * 根据条件删除对象的方法
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @Override
    public int deleteByExample(Class<T> t, Example example) {
        int deleteByExample = baseMapper.deleteByExample(t, example);

        return deleteByExample;
    }

    /**
     * 根据条件删除对象的方法
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @Override
    public int deleteByExample(String tableName, Example example) {
        int deleteByExample = baseMapper.deleteByValueExample(tableName, example);

        return deleteByExample;
    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public int selectCountByExample(String tableName, Example example) {
        int deleteByExample = baseMapper.selectCountByValueExample(tableName, example);

        return deleteByExample;
    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public int selectCountByExample(Class<T> t, Example example) {
        int deleteByExample = baseMapper.selectCountByExample(t, example);

        return deleteByExample;
    }

}
