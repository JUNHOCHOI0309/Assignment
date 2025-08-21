package com.multi.travel.SERVICE;

import com.multi.travel.VO.TravelVO;

import java.util.List;

public interface TravelService {
    List<TravelVO> selectAll(int page, int pageSize);
    List<TravelVO> selectByDistrict(String district);
    List<TravelVO> search(String keyword);
    void addTravel(TravelVO vo);
}
