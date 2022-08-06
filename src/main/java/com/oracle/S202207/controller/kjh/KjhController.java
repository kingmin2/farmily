package com.oracle.S202207.controller.kjh;

import java.net.http.HttpResponse;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.S202207.domain.kjh.Host;
import com.oracle.S202207.domain.kjh.Res;
import com.oracle.S202207.domain.kjh.Rev;
import com.oracle.S202207.service.kjh.KjhService;

@Controller
public class KjhController {
	
	private final KjhService js;

	@Autowired
	public KjhController(KjhService js) {
		this.js=js;
	}
	
	
	private static final Logger logger=LoggerFactory.getLogger(KjhController.class);
	
	@RequestMapping(value = "myPage")
	public String main(Model model) {
		System.out.println("KjhController myPage Starts...");
		return "kjh/myPage";
	}
	
	// 호스트 리스트 
	@RequestMapping(value = "HostSearch")
	public String hostSearch(Model model) {
		System.out.println("KjhController HostSearch Starts...");
		List<Host> hosts=js.hostList();
		model.addAttribute("hostList", hosts);
		return "kjh/hostSearch";
	}
	
	// 호스트 리스트 상세 보기 
	@RequestMapping(value = "HostDetail")
	public String hostDetail(HttpServletRequest request, HttpServletResponse response, int farmno, Model model) {
		System.out.println("KjhController HostDetail Starts...");
		System.out.println("KjhController HostDetail farmno "+farmno);
		
		// 호스트 정보
		Host host=js.hostDetail(farmno);
		
		// 상세주소 용 (로그인 세션 잡히면)
//		String userno=(String)request.getSession().getAttribute("userno"); 
//		int membership;
// 		int revAuth;
//		if(userno!=null) {
//			int userno1=Integer.parseInt(userno);
//			membership=js.memshipchk(userno1);
//		} else {
//			membership=0; 
//		}
		
		// 멤버쉽 여부(상세주소)
		int userno=6; // 임의로 잡아줬음 로그인 하면 변경이 될 예정 
		int membership=js.memshipchk(userno);
		System.out.println("KjhController membership"+membership);
		
		// 리뷰 작성 권한 (임의로 userno 잡았음)  revAuth (userno가 없는 경우 null로 넘기자. -1 회원가입)
		List<Res> res=js.revAuthchk(farmno, userno);
		
		// 리뷰
		List<Rev> revList=js.revList(farmno);
		
		model.addAttribute("info", host);
		model.addAttribute("membercheck", membership);
		model.addAttribute("revList", revList);
		model.addAttribute("res", res);
		
		return "kjh/hostDetail";
	}
	
	// 호스트 상세 조건 팝업창
	@RequestMapping(value = "HostSearchOpt")
	public String hostSearchOpt(Model model) {
		System.out.println("KjhController HostSearchOpt Starts...");
		return "kjh/hostSearchOpt";
	}
	
	// 호스트 상세 조건 팝업창 선택 제출 
	@RequestMapping(value = "HostSearchOptSubmit")
	public String hostSearchOptSubmit(Date startdate, Date endate, int ppl, Model model) {
		System.out.println("KjhController HostSearchOptSubmit Starts...");
		return "kjh/hostSearchOpt";
	}
	
}
