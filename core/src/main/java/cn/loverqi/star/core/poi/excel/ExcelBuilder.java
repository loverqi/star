package cn.loverqi.star.core.poi.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

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
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws IOException
     */
    public static <T extends ExcelPojo> void exportExcel(OutputStream os, Class<T> clazz, List<T> list)
            throws InstantiationException, IllegalAccessException {

        T t = clazz.newInstance();

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
                createCell.setCellValue(tTemp.getExcelFieldsList(ecm.getFieldName()));
                createCell.setCellStyle(getNoteStyle(book));
            }
        }

        for (int i = 0; i < exms.size(); i++) {
            sheet.autoSizeColumn(i, true);
        }

        try {
            book.write(os);
        } catch (Exception ex) {
        } finally {
            IOUtils.closeQuietly(book);
            IOUtils.closeQuietly(os);
        }
    }

    private static final DecimalFormat df = new DecimalFormat("0");// 格式化 number为整
    private static final DecimalFormat df_per = new DecimalFormat("##.00%");//格式化分比格式，后面不足2位的用0补齐
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
    private static final DecimalFormat sc_number = new DecimalFormat("0.00E000"); //格式化科学计数器
    private static final Pattern points_ptrn = Pattern.compile("0.0+_*[^/s]+");

    /**
     * 对外提供读取excel 的方法
     * @param file
     * @param cls
     * @return
     * @throws IOException
     */
    //    public static <T> List<T> readExcel(MultipartFile file, Class<T> clazz) {
    //        List<T> list = new ArrayList<>();
    //        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
    //                .toLowerCase();
    //        if ("xls".equals(extension) || "xlsx".equals(extension)) {
    //            try {
    //                T t = clazz.newInstance();
    //                list = readExcel(file.getInputStream(), t);
    //            } catch (IOException e) {
    //            }
    //        }
    //
    //        return list;
    //    }

    /**
     * 获取excel数据 将之转换成bean
     * @param path
     * @param cls
     * @param <T>
     * @return
     */
    //    private static <T> List<T> readExcel(InputStream inputStream, T t) {
    //        Workbook workbook =  WorkbookFactory.create(inputStream);
    //            
    //            
    //            int sheetsNumber = workbook.getNumberOfSheets();
    //            
    //            for (int n = 0; n < sheetsNumber; n++) {
    //                Sheet sheet = workbook.getSheetAt(n);
    //                
    //                for (int j = sheet.getRow(0).getFirstCellNum(); j < sheet.getRow(0).getLastCellNum(); j++) { //首行提取注解
    //                    Object cellValue = getCellValue(sheet.getRow(0).getCell(j));
    //                }
    //                
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
    //        }catch(
    //
    //    Exception e)
    //    {
    //        dataList = null;
    //    }finally
    //    {
    //        IOUtils.closeQuietly(workbook);
    //        IOUtils.closeQuietly(inputStream);
    //    }return dataList;
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
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);

        return cellStyle;
    }

    private static CellStyle getNoteStyle(Workbook book) {
        //设置字体
        Font font = book.createFont();

        //设置单元格类型
        CellStyle cellStyle = book.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setWrapText(true);

        return cellStyle;
    }

}