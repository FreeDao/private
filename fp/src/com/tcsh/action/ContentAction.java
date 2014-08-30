package com.tcsh.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tcsh.common.BaseAction;
import com.tcsh.common.PageUtil;
import com.tcsh.model.Content;
import com.tcsh.service.ContentService;


@Component("contentAction")
@Scope("prototype")
public class ContentAction extends BaseAction{

	@Autowired
	private ContentService contentService;

	private PageUtil pu;
	private Integer pageNow;
	private Integer limit ;
	
	private Content Content;
	
	/**
	 * 查询所有内容
	 * @return
	 */
	public String index(){
		try {
			pu = contentService.findContentList(pageNow,limit);
			pu.setUrl("bg/content!index");
			return "index";
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("ContentAction中方法index出错");
		}
		return ERROR;
	}

	/**
	 * 删除指定行业资讯
	 * @return
	 */
	public String delContent(){
		try {
			contentService.delObjById(Content.class,Content.getId());
			request.setAttribute("msg", 1);
			return index();
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg", 0);
			log.debug("ContentAction中方法delContent出错");
			return index();
		}
	}
	
	/**
	 * 跳转到添加和修改页面
	 * @return
	 */
	public String goAddOrEdit(){
		try {
			if( null != Content){
				Content = (Content) contentService.findObjById(Content.class,Content.getId());
			}
			return "addOrEdit";
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("ContentAction中方法goAddOrEdit出错");
		}
		return ERROR;
	}
	
	/**
	 * 添加或修改信息
	 * @return
	 */
	public String addOrEdit(){
		try {
			Content e = new Content();
			if( null != Content.getId() ){
				e = (Content) contentService.findObjById(Content.class, Content.getId());
			}else{
				
			}
			
			contentService.saveOrUpdateObj(Content);
			request.setAttribute("msg", 1);
			return index();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("msg", 0);
			log.debug("ContentAction中方法addOrEdit出错");
			return index();
		}
	}

	public Content getContent() {
		return Content;
	}

	public void setContent(Content Content) {
		this.Content = Content;
	}

	public PageUtil getPu() {
		return pu;
	}

	public void setPu(PageUtil pu) {
		this.pu = pu;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
