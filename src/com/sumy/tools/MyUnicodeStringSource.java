package com.sumy.tools;

import java.lang.reflect.Field;

public class MyUnicodeStringSource {
	public static final String Unicode_login_notlogin = "\u4f60\u8fd8\u6ca1\u6709\u767b\u5f55\u3002"; // 你还没有登录。
	public static final String Unicode_login_faild = "Oooop\uff0c\u767b\u5f55\u8fc7\u7a0b\u51fa\u9519\u5566\uff0c\u91cd\u8bd5\u4e00\u4e0b\u5427\u3002"; // Oooop，登录过程出错啦，重试一下吧。
	public static final String Unicode_login_success = "\u767b\u5f55\u6210\u529f\uff0c\u6b22\u8fce\u4f7f\u7528\uff0c\u8bf7\u7ee7\u7eed\u64cd\u4f5c\u3002"; // 登录成功，欢迎使用，请继续操作。
	public static final String Unicode_login_pwderror = "\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5\u3002"; // 用户名或密码错误，请重试。

	public static final String Unicode_card_idfaild = "\u83b7\u53d6\u540d\u7247\u7f16\u53f7\u51fa\u9519\uff0c\u8bf7\u91cd\u8bd5\u3002"; // 获取名片编号出错，请重试。
	public static final String Unicode_card_iderror = "\u83b7\u53d6\u540d\u7247\u7f16\u53f7\u51fa\u9519\uff0c\u627e\u4e0d\u5230\u6539\u7f16\u53f7\u7684\u540d\u7247\u3002"; // 获取名片编号出错，找不到改编号的名片。
	public static final String Unicode_card_powerfaild = "\u60a8\u65e0\u6743\u64cd\u4f5c\u5176\u5b83\u7528\u6237\u7684\u540d\u7247\u3002"; // 您无权操作其它用户的名片。
	public static final String Unicode_card_movetorecycle = "\u6210\u529f\u5c06\u4e00\u5f20\u540d\u7247\u79fb\u5165\u56de\u6536\u7ad9\u3002"; // 成功将一张名片移入回收站。

	public static final String Unicode_card_infoerror = "\u60a8\u63d0\u4ea4\u4e86\u4e0d\u6b63\u786e\u7684\u540d\u7247\u4fe1\u606f\u3002\u8bf7\u91cd\u65b0\u8f93\u5165\u3002"; // 您提交了不正确的名片信息。请重新输入。
	public static final String Unicode_card_addsuccess = "\u6dfb\u52a0\u540d\u7247\u6210\u529f\u3002"; // 添加名片成功。

	public static final String Unicode_card_delsuccess = "\u6210\u529f\u5220\u9664\u4e86\u4e00\u5f20\u540d\u7247\u3002"; // 成功删除了一张名片。
	public static final String Unicode_card_delcardfaild = "\u672a\u5728\u56de\u6536\u7ad9\u7684\u540d\u7247\u4e0d\u80fd\u5220\u9664\u3002"; // 未在回收站的名片不能删除。
	public static final String Unicode_card_editrecyclecard = "\u60a8\u4e0d\u80fd\u7f16\u8f91\u56de\u6536\u7ad9\u4e2d\u7684\u540d\u7247\u3002"; // 您不能编辑回收站中的名片。

	public static final String Unicode_card_movetolist = "\u6210\u529f\u8fd8\u539f\u4e86\u4e00\u5f20\u540d\u7247\u3002"; // 成功还原了一张名片。
	public static final String Unicode_card_updatesuccess = "\u66f4\u65b0\u540d\u7247\u6210\u529f\u3002"; // 更新名片成功。

	public static final String Unicode_regist_success = "\u6ce8\u518c\u6210\u529f\uff0c\u8bf7\u767b\u5f55\u3002"; // 注册成功，请登录。
	public static final String Unicode_regist_infofaild = "\u83b7\u53d6\u6ce8\u518c\u4fe1\u606f\u51fa\u9519\uff0c\u8bf7\u91cd\u8bd5\u3002"; // 获取注册信息出错，请重试。
	public static final String Unicode_regist_pwdnotequal = "\u4e24\u6b21\u5bc6\u7801\u4e0d\u76f8\u7b49\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u3002"; // 两次密码不相等，请重新输入。
	public static final String Unicode_regist_nameexist = "\u7528\u6237\u540d\u5df2\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u3002"; // 用户名已存在，请重新输入。

	public static String getValue(String sourcekey) {
		String name = "Unicode_" + sourcekey;
		try {
			Class c = Class.forName("com.sumy.tools.MyUnicodeStringSource");
			Field field = c.getField(name);
			return field.get(c).toString();
		} catch (Exception e) {
			return "";
		}
	}
}
