package com.multi.travel.DAO;

import com.multi.travel.VO.TravelVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TravelDao {
    List<TravelVO> selectAll(int page, int pageSize);
    List<TravelVO> selectByDistrict(String district);
    List<TravelVO> search(String keyword);
    void insert(TravelVO vo);
    TravelVO resultSetToVO(ResultSet rs) throws SQLException;
}
