package coupons.core.DBDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.dao.CouponsDao;
import coupons.core.exceptions.CouponSystemException;

public class CouponsDBDao implements CouponsDao {

	private ConnectionPool connectionPool;

	public CouponsDBDao() throws CouponSystemException {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		String sql = "insert into COUPONS values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompanyId());
			pstmt.setString(2, coupon.getCategory().toString());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			coupon.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("addCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		String sql = "update COUPONS set `company_id` = ?, `category` = ?, `title` = ?, `description` = ?,"
				+ " `start_date` = ?, `end_date` = ?, `amount` = ?, `price`  = ?, `image` = ? where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompanyId());
			pstmt.setString(2, coupon.getCategory().toString());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.setInt(10, coupon.getId());
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("update coupon " + coupon.getId() + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCoupon(int couponId) throws CouponSystemException {
		String sql = "delete from COUPONS where `id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete coupon " + couponId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public Coupon getOneCoupon(int couponId) throws CouponSystemException {
		String sql = "select * from COUPONS where id = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Coupon(rs.getInt("id"), rs.getInt("company_id"), Category.valueOf(rs.getString("category")),
						rs.getString("title"), rs.getString("description"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getInt("amount"), rs.getDouble("price"),
						rs.getString("image"));
			} else {
				throw new CouponSystemException("read coupon " + couponId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public List<Coupon> getAllCoupons() throws CouponSystemException {
		String sql = "select * from COUPONS";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			List<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				coupons.add(new Coupon(rs.getInt("id"), rs.getInt("company_id"),
						Category.valueOf(rs.getString("category")), rs.getString("title"), rs.getString("description"),
						rs.getDate("start_date").toLocalDate(), rs.getDate("end_date").toLocalDate(),
						rs.getInt("amount"), rs.getDouble("price"), rs.getString("image")));
			}
			return coupons;
		} catch (SQLException e) {
			throw new CouponSystemException("getAllCoupons failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
	
	@Override
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		String sql = "insert into CUSTOMERS_VS_COUPONS values(?, ?)";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("addCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		String sql = "delete from CUSTOMERS_VS_COUPONS where `customer_id` = ? AND `coupon_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("deleteCouponPurchase failed: customerId-" + customerId + ", couponId-"
						+ couponId + "  not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public boolean isCouponExistsByIdAndCompanyId(int couponId, int companyId) throws CouponSystemException {
		String sql = "select id from COUPONS where `coupon_id` = ? AND `company_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			pstmt.setInt(2, companyId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponExistsByIdAndCompanyId failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	} 
	
	@Override
	public boolean isCouponExistsByTitleOfCompany(int companyId, String title) throws CouponSystemException {
		String sql = "select id from COUPONS where `company_id` = ? AND `title` =  ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			pstmt.setString(2, title);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponExistsByTitle failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCouponById(int couponId) throws CouponSystemException {
		String sql = "delete from CUSTOMERS_VS_COUPONS where `coupon_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("deleteCouponById failed: couponId-" + couponId + "  not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCouponById failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}

	@Override
	public void deleteCouponsOfCompany(int companyId) throws CouponSystemException {
		String sql = "delete from COUPONS where `company_id` = ?";
		Connection con = connectionPool.getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			while(rsId.next()) {
				deleteCouponById(rsId.getInt(1));
			}
			if (pstmt.executeUpdate() == 0) {
				throw new CouponSystemException("delete coupons of company " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCouponsOfCompany failed", e);
		} finally {
			connectionPool.restoreConnection(con);
		}
	}
}
