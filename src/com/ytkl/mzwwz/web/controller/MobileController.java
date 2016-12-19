package com.ytkl.mzwwz.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ytkl.mzwwz.criteria.LinkInfoCriteria;
import com.ytkl.mzwwz.criteria.NewsBookCriteria;
import com.ytkl.mzwwz.criteria.NewsBookImgCriteria;
import com.ytkl.mzwwz.criteria.NewsCriteria;
import com.ytkl.mzwwz.criteria.OrgGuideCriteria;
import com.ytkl.mzwwz.domain.CommonPara;
import com.ytkl.mzwwz.domain.LinkInfo;
import com.ytkl.mzwwz.domain.News;
import com.ytkl.mzwwz.domain.NewsBook;
import com.ytkl.mzwwz.domain.NewsBookImg;
import com.ytkl.mzwwz.domain.OrgGuide;
import com.ytkl.mzwwz.domain.Message;
import com.ytkl.mzwwz.service.CommonParaService;
import com.ytkl.mzwwz.service.LinkInfoService;
import com.ytkl.mzwwz.service.MessageApplyService;
import com.ytkl.mzwwz.service.MessageService;
import com.ytkl.mzwwz.service.NewsBookImgService;
import com.ytkl.mzwwz.service.NewsBookService;
import com.ytkl.mzwwz.service.NewsService;
import com.ytkl.mzwwz.service.OrgGuideService;

@Controller
public class MobileController {

	@Autowired
	private CommonParaService commonParaService;
	@Autowired
	private OrgGuideService orgGuideService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsBookService newsBookService;
	@Autowired
	private NewsBookImgService newsBookImgService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageApplyService messageApplyService;
	@Autowired
	private LinkInfoService linkInfoService;

	/**
	 * 机构职能
	 * 
	 * @param commonParaCriteria
	 * @param code
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/common.do")
	public String detail(String code, ModelMap model) {
		CommonPara commonPara = commonParaService.select(code);

		model.addAttribute("commonPara", commonPara);

		return "mobile/common";
	}

	/**
	 * 办事指南列表
	 * 
	 * @param orgGuideCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/guide.do")
	public String list(ModelMap model) {
		List<OrgGuide> orgGuideList = orgGuideService.list(new OrgGuideCriteria("1"));

		model.addAttribute("orgGuideList", orgGuideList);

		return "mobile/guide";
	}

	/**
	 * 办事指南详细
	 * 
	 * @param orgGuideCriteria
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/guideDetail.do")
	public String guideDetail(int id, ModelMap model) {
		OrgGuide orgGuide = orgGuideService.select(id);

		model.addAttribute("orgGuide", orgGuide);

		return "mobile/guideDetail";
	}

	/**
	 * 新闻页面
	 * 
	 * @param orgGuideCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/news.do")
	public String news(OrgGuideCriteria orgGuideCriteria, ModelMap model) {

		// 民政要闻
		List<News> mzywList = newsService.listOnPage(new NewsCriteria("1"));
		if (mzywList.size() > 5) {
			mzywList = mzywList.subList(0, 5);
		}
		// 县区动态
		List<News> xqdtList = newsService.listOnPage(new NewsCriteria("2"));
		if (xqdtList.size() > 5) {
			xqdtList = xqdtList.subList(0, 5);
		}
		// 近期焦点
		List<News> jqjdList = newsService.listOnPage(new NewsCriteria("3"));
		if (jqjdList.size() > 5) {
			jqjdList = jqjdList.subList(0, 5);
		}
		// 图片新闻
		List<NewsBook> bookList = newsBookService.list(new NewsBookCriteria());
		if (bookList.size() > 4) {
			bookList = bookList.subList(0, 3);
		}

		model.addAttribute("mzywList", mzywList);
		model.addAttribute("xqdtList", xqdtList);
		model.addAttribute("jqjdList", jqjdList);
		model.addAttribute("bookList", bookList);

		return "mobile/news";
	}

	/**
	 * 新闻更多
	 * 
	 * @param orgGuideCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/newsMore.do")
	public String newsMore(OrgGuideCriteria orgGuideCriteria, ModelMap model) {
		List<OrgGuide> orgGuideList = orgGuideService.listOnPage(orgGuideCriteria);

		model.addAttribute("orgGuideList", orgGuideList);

		return "mobile/newsMore";
	}

	/**
	 * 新闻详细
	 * 
	 * @param orgGuideCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/newsDetail.do")
	public String newsDetail(int id, ModelMap model) {
		News news = newsService.select(id);
		model.addAttribute("news", news);
		return "mobile/newsDetail";
	}

	@RequestMapping("/mobile/linkInfo.do")
	public String linkInfo(LinkInfoCriteria linkInfoCriteria, ModelMap model) {
		List<LinkInfo> linkInfoList = linkInfoService.list(linkInfoCriteria);

		model.addAttribute("linkInfoList", linkInfoList);
		model.addAttribute("linkInfoCriteria", linkInfoCriteria);

		return "mobile/linkInfo";
	}
	/**
	 * 民政动态
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/toMzdt.do")
	public String toMzdt(ModelMap model) {
		// 民政要闻
		List<News> mzywList = newsService.listOnPage(new NewsCriteria("1"));
		if (mzywList.size() > 5) {
			mzywList = mzywList.subList(0, 5);
		}
		// 县区动态
		List<News> xqdtList = newsService.listOnPage(new NewsCriteria("2"));
		if (xqdtList.size() > 5) {
			xqdtList = xqdtList.subList(0, 5);
		}
		// 近期焦点
		List<News> jqjdList = newsService.listOnPage(new NewsCriteria("3"));
		if (jqjdList.size() > 5) {
			jqjdList = jqjdList.subList(0, 5);
		}
		// 图片新闻
		List<NewsBook> bookList = newsBookService.list(new NewsBookCriteria());
		if (bookList.size() > 4) {
			bookList = bookList.subList(0, 3);
		}

		model.addAttribute("mzywList", mzywList);
		model.addAttribute("xqdtList", xqdtList);
		model.addAttribute("jqjdList", jqjdList);
		model.addAttribute("bookList", bookList);
		return "mobile/mzdt";
	}
	/**
	 * 留言
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/toMessage.do")
	public String Message(ModelMap model) {
		return "mobile/message";
	}
	/**
	 * 保存留言
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/saveMessage.do")
	public String saveMessage(Message message,ModelMap model) {
		message.setCreateTime(new Date());
		message.setReplyFlag("1");
		messageService.insert(message);
		return toMzdt(model);
	}
	/**
	 * 去新闻列表
	 * @param newsCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/toNewList.do")
	public String toNewList(NewsCriteria newsCriteria,ModelMap model){
		List<News> newsList = newsService.list(newsCriteria);
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsCriteria", newsCriteria);
		return "mobile/newsList";
	}
	/**
	 * 去图册目录列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/toNewBookList.do")
	public String toNewBookList(ModelMap model){
		List<NewsBook> newsBookList = newsBookService.list(new NewsBookCriteria());
		model.addAttribute("newsBookList", newsBookList);
		return "mobile/newsBookList";
	}
	/**
	 * 图册目录详细
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/newsBookDetail.do")
	public String newsBookDetail(int id, ModelMap model) {
		NewsBook newsBook = newsBookService.select(id);
		model.addAttribute("newsBook", newsBook);
		List<NewsBookImg> newsBookImgs = newsBookImgService.list(new NewsBookImgCriteria(newsBook.getId()));
		model.addAttribute("newsBookImgs", newsBookImgs);
		return "mobile/newsBookDetail";
	}
	
	/**
	 * 联系信息详情
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/mobile/linkInfoDetail.do")
	public String linkInfoDetail(int id, ModelMap model) {
		LinkInfo linkInfo = linkInfoService.select(id);
		model.addAttribute("linkInfo", linkInfo);
		return "mobile/linkInfoDetail";
	}
}
