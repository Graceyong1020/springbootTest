package org.pgm.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.demo.dto.BoardDTO;
import org.pgm.demo.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;


    @Override
    public List<BoardDTO> getList() {
        return boardMapper.selectAll(); //BoardMapper를 통해서 select한 결과를 가져온다. 이때 반환된 List<BoardVO>를 List<BoardDTO>로 변환하여 반환
    }
}
