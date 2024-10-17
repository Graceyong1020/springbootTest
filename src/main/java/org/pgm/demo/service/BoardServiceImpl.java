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

    @Override
    public BoardDTO getOne(int bno) {
        boardMapper.visitCountUpdate(bno); //한번 조회시 조회수 증가
        return boardMapper.selectOne(bno);
    } //BoardMapper를 통해서 selectOne한 결과를 가져온다. 이때 반환된 BoardVO를 BoardDTO로 변환하여 반환

    @Override
    public void register(BoardDTO boardDTO) {
        boardMapper.insert(boardDTO);
    } //BoardMapper를 통해서 insert한 결과를 가져온다. 이때 반환된 BoardVO를 BoardDTO로 변환하여 반환

    @Override
    public void modify(BoardDTO boardDTO) {
        BoardDTO dto = boardMapper.selectOne(boardDTO.getBno()); //수정할 게시글의 번호를 이용하여 해당 게시글을 조회
        //dto.setVisitcount(boardDTO.getVisitcount()); //수정할 게시글의 조회수를 수정
        //dto.setPostdate(boardDTO.getPostdate()); //수정할 게시글의 작성일을 수정
        boardMapper.update(boardDTO);
    }

    @Override
    public void remove(int bno) {
        boardMapper.delete(bno);
    }
}
