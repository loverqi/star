package cn.loverqi.star.core.mybaties.example;

import java.util.ArrayList;
import java.util.List;

import cn.loverqi.star.core.utils.NameFormatConversionUtil;

/**
 * 查询配置类，根据该类可以指定查询的参数和配置，实现单表查询的规范化操作
 * @author loverqi
 * @date 2018年1月9日
 */
public class Example {

    /** 排序字段*/
    private String orderByClause;

    /** 去重复*/
    private boolean distinct;

    /** 条件集合*/
    private List<Criterion> criterions;

    /** 条件设置类*/
    private Criteria criteria;

    public Example() {
        criterions = new ArrayList<Criterion>();
        criteria = new Criteria(criterions);
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = NameFormatConversionUtil.humpToLine(orderByClause);
    }

    public void setASCOrderByClause(String orderByClause) {
        this.orderByClause = "`" + NameFormatConversionUtil.humpToLine(orderByClause) + "`" + " ASC";
    }

    public void setDESCOrderByClause(String orderByClause) {
        this.orderByClause = "`" + NameFormatConversionUtil.humpToLine(orderByClause) + "`" + " DESC";
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criterion> getOredCriteria() {
        return criterions;
    }

    /**
     * 去除所有的条件集合
     */
    public Criteria createCriteria() {

        return criteria;
    }

    /**
     * 去除所有的条件集合
     */
    public Criteria clear() {
        orderByClause = null;
        distinct = false;
        criterions.clear();

        return criteria;
    }

    /**
     * 判断查询条件是否为空
     * @return 是否非空
     */
    public boolean isValid() {
        return criterions.size() > 0;
    }

    /**
     * 获取所有的查询条件
     * @return 查询到的条件
     */
    public List<Criterion> getCriterions() {
        return criterions;
    }

    /**
     * 查询条件的实体类
     * @author loverqi
     * @date 2018年1月10日
     */
    public static class Criterion {

        /** 具体的条件*/
        private String condition;

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        /**
         * 通过具体的条件创建对象
         * @param condition 具体的条件
         */
        public Criterion(String condition) {
            this.condition = condition;
        }

        /**
         * 通过具体的条件创建对象
         * @param condition 具体的条件
         * @param value 
         */
        public Criterion(String condition, String value) {
            this.condition = NameFormatConversionUtil.humpToLine(condition) + " " + value;
        }

        /**
         * 通过条件的三个属性创建对象
         * @param fileld 哪个字段
         * @param property 满足的条件
         * @param value 需要的要求
         */
        public Criterion(String fileld, String property, String value) {
            this.condition = NameFormatConversionUtil.humpToLine(fileld) + " " + property + " " + value;
        }

    }

    /**
     * 增加查询条件的工具类
     * @author loverqi
     * @date 2018年1月10日
     */
    public static class Criteria {

        /** 具体的条件列表*/
        private List<Criterion> criterions;

        public Criteria(List<Criterion> criterions) {
            this.criterions = criterions;
        }

        /**
         * 具体的添加属性
         */
        private void addCriterion(String condition) {
            criterions.add(new Criterion(condition));
        }

        /**
         * 具体的添加属性
         */
        private void addCriterion(String condition, String value) {
            criterions.add(new Criterion("`" + condition + "`", value));
        }

        /**
         * 具体的添加属性
         */
        private void addCriterion(String fileld, String property, String value) {
            if (fileld != null && property != null && value != null) {
                criterions.add(new Criterion("`" + fileld + "`", property, value));
            }
        }

        /**
         * 添加自定义条件
         * @param fileld
         */
        public Criteria andFieldCustom(String fileld, String property) {
            addCriterion(fileld, " " + property);

            return this;
        }

        /**
         * 添加自定义条件
         * @param fileld
         */
        public Criteria andFieldCustom(String fileld, String property, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, property, standard);

            return this;
        }

        /**
         * 添加空条件
         * @param fileld
         */
        public Criteria andFieldIsNull(String fileld) {
            addCriterion(fileld, " is null ");

            return this;
        }

        /**
         * 添加非空条件
         */
        public Criteria andFieldIsNotNull(String fileld) {
            addCriterion(fileld, " is not null ");

            return this;
        }

        /**
         * 添加相等条件
         */
        public Criteria andFieldEqualTo(String fileld, Object value) {
            String standard = getStandardString(value);

            addCriterion(fileld, "=", standard);

            return this;
        }

        /**
         * 添加不等条件
         */
        public Criteria andFieldNotEqualTo(String fileld, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, "<>", standard);

            return this;
        }

        /**
         * 添加大于条件
         */
        public Criteria andFieldGreaterThan(String fileld, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, ">", standard);
            return this;
        }

        /**
         * 添加大于等于条件
         */
        public Criteria andFieldGreaterThanOrEqualTo(String fileld, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, ">=", standard);

            return this;
        }

        /**
         * 添加小于条件
         */
        public Criteria andFieldLessThan(String fileld, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, "<" + standard);

            return this;
        }

        /**
         * 添加小于等于条件
         */
        public Criteria andFieldLessThanOrEqualTo(String fileld, Object value) {
            String standard = getStandardString(value);
            addCriterion(fileld, "<=", standard);

            return this;
        }

        /**
         * 添加in条件
         */
        public Criteria andFieldIn(String fileld, List<?> values) {
            String sql = null;
            fileld = "`" + NameFormatConversionUtil.humpToLine(fileld) + "`";

            if (values != null) {
                int size = values.size();
                switch (size) {
                case 0:
                    sql = "1 <> 1";
                    break;
                case 1:
                    sql = fileld + " = " + getStandardString(values.get(0));
                    break;

                default:
                    StringBuffer sb = new StringBuffer();
                    sb.append(fileld + " IN( ");
                    for (int i = 0; i < size; i++) {
                        sb.append(getStandardString(values.get(i)) + ", ");
                    }

                    //删除最后的一个逗号
                    int i = sb.lastIndexOf(",");
                    if (i > -1) {
                        sb.delete(i, i + 1);
                    }

                    sb.append(") ");

                    sql = sb.toString();
                    break;
                }

            } else {
                sql = "1 <> 1";
            }

            addCriterion(sql);

            return this;
        }

        /**
         * 添加not in 条件
         */
        public Criteria andFieldNotIn(String fileld, List<?> values) {
            String sql = null;
            fileld = "`" + NameFormatConversionUtil.humpToLine(fileld) + "`";
            if (values != null) {
                int size = values.size();
                switch (size) {
                case 0:
                    sql = "1 = 1";
                    break;
                case 1:
                    sql = fileld + " <> " + getStandardString(values.get(0));
                    break;

                default:
                    StringBuffer sb = new StringBuffer();
                    sb.append(fileld + " NOT IN( ");
                    for (int i = 0; i < size; i++) {
                        sb.append(getStandardString(values.get(i)) + ", ");
                    }

                    //删除最后的一个逗号
                    int i = sb.lastIndexOf(",");
                    if (i > -1) {
                        sb.delete(i, i + 1);
                    }

                    sb.append(") ");

                    sql = sb.toString();
                    break;
                }

            } else {
                sql = "1 = 1";
            }

            addCriterion(sql);

            return this;
        }

        /**
         * 添加between条件
         */
        public Criteria andFieldBetween(String fileld, Object value1, Object value2) {
            addCriterion(fileld, " BETWEEN " + getStandardString(value1) + " AND" + getStandardString(value2));

            return this;
        }

        /**
         * 添加not between条件
         */
        public Criteria andFieldNotBetween(String fileld, Object value1, Object value2) {
            addCriterion(fileld, " NOT BETWEEN " + getStandardString(value1) + " AND" + getStandardString(value2));

            return this;
        }

        /**
         * 添加like条件
         */
        public Criteria andFieldLike(String fileld, Object value) {
            String valueStr = "'%" + value.toString() + "%'";
            addCriterion(fileld, "LIKE", valueStr);

            return this;
        }

        /**
         * 添加like条件
         */
        public Criteria andFieldLeftLike(String fileld, Object value) {
            String valueStr = "'%" + value.toString() + "'";
            addCriterion(fileld, "LIKE", valueStr);

            return this;
        }

        /**
         * 添加like条件
         */
        public Criteria andFieldRightLike(String fileld, Object value) {
            String valueStr = "'" + value.toString() + "%'";
            addCriterion(fileld, "LIKE", valueStr);

            return this;
        }

        /**
         * 添加not like条件
         */
        public Criteria andFieldNotLike(String fileld, Object value) {
            String valueStr = "'%" + value.toString() + "%'";
            addCriterion(fileld, "NOT LIKE", valueStr);

            return this;
        }

        /**
         * 添加not like条件
         */
        public Criteria andFieldNotLeftLike(String fileld, Object value) {
            String valueStr = "'%" + value.toString() + "'";
            addCriterion(fileld, "NOT LIKE", valueStr);

            return this;
        }

        /**
         * 添加not like条件
         */
        public Criteria andFieldNotRightLike(String fileld, Object value) {
            String valueStr = "'" + value.toString() + "%'";
            addCriterion(fileld, "NOT LIKE", valueStr);

            return this;
        }

        /**
         * 避免字符串中包含空格,且根据类型选择格式
         */
        private String getStandardString(Object standard) {
            String valueStr = null;
            if (standard != null) {
                if (standard.getClass().getName().equals("java.lang.String")) {
                    valueStr = "'" + standard.toString().replaceAll("'", "").trim() + "'";
                } else {
                    valueStr = standard.toString();
                }
            }

            return valueStr;
        }
    }

}
