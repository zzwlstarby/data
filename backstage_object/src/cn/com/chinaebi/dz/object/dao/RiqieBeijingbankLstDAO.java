package cn.com.chinaebi.dz.object.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.chinaebi.dz.object.RiqieBeijingbankLst;
import cn.com.chinaebi.dz.object.base.BaseRiqieBeijingbankLstDAO;
import cn.com.chinaebi.dz.util.DYDataUtil;


public class RiqieBeijingbankLstDAO extends BaseRiqieBeijingbankLstDAO implements cn.com.chinaebi.dz.object.dao.iface.RiqieBeijingbankLstDAO {

	private Log log = LogFactory.getLog(getClass());
	
	public RiqieBeijingbankLstDAO () {}
	
	public RiqieBeijingbankLstDAO (Session session) {
		super(session);
	}

	@Override
	public List<RiqieBeijingbankLst> findRiqieBeijingbankLst(String deductStlmDate) {
		Session session = null;
		List<RiqieBeijingbankLst> list = null; 
		if(deductStlmDate == null){
			log.error("RiqieBeijingbankLstDAO findRiqieBeijingbankLst deductStlmDate param is not null");
			return null;
		}
		try {
			Date startTime = DYDataUtil.getformatConversionDate3(deductStlmDate);
			Date endTime = DYDataUtil.getformatConversionDate4(deductStlmDate);
			log.info("北京银行对账查询日切原始交易开始时间 ："+startTime);
			log.info("北京银行对账查询日切原始交易开始时间 ："+endTime);
			
			session = this.getSession();
			Query query = session.createQuery("from RiqieBeijingbankLst where DeductStlmDate BETWEEN ? and ? and whetherValid = 1 order by ReqTime,TrademsgType asc");
			query.setParameter(0, startTime);
			query.setParameter(1, endTime);
			List listResult = query.list();
			if(listResult != null && listResult.size() > 0){
				list = listResult;
			}else{
				log.warn("from RiqieBeijingbankLst where DeductStlmDate BETWEEN ? and ? and whetherValid = 1 is not data");
			}
		}catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		cn.com.chinaebi.dz.object.dao.iface.RiqieBeijingbankLstDAO riqieBeijingbankLstDAO = RiqieBeijingbankLstDAO.getInstance();
		 List<RiqieBeijingbankLst> list = riqieBeijingbankLstDAO.findRiqieBeijingbankLst("0310");
		 for (RiqieBeijingbankLst riqieBeijingbankLst : list) {
			 System.out.println(riqieBeijingbankLst.getReqSysStance());
		}
	}
	
	@Override
	public boolean updateClean(String reqSysStance, boolean clean,Integer bkchk,Integer tradeMsgType,boolean deductRollBk,String deductStmlDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				Date startTime = DYDataUtil.getformatConversionDate3(deductStmlDate);
				Date endTime = DYDataUtil.getformatConversionDate4(deductStmlDate);
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = ? where req_sys_stance = ? and trademsg_type = ? and deduct_roll_bk = ? and deduct_stlm_date BETWEEN ? and ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, bkchk);
				sqlQuery.setString(2, reqSysStance);
				sqlQuery.setInteger(3, tradeMsgType);
				sqlQuery.setBoolean(4, deductRollBk);
				sqlQuery.setParameter(5, startTime);
				sqlQuery.setParameter(6, endTime);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +", 流水号不存在");
		}
		return flag;
	}
	
	@Override
	public boolean updateCleanAndError(String reqSysStance, boolean clean,Integer whetherErroeHandle,Integer tradeMsgType,boolean deductRollBk
			,String deductStmlDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				Date startTime = DYDataUtil.getformatConversionDate3(deductStmlDate);
				Date endTime = DYDataUtil.getformatConversionDate4(deductStmlDate);
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ? , whetherErroeHandle = ?,bk_chk = 2 where req_sys_stance = ? and trademsg_type = ? and deduct_roll_bk = ? and deduct_stlm_date BETWEEN ? and ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, whetherErroeHandle);
				sqlQuery.setString(2, reqSysStance);
				sqlQuery.setInteger(3, tradeMsgType);
				sqlQuery.setBoolean(4, deductRollBk);
				sqlQuery.setParameter(5, startTime);
				sqlQuery.setParameter(6, endTime);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +", 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean updateClean(String reqSysStance, boolean clean,
			Integer tradeMsgType,String deductStmlDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherJs = ?,bk_chk = 1 where req_sys_stance = ? and trademsg_type = ? and substring(deduct_stlm_date,1,10) = ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setString(1, reqSysStance);
				sqlQuery.setInteger(2, tradeMsgType);
				sqlQuery.setString(3, deductStmlDate);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +", 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean updateClean(String reqSysStance, boolean clean,boolean deductRollBk,String deductStlmDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = 1 where req_sys_stance = ? and deduct_roll_bk = ? and substring(deduct_stlm_date,1,10) = ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setString(1, reqSysStance);
				sqlQuery.setBoolean(2, deductRollBk);
				sqlQuery.setString(3, deductStlmDate);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +". 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean saveRiqieBeijingbankLst(RiqieBeijingbankLst riqieBeijingbankLst,Integer flagStatus) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		try {
			session = this.getSession();
			transaction = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("select count(*) from riqie_beijingbank_lst where trade_id = ?");
			sqlQuery.setString(0, riqieBeijingbankLst.getId());
			Integer count = Integer.valueOf(sqlQuery.uniqueResult().toString());
			if(count > 0 ){
				if(flagStatus == 0){
					update(riqieBeijingbankLst);
					transaction.commit();
					flag = true;
				}
			}else{
				save(riqieBeijingbankLst);
				transaction.commit();
				flag = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			log.error(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flag;
	}

	@Override
	public boolean updateClean(String reqSysStance, boolean clean,
			Integer bkchk, boolean deductRollBk, String deductStlmDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = ? where req_sys_stance = ? and deduct_roll_bk = ? and substring(deduct_stlm_date,1,10) = ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, bkchk);
				sqlQuery.setString(2, reqSysStance);
				sqlQuery.setBoolean(3, deductRollBk);
				sqlQuery.setString(4, deductStlmDate);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +". 流水号不存在");
		}
		return flag;
	}
	
	@Override
	public boolean updateOriginalError(String reqSysStance, boolean clean,
			Integer bkchk, Integer whetherError, boolean deductRollBk,
			String tradeTime) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = ?,whetherErroeHandle = ? where deduct_sys_stance = ? and substring(deduct_stlm_date,1,10) = ? and deduct_roll_bk = ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, bkchk);
				sqlQuery.setInteger(2, whetherError);
				sqlQuery.setString(3, reqSysStance);
				sqlQuery.setString(4, tradeTime);
				sqlQuery.setBoolean(5, deductRollBk);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +", 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean updateClean(String reqSysStance, boolean clean,
			Integer bkchk, Integer tradeMsgType, String deductStmlDate) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = ? where req_sys_stance = ? and trademsg_type = ? and substring(deduct_stlm_date,1,10) = ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, bkchk);
				sqlQuery.setString(2, reqSysStance);
				sqlQuery.setInteger(3, tradeMsgType);
				sqlQuery.setString(4, deductStmlDate);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +", 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean updateSettleInfo(String reqSysStance,
			boolean whetherTk,Double zf_fee,String zf_file_fee, Integer tradeMsgType,
			boolean deductRollBk, String deductStmlDate,Integer whetherReturnFee) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				Date startTime = DYDataUtil.getformatConversionDate3(deductStmlDate);
				Date endTime = DYDataUtil.getformatConversionDate4(deductStmlDate);
				Integer zfFeeBj = 2;//0:无需比对、1:比对成功、2:比对失败  ->默认比对失败
				StringBuffer sb = new StringBuffer();
//				if(tradeMsgType == 20 && whetherTk && whetherReturnFee == 0){//退货交易
//					zf_fee = 0d;
//				}
				Double zf_file_fee_double = Double.valueOf(zf_file_fee);
				if(zf_fee.equals(Double.valueOf(zf_file_fee_double))){
					zfFeeBj = 1;
				}
				if(whetherTk){
					zf_fee = 0-zf_fee;
					if(zf_file_fee_double == 0){
						sb.append(zf_file_fee);
					}else{
						sb.append("-");
						sb.append(zf_file_fee);
					}
				}else{
					//消费or预授权完成or消费撤销冲正or预授权完成撤销冲正or电子现金(脱机消费)
					if(tradeMsgType == 2 || tradeMsgType == 56 || tradeMsgType == 28 || tradeMsgType == 82 || tradeMsgType == 110){
						sb.append(zf_file_fee);
					}else{
						zf_fee = 0-zf_fee;
						if(zf_file_fee_double == 0){
							sb.append(zf_file_fee);
						}else{
							sb.append("-");
							sb.append(zf_file_fee);
						}
					}
				}
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherTk = ?,zf_file_fee = ?,zf_fee = ?,zf_fee_bj = ? where deduct_sys_stance = ? and trademsg_type = ? and deduct_roll_bk = ? and deduct_stlm_date BETWEEN ? and ?");
				sqlQuery.setBoolean(0, whetherTk);
				sqlQuery.setString(1, sb.toString());
				sqlQuery.setDouble(2, zf_fee);
				sqlQuery.setInteger(3, zfFeeBj);
				sqlQuery.setString(4, reqSysStance);
				sqlQuery.setInteger(5, tradeMsgType);
				sqlQuery.setBoolean(6, deductRollBk);
				sqlQuery.setDate(7, startTime);
				sqlQuery.setDate(8, endTime);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +" 流水号不存在");
		}
		return flag;
	}

	@Override
	public boolean updateNoNeedHandle(String reqSysStance, boolean clean,
			Integer bkchk, Integer tradeMsgType, String deductStmlDate) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false; 
		if(StringUtils.isNotBlank(reqSysStance)){
			try {
				Date startTime = DYDataUtil.getformatConversionDate3(deductStmlDate);
				Date endTime = DYDataUtil.getformatConversionDate4(deductStmlDate);
				session = this.getSession();
				transaction = session.beginTransaction();
				SQLQuery sqlQuery = session.createSQLQuery("update riqie_beijingbank_lst set whetherQs = ?,bk_chk = ? where deduct_sys_stance = ? and trademsg_type = ? and deduct_stlm_date BETWEEN ? and ?");
				sqlQuery.setBoolean(0, clean);
				sqlQuery.setInteger(1, bkchk);
				sqlQuery.setString(2, reqSysStance);
				sqlQuery.setInteger(3, tradeMsgType);
				sqlQuery.setParameter(4, startTime);
				sqlQuery.setParameter(5, endTime);
				int count =  sqlQuery.executeUpdate();
				if(count > 0 ){
					transaction.commit();
					flag = true;
				}
			} catch (Exception e) {
				transaction.rollback();
				log.error(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}else{
			log.warn(reqSysStance +" 流水号不存在");
		}
		return flag;
	}
}