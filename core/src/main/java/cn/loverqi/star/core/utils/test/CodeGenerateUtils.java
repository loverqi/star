package cn.loverqi.star.core.utils.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.loverqi.star.core.bean.ColumnClass;
import cn.loverqi.star.core.utils.DateUtil;
import cn.loverqi.star.core.utils.NameFormatConversionUtil;
import freemarker.template.Template;

/**
 * 描述：代码生成器
 * Created by Ay on 2017/5/1.
 */
public class CodeGenerateUtils {

    @Test
    public void runTest() throws Exception {
        CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
        codeGenerateUtils.generate();
    }

    private final String AUTHOR = "loverqi";
    private final String tableName = "test";
    private final String packageName = "cn.loverqi.star.domain";
    private final String tableAnnotation = "质量问题";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/star?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String diskPath = "D://";
    private final String changeTableName = NameFormatConversionUtil.lineToHumpAndUpperCase(tableName);
    private final boolean isNode = false;

    public Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public void generate() throws Exception {
        try {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
            //            //生成Mapper文件
            //            generateMapperFile(resultSet);
            //            //生成Dao文件
            //            generateDaoFile(resultSet);
            //            //生成Repository文件
            //            generateRepositoryFile(resultSet);
            //            //生成服务层接口文件
            //            generateServiceInterfaceFile(resultSet);
            //            //生成服务实现层文件
            //            generateServiceImplFile(resultSet);
            //            //生成Controller层文件
            //            generateControllerFile(resultSet);
            //            //生成DTO文件
            //            generateDTOFile(resultSet);
            //生成Model文件
            //            generatBasePojoFile(resultSet);
            generateServiceFile(resultSet);
            generateServiceImplFile(resultSet);
            generateMapperFile(resultSet);
            generatExcelPojoFile(resultSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    /**
     * 生成数据库支持的实体类
     */
    public void generatBasePojoFile(ResultSet resultSet) throws Exception {

        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
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

            System.err.print(resultSet.getString("COLUMN_NAME") + "---");
            System.err.println(resultSet.getString("TYPE_NAME"));
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }

    /**
     * 生成Excel表格支持的实体类
     */
    public void generatExcelPojoFile(ResultSet resultSet) throws Exception {
        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
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
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }

    private void generateMapperFile(ResultSet resultSet) throws Exception {
        final String suffix = "Mapper.java";
        final String path = "D://" + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateServiceFile(ResultSet resultSet) throws Exception {
        final String suffix = "Service.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Service.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateServiceImplFile(ResultSet resultSet) throws Exception {
        final String suffix = "ServiceImpl.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    //    private void generateServiceInterfaceFile(ResultSet resultSet) throws Exception {
    //        final String prefix = "I";
    //        final String suffix = "Service.java";
    //        final String path = diskPath + prefix + changeTableName + suffix;
    //        final String templateName = "ServiceInterface.ftl";
    //        File mapperFile = new File(path);
    //        Map<String, Object> dataMap = new HashMap<>();
    //        generateFileByTemplate(templateName, mapperFile, dataMap);
    //    }
    //
    //    private void generateRepositoryFile(ResultSet resultSet) throws Exception {
    //        final String suffix = "Repository.java";
    //        final String path = diskPath + changeTableName + suffix;
    //        final String templateName = "Repository.ftl";
    //        File mapperFile = new File(path);
    //        Map<String, Object> dataMap = new HashMap<>();
    //        generateFileByTemplate(templateName, mapperFile, dataMap);
    //    }
    //
    //    private void generateDaoFile(ResultSet resultSet) throws Exception {
    //        final String suffix = "DAO.java";
    //        final String path = diskPath + changeTableName + suffix;
    //        final String templateName = "DAO.ftl";
    //        File mapperFile = new File(path);
    //        Map<String, Object> dataMap = new HashMap<>();
    //        generateFileByTemplate(templateName, mapperFile, dataMap);
    //
    //    }
    //
    //    private void generateMapperFile(ResultSet resultSet) throws Exception {
    //        final String suffix = "Mapper.xml";
    //        final String path = diskPath + changeTableName + suffix;
    //        final String templateName = "Mapper.ftl";
    //        File mapperFile = new File(path);
    //        Map<String, Object> dataMap = new HashMap<>();
    //        generateFileByTemplate(templateName, mapperFile, dataMap);
    //
    //    }

    private void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap)
            throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", tableName);
        dataMap.put("table_name", changeTableName);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", DateUtil.format(new Date(), "yyyy年M月dd日"));
        dataMap.put("package_name", packageName);
        dataMap.put("table_annotation", tableAnnotation);
        dataMap.put("is_node", isNode);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

}