package org.pgm.demo.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.pgm.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired //의존성 주입
    private BoardService boardService; //final 추가시 @RequiredArgsConstructor 추가

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("boardList", boardService.getList());
    }


}
