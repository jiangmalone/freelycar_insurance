package com.freelycar.util;

public enum INSURANCE {
    /**
     * INSURANCE_NO_1("车辆损失险"),
     * INSURANCE_NO_2("第三者责任险"),
     * INSURANCE_NO_3("全车盗抢险"),
     * INSURANCE_NO_4("司机座位责任险"),
     * INSURANCE_NO_5("乘客座位责任险"),
     * INSURANCE_NO_6("玻璃单独破碎险"),
     * INSURANCE_NO_7("车身划痕损失险"),
     * INSURANCE_NO_8("自燃损失险"),
     * INSURANCE_NO_9("发动机涉水损失险"),
     * INSURANCE_NO_10("指定专修厂特约条款"),
     * INSURANCE_NO_11("无法找到第三方特约险"),
     */


    //报价状态

    QUOTESTATE_HEBAOING(0, "核保中"),
    QUOTESTATE_HEBAOFAIL(1, "核保失败"),
    QUOTESTATE_NOTPAY(2, "未支付"),
    QUOTESTATE_CHENGBAOING(3, "承保中"),
    QUOTESTATE_CHENGBAOFAIL(4, "承保失败"),
    QUOTESTATE_NOTDELIVER(5, "待配送"),
    QUOTESTATE_NOTREVICER(6, "待签收"),
    QUOTESTATE_HASTOUBAO(7, "已投保"),
    QUOTESTATE_NOTQUOTE(8, "未报价");


    private int code;
    private String name;

    INSURANCE(String name) {
        this.name = name;
    }

    INSURANCE(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据number得到名称
     *
     * @param number
     * @return
     */
    /*public static String getInsuranceTypeName(int number) {
        return INSURANCE.valueOf("INSURANCE_NO_" + number).name;
    }*/

    /**
     * 根据state来得到报价状态的中文意思
     *
     * @param number
     * @return
     */
    public static String getQuotestateName(int number) {
        for (INSURANCE quoteState : INSURANCE.values()) {
            if (quoteState.code == number) {
                return quoteState.name;
            }
        }
            return null;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
