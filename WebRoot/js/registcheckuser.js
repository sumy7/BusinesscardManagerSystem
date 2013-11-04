//用户名验证
var usernameok = false;
var passwordok = false;
$().ready(

function() {
  function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(
    0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
  }
  
  function changesubmit() {
	  if(usernameok && passwordok){
		  $("#btn-submit").removeAttr("disabled");
	  }
	  else{
		  $("#btn-submit").attr("disabled",true);
	  }
  }
  
  $("#registInputUsername").keyup(
		  function(){
			  usernameok = false;
			  $("#registInputPassword").val('');
			  $("#registInputRepeatPass").val('');
			  changesubmit();
		  });
  
  $("#registInputUsername").blur(
  function() {
    var username = $("#registInputUsername").val();
    if (username.trim()) {
      var parameter = {
        checkusername: username
      };
      $.post(
      getRootPath() + "/ajaxValidate/ajaxValidate_toCheckUsername.action", parameter, function(data) {
        if(data.message == "true"){
    	  $("#vldUserName").html("用户名已存在，请使用其它用户名。");
    	  usernameok = false;
        }
        else {
          $("#vldUserName").html("用户名可用。");
          usernameok = true;
        }
        
      });
    } else {
      $("#vldUserName").html("用户名不能为空，请输入用户名。");
      usernameok = false;
    }
    changesubmit();
  });
  
  $("#registInputPassword,#registInputRepeatPass").keyup(
		  function() {
		    var password1 = $("#registInputPassword").val();
		    var password2 = $("#registInputRepeatPass").val();
		    if (password1.trim() && password2.trim()) {
		      if(password1 != password2){
		    	  $("#vldPassword").html("两次密码不匹配。");
		    	  passwordok = false;
		      }
		      else{
		    	  $("#vldPassword").html("OK!");
		    	  passwordok = true;
		      }
		    } else {
		      $("#vldPassword").html("请输入两次密码。");
		      passwordok = false;
		    }
		    changesubmit();
		  });
  
});