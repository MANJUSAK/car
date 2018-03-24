package com.dhcc.car.model.statusenum;

/**
 * function
 * description:
 * ===>系统响应状态提示枚举类
 * 1、0代表程序运行正常
 * 2、100xx代表应用服务器提示状态码。
 * 3、200xx代表数据库服务器提示状态码
 * 4、xx500代表程序异常
 * 5、xx404代表无数据异常
 * 6、xx400代表参数异常
 * 7、xx502代表客户端操作异常
 * 8、400xx代表前台异常
 * <p>
 *
 * @author dhcc[manjusakachn@gmail.com] on 2017/7/24.
 * @version v1.1.0
 */
public enum StatusEnum {
    /**
     * 枚举描述信息
     */
    SUCCESS(0, "成功"),
    SERVER_ERROR(100500, "应用服务器发生异常"),
    DATABASE_ERROR(200500, "数据库服务器发生异常"),
    DEFEAT(200500, "失败"),
    UNKONW_ERROR(100501, "未知错误"),
    ERROR(100502, "错误操作"),
    NO_DATA(200404, "很抱歉，未找到该记录数据！"),
    NO_PARAM_DATA(400404, "未获取到所需数据"),
    NO_USER(200404, "用户名与密码不匹配"),
    NO_PARAM(400400, "参数错误或缺少参数！"),
    NO_FILE(100404, "文件不能为空"),
    FILE_FORMAT(100603, "文件格式不正确，图片格式为jpg、png、jpeg、gif、bmp，文档格式为pdf、doc、docx，表格格式为xlsx、xls"),
    FILE_SIZE(100601, "文件大小不符合要求，图片大小最大为1.5M，文档大小最大为30M,表格大小最大为10M"),
    FILE_UPLOAD(100600, "文件上传失败");


    private final int CODE;
    private final String EXPLAIN;

    StatusEnum(int CODE, String EXPLAIN) {
        this.CODE = CODE;
        this.EXPLAIN = EXPLAIN;
    }

    public int getCODE() {
        return CODE;
    }

    public String getEXPLAIN() {
        return EXPLAIN;
    }

}
