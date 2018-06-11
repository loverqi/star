package cn.loverqi.star.core.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mapper.base.BaseMapMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.base.BaseMapService;

/**
 * BasePojo逻辑处理类实现类
 * @author LoverQi
 * @date 2018年6月04日
 */
@Service
public class BaseMapServiceImpl implements BaseMapService {

    @Autowired
    protected BaseMapMapper baseMapper;

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insert(BasePojo record) {
        int insert = baseMapper.insert(record);

        return insert;
    }

    /**
     * 插入对象, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertWithGeneratedKeys(BasePojo record) {
        int insertWithGeneratedKeys = baseMapper.insertWithGeneratedKeys(record);

        return insertWithGeneratedKeys;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertSelective(BasePojo record) {
        int insertSelective = baseMapper.insertSelective(record);

        return insertSelective;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public int insertSelectiveWithGeneratedKeys(BasePojo record) {
        int insertSelectiveWithGeneratedKeys = baseMapper.insertSelectiveWithGeneratedKeys(record);

        return insertSelectiveWithGeneratedKeys;
    }

    /**
     * 根据主键获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    public Map<String, Object> selectByPrimaryKey(BasePojo record) {
        Map<String, Object> selectByPrimaryKey = baseMapper.selectByPrimaryKey(record);

        return selectByPrimaryKey;
    }

    /**
     * 根据主键值获取对象的方法
     * @param 对象
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    public Map<String, Object> selectByPrimaryKey(String tableName, Integer id) {
        Map<String, Object> selectByPrimaryKey = baseMapper.selectByPrimaryKeyValue(tableName, id);

        return selectByPrimaryKey;
    }

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public List<Map<String, Object>> selectByExample(String tableName, Example example) {
        List<Map<String, Object>> selectByExample = baseMapper.selectByValueExample(tableName, example);

        return selectByExample;
    }

    /**
     * 根据条件查询对象的方法
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public List<Map<String, Object>> selectByExample(BasePojo record, Example example) {
        List<Map<String, Object>> selectByExample = baseMapper.selectByExample(record, example);

        return selectByExample;
    }

    /**
     * 根据Sql查询对象的方法
     * @param Sql Sql
     * @return 所有符合条件的对象
     */
    @Override
    public List<Map<String, Object>> selectBySql(String sql) {
        List<Map<String, Object>> selectByExample = baseMapper.selectBySql(sql);

        return selectByExample;
    }

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public ResponsePageData<Map<String, Object>> selectByExampleWithRowbounds(BasePojo record, Example example,
            int page, int pageSize) {

        //添加分页属性
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> selectByExampleWithRowbounds = baseMapper.selectByExample(record, example);

        //用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(selectByExampleWithRowbounds);

        return new ResponsePageData<Map<String, Object>>(pageInfo);
    }

    /**
     * 根据条件查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public ResponsePageData<Map<String, Object>> selectByExampleWithRowbounds(String tableName, Example example,
            int page, int pageSize) {
        //添加分页属性
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> selectByExampleWithRowbounds = baseMapper.selectByValueExample(tableName, example);

        //用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(selectByExampleWithRowbounds);

        return new ResponsePageData<Map<String, Object>>(pageInfo);
    }

    /**
     * 根据Sql查询对象的方法, 支持分页
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public ResponsePageData<Map<String, Object>> selectBySqlWithRowbounds(String sql, int page, int pageSize) {
        //添加分页属性
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> selectByExampleWithRowbounds = baseMapper.selectBySql(sql);

        //用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(selectByExampleWithRowbounds);

        return new ResponsePageData<Map<String, Object>>(pageInfo);
    }

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    @Override
    public int updateByPrimaryKey(BasePojo record) {
        int updateByPrimaryKey = baseMapper.updateByPrimaryKey(record);

        return updateByPrimaryKey;
    }

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    @Override
    public int updateByPrimaryKeySelective(BasePojo record) {
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
    public int updateByExample(BasePojo record, Example example) {
        int updateByExample = baseMapper.updateByExample(record, example);

        return updateByExample;
    }

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    @Override
    public int updateByExampleSelective(BasePojo record, Example example) {
        int updateByExampleSelective = baseMapper.updateByExampleSelective(record, example);

        return updateByExampleSelective;
    }

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @Override
    public int deleteByPrimaryKey(BasePojo record) {
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
    public int deleteByExample(BasePojo record, Example example) {
        int deleteByExample = baseMapper.deleteByExample(record, example);

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
    public int selectCountByExample(BasePojo record, Example example) {
        int deleteByExample = baseMapper.selectCountByExample(record, example);

        return deleteByExample;
    }

    /**
     * 根据Sql查询页面数据个数的方法
     * @param Sql Sql
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public int selectCountBySql(String sql) {
        int deleteByExample = baseMapper.selectCountBySql(sql);

        return deleteByExample;
    }
}
