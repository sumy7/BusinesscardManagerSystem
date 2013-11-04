简单的名片管理系统
=========================

Simple Card Manager System for J2EE Homework.  

### 简介

*2013-11-4 需求更新*  

基于Struts2+JDBC+DAO，设计一个简单的网上名片管理系统，实现名片的增、删、改、查等操作。该名片管理系统包括如下功能：  

1. 用户登录与注册  
**用户登录：**在登录时，如果用户名和密码正确，进入系统页面；  
**用户注册：**新用户应该先注册，然后再登录该系统。  

2. 名片管理  
**增加名片：**以仿真形式（按常用的名片格式）增加名片信息；  
**修改名片：**以仿真形式（按常用的名片格式）修改名片信息；  
**查询名片：**以模糊查询方式查询名片；  
**删除名片：**名片的删除由2种方式，即把名片移到回收站，把名片彻底删除。  

3. 回收站管理  
**还原：**把回收站中的名片还原回收；  
**彻底删除：**把名片彻底从回收站删除；  
**浏览/查询：**可以模糊查询、浏览回收站中的名片。  

*2013-11-1*  
初衷是J2EE的期中作业，现在作业的要求还没有出来，只能根据自己的想象的需求来做。  

### 前言
使用J2EE开发，应用了Struts2框架，结合Bootstrap来优化界面，使用了少量的 jQuery 和 Ajax 技术来优化体验。  
**强烈建议使用 Chrome 、 Firefox 和 IE9 浏览器进行浏览。**  

### 进度

基本大功能已经实现，接下来要进行用户体验的优化了。  

####当前已实现的功能有：  

1. 登录
2. 注册
3. 添加名片
4. 修改名片
5. 删除名片到回收站
6. 从回收站还原名片
7. 从回收站彻底删除名片
8. 搜索名片
9. 注册页面用户名已存在提示，注册页面重复输入密码不相等提示
10. 在浏览名片时查找名片

####还想实现的功能有：

1. **需求更新：** 以仿真形式显示名片
2. **需求更新：** 可以在回收站界面查找名片
2. 等等

#### 存在的问题

1. 注册页面注册按钮开启需用户名和密码都满足要求，使用 jQuery 验证存在延迟，而且必须按照顺序输入才能开启。  
**暂时解决方法：**  当重新输入 用户名 时将密码框的内容清空。 PS：IE9根本不起作用。  

### 遇到的问题及简单解决方法

1.Struts2 的表单使用 `get` 方法时出现乱码，而 `post` 方法没有乱码。  

这主要是编码不匹配造成的，要对字符串重新编码  

    new String(value.getBytes("ISO-8859-1"),"UTF-8")

2.非 Struts2 的标签组件显示 action 的变量内容。  

直接在组件的 value 属性中嵌套 Struts 的标签。  

    <input type="text" value="<s:property value='keyword'/>">

3.将网址中的请求参数传入 action  

在 action 中声明一个和网址请求参数名称同名的变量，并设置 get 和 set 方法。  

4.在 jsp 中遍历 action 的列表。  

在 action 中声明一个名称为 list 的 ArrayList。使用 Struts2 的标签 `s:iterator` 可以遍历。  

    <s:iterator value="list" id="iter" status="st">
        <s:property value="#st.getIndex()" />
        <s:property value="#iter.value" />
    </s:iterator>

5.通过一个 action 跳转到另一个 action  

在 struts.xml 的 action 中配置相应的跳转方法。  

    <!-- 不保留actiona的request对象 -->
    <action name="actiona" class="com.action.A">
        <result name="success" type="redirect">actionb</result>
    </action>
    
    <!-- 保留actionb的request对象 -->
    <action name="actionb" class="com.action.B">
        <result name="success" type="chain">actiona</result>
    </action>

6.设计登录操作的相关问题  

首先可以将登录成功后的 User 对象保存到 Session 中  

    User visitor = new User();
    ...
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    session.put("visitor", visitor);

然后就可以通过 Session 中的字段来判断登录信息  
  
Action 中获取：  

    User visitor = null;
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    visitor = (OnlineUser) session.get("visitor");

Struts2 - JSP 中获取： 
 
    <s:if test="#session.visitor != null">
        <s:property value="#session.visitor.username" />
    </s:if>
    <s:else>
        ...
    </s:else>

7.注销登录

直接清空 Session 中的字段信息  
 
    <%
        session.removeAttribute("visitor");
    %>

8.在资源管理器中删除工程的文件之后重新打开工程时，出现`Could not open the editor`异常。  

打开 Myeclipse 之后，在左侧文件管理器里按 F5 刷新资源。重新打开需要的文件即可。  

### 声明

希望能从这次练习中学到一些东西，能有收获才是最重要的。  
