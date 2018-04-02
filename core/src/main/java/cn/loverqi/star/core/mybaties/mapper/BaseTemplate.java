package cn.loverqi.star.core.mybaties.mapper;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.core.mybaties.pojo.Example.Criterion;
import cn.loverqi.star.core.mybaties.pojo.MyBatisPojo;
import cn.loverqi.star.core.mybaties.utils.NameFormatConversionUtil;
import cn.loverqi.star.core.utils.StringUtil;

/**
 * 通用查询类
 * @param <T>
 * @author loverqi
 * @date 2018年1月9日
 */
public class BaseTemplate<T extends MyBatisPojo> {

    /**
     * 插入对象
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    public String insert(final T record) {

        String sql = new SQL() {
            {
                INSERT_INTO("`" + record.getTablename() + "`");
                List<String> fieldsList = record.getTableFieldsList();
                for (String filed : fieldsList) {
                    VALUES("`" + NameFormatConversionUtil.humpToLine(filed) + "`", "#{" + filed + "}");
                }
            }
        }.toString();

        return sql;
    }

    /**
     *  插入对象，仅插入对象非空的属性
     * @param record 需要插入的对象
     * @return 插入成功的条数
     */
    public String insertSelective(final T record) {
        String sql = new SQL() {
            {
                INSERT_INTO("`" + record.getTablename() + "`");
                List<String> fieldsList = record.getTableFieldsList();
                for (String filed : fieldsList) {

                    if (record.getTableFieldValue(filed) != null) {
                        VALUES("`" + NameFormatConversionUtil.humpToLine(filed) + "`", "#{" + filed + "}");
                    }

                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据主键获取对象的方法
     * @param 对象id
     * @return 查询到的对象，查询不到返回null
     */
    public String selectByPrimaryKey(final T record) {
        String sql = new SQL() {
            {
                SELECT(record.getEscapeTableFields());
                FROM("`" + record.getTablename() + "`");
                if (record.getTablePrimaryKeyValue() != null) {
                    String tablePrimaryKey = record.getTablePrimaryKey();
                    WHERE("`" + tablePrimaryKey + "`" + "=#{" + NameFormatConversionUtil.lineToHump(tablePrimaryKey)
                            + "}");
                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据主键值获取对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 查询到的对象，查询不到返回null
     */
    public String selectByPrimaryKeyValue(final String tableName, final Integer id) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("`" + tableName + "`");
                if (id != null) {
                    WHERE("`id`=#{id}");
                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件查询对象的方法
     * @param record 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    public String selectByExample(final T record, final Example example) {
        String sql = new SQL() {
            {
                if (example != null && example.isDistinct()) {
                    SELECT_DISTINCT(record.getEscapeTableFields());
                } else {
                    SELECT(record.getEscapeTableFields());
                }
                FROM("`" + record.getTablename() + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
                if (example != null) {
                    String orderByClause = example.getOrderByClause();
                    if (StringUtil.isNotNull(orderByClause)) {
                        ORDER_BY(example.getOrderByClause());
                    }
                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    public String selectCountByExample(final T record, final Example example) {
        String sql = new SQL() {
            {
                if (example != null && example.isDistinct()) {
                    SELECT_DISTINCT("COUNT(DISTINCT 1)");
                } else {
                    SELECT("COUNT(1)");
                }
                FROM("`" + record.getTablename() + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }

                if (example != null) {
                    String orderByClause = example.getOrderByClause();
                    if (StringUtil.isNotNull(orderByClause)) {
                        ORDER_BY(example.getOrderByClause());
                    }
                }
            }
        }.toString();

        return sql;

    }

    /**
     * 根据条件查询页面数据个数的方法
     * @param tableName 查询的表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    public String selectCountByValueExample(final String tableName, final Example example) {
        String sql = new SQL() {
            {
                if (example != null && example.isDistinct()) {
                    SELECT_DISTINCT("COUNT(DISTINCT 1)");
                } else {
                    SELECT("COUNT(1)");
                }
                FROM("`" + tableName + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
                if (example != null) {
                    String orderByClause = example.getOrderByClause();
                    if (StringUtil.isNotNull(orderByClause)) {
                        ORDER_BY(example.getOrderByClause());
                    }
                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件查询对象的方法
     * @param tableName 查询到表名
     * @param example 指定的条件
     * @return 所有符合条件的对象
     */
    public String selectByValueExample(final String tableName, final Example example) {
        String sql = new SQL() {
            {
                if (example != null && example.isDistinct()) {
                    SELECT_DISTINCT("*");
                } else {
                    SELECT("*");
                }
                FROM("`" + tableName + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
                if (example != null) {
                    String orderByClause = example.getOrderByClause();
                    if (StringUtil.isNotNull(orderByClause)) {
                        ORDER_BY(example.getOrderByClause());
                    }
                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据主键id更新对象的方法
     * @param record 修改后的对象
     * @return 修改的对象数量
     */
    public String updateByPrimaryKey(final T record) {
        String sql = new SQL() {
            {
                UPDATE("`" + record.getTablename() + "`");

                List<String> fieldsList = record.getTableOrdinaryFieldsList();
                for (String field : fieldsList) {
                    SET("`" + NameFormatConversionUtil.humpToLine(field) + "`" + "=#{" + field + "}");
                }
                String tablePrimaryKey = record.getTablePrimaryKey();
                WHERE("`" + tablePrimaryKey + "`" + "=#{" + NameFormatConversionUtil.lineToHump(tablePrimaryKey) + "}");
            }
        }.toString();

        return sql;
    }

    /**
     * 根据主键id更新对象的方法,仅修改对象中的非空属性
     * @param record
     * @return 修改的对象数量
     */
    public String updateByPrimaryKeySelective(final T record) {
        String sql = new SQL() {
            {
                UPDATE("`" + record.getTablename() + "`");

                List<String> fieldsList = record.getTableOrdinaryFieldsList();
                for (String filed : fieldsList) {
                    if (record.getTableFieldValue(filed) != null) {
                        SET("`" + NameFormatConversionUtil.humpToLine(filed) + "`" + "=#{" + filed + "}");
                    }
                }
                String tablePrimaryKey = record.getTablePrimaryKey();
                WHERE("`" + tablePrimaryKey + "`" + "=#{" + NameFormatConversionUtil.lineToHump(tablePrimaryKey) + "}");
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件更新对象的方法
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    public String updateByExample(final T record, final Example example) {
        String sql = new SQL() {
            {
                UPDATE("`" + record.getTablename() + "`");

                List<String> fieldsList = record.getTableOrdinaryFieldsList();
                for (String filed : fieldsList) {
                    if (record.getTableFieldValue(filed) != null) {
                        SET("`" + NameFormatConversionUtil.humpToLine(filed) + "`" + "=#{record." + filed + "}");
                    }
                }
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件更新对象的方法，仅更新对象非空的属性
     * @param record 修改后的对象
     * @param example 更新的条件
     * @return 修改的对象数量
     */
    public String updateByExampleSelective(final T record, final Example example) {
        String sql = new SQL() {
            {
                UPDATE("`" + record.getTablename() + "`");

                List<String> fieldsList = record.getTableOrdinaryFieldsList();
                for (String filed : fieldsList) {
                    if (record.getTableFieldValue(filed) != null) {
                        SET("`" + NameFormatConversionUtil.humpToLine(filed) + "`" + "=#{record." + filed + "}");
                    }
                }
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
            }
        }.toString();

        return sql;
    }

    /** 
     * 根据主键值和表名删除对象的方法
     * @param tableName 表名
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    public String deleteByPrimaryKeyValue(final String tableName, final Integer id) {
        String sql = new SQL() {
            {
                DELETE_FROM("`" + tableName + "`");
                WHERE("`id`=#{id}");
            }
        }.toString();

        return sql;
    }

    /** 
     * 根据主键删除对象的方法
     * @param id 对象的主键id
     * @return 删除的对象的个数
     */
    public String deleteByPrimaryKey(final T record) {
        String sql = new SQL() {
            {
                DELETE_FROM("`" + record.getTablename() + "`");
                String tablePrimaryKey = record.getTablePrimaryKey();
                WHERE("`" + tablePrimaryKey + "`" + "=#{" + NameFormatConversionUtil.lineToHump(tablePrimaryKey) + "}");
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    public String deleteByExample(final T t, final Example example) {
        String sql = new SQL() {
            {
                DELETE_FROM("`" + t.getTablename() + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
            }
        }.toString();

        return sql;
    }

    /**
     * 根据条件删除对象的方法
     * @param tableName 查询的表名
     * @param example 删除的条件
     * @return 删除的对象的个数
     */
    public String deleteByValueExample(final String tableName, final Example example) {
        String sql = new SQL() {
            {
                DELETE_FROM("`" + tableName + "`");
                if (example != null && example.isValid()) {
                    List<Criterion> criterions = example.getCriterions();
                    for (Criterion criterion : criterions) {
                        WHERE(criterion.getCondition());
                    }

                }
            }
        }.toString();

        return sql;
    }

}
