<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<script type="text/javascript">

	//将表单数据转为json
	function form2Json(id) {
	
	    var arr = $("#" + id).serializeArray();
	    var jsonStr = "";
	
	   	jsonStr += '{';
	    for (var i = 0; i < arr.length; i++) {
	        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
	    }
	    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
	    jsonStr += '}'
	
	    var json = JSON.parse(jsonStr);
	    return json;
	}
	
	var url = "";
	$(function(){
		
		$("#dg").datagrid({
			idField:"id",
			url:"User/queryByPage",
			queryParams: form2Json("searchform"),//查询参数
			columns:[[
				{field:"",checkbox:true},
				{field:"id",title:"编号",width:100,align:"center"},
				{field:"username",title:"账号",width:100,align:"center"},
				{field:"password",title:"密码",width:100,align:"center"},
				{field:"name",title:"姓名",width:100,align:"center"},
				{field:"sex",title:"性别",width:100,align:"center",formatter: function(value,row,index){
					if (value==1){
						return "男";
					} else {
						return "女";
					}
				}
				},
				{field:"phone",title:"联系方式",width:100,align:"center"},
				{field:"address",title:"联系地址",width:100,align:"center"},
				{field:"email",title:"邮箱",width:100,align:"center"},
				{field:"photo",title:"用户头像",width:100,align:"center"},
				{field:"role",title:"所属角色",width:100,align:"center"},
				{field:"createTime",title:"创建时间",width:100,align:"center"}
				
			]],
			fitColumns:true,
			toolbar: [{
				text:"新增",
				iconCls: 'icon-add',
				handler: function(){
					add();
				}
			},'-',{
				text:"修改",
				iconCls: 'icon-edit',
				handler: function(){
					update();
				}
			},'-',{
				text:"删除",
				iconCls: 'icon-remove',
				handler: function(){
					remove();
				}
				},'-',{
					text:"分配角色",
					iconCls: 'icon-add',
					handler: function(){
						setRole();
					}
				}],
				pagination:true,
				pageSize:30,
				onLoadSuccess:function(data){
					$("#rolegrid").datagrid({
						idField:"id",
						url:"PublicNumber/queryByPage",
						queryParams: form2Json("searchform"),//查询参数
						columns:[[
							{field:"",checkbox:true},
							{field:"id",title:"编号",width:100,align:"center"},
							{field:"public_id",title:"公众号账号",width:100,align:"center"},
							{field:"public_name",title:"公众号昵称",width:100,align:"center"},
							{field:"public_type",title:"公众号性质",width:100,align:"center"},
							{field:"name",title:"公众号注册人名称",width:100,align:"center"},
							{field:"phone",title:"公众号注册联系方式",width:100,align:"center"},
							{field:"address",title:"公众号注册联系地址",width:100,align:"center"},
							{field:"logo",title:"公众号logo图片",width:100,align:"center"},
							{field:"regDate",title:"公众号注册日期",width:100,align:"center"},
							{field:"createTime",title:"创建时间",width:100,align:"center"}
						]],
						pagination:true,
						pageSize:20,
						fitColumns:true
					
					});
				}
			});
		
		//点击搜索
		$("#search_btn").click(function() {
            $('#dg').datagrid({ 
            	queryParams: form2Json("searchform")
            });   
        });
		
		/* //点击导出
		$("#export_btn").click(function(){
			$.messager.confirm("确定信息","确定要下载User.xls文件吗？",function(r){
				if(r){
					location.href="UserServlet?opType=downloadxls&fileName=User.xls"
				}
			});
		}); */
		
	});
	//分配角色
	function setRole(){
		var array = $("#dg").datagrid("getSelections");
		if(array.length==0){
			$.messager.alert("提示","请选择记录","info");
			return;
		}
		//用户的编号Id
		var uids = "";
		for(var i=0;i<array.length;i++){
			uids += array[i].id+",";
		}
		uids = uids.substring(0,uids.length-1);
		$.ajax({
			url:"User/getOwnerRoles",
			type:"post",
			data:"uids="+uids,
			dataType:"json",
			success:function(result){
				$("#role").dialog({
					title:"菜单列表",
					buttons:[{
						text:'分配菜单',
						iconCls:"icon-save",
						handler:function(){
							saveRole(uids);
						}
					},{
						text:'关闭',
						iconCls:"icon-cancel",
						handler:function(){
							$("#role").dialog("close");
						}
					}]
				});
				for(var i=0;i<result.length;i++){
					//根据后台返回的角色id，设置列表框默认选中状态
					$("#rolegrid").datagrid("selectRecord",result[i].id);
				}
				//打开对话框
				$("#role").dialog("open");
			}
		});
	}
	//保存角色
	function saveRole(uids){
		var array = $("#rolegrid").datagrid("getSelections");
		if(array.length==0){
			$.messager.alert("提示","请选择角色","info");
			return;
		}
		//角色的编号Id
		var pids = "";
		for(var i=0;i<array.length;i++){
			pids += array[i].id+",";
		}
		pids = pids.substring(0,pids.length-1);
		$.ajax({
			url:"User/saveRole",
			type:"post",
			data:"uids="+uids+"&pids="+pids,
			dataType:"json",
			success:function(result){
				if(result.state==0){
					$.messager.alert("提示",result.msg,"info");
				}else{
					$.messager.alert("提示",result.msg,"error");
				}
				//清除之前选择的所有行
				$("#rolegrid").datagrid("clearSelections");
				//关闭对话框
				$("#role").dialog("close");
			}
		});
	}
	//删除记录
	function remove(){
		var array = $("#dg").datagrid("getSelections");
		if(array.length==0){
			$.messager.alert("提示","请选择要删除的记录","info");
			return;
		}
		$.messager.confirm("提示","你确定要删除这"+array.length+"条记录吗？",function(r){
			if(r){
				var ids = "";
				for(var i=0;i<array.length;i++){
					ids += array[i].id+",";
				}
				ids = ids.substring(0,ids.length-1);
				$.ajax({
					url:"User/deleteMore",
					type:"post",
					data:"ids="+ids,
					dataType:"json",
					success:function(result){
						if(result.state==0){
							//刷新页面
							$("#dg").datagrid("reload");
							$.messager.alert("提示",result.msg,"info");
						}else{
							$.messager.alert("提示",result.msg,"error");
						}
						//清除之前选择的所有行
						$("#dg").datagrid("clearSelections");
					}
				});
			}
		});
	}
	//打开弹出框
	function openFormDialog(){
		$("#dd").dialog({
			buttons:[{
				text:'保存',
				iconCls:"icon-save",
				handler:function(){
					save();
				}
			},{
				text:'关闭',
				iconCls:"icon-cancel",
				handler:function(){
					$("#dd").dialog("close");
				}
			}]
		});
		//打开对话框
		$("#dd").dialog("open");
	}
	//新增记录
	function add(){
		//重置表单内容
        $("#ff").form("reset");
		//新增记录的请求地址
		url = "User/add";
		//打开弹出框
		openFormDialog();
		//设置弹出框标题
		$("#dd").dialog("setTitle","新增学生信息");
	}
	//修改记录
	function update(){
		var array = $("#dg").datagrid("getSelections");
		if(array.length==0){
			$.messager.alert("提示","请选择要修改的记录","info");
			return;
		}else if(array.length>1){
			$.messager.alert("提示","每次只能修改一条记录","info");
			return;
		}
		//重置表单内容
        $("#ff").form("reset");
      	//修改记录的请求地址
		url = "User/update?id="+array[0].id;
		//表单填充内容
        $("#ff").form("load",array[0]);
      	//打开弹出框
		openFormDialog();
		//设置弹出框标题
		$("#dd").dialog("setTitle","修改学生信息");
	}
	//保存或者更新数据
	function save(){
		$("#ff").form("submit",{
			url:url,
			onSubmit:function(){
				//调用validate方法校验表单中所有的字段有效性，只有所有的字段有效才返回true
				return $(this).form("validate");
			},
			success:function(result){
				//接收服务器返回的json格式字符串数据转换成json对象
			 	var data = eval('(' + result + ')');   
		        if (data.state==0){    
		           	$.messager.alert("提示消息",data.msg,"info"); 
		           	//刷新列表
		           	$("#dg").datagrid("reload");
		        } else{
		        	$.messager.alert("提示消息",data.msg,"error");
		        }
		        //关闭弹出框
		        $("#dd").dialog("close");
			}
		});
	}
	
</script>
<style type="text/css">
	
	.right{
		text-align: right;
	}
</style>
</head>
<body>
	<div style="height: 5%">
		<div style="width:66%;height: 5%;float:left">
		<form name="searchform" method="post" id ="searchform">
			账号：<input type="text" name="qusername" class="easyui-textbox" >
			姓名：<input type="text" name="qname" class="easyui-textbox">
		        <a id="search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
	  	</form>
	  	</div>
		
  	</div>
  	
  	<div style="height: 95%">
		<table id="dg" fit="true"></table>
	</div>
	<div id="dd" class="easyui-dialog" style="width: 400px;text-align: center;padding: 10px;" closed="true">
		<form id="ff" method="post">
			<table style="margin: 0 auto;">
				<!-- <tr>
					<td class="right">编号：</td>
					<td><input type="text" name="id" class="easyui-textbox" data-options="required:true"></td>
				</tr> -->
				<tr>
					<td class="right">账号：</td>
					<td><input type="text" name="username" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">密码：</td>
					<td><input type="password" name="password" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">姓名：</td>
					<td><input type="text" name="name" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">性别：</td>
					<td>
						<input type="radio" name="sex" value="1" checked="checked">男
						<input type="radio" name="sex" value="0">女
					</td>
				</tr>
				<tr>
					<td class="right">联系方式：</td>
					<td><input type="text" name="phone" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">联系地址：</td>
					<td><input type="text" name="address" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">邮箱：</td>
					<td><input type="text" name="email" class="easyui-textbox" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="right">用户头像：</td>
					<td><input id="sc"  name="photo" class="easyui-filebox" data-options="buttonText:'选择头像'"></td>
				</tr>
				<tr>
					<td class="right">所属角色：</td>
					<td>
					<select name="role" data-options="editable:false" class="easyu-comboxx">
					<option value="管理员">管理员</option>
					<option value="公众号运营员">公众号运营员</option>
					<option value="营业员">营业员</option>
					</select>

					</td>
				</tr>
				
			</table>
		</form>
	</div>
	<div id="role" class="easyui-dialog" style="width: 400px;text-align: center;" closed="true">
		<table id="rolegrid"></table>
	</div>
</body>
</html>