/**
 * 登录JS
 * 
 * @author tc
 * @createDate 2016-07-06
 */
login = (function(){
	 /**
	  * 登录，通过网页姓名密码登录
	  */
	var	_login = function() {
	       var name =  $.trim($("#userName").val());
           var pass =  $.trim($("#password").val());
           if(name==""){
           	common.alert("提示","用户名不能为空！");
           	return;
           }    
           if(pass==""){
           	common.alert("提示","密码不能为空！");
           	return;
           } 
           var type = $('input:radio[name="optionsRadios"]:checked').val();
           if($("#rememberme").is(":checked")){
        	   $.cookie("name",name,{expires:30});
        	   $.cookie("pass",pass,{expires:30});
        	   $.cookie("type",type,{expires:30});
           }else{
        	   $.cookie("name",null);
        	   $.cookie("pass",null);
        	   $.cookie("type",null);
           }
           var param = {"id":1};
//           var param = {"srcFlag":"1","agreementType":"2","areaId":"8320400","sysFlag":"10002","mktResCd":"9932","channelId":"1406794"};
           common.post(param,"login/loginDo",function(data){
               	if(data.resultCode==0){
               		common.menu("login/mainHome");
               	}else if(data.resultCode==3){
               		common.menu("login/home");
               	}else{
               		if(type==1){
               		$("#resultMsg").text(data.resultMsg);
               		$("#Waring").show();
               		}
               		common.alert("提示","登录失败，温馨提示："+data.resultMsg);
               	}               	
               });
         };
    	 /**
    	  * 虚拟登录，用小灰灰模拟登录，不用校验帐号密码
    	  */
         var _simulateLogin = function() {
        	var type = $('input:radio[name="optionsRadios"]:checked').val();
           var param = {"type":type};
           common.post(param,"login/slogin",function(data){
               	if(data.resultCode==0){
               		if(type==1)
               			common.menu("login/mainHome");
               		else
                   		common.menu("login/home");
               	}else{
               		common.alert("提示","模拟登录失败，温馨提示："+data.resultMsg);
               		$("#resultMsg").text(data.resultMsg);
               		$("#Waring").css("dispaly","block");
               	}               	
               });
		}; 
		/**
   	 	* 微信第一次登录，根据输入信息完善Staff表中信息（添加记录）
   	 	*/
	     var _addStaff = function() {
	    	   var period = "";
		       var name = $.trim($("#name").val());
	           var password = "123456";
	           password2 = $.trim($("#password").val());
	           period = $.trim($("#period").val());
	           if(name==""){
	           	common.alert("提示","真实姓名不能为空！");
	           	return;
	           } 
	           if(period!=""&&isNaN(period)){
	        	   common.alert("提示","届数必须为数字！");
	               return; 
	            }
	           if(password2!=""){
	        	   password = password2;
//	        	   common.confirm("提示","您没有输入密码，是否使用默认密码123456？",function() {
//	        		   $("#password").val("123456");
//	        		   password ="123456";
//	        		   return;
//	        	   	},function() {return;});
	           } 
	           var param = {
	        		   name : name,
	        		   password : password,
	        		   period : period+""
	        		   };
	           common.post(param,"login/addStaff",function(data){
	               	if(data.resultCode=='0'){
	               		common.menu("login/mainHome");
	               	}else if(data.resultCode=='2'){
	               		common.alert("提示","注册成功，温馨提示："+data.resultMsg);
	               		common.menu("login/mainHome");
	               	}else{
	               		if(data.resultMsg!=null){
	               		$("#resultMsg").text(data.resultMsg);
	               		$("#Waring").show();
	               		common.alert("提示","注册失败，温馨提示："+data.resultMsg);
	               		}
	               	}               	
	               });
	    		};  
	var _webChatShow = function() {	
		$("#loginForm").hide("slow");
		$("#weChatLoginForm").show("slow");
	};
	var _webChatBack = function() {	
		$("#loginForm").show("slow");
		$("#weChatLoginForm").hide("slow");
	};
		
	return{
		webChatBack : _webChatBack,
		webChatShow : _webChatShow,
		addStaff : _addStaff,
		login : _login,
		simulateLogin : _simulateLogin
	};
})();
$(function() {
	document.onkeydown = function(event) {
		var e = event || window.event
				|| arguments.callee.caller.arguments[0];
		if (e && e.keyCode == 13) { // enter 键
			login.login();
		}
	};
	var name =$.cookie("name");
	var pass = $.cookie("pass");
	var type = $.cookie("type");
	if(name!=null&&name!=undefined){
		$("#userName").val(name);
	}
	if(pass!=null&&pass!=undefined){
		$("#password").val(pass);
	}
	if(type!=null&&type!=undefined){
		$("#loginType input").each(function(){		
			if($(this).val()==type)
				$(this).attr("checked","checked");
		});
	}
});