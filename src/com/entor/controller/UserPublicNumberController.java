package com.entor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.entor.dao.UserPublicNumberDao;


import com.entor.entity.UserPublicNumber;

import com.entor.service.UserPublicNumberService;
import com.entor.vo.UserPublicNumberVo;

@Controller
@RequestMapping("/UserPublicNumber")
public class UserPublicNumberController {

	@Resource
	private UserPublicNumberService UserPublicNumberService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@RequestMapping("/add")
	public void add(UserPublicNumber UserPublicNumber) {
		JSONObject jo = new JSONObject();
		PrintWriter out = null;
		try {
			UserPublicNumber.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			out = response.getWriter();
			UserPublicNumberService.add(UserPublicNumber);
			jo.put("state", 0);
			jo.put("msg", "�����ɹ�");
		}catch(Exception e) {
			jo.put("state", -1);
			jo.put("msg", "����ʧ��"+e.getMessage());
		}finally {
			String str = JSON.toJSONString(jo);
			System.out.println(str);
			out.write(str);
			out.flush();
			out.close();
		}
	}
	@RequestMapping("/deleteMore")
	public void deleteMore(String ids) {
		JSONObject jo = new JSONObject();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			UserPublicNumberService.deleteMore(UserPublicNumber.class,ids);
			jo.put("state", 0);
			jo.put("msg", "ɾ���ɹ�");
		}catch(Exception e) {
			jo.put("state", -1);
			jo.put("msg", "ɾ��ʧ��"+e.getMessage());
		}finally {
			String str = JSON.toJSONString(jo);
			System.out.println(str);
			out.write(str);
			out.flush();
			out.close();
		}
	}
	@RequestMapping("/update")
	public void update(UserPublicNumber UserPublicNumber) {
		JSONObject jo = new JSONObject();
		PrintWriter out = null;
		try {
			out = response.getWriter();

			UserPublicNumberService.update(UserPublicNumber);
			jo.put("state", 0);
			jo.put("msg", "�޸ĳɹ�");
		}catch(Exception e) {
			jo.put("state", -1);
			jo.put("msg", "�޸�ʧ��"+e.getMessage());
		}finally {
			String str = JSON.toJSONString(jo);
			System.out.println(str);
			out.write(str);
			out.flush();
			out.close();
		}
	}
	@RequestMapping("/queryByPage")
	public void queryByPage(String page) {
		
		String qname = request.getParameter("qname");
		String qUserPublicNumbername = request.getParameter("qUserPublicNumbername");
		String qsex = request.getParameter("qsex");
		String qbeginDate = request.getParameter("qbeginDate");
		String qendDate = request.getParameter("qendDate");
		//鑾峰彇姣忛�?�鏄剧ず璁板綍鏁�?
		String rows = request.getParameter("rows");
	
		String condition = " where 1=1 ";
		if(qname!=null&&!qname.equals("")&&!qname.equalsIgnoreCase("null")){
			condition += " and name like '%"+qname+"%'";
		}
		if(qUserPublicNumbername!=null&&!qUserPublicNumbername.equals("")&&!qname.equalsIgnoreCase("null")){
			condition += " and UserPublicNumbername like '%"+qUserPublicNumbername+"%'";
		}
		if(qsex!=null&&!qsex.equals("")&&!qsex.equals("-1")&&!qname.equalsIgnoreCase("null")){
			condition += " and sex = "+qsex;
		}
		if(qbeginDate!=null&&!qbeginDate.equals("")) {
			condition += " and birthday >= '"+qbeginDate+"'";
		}
		if(qendDate!=null&&!qendDate.equals("")) {
			condition += " and birthday <= '"+qendDate+"'";
		}

		//褰撳墠椤�?
		int sp = 1;
		//鎬昏褰曟暟
		int totals = UserPublicNumberService.getTotals(UserPublicNumber.class);
		//姣忛〉璁板綍鏁�
		int pageSize = Integer.parseInt(rows);
		//鎬婚〉鏁�?
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0){
			pageCounts++;
		}
		try{
			sp = Integer.parseInt(page);
		}catch(Exception e){
			sp = 1;
		}
		if(sp>pageCounts){
			sp = pageCounts;
		}
		if(sp<1){
			sp = 1;
		}
		List<UserPublicNumberVo> list =UserPublicNumberService.aqueryByPage(sp, pageSize);
		try {
			PrintWriter out = response.getWriter();
			JSONObject jo = new JSONObject();
			jo.put("total", totals);
			jo.put("rows", list);
			String json = JSON.toJSONString(jo);
			System.out.println(json);
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@RequestMapping("/saveRole")
//	public void saveRole(String uids,String rids) {
//		List<UserPublicNumberRole> list = new ArrayList<>();
//		UserPublicNumberRoleDao.deleteUserPublicNumberRolesByUids(uids);
//		for(String uid:uids.split(",")) {
//			for(String rid:rids.split(",")) {
//				UserPublicNumberRole UserPublicNumberRole = new UserPublicNumberRole();
//				UserPublicNumberRole.setUid(Integer.parseInt(uid));
//				UserPublicNumberRole.setRid(Integer.parseInt(rid));
//				list.add(UserPublicNumberRole);
//			}
//		}JSONObject jo = new JSONObject();
//		PrintWriter out = null;
//		try {
//			out = response.getWriter();
//			addMore(list);
//			jo.put("state", 0);
//			jo.put("msg", "分配成功");
//		}catch(Exception e) {
//			jo.put("state", -1);
//			jo.put("msg", "分配失败"+e.getMessage());
//		}finally {
//			String str = JSON.toJSONString(jo);
//			System.out.println(str);
//			out.write(str);
//			out.flush();
//			out.close();
//		}
//		
//	}
//	@RequestMapping("/getOwnerRoles")
//	public void getOwnerRoles(String uids) {
//		try {
//			PrintWriter out = response.getWriter();
//			RoleDao dao = new RoleDaoImpl();
//			List<Role> list = dao.queryAllRolesByUids(uids);
//			String str = JSON.toJSONString(list);
//			System.out.println(str);
//			out.write(str);
//			out.flush();
//			out.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	@RequestMapping("/queryAll")
	public void queryAll() {
		List<UserPublicNumber>list=UserPublicNumberService.queryAll(UserPublicNumber.class);
		try {
			PrintWriter out = response.getWriter();
			String json = JSON.toJSONString(list);
			System.out.println(json);
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 澶勭悊鍙傛暟涓烘棩鏈熸牸寮�
	 * @param binder
	 */
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.response.setContentType("text/html;charset=utf-8");
	}
}
