package cn.loverqi.star.core.poi.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.loverqi.star.core.basepojo.ExcelPojo;
import cn.loverqi.star.core.bean.ExcelColumnMapping;

/**
 * 对于excel的静态支持类
 * @author LoverQi
 * @date 2018年4月8日
 */
public class ExcelBuilder {

    /**
     * 根据对象的值生成excel表格的静态方法
     * @param os
     * @throws IOException
     */
    public static <T extends ExcelPojo> void exportExcel(OutputStream os, T t, List<T> list) {

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet(t.getExcelName());

        // 设置首行
        List<ExcelColumnMapping> exms = t.getExcelFieldsList();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellStyle(getTitleStyle(book));
        cell.setCellValue(t.getExcelName());
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, exms.size() - 1);
        sheet.addMergedRegion(region);
        row.setHeightInPoints((short) 22);
        // 设置首行

        row = sheet.createRow(1);
        for (int i = 0; i < exms.size(); i++) {
            ExcelColumnMapping ecm = exms.get(i);
            Cell createCell = row.createCell(i);
            createCell.setCellValue(ecm.getName());
            createCell.setCellStyle(getTitleNoteStyle(book));
        }

        for (int i = 0; i < list.size(); i++) {
            T tTemp = list.get(i);
            row = sheet.createRow(i + 2);

            for (int j = 0; j < exms.size(); j++) {
                ExcelColumnMapping ecm = exms.get(j);
                Cell createCell = row.createCell(j);
                String fieldStr = tTemp.getExcelFieldsList(ecm.getFieldName());
                createCell.setCellValue(fieldStr);
                if (ecm.isIfUtf() && ecm.getName().length() < fieldStr.length()) {
                    String regEx = "[\u4e00-\u9fa5]";
                    Pattern pat = Pattern.compile(regEx);
                    Matcher matcher = pat.matcher(fieldStr);
                    if (matcher.find()) {
                        ecm.setName(fieldStr);
                    }
                }
                createCell.setCellStyle(getNoteStyle(book));
            }
        }

        for (int i = 0; i < exms.size(); i++) {
            ExcelColumnMapping ecm = exms.get(i);
            if (ecm.isIfUtf()) {
                sheet.setColumnWidth(i, ecm.getName().getBytes().length * 2 * 128);
            } else {
                sheet.autoSizeColumn(i, true);
            }
        }

        try {
            book.write(os);
        } catch (Exception ex) {
        } finally {
            try {
                book.close();
                os.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private static CellStyle getTitleStyle(Workbook book) {
        //设置字体
        Font font = book.createFont();
        font.setFontHeightInPoints((short) 14); //字体高度
        font.setBold(true);
        font.setFontName("微软雅黑"); //字体

        //设置单元格类型
        CellStyle cellStyle = book.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        return cellStyle;
    }

    private static CellStyle getTitleNoteStyle(Workbook book) {
        //设置字体
        Font font = book.createFont();
        font.setBold(true);
        font.setFontName("微软雅黑"); //字体

        //设置单元格类型
        CellStyle cellStyle = book.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);

        return cellStyle;
    }

    private static CellStyle getNoteStyle(Workbook book) {
        //设置字体
        Font font = book.createFont();

        //设置单元格类型
        CellStyle cellStyle = book.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setWrapText(true);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);

        return cellStyle;
    }

    public static class Userinfo {
        private String id;
        private String name;
        private String pass;
        private String lastname;
        private String addres;
        private String remark;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }

    //    private static final DecimalFormat df = new DecimalFormat("0");// 格式化 number为整
    //    private static final DecimalFormat df_per = new DecimalFormat("##.00%");//格式化分比格式，后面不足2位的用0补齐
    //    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
    //    private static final DecimalFormat sc_number = new DecimalFormat("0.00E000"); //格式化科学计数器
    //    private static final Pattern points_ptrn = Pattern.compile("0.0+_*[^/s]+");
    //
    //    /**
    //     * 对外提供读取excel 的方法
    //     * @param file
    //     * @param cls
    //     * @return
    //     * @throws IOException
    //     */
    //    public static <T> List<T> readExcel(MultipartFile file, Class<T> cls) throws IOException {
    //        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
    //                .toLowerCase();
    //        if ("xls".equals(extension) || "xlsx".equals(extension)) {
    //            return readExcel(file.getInputStream(), cls);
    //        } else {
    //            throw new IOException("不支持的文件类型");
    //        }
    //    }
    //
    //    /**
    //     * 获取excel数据 将之转换成bean
    //     * @param path
    //     * @param cls
    //     * @param <T>
    //     * @return
    //     */
    //    private static <T> List<T> readExcel(InputStream inputStream, Class<T> cls) {
    //        List<T> dataList = new LinkedList<>();
    //        Workbook workbook = null;
    //        try {
    //            workbook = WorkbookFactory.create(inputStream);
    //            Map<String, List<Field>> classMap = new HashMap<>();
    //            Field[] fields = cls.getDeclaredFields();
    //            for (Field field : fields) {
    //                ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
    //                if (annotation != null) {
    //                    String value = annotation.value();
    //                    if (!classMap.containsKey(value)) {
    //                        classMap.put(value, new ArrayList<Field>());
    //                    }
    //                    field.setAccessible(true);
    //                    classMap.get(value).add(field);
    //                }
    //            }
    //            Map<Integer, List<Field>> reflectionMap = new HashMap<>();
    //            int sheetsNumber = workbook.getNumberOfSheets();
    //            for (int n = 0; n < sheetsNumber; n++) {
    //                Sheet sheet = workbook.getSheetAt(n);
    //                for (int j = sheet.getRow(0).getFirstCellNum(); j < sheet.getRow(0).getLastCellNum(); j++) { //首行提取注解
    //                    Object cellValue = getCellValue(sheet.getRow(0).getCell(j));
    //                    if (classMap.containsKey(cellValue)) {
    //                        reflectionMap.put(j, classMap.get(cellValue));
    //                    }
    //                }
    //                Row row = null;
    //                Cell cell = null;
    //                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
    //                    row = sheet.getRow(i);
    //                    T t = cls.newInstance();
    //                    for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
    //                        cell = row.getCell(j);
    //                        System.out.println(cell.getCellTypeEnum());
    //                        System.out.println(cell.getCellStyle().getDataFormatString());
    //                        if (reflectionMap.containsKey(j)) {
    //                            Object cellValue = getCellValue(cell);
    //                            List<Field> fieldList = reflectionMap.get(j);
    //                            for (Field field : fieldList) {
    //                                try {
    //                                    field.set(t, cellValue);
    //                                } catch (Exception e) {
    //                                    //logger.error()
    //                                }
    //                            }
    //                        }
    //                    }
    //                    dataList.add(t);
    //                }
    //            }
    //        } catch (Exception e) {
    //            dataList = null;
    //        } finally {
    //            IOUtils.closeQuietly(workbook);
    //            IOUtils.closeQuietly(inputStream);
    //        }
    //        return dataList;
    //    }
    //
    //    /**
    //     * 获取excel 单元格数据
    //     * @param cell
    //     * @return
    //     */
    //    private static Object getCellValue(Cell cell) {
    //        Object value = null;
    //        switch (cell.getCellTypeEnum()) {
    //        case _NONE:
    //            break;
    //        case STRING:
    //            value = cell.getStringCellValue();
    //            break;
    //        case NUMERIC:
    //            if (DateUtil.isCellDateFormatted(cell)) { //日期
    //                value = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
    //            } else if ("@".equals(cell.getCellStyle().getDataFormatString())
    //                    || "General".equals(cell.getCellStyle().getDataFormatString())
    //                    || "0_ ".equals(cell.getCellStyle().getDataFormatString())) {
    //                //文本  or 常规 or 整型数值
    //                value = df.format(cell.getNumericCellValue());
    //            } else if (points_ptrn.matcher(cell.getCellStyle().getDataFormatString()).matches()) { //正则匹配小数类型 
    //                value = cell.getNumericCellValue(); //直接显示
    //            } else if ("0.00E+00".equals(cell.getCellStyle().getDataFormatString())) {//科学计数
    //                value = cell.getNumericCellValue(); //待完善           
    //                value = sc_number.format(value);
    //            } else if ("0.00%".equals(cell.getCellStyle().getDataFormatString())) {//百分比                      
    //                value = cell.getNumericCellValue(); //待完善
    //                value = df_per.format(value);
    //            } else if ("# ?/?".equals(cell.getCellStyle().getDataFormatString())) {//分数
    //                value = cell.getNumericCellValue(); ////待完善
    //            } else { //货币       
    //                value = cell.getNumericCellValue();
    //                value = DecimalFormat.getCurrencyInstance().format(value);
    //            }
    //            break;
    //        case BOOLEAN:
    //            value = cell.getBooleanCellValue();
    //            break;
    //        case BLANK:
    //            //value = ",";
    //            break;
    //        default:
    //            value = cell.toString();
    //        }
    //        return value;
    //    }
    //

}