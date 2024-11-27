package com.anonymous.base.common.constant;

/**
 * @author : yangsl25774
 * @Description: BaseCommonConstant 常量类
 * @date: 2024/6/24 17:00
 */
public class BaseCommonConstant {

    // 日志前缀常量
    public static final String BASE_COMMON_ASPECT = "BaseCommonAspect";

    // 数字常量
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int HUNDRED = 100;
    public static final int THOUSAND = 1000;

    // 星期常量，从星期天到星期六
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    // 月份常量，从一月到十二月
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    // 常用字符串常量
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String DOT = ".";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String UNDERSCORE = "_";
    public static final String DASH = "-";
    public static final String NEWLINE = System.lineSeparator();

    // 常用布尔常量
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;

    // HTTP状态码
    public static final int HTTP_OK = 200;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_METHOD_NOT_ALLOWED = 405;
    public static final int HTTP_INTERNAL_SERVER_ERROR = 500;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_SERVICE_UNAVAILABLE = 503;

    // 文件大小常量
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 1024L * ONE_KB;
    public static final long ONE_GB = 1024L * ONE_MB;
    public static final long ONE_TB = 1024L * ONE_GB;

    // 时间常量，单位为毫秒
    public static final long ONE_SECOND = 1000L;
    public static final long ONE_MINUTE = 60L * ONE_SECOND;
    public static final long ONE_HOUR = 60L * ONE_MINUTE;
    public static final long ONE_DAY = 24L * ONE_HOUR;

    // 单位转换常量
    public static final double INCHES_TO_CM = 2.54;
    public static final double CM_TO_INCHES = 1 / INCHES_TO_CM;
    public static final double POUNDS_TO_KG = 0.45359237;
    public static final double KG_TO_POUNDS = 1 / POUNDS_TO_KG;

    // 数学常量
    public static final double PI = 3.141592653589793;
    public static final double E = 2.718281828459045;
    public static final double SQRT2 = 1.4142135623730951;

    // 文件路径常量
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");

    // MIME类型常量
    public static final String MIME_TEXT_PLAIN = "text/plain";
    public static final String MIME_TEXT_HTML = "text/html";
    public static final String MIME_APPLICATION_JSON = "application/json";
    public static final String MIME_APPLICATION_XML = "application/xml";
    public static final String MIME_IMAGE_JPEG = "image/jpeg";
    public static final String MIME_IMAGE_PNG = "image/png";

    // 常用的正则表达式常量
    public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String REGEX_PHONE = "^\\+?[0-9. ()-]{7,25}$";
    public static final String REGEX_POSTAL_CODE = "^[0-9]{5}(?:-[0-9]{4})?$";

    // 常用的时间格式常量
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // 常用的HTTP头部常量
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
}
