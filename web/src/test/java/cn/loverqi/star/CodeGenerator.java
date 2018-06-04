package cn.loverqi.star;

import org.junit.Test;

import cn.loverqi.star.core.bulid.CodeGenerateBulider;

/**
 * 代码生成器示例
 * @author LoverQi
 * @date 2018年5月31日
 */
public class CodeGenerator {

    @Test
    public void generate() {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/star?useUnicode=true&characterEncoding=UTF-8";
        String jdbcUserName = "root";
        String jdbcPassWord = "root";

        CodeGenerateBulider bulid = new CodeGenerateBulider(jdbcUrl, jdbcUserName, jdbcPassWord);

        //设置文件作者
        bulid.setAuthor("LoverQi");
        //设置文件日期格式
        bulid.setDateFormat("yyyy年M月dd日");
        //是否生成实体类
        bulid.setGenDomain(false);
        //实体类是否支持excel操作
        bulid.setExcel(false);
        //实体类是否是层级菜单
        bulid.setNode(false);
        //是否生成数据库操作类
        bulid.setGenMapper(false);
        //是否生成逻辑处理类
        bulid.setGenService(true);
        //是否生成逻辑处理类实现类
        bulid.setGenServieImpl(true);

        //指定需要生成的表，不定参，不传参时生成当前库所有
        bulid.generate("base_pojo");
    }

}
