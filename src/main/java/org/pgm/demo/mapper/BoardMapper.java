package org.pgm.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.pgm.demo.dto.BoardDTO;

import java.util.List;
@Mapper
public interface BoardMapper {

    List<BoardDTO> selectAll();


}
