package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.JDBCTemplate;
import com.lib.dto.LibDto;

public class LibDao extends JDBCTemplate {
	public int delete() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = "DELETE FROM camp_info";

		try {
			pstm = con.prepareStatement(sql);

			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;

	}

	public int insert(List<LibDto> dtos) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO camp_info VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstm = con.prepareStatement(sql);

			for (int i = 0; i < dtos.size(); i++) {
				LibDto dto = dtos.get(i);

				pstm.setString(1, dto.getAddr1());
				pstm.setString(2, dto.getAddr2());
				pstm.setString(3, dto.getCaraSiteCo());
				pstm.setString(4, dto.getFacltNm());
				pstm.setString(5, dto.getFeatureNm());
				pstm.setString(6, dto.getFirstImageUrl());
				pstm.setString(7, dto.getInduty());
				pstm.setString(8, dto.getIntro());
				pstm.setString(9, dto.getLineIntro());
				pstm.setString(10, dto.getMapX());
				pstm.setString(11, dto.getMapY());

				pstm.addBatch();

			}
			int[] result = pstm.executeBatch();

			for (int i = 0; i < result.length; i++) {
				if (result[i] == -2) {
					res++;
				}
			}
			if (res == dtos.size()) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}
}