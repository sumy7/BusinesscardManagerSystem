简单的名片管理系统
=========================

Simple Card Manager System for J2EE Homework.  

### 简介
初衷是J2EE的期中作业，现在作业的要求还没有出来，只能根据自己的想象的需求来做。  

### 主要技术
主要使用J2EE开发，应用了Struts2框架，结合Bootstrap来优化界面。恩，现在就用了这么多。  

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

####还想实现的功能有：

1. 注册用户名验证
2. 等等

### 遇到的问题及简单解决方法

1. Struts2 的表单使用 `get` 方法时出现乱码，而 `post` 方法没有乱码。  
这主要是编码不匹配造成的，要对字符串重新编码  

    new String(value.getBytes("ISO-8859-1"),"UTF-8")

2. 非 Struts2 的标签组件显示 action 的变量内容。  
直接在组件的 value 属性中嵌套 Struts 的标签。  

    <input type="text" value="<s:property value='keyword'/>">

3. 将网址中的请求参数传入 action  
在 action 中声明一个和网址请求参数名称同名的变量，并设置 get 和 set 方法。  

4. 在 jsp 中遍历 action 的列表。  
在 action 中声明一个名称为 list 的 ArrayList。使用 Struts2 的标签 `s:iterator` 可以遍历。  

    <s:iterator value="list" id="iter" status="st">
        <s:property value="#st.getIndex()" />
        <s:property value="#iter.value" />
    </s:iterator>

5. 通过一个 action 跳转到另一个 action  
在 struts.xml 的 action 中配置相应的跳转方法。  

    <!-- 不保留actiona的request对象 -->
    <action name="actiona" class="com.action.A">
        <result name="success" type="redirect">actionb</result>
    </action>
    
    <!-- 保留actionb的request对象 -->
    <action name="actionb" class="com.action.B">
        <result name="success" type="chain">actiona</result>
    </action>

6. 设计登录操作的相关问题
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

7. 注销登录
直接清空 Session 中的字段信息

    <%
        session.removeAttribute("visitor");
    %>

### 声明

希望能从这次练习中学到一些东西，能有收获才是最重要的。  
