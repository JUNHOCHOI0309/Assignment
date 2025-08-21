package com.multi.travel.DAO;

import com.multi.travel.VO.TravelVO;
import com.multi.travel.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelDaoImpl implements TravelDao{
    @Override
    public List<TravelVO> selectAll(int page, int pageSize) {
        List<TravelVO> list = new ArrayList<TravelVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DBUtil.getInstance().getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM travel\n");
            sql.append("WHERE no BETWEEN 449 AND 560 ");
            sql.append("ORDER BY no DESC LIMIT ? OFFSET ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, pageSize);
            pstmt.setInt(2,(page-1) * pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(resultSetToVO(rs));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public List<TravelVO> selectByDistrict(String district) {
        List<TravelVO> list = new ArrayList<TravelVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DBUtil.getInstance().getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM travel\n");
            sql.append("WHERE district = ?\n");
            sql.append("ORDER BY no DESC");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, district);
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(resultSetToVO(rs));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public List<TravelVO> search(String keyword) {
        List<TravelVO> list = new ArrayList<TravelVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            conn = DBUtil.getInstance().getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM travel WHERE title LIKE ? OR description LIKE ? ORDER BY no DESC");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, "%"+ keyword + "%");
            pstmt.setString(2, "%"+ keyword + "%");
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(resultSetToVO(rs));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public void insert(TravelVO vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            StringBuilder sql = new StringBuilder("INSERT INTO travel (district, title, description, address, phone) VALUES (?, ?, ?, ?, ?)");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, vo.getDistrict());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getDescription());
            pstmt.setString(4, vo.getAddress());
            pstmt.setString(5, vo.getPhone());
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public TravelVO resultSetToVO(ResultSet rs) throws SQLException {
        TravelVO vo = new TravelVO();
        vo.setNo(rs.getInt("no"));
        vo.setDistrict(rs.getString("district"));
        vo.setTitle(rs.getString("title"));
        vo.setDescription(rs.getString("description"));
        vo.setAddress(rs.getString("address"));
        vo.setPhone(rs.getString("phone"));

        return vo;
    }
}
