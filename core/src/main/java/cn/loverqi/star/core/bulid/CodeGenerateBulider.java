package cn.loverqi.star.core.bulid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.loverqi.star.core.bean.ColumnClass;
import cn.loverqi.star.core.utils.ConnectionUtil;
import cn.loverqi.star.core.utils.DateUtil;
import cn.loverqi.star.core.utils.FreeMarkerTemplateUtils;
import cn.loverqi.star.core.utils.NameFormatConversionUtil;
import freemarker.template.Template;

/**
 * 描述：代码生成器
 * Created by Ay on 2017/5/1.
 */
public class CodeGenerateBulider {

    /** 数据库连接字符串*/
    private String jdbcUrl;

    /** 数据库用户名*/
    private String jdbcUserName;

    /** 数据库用户密码*/
    private String jdbcPassWord;

    /** 文件生成作者*/
    private String author;

    /** 日期格式化样式*/
    private String dateFormat;

    /** 项目跟目录*/
    private String parentPath;

    /** 项目跟包名*/
    private String packageName;

    /** 生成实体类路径*/
    private String domainPath;
    /** 生成数据库操作类路径*/
    private String mapperPath;
    /** 生成逻辑处理类路径*/
    private String servicePath;
    /** 生成逻辑处理类实现类路径*/
    private String serviceImplPath;

    /** 是否集成层级菜单样式*/
    private boolean isNode = false;
    /** 是否支持报表excel*/
    private boolean isExcel = false;
    /** 是否生成实体类*/
    private boolean isGenDomain = true;
    /** 是否生成数据库操作类*/
    private boolean isGenMapper = true;
    /** 是否生成逻辑处理类*/
    private boolean isGenService = true;
    /** 是否生成逻辑处理类实现类*/
    private boolean isGenServieImpl = true;

    /** 文件生成作者*/
    public void setAuthor(String author) {
        this.author = author;
    }

    /** 项目跟包名*/
    public void setPackageName(String packageName) {
        this.packageName = packageName;

        String packPath = packageName.replace(".", "/");

        domainPath = parentPath + "/domain/src/main/java/" + packPath + "/domain/";
        mapperPath = parentPath + "/mapper/src/main/java/" + packPath + "/mapper/";
        servicePath = parentPath + "/service/src/main/java/" + packPath + "/service/";
        serviceImplPath = parentPath + "/service/src/main/java/" + packPath + "/service/impl/";
    }

    /** 日期格式化样式*/
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /** 生成实体类路径*/
    public void setDomainPath(String domainPath) {
        this.domainPath = domainPath;
    }

    /** 生成数据库操作类路径*/
    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    /** 生成逻辑处理类路径*/
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    /** 生成逻辑处理类实现类路径*/
    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    /** 项目跟目录*/
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
        this.setPackageName(packageName);
    }

    /** 是否集成层级菜单样式*/
    public void setNode(boolean isNode) {
        this.isNode = isNode;
    }

    /** 是否支持报表excel*/
    public void setExcel(boolean isExcel) {
        this.isExcel = isExcel;
    }

    /** 是否生成实体类*/
    public void setGenDomain(boolean isGenDomain) {
        this.isGenDomain = isGenDomain;
    }

    /** 是否生成数据库操作类*/
    public void setGenMapper(boolean isGenMapper) {
        this.isGenMapper = isGenMapper;
    }

    /** 是否生成逻辑处理类*/
    public void setGenService(boolean isGenService) {
        this.isGenService = isGenService;
    }

    /** 是否生成逻辑处理类实现类*/
    public void setGenServieImpl(boolean isGenServieImpl) {
        this.isGenServieImpl = isGenServieImpl;
    }

    public CodeGenerateBulider(String jdbcUrl, String jdbcUserName, String jdbcPassWord) {
        this(jdbcUrl, jdbcUserName, jdbcPassWord, "cn.loverqi.star");
    }

    public CodeGenerateBulider(String jdbcUrl, String jdbcUserName, String jdbcPassWord, String packageName,
            String... tableNames) {
        this(jdbcUrl, jdbcUserName, jdbcPassWord, new File(System.getProperty("user.dir")).getParent(), packageName);
    }

    public CodeGenerateBulider(String jdbcUrl, String jdbcUserName, String jdbcPassWord, String parentPath,
            String packageName) {
        this("Star-loverqi", "yyyy年M月dd日", jdbcUrl, jdbcUserName, jdbcPassWord, parentPath, packageName);
    }

    public CodeGenerateBulider(String author, String dateFormat, String jdbcUrl, String jdbcUserName,
            String jdbcPassWord, String parentPath, String packageName) {
        this.author = author;
        this.dateFormat = dateFormat;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassWord = jdbcPassWord;
        this.packageName = packageName;

        this.setParentPath(parentPath);

    }

    /**
     * 实际生成文件的方法
     * @param tableName 需要生成的数据表，不传时生成所有
     */
    public void generate(String... tableNames) {
        if (tableNames == null || tableNames.length < 1) {
            List<String> names = new ArrayList<String>();
            try {
                Connection connection = ConnectionUtil.getConnection(jdbcUrl, jdbcUserName, jdbcPassWord);
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                ResultSet resultSetTable = databaseMetaData.getTables(null, "%", "%", new String[] { "TABLE" });
                while (resultSetTable.next()) {
                    names.add(resultSetTable.getString("TABLE_NAME"));
                }
                resultSetTable.close();

                connection.close();
                tableNames = names.toArray(tableNames);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
            }
        }
        for (String tableName : tableNames) {
            generate(tableName);
        }
    }

    /**
     * 实际生成文件的方法
     * @param tableName 需要生成的数据表
     */
    public void generate(String tableName) {
        try {
            Connection connection = ConnectionUtil.getConnection(jdbcUrl, jdbcUserName, jdbcPassWord);
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSetTable = databaseMetaData.getTables(null, "%", tableName, new String[] { "TABLE" });
            String tableAnnotation = null;
            if (resultSetTable.next()) {
                tableAnnotation = resultSetTable.getString("REMARKS");
            } else {
                tableAnnotation = "";
            }
            resultSetTable.close();

            String changeTableName = NameFormatConversionUtil.lineToHumpAndUpperCase(tableName);

            ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");

            if (isGenDomain) { //判断是否生成实体类
                if (isExcel) { //是否支持excel操作
                    generatExcelPojoFile(changeTableName, tableAnnotation, resultSet);
                } else {
                    generatBasePojoFile(changeTableName, tableAnnotation, resultSet);
                }
            }
            if (isGenMapper) { //判断是否生生成数据库操作类
                generateMapperFile(changeTableName, tableAnnotation, resultSet);
            }
            if (isGenService) { //判断是否生成逻辑处理类
                generateServiceFile(changeTableName, tableAnnotation, resultSet);
            }
            if (isGenServieImpl) {// 判断是否生成逻辑处理类实现类
                generateServiceImplFile(changeTableName, tableAnnotation, resultSet);
            }
            resultSet.close();

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    /**
     * 生成数据库支持的实体类
     */
    public void generatBasePojoFile(String changeTableName, String tableAnnotation, ResultSet resultSet)
            throws Exception {

        final String suffix = ".java";
        final String path = domainPath + changeTableName + suffix;
        final String templateName = "BasePojo.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while (resultSet.next()) {
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 sysName
            columnClass.setChangeColumnName(NameFormatConversionUtil.lineToHump(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);

        generateFileByTemplate(changeTableName, tableAnnotation, templateName, mapperFile, dataMap);
    }

    /**
     * 生成Excel表格支持的实体类
     */
    public void generatExcelPojoFile(String changeTableName, String tableAnnotation, ResultSet resultSet)
            throws Exception {
        final String suffix = ".java";
        final String path = domainPath + changeTableName + suffix;
        final String templateName = "ExcelPojo.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while (resultSet.next()) {
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 sysName
            columnClass.setChangeColumnName(NameFormatConversionUtil.lineToHump(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);

        generateFileByTemplate(changeTableName, tableAnnotation, templateName, mapperFile, dataMap);
    }

    /**
     * 生成数据库操作类
     */
    public void generateMapperFile(String changeTableName, String tableAnnotation, ResultSet resultSet)
            throws Exception {
        final String suffix = "Mapper.java";
        final String path = mapperPath + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();

        generateFileByTemplate(changeTableName, tableAnnotation, templateName, mapperFile, dataMap);
    }

    public void generateServiceFile(String changeTableName, String tableAnnotation, ResultSet resultSet)
            throws Exception {
        final String suffix = "Service.java";
        final String path = servicePath + changeTableName + suffix;
        final String templateName = "Service.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();

        generateFileByTemplate(changeTableName, tableAnnotation, templateName, mapperFile, dataMap);
    }

    public void generateServiceImplFile(String changeTableName, String tableAnnotation, ResultSet resultSet)
            throws Exception {
        final String suffix = "ServiceImpl.java";
        final String path = serviceImplPath + changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();

        generateFileByTemplate(changeTableName, tableAnnotation, templateName, mapperFile, dataMap);
    }

    private void generateFileByTemplate(String changeTableName, String tableAnnotation, String templateName, File file,
            Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name", changeTableName);
        dataMap.put("author", author);
        dataMap.put("date", DateUtil.format(new Date(), dateFormat));
        dataMap.put("package_name", packageName);
        dataMap.put("table_annotation", tableAnnotation);
        dataMap.put("is_node", isNode);

        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);

        FreeMarkerTemplateUtils.clearCache();
        System.err.println("生成文件: [" + file + "]");
    }

}