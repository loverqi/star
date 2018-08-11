package ${package_name}.domain;

<#if model_column?exists>
	<#list model_column as model>
    	<#if (model.columnType=="TIMESTAMP" || model.columnType=="DATE" || model.columnType=="DATETIME")>
import java.util.Date;
   			<#break>
		</#if> 
	</#list>
</#if>
<#if is_node>
import java.util.List;
import cn.loverqi.star.core.basepojo.INode;
</#if>
import cn.loverqi.star.core.basepojo.ExcelPojo;

/**
 * ${table_annotation}实体类
 * @author ${author}
 * @date ${date}
 */
public class ${table_name} extends ExcelPojo <#if is_node>implements INode<${table_name}></#if>{

    /** 默认序列号*/
    private static final long serialVersionUID = 1L;

<#if model_column?exists>
	<#list model_column as model>
    /** ${model.columnComment}*/
    	<#if (model.columnType=="VARCHAR" || model.columnType=="TEXT")>
    private String ${model.changeColumnName};
		<#elseif (model.columnType=="INT")>
    private Integer ${model.changeColumnName};
		<#elseif (model.columnType=="BIGINT")>
    private Long ${model.changeColumnName};
		<#elseif (model.columnType=="DOUBLE" || model.columnType=="DECIMAL")>
    private Double ${model.changeColumnName};
		<#elseif (model.columnType=="TINYINT")>
    private Boolean ${model.changeColumnName};
		<#elseif (model.columnType=="TIMESTAMP" || model.columnType=="DATE" || model.columnType=="DATETIME")>
    private Date ${model.changeColumnName};
		</#if> 

	</#list>
</#if>
<#if model_column?exists>
	<#list model_column as model>
    	<#if (model.columnType=="VARCHAR" || model.columnType=="TEXT")>
    public void set${model.changeColumnName?cap_first}(String ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName} == null ? null : ${model.changeColumnName}.trim();
    }
    
    public String get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		<#elseif (model.columnType=="INT")>
    public void set${model.changeColumnName?cap_first}(Integer ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
    
    public Integer get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		<#elseif (model.columnType=="BIGINT")>
    public void set${model.changeColumnName?cap_first}(Long ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
    
    public Long get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		<#elseif (model.columnType=="DOUBLE" || model.columnType=="DECIMAL")>
    public void set${model.changeColumnName?cap_first}(Double ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
    
    public Double get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		<#elseif (model.columnType=="TINYINT")>
    public void set${model.changeColumnName?cap_first}(Boolean ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
    
    public Boolean get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		<#elseif (model.columnType=="TIMESTAMP" || model.columnType=="DATE" || model.columnType=="DATETIME")>
    public void set${model.changeColumnName?cap_first}(Date ${model.changeColumnName}) {
        this.${model.changeColumnName} = ${model.changeColumnName};
    }
    
    public Date get${model.changeColumnName?cap_first}() {
        return ${model.changeColumnName};
    }
		</#if> 

	</#list>
</#if>
<#if is_node>
    /**
     * 获取当前节点的id
     * @return 当前节点的id
     */
    @Override
    public String getOId() {
        // TODO 自动生成的方法存根
        return null;
    }

    /**
     * 获取当前节点的父节点id
     * @return 当前节点的父节点id
     */
    @Override
    public String getPid() {
        // TODO 自动生成的方法存根
        return null;
    }

    /**
     * 设置当前节点的孩子节点
     * @param children 当前节点的孩子节点
     */
    @Override
    public void setChildren(List<Test> children) {
        // TODO 自动生成的方法存根
    }
</#if>
}