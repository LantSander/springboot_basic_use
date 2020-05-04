
package com.lant.springboot_basic_use.enums;

public class ResultCode {
    public static final Integer RESULT_SUCCESS = 10200;
    public static final Integer RESULT_FAIL = 10500;
    public static final Integer RESULT_UNAUTHORIZED = 10001;
    public static final Integer RESULT_NO_LOGIN = 10002;
    public static final Integer RESULT_OPERATION_FAIL = 10003;
    public static final Integer RESULT_METHOD_NOT_SUPPORT = 10004;
    public static final Integer RESULT_VALID_REQUST_ERRO= 10005;
    public static final Integer RESULT_ERROR = 10006;
    public static final Integer RESULT_USERNAME_PASSWORD = 10007;
    public static final Integer RESULT_TOKEN_INVALID = 10008;
    public static final Integer RESULT_NO_TOKEN = 10009;
    public static final Integer RESULT_NOT_SUPPORT_REFRESH = 10010;
    public static final Integer RESULT_REFRESH_TOKEN_INVALID = 10011;
    public static final Integer RESULT_REFRESH_TOKEN_COUNT_MAX = 10012;
    public static final Integer RESULT_NO_THIRD_USERID = 11001;
    public static final Integer RESULT_NO_CLIENTID = 11002;
    public static final Integer RESULT_ERROR_CLIENT_SECRET = 11003;
    public static final Integer RESULT_ERROR_GRANT_TYPE = 11004;
    public static final Integer RESULT_ERROR_SCOPE = 11005;
    public static final Integer RESULT_FAIL_CREATE_TOKEN = 11006;
    public static final Integer RESULT_NO_VALIDCODE = 11007;
    public static final Integer RESULT_ERROR_VALIDCODE = 11008;
    public static final Integer RESULT_NO_MOBILE = 11009;
    public static final Integer RESULT_ERROR_SMS_CODE = 11010;
    public static final Integer RESULT_FAIL_SEND_SMS = 11011;
    public static final Integer RESULT_FAIL_RSA = 11012;
    public static final Integer RESULT_LOGIN_PLATFORM_TIMEOUT = 11013;
    public static final Integer RESULT_USER_NO_INIT = 11014;
    public static final Integer RESULT_TIMES_OUT = 11015;
    public static final Integer RESULT_NO_THIRD_LOGIN_URL = 11016;
    public static final Integer RESULT_REQUEST_THIRD_LOGIN_URL_FAIL = 11017;
    public static final Integer RESULT_NOTEXISTS_THIRD_USER_ID = 12010;
    public static final Integer RESULT_NOTEXISTS_USER = 12011;
    public static final Integer RESULT_EXISTS_USER = 12012;
    public static final Integer RESULT_SYN_USER_ERROR = 12013;
    public static final Integer RESULT_EXISTS_USER_IN_SYS = 12025;
    public static final Integer RESULT_NOTEXISTS_THIRD_COMPANY_ID = 12020;
    public static final Integer RESULT_NOTEXISTS_COMPANY = 12021;
    public static final Integer RESULT_EXISTS_COMPANY = 12022;
    public static final Integer RESULT_SYN_COMPANY_ERROR = 12024;
    public static final Integer RESULT_EXISTS_COMPANY_IN_SYS = 12025;
    public static final Integer RESULT_NOTEXISTS_THIRD_STAFF_ID = 12030;
    public static final Integer RESULT_NOTEXISTS_STAFF = 12031;
    public static final Integer RESULT_EXISTS_STAFF = 12032;
    public static final Integer RESULT_SYN_STAFF_ERROR = 12034;
    public static final Integer RESULT_EXISTS_STAFF_IN_SYS = 12035;
    public static final Integer RESULT_EXISTS_PHONE = 12070;
    public static final Integer RESULT_MQ_ERROR = 12090;
    public static final Integer RESULT_GATEWAY_ERROR = 13500;

    public ResultCode() {
    }
}
