package cn.loverqi.star.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil
 */
public final class DateUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);
    private static final String DATE_FMT_DEFAULT = ConstantUtil.DATE_FMT_SECOND;

    public final static Date parseDefault(String dateStr) {
        return parse(dateStr, DATE_FMT_DEFAULT);
    }

    public final static String formatDefault(Date date) {
        return format(date, DATE_FMT_DEFAULT);
    }

    public final static Date parse(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return date;
    }

    public final static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public final static String toSQLDateDefault(String dateStr) {
        return "str_to_date('" + dateStr + "','%Y-%m-%d %H:%i:%s')";
    }

    public final static String toSQLDateDay(String dateStr) {
        return "str_to_date('" + dateStr + "','%Y-%m-%d')";
    }

    /**
     * 获取一天的开始时间
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.HOUR_OF_DAY, 0);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }

    /**
     * 获取今天的开始时间
     * @return
     */
    public static Date getStartOfToday() {
        return getStartOfDay(new Date());
    }

    /**
     * 获取偏移时间
     * @param date
     * @param n
     * @param timeUnit
     * @return
     */
    public static Date getOffsetDay(Date date, int n, String timeUnit) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        switch (timeUnit) {
            case ConstantUtil.SYMBOL_DATE_YEAR:
                cld.add(Calendar.YEAR, n);
                break;
            case ConstantUtil.SYMBOL_DATE_MONTH:
                cld.add(Calendar.MONTH, n);
                break;
            case ConstantUtil.SYMBOL_DATE_DAY:
                cld.add(Calendar.DATE, n);
                break;
            case ConstantUtil.SYMBOL_DATE_HOUR:
                cld.add(Calendar.HOUR_OF_DAY, n);
                break;
            case ConstantUtil.SYMBOL_DATE_MINUTE:
                cld.add(Calendar.MINUTE, n);
                break;
            case ConstantUtil.SYMBOL_DATE_SECOND:
                cld.add(Calendar.SECOND, n);
                break;
            case ConstantUtil.SYMBOL_DATE_MILLISECOND:
                cld.add(Calendar.MILLISECOND, n);
                break;
            default:
                LOG.error("timeUnit[{}] Unrecognized, please check!", timeUnit);
                return null;
        }
        return cld.getTime();
    }

    /**
     * 获取对应时间之前一天的时间
     * @param now
     * @return
     */
    public static Date getYesterdayNow(Date now) {
        return getOffsetDay(now, -1, ConstantUtil.SYMBOL_DATE_DAY);
    }

    /**
     * 获得N天前的时间
     * @param now
     * @param n
     * @return
     */
    public static Date getNDaysOffset(Date now, int n) {
        return getOffsetDay(now, n, ConstantUtil.SYMBOL_DATE_DAY);
    }

    public static void main(String[] args) {
        Date date = getOffsetDay(new Date(), 1, ConstantUtil.SYMBOL_DATE_MONTH);
        LOG.info("date:{}", format(getStartOfDay(date), ConstantUtil.DATE_FMT_MSEC));
    }

}
