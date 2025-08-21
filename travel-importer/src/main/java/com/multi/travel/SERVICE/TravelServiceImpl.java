package com.multi.travel.SERVICE;

import com.multi.travel.DAO.TravelDaoImpl;
import com.multi.travel.VO.TravelVO;

import java.util.List;


public class TravelServiceImpl implements TravelService{
    private static TravelService travelService = new TravelServiceImpl();
    private TravelDaoImpl travelDao = new TravelDaoImpl();

    public static TravelService getInstace(){
        return travelService;
    }

    @Override
    public List<TravelVO> selectAll(int page, int pageSize) {
        return travelDao.selectAll(page, pageSize);
    }

    @Override
    public List<TravelVO> selectByDistrict(String district) {
        return travelDao.selectByDistrict(district);
    }

    @Override
    public List<TravelVO> search(String keyword) {
        return travelDao.search(keyword);
    }

    @Override
    public void addTravel(TravelVO vo) {
        travelDao.insert(vo);
    }
}
