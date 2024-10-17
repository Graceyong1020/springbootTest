package org.pgm.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pgm.demo.dto.BoardDTO;

import java.util.List;
@Mapper
public interface BoardMapper {

    List<BoardDTO> selectAll(); //모든 게시글을 조회
    BoardDTO selectOne(int bno); //게시글 번호를 이용하여 해당 게시글을 조회
    void insert(BoardDTO board);
    void update(BoardDTO board);
    void delete(int bno);
    void visitCountUpdate(int bno);


}
