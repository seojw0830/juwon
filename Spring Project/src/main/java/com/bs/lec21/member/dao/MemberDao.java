package com.bs.lec21.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bs.lec21.member.Member;
import com.mchange.v2.c3p0.DriverManagerDataSource;

@Repository
public class MemberDao implements IMemberDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin@localhost:1521:xe";
	private String userid = "scott";
	private String userpw = "tiger";
	
	/*private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;*/
	
	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;
	
	
	private HashMap<String, Member> dbMap;
	
	public MemberDao() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setUser(userpw);
		// DataSource 객체에 set해주고 template에 넣어주고 사용하면 끝
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}
	
	@Override
	public int memberInsert(Member member) {
		int result = 0;
		
		String sql = "INSERT INTO MEMBER (memId,memPw, memMail) values (?,?,?)";
		result = template.update(sql, member.getMemId(), member.getMemPw(), member.getMemMail());
		
		
		/*try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "INSERT INTO MEMBER (memId,memPw, memMail) values (?,?,?)";
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPw());
			pstmt.setString(3, member.getMemMail());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}*/
		
		return result;
		
	}

	@Override
	public Member memberSelect(final Member member) {
		List<Member> members = null;
		
		String sql = "SELECT * FROM member WHERE memID = ? AND memPw = ?";
		
		members = template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
			}
		}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rownum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				return mem;
			}
		});
		if (members.isEmpty()) {
			return null;
		}
		
		return members.get(0);
		
	}

	@Override
	public Member memberUpdate(Member member) {
		
		dbMap.put(member.getMemId(), member);
		return dbMap.get(member.getMemId());
		
	}

	@Override
	public Map<String, Member> memberDelete(Member member) {
		
		dbMap.remove(member.getMemId());
		return dbMap;
		
	}

}
