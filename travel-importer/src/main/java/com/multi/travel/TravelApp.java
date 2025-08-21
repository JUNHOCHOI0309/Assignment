package com.multi.travel;

import com.multi.travel.SERVICE.TravelService;
import com.multi.travel.SERVICE.TravelServiceImpl;
import com.multi.travel.VO.TravelVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class TravelApp {
    private BufferedReader in;
    private TravelService service;
    public TravelApp(){
        in = new BufferedReader(new InputStreamReader(System.in));
        service = TravelServiceImpl.getInstace();
        menu();
    }

    private void menu(){
        while(true){
            System.out.println("-------- 관광지 관리 메뉴 --------");
            System.out.println("1. 전체 리스트");
            System.out.println("2. 권역별 목록");
            System.out.println("3. 검색");
            System.out.println("4. 신규 관광지 등록");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
            try{
                int sel = Integer.parseInt(in.readLine());
                switch (sel){
                    case 1:
                        listAll();
                        break;
                    case 2:
                        listDistrict();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        addTravel();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void listAll() throws Exception{
        System.out.println("페이지 번호: ");
        int page = Integer.parseInt(in.readLine());
        System.out.println("페이지당 개수: ");
        int size = Integer.parseInt(in.readLine());
        List<TravelVO> list = service.selectAll(page, size);
        System.out.println("** 전체 관광지 목록 **");
        for(TravelVO vo : list){
            System.out.println(vo);
        }
    }
    private void listDistrict() throws Exception{
        System.out.println("권역 입력: ");
        String district = in.readLine();
        List<TravelVO> list = service.selectByDistrict(district);
        System.out.println("**"+ district+ "관광지 목록 **");
        for(TravelVO vo : list){
            System.out.println(vo);
        }
    }

    private void search() throws Exception{
        System.out.println("검색어 입력: ");
        String keyword = in.readLine();
        List<TravelVO> list = service.search(keyword);
        System.out.println("** 검색 결과 관광지 목록 **");
        for(TravelVO vo : list){
            System.out.println(vo);
        }
    }
    private void addTravel() throws Exception{
        TravelVO vo = new TravelVO();
        System.out.println("권역: ");
        vo.setDistrict(in.readLine());
        System.out.println("제목: ");
        vo.setTitle(in.readLine());
        System.out.println("설명: ");
        vo.setDescription(in.readLine());
        System.out.println("주소: ");
        vo.setAddress(in.readLine());
        System.out.println("전화번호: ");
        vo.setPhone(in.readLine());
        service.addTravel(vo);
        System.out.println("관광지 등록 완료");
    }

    public static void main(String[] args) throws Exception{
        new TravelApp();
    }
}
