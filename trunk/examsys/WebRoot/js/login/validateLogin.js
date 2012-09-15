$(function(){
            $("form .required").blur(function(){//为表单元素添加失去焦点事件
                var $message=$(this).next();
                $message.find(".formTips").remove();//删除以前的提醒元素
                //验证用户名
                if($(this).is("#userAccount")){
                    var regex=/^\w+$/;
                    if(this.value==""){
                        var errorMsg="请输入账号";
                        $message.append("<span class='formTips onError'>"+errorMsg+"</span>");
                    }else{
						var okMsg="";
                        $message.append("<span class='formTips onSuccess'>"+okMsg+"</span>");
                    }
                }
                
                //验证密码
                if($(this).is("#userPassword")){
                    if(this.value==""){
                        var errorMsg="请输入密码";
                        $message.append("<span class='formTips onError'>"+errorMsg+"</span>");
                    }else{
                        var okMsg="";
                        $message.append("<span class='formTips onSuccess'>"+okMsg+"</span>");
                    }
                }
                
            });
            //单击“提交”时，为了使表单填写正确，在表单提交之前，需要对表单的必填元素进行一次整体的验证。
            $("#sub").click(function(){
                $("form .required").trigger("blur");
                var numError=$("form .onError").length;//错误的个数
                if(numError){
                    return false;//阻止表单提交
                }else{
                    $.post(
						"login.action",
						$("#loginForm").serialize(),
						function(data){
						    $("#message").find(".formTips").remove();//删除以前的提醒元素
						    $("#message").find("br").remove();
						    if(data.fieldErrors['loginuser.userName']!=null){
						        $("#userNameError").append("<span class='formTips onError'>"+data.fieldErrors['loginuser.userName']+"</span>");
						    }
						    if(data.fieldErrors['loginuser.userPassword']!=null){
						        $("#passwordError").append("<span class='formTips onError'>"+data.fieldErrors['loginuser.userPassword']+"</span>");
						    }
							if(data.result == "error")
							{
								var errorMsg="系统错误";
                                $("#message").html(errorMsg).removeClass("box box-info").addClass("box box-error");
							}else if(data.result=="userError"){
							    var errorMsg="账号或密码错误";
                                $("#message").html(errorMsg).removeClass("box box-info").addClass("box box-error");
							}
							else if(data.result == "manager")
							{
								window.location.href="pages/admin/exam_list.jsp";
							}else if(data.result == "commonUser")
							{
								window.location.href="pages/user/user_exam_start.jsp";
							}
						});
				 }
            });
            $("#res").click(function(){
			      $("#userName").val("");
			      $("#userPassword").val("");
			});
			$("body").bind("keyup",function(event){//按回车执行提交
			        //alert(event.keyCode);
			    if(event.keyCode==13){
			        $("#sub").trigger("click");
			    }
			});
        });