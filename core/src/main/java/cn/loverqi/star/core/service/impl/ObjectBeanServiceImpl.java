package cn.loverqi.star.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.mapper.base.BaseMapper;
import cn.loverqi.star.core.mybaties.example.Example;
import cn.loverqi.star.core.service.ObjectBeanService;

/**
 * 逻辑处理类实现类
 * @author LoverQi
 * @date 2018年6月03日
 */
@Service
public class ObjectBeanServiceImpl implements ObjectBeanService {

    @Autowired
    protected BaseMapper<BasePojo> baseMapper;

    /**
     * 插入对象, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public <T extends BasePojo> int insert(T record) {
        int insert = baseMapper.insert(record);

        return insert;
    }

    /**
     * 插入对象，会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public <T extends BasePojo> int insertWithGeneratedKeys(T record) {
        int insertWithGeneratedKeys = baseMapper.insertWithGeneratedKeys(record);

        return insertWithGeneratedKeys;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 不会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public <T extends BasePojo> int insertSelective(T record) {
        int insertSelective = baseMapper.insertSelective(record);

        return insertSelective;
    }

    /**
     *  插入对象，仅插入对象非空的属性, 会将自定义主键赋值
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    @Override
    public <T extends BasePojo> int insertSelectiveWithGeneratedKeys(T record) {
        int insertSelectiveWithGeneratedKeys = baseMapper.insertSelectiveWithGeneratedKeys(record);

        return insertSelectiveWithGeneratedKeys;
    }

    /**
     * 根据主键获取对象的方法
     * @param 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BasePojo> T selectByPrimaryKey(T record) {
        T selectByPrimaryKey = (T) baseMapper.selectByPrimaryKey(record);

        return selectByPrimaryKey;
    }

    /**
     * 根据主键值获取对象的方法
     * @param tableName 表名
     * @param id 对象id
     * @return 查询到的对象，查询不到返回null
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BasePojo> T selectByPrimaryKey(String tableName, Integer id) {
        T selectByPrimaryKey = (T) baseMapper.selectByPrimaryKeyValue(tableName, id);

        return selectByPrimaryKey;
    }

    /**
     * 根据条件查询对象的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BasePojo> List<T> selectByExample(String tableName, Example example) {
        List<T> selectByExample = (List<T>) baseMapper.selectByValueExample(tableName, example);

        return selectByExample;
    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @Override
    public <T extends BasePojo> int selectCountByExample(Class<T> t, Example example)
            throws InstantiationException, IllegalAccessException {
        int selectCountByExample = baseMapper.selectCountByExampleBean(t.newInstance(), example);

        return selectCountByExample;
    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    @Override
    public <T extends BasePojo> int selectCountByExample(String tableName, Example example) {
        int selectCountByValueExample = baseMapper.selectCountByValueExample(tableName, example);

        return selectCountByValueExample;
    }

    /**
     * 根据条件查询对象的方法
     * @param record 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BasePojo> List<T> selectByExample(Class<T> t, Example example)
            throws InstantiationException, IllegalAccessException {
        List<T> selectByExampleBean = (List<T>) baseMapper.selectByExampleBean(t.newInstance(), example);

        return selectByExampleBean;
    }

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    @Override
    public <T extends BasePojo> int updateByPrimaryKey(T record) {
        int updateByPrimaryKey = baseMapper.updateByPrimaryKey(record);

        return updateByPrimaryKey;
    }

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    @Override
    public <T extends BasePojo> int updateByPrimaryKeySelective(T record) {
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
    public <T extends BasePojo> int updateByExample(T record, Example example) {
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
    public <T extends BasePojo> int updateByExampleSelective(T record, Example example) {
        int updateByExampleSelective = baseMapper.updateByExampleSelective(record, example);

        return updateByExampleSelective;
    }

    /**
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @Override
    public <T extends BasePojo> int deleteByPrimaryKey(String tableName, Integer id) {
        int deleteByPrimaryKeyValue = baseMapper.deleteByPrimaryKeyValue(tableName, id);

        return deleteByPrimaryKeyValue;
    }

    /**
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    @Override
    public <T extends BasePojo> int deleteByPrimaryKey(T record) {
        int deleteByPrimaryKey = baseMapper.deleteByPrimaryKey(record);

        return deleteByPrimaryKey;
    }

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @Override
    public <T extends BasePojo> int deleteByExample(Class<T> t, Example example)
            throws InstantiationException, IllegalAccessException {
        int deleteByExample = baseMapper.deleteByExampleBean(t.newInstance(), example);

        return deleteByExample;
    }

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    @Override
    public <T extends BasePojo> int deleteByExample(String tableName, Example example) {
        int deleteByExample = baseMapper.deleteByValueExample(tableName, example);

        return deleteByExample;
    }

}
