package org.pgm.demo.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.pgm.demo.dto.BoardDTO;
import org.pgm.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/register")
    public void registerGet() {
        log.info("registerGet");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO) {
        log.info("registerPost");
        boardService.register(boardDTO);
        return "redirect:/board/list"; // redirection은 다시 controller를 선택하라는 의미
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("bno") int bno, Model model) {
        log.info("read");
        BoardDTO dto = boardService.getOne(bno);
        model.addAttribute("dto", dto);
    } //read와 modify는 같은 화면을 사용하기 때문에 같은 메서드를 사용

    @PostMapping("/modify")
    public String modifyPost(BoardDTO boardDTO) {
        log.info("modifyPost");
        boardService.modify(boardDTO);
        return "redirect:/board/read?bno=" + boardDTO.getBno();
    } //수정된 내용을 다시 read로 보내기 위해 redirect 사용

    @GetMapping("/remove")
    public String remove(int bno) {
        log.info("remove");
        boardService.remove(bno);
        return "redirect:/board/list";
    }


}
