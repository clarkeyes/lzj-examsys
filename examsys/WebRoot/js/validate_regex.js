//验证正整数
jQuery.validator.addMethod( "intNumber",function(value,element){      
            var pattern =/^\d+$/;   
            if(!pattern.test(value)){return false;}  
            return true;    
     } ,  "  <font color='red'>请输入正整数</font>" );     


//验证类别（新建类别和选择类别只能二选一）
jQuery.validator.addMethod( "chooseOne",function(value,element){      
            if( ( $("#newClassInput").val()==""&&$("#classListSelect").val()!="" ) || ( $("#classListSelect").val()==""&&$("#newClassInput").val()!="" ) )
            {return true;}
            else{
            return false;
            }
     } ,  "  <font color='red'>新建类别和选择类别只能二选一</font>" );     

//验证合法名称，可以是汉字的，可以为空
jQuery.validator.addMethod( "avaiNameAndNull",function(value,element){      
            var pattern =/^[\w|\u4e00-\u9fa5]+$/;  
            if(value==""||value==null){return true;} 
            if(!pattern.test(value)){return false;}  
            return true;    
     } ,  "  <font color='red'>请输入字母、数字、汉字和下划线</font>" );     
//验证合法名称，可以为空
jQuery.validator.addMethod( "avaiWordAndNull",function(value,element){      
           var pattern =/^\w*$/;  
            if(!pattern.test(value)){return false;}  
            return true;    
     } ,  "  <font color='red'>请输入字母、数字、汉字和下划线</font>" );     


//验证合法名称
jQuery.validator.addMethod( "avaiWord",function(value,element){      
            var pattern =/^\w+$/;   
            if(!pattern.test(value)){return false;}  
            return true;    
     } ,  "  <font color='red'>请输入字母、数字和下划线</font>" );     
//验证合法名称，可以是汉字的
jQuery.validator.addMethod( "avaiName",function(value,element){      
            var pattern =/^[\w|\u4e00-\u9fa5]+$/;   
            if(!pattern.test(value)){return false;}  
            return true;    
     } ,  "  <font color='red'>请输入字母、数字、汉字和下划线</font>" );     

//验证邮政编码   
    jQuery.validator.addMethod( "checkPost",function(value,element){      
            var pattern =/^[0-9]{6}$/;   
            if(value !=''){if(!pattern.exec(value)){return false;}};   
            return true;    
     } ,  "  <font color='red'>请输入有效的邮政编码！</font>" );      
       
  
    //验证手机   
    jQuery.validator.addMethod( "checkMobile",function(value,element){      
         var reg0 = /^13\d{5,9}$/;   
         var reg1 = /^15\d{5,9}$/;   
         var reg2 = /^189\d{4,8}$/;   
         var reg3 = /^0\d{10,11}$/;   
         var my = false;   
         if (reg0.test(value))my=true;   
         if (reg1.test(value))my=true;   
         if (reg2.test(value))my=true;   
         if (reg3.test(value))my=true;   
         if(value!=''){if(!my){return false;}};   
        return true;    
     } ,  "  <font color='red'>请输入有效的手机号码！</font>" );      
  
       
    //验证邮箱   
    jQuery.validator.addMethod( "checkEmail",function(value,element){      
            var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;   
            if(value !=''){if(!myreg.test(value)){return false;}};   
            return true;    
     } ,  "  <font color='red'>请输入有效的E_mail！</font>" );    
  
    //验证固定电话   
    jQuery.validator.addMethod( "checkTel",function(value,element){      
        var pattern =/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;   
        if(value!=''){if(!pattern.exec(value)){return false;}};   
        return true;    
    } ,  "  <font color='red'>请输入有效的固定电话！</font>" );  
         
    // 联系电话(手机/电话皆可)验证   
	jQuery.validator.addMethod("isPhone", function(value,element) {    
	   var length = value.length;    
	   var mobile = /^(\d{11})$/;    
       var tel = /^\d{3,4}-\d{7,9}$/;    
       return this.optional(element) || (tel.test(value) || mobile.test(value));    
	}, "<font color='red'>请正确填写您的联系电话</font>");  
	     
         //验证数量范围
    jQuery.validator.addMethod( "checkNumBound",function(value,element){      
        var pattern =/^\[\d+,\d+\]$/;   
        if(value!=''){if(!pattern.exec(value)){return false;}};   
        return true;    
    } ,  "  <font color='red'>请输入有效的范围，eg:[1,2]</font>" );   
    
    //验证ip格式
    jQuery.validator.addMethod( "checkIp",function(value,element){      
        var pattern =/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;   
        if(value!=''){if(!pattern.exec(value)){return false;}};   
        return true;    
    } ,  "  <font color='red'>IP格式错误</font>" );   
    
    //验证日期格式为：2011/10/24
    jQuery.validator.addMethod( "checkDate",function(value,element){      
        var pattern =/^\d{4}((\/\d{2}){2})$/;   
        if(value!=''){if(!pattern.exec(value)){return false;}};   
        return true;    
    } ,  "  <font color='red'>日期格式错误，例：2011/10/24</font>" );
       
    //验证企业名称是否重复   
    jQuery.validator.addMethod( "checkMirrorName",function(value,element){      
        var a=true;   
        jQuery.ajax({
        type:"post",
        url:"../mirrormanage/mirrorToMirrorAdd!validateMirror.action",   
        async:false,
        cache:false,
        data:{"mirror.mirName":$("#mirName").val()}, 
        dateType:"json",
        scriptCharset:"UTF-8",
       success:function(data){
							if(data.result == "exist")
							{
								a=false;
							}
							else if(data.result == "error")
							{
								a=false;
							}else 
							{
								a=true;
							}
						} });   
        return a;   
    } ,  "  <font color='red'>此企业(店)名称已经被占用！请您更换其它名称！</font>" );       
 
   