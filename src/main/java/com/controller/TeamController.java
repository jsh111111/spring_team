package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.TeamDTO;
import com.model.TeamMapper;
import com.model.TeamService;
import com.utility.Utility;

@Controller
public class TeamController {

	@Autowired
	private TeamMapper mapper;

	@Autowired
	private TeamService service;

	@GetMapping("/")
	public String home() {

		return "/home";
	}

	@GetMapping("/team/create")
	public String create() {

		return "/create";
	}

	@PostMapping("/team/create")
	public String create(TeamDTO dto) {
		int cnt = mapper.create(dto);

		if (cnt > 0) {
			return "redirect:/team/list";
		} else {
			return "error";
		}
	}

	@GetMapping("/team/list")
	public String list(HttpServletRequest request, Model model) {
		// 검색관련
		String col = Utility.chechNull(request.getParameter("col"));
		String word = Utility.chechNull(request.getParameter("word"));

		if (col.equals("total"))
			word = "";

		// 페이징관련
		int nowPage = 1;
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		// 한페이지당 보여줄 레코드 갯수
		int eno = 5;
		// 데이터베이스에서 시작 레코드 수
		int sno = (nowPage - 1) * eno;

		// 데이터베이스에서 목록 가져오기
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		List<TeamDTO> list = mapper.list(map);

		int total = mapper.total(map);

		String url = "list";

		String paging = Utility.paging(total, nowPage, eno, col, word, url);

		model.addAttribute("col", col);
		model.addAttribute("word", word);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

		return "/list";
	}

	@GetMapping("/team/read")
	public String read(int teamno, Model model, HttpServletRequest request) {

		TeamDTO dto = mapper.read(teamno);// 데이터 한건 조회
		model.addAttribute("dto", dto);

		return "/read";
	}

	@GetMapping("/team/update")
	public String update(int teamno, Model model) {

		model.addAttribute("dto", mapper.read(teamno));

		return "/update";
	}

	@PostMapping("/team/update")
	public String update(TeamDTO dto, String nowPage, String col, String word, RedirectAttributes redirect) {

		Boolean flag = false;
		int cnt = mapper.update(dto);

		if (cnt > 0)
			flag = true;

		if (flag) {
			redirect.addAttribute("nowPage", nowPage);
			redirect.addAttribute("col", col);
			redirect.addAttribute("word", word);
			return "redirect:/team/list";
		} else {
			return "error";
		}
	}

	@GetMapping("/team/delete")
	public String delete(@RequestParam Map<String, String> map, RedirectAttributes redirect) {

		boolean flag = false;

		try {
			int teamno = Integer.parseInt(map.get("teamno"));
			flag = service.delete(teamno);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (flag) {
			redirect.addAttribute("nowPage", map.get("nowPage"));
			redirect.addAttribute("col", map.get("col"));
			redirect.addAttribute("word", map.get("word"));

			return "redirect:/team/list";
		} else {
			return "error";
		}

	}

}
