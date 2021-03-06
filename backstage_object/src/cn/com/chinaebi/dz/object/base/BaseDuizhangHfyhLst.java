package cn.com.chinaebi.dz.object.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the duizhang_hfyh_lst table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="duizhang_hfyh_lst"
 */

public abstract class BaseDuizhangHfyhLst  implements Serializable {

	public static String REF = "DuizhangHfyhLst";
	public static String PROP_TRADE_AMOUNT = "TradeAmount";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_ORDER_AMOUNT = "OrderAmount";
	public static String PROP_TRADE_FEE = "TradeFee";
	public static String PROP_DZ_FILE_NAME = "DzFileName";
	public static String PROP_BK_CHK = "BkChk";
	public static String PROP_REQ_TIME = "ReqTime";
	public static String PROP_DEDUCT_SYS_REFERENCE = "DeductSysReference";
	public static String PROP_PROCESS = "Process";
	public static String PROP_WHETHER_TK = "WhetherTk";
	public static String PROP_TRADE_TIME = "TradeTime";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_TK_COUNT = "TkCount";
	public static String PROP_PAY_TYPE = "PayType";
	public static String PROP_TRADE_DATE = "TradeDate";
	public static String PROP_OUT_ACCOUNT = "OutAccount";
	public static String PROP_ORDER_COMMIT_TIME = "OrderCommitTime";
	public static String PROP_TERM_ID = "TermId";
	public static String PROP_INST_NAME = "InstName";
	public static String PROP_ORDER_ID = "OrderId";
	public static String PROP_MER_CODE = "MerCode";
	public static String PROP_TK_AMOUNT = "TkAmount";
	public static String PROP_DEDUCT_STLM_DATE = "DeductStlmDate";
	public static String PROP_PAY_STATUS = "PayStatus";
	public static String PROP_REQ_SYS_STANCE = "ReqSysStance";
	public static String PROP_TK_FEE = "TkFee";
	public static String PROP_ID = "Id";
	public static String PROP_ORDER_CONTENT = "OrderContent";


	// constructors
	public BaseDuizhangHfyhLst () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDuizhangHfyhLst (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String orderId;
	private java.lang.String reqSysStance;
	private java.lang.String reqTime;
	private java.lang.String tradeAmount;
	private java.lang.String tradeFee;
	private java.lang.Integer bkChk;
	private java.lang.String deductStlmDate;
	private boolean whetherTk;
	private java.lang.String outAccount;
	private java.lang.String payType;
	private java.lang.String dzFileName;
	private java.lang.String instName;
	private java.lang.String deductSysReference;
	private java.lang.String termId;
	private java.lang.String merCode;
	private java.lang.String process;
	private java.lang.String payStatus;
	private java.lang.String tradeDate;
	private java.lang.String tradeTime;
	private java.lang.String orderStatus;
	private java.lang.String orderContent;
	private java.lang.String orderAmount;
	private java.lang.String currency;
	private java.lang.String orderCommitTime;
	private java.lang.String tkCount;
	private java.lang.String tkAmount;
	private java.lang.String tkFee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.UUIDHexGenerator"
     *  column="id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: orderId
	 */
	public java.lang.String getOrderId () {
		return orderId;
	}

	/**
	 * Set the value related to the column: orderId
	 * @param orderId the orderId value
	 */
	public void setOrderId (java.lang.String orderId) {
		this.orderId = orderId;
	}



	/**
	 * Return the value associated with the column: reqSysStance
	 */
	public java.lang.String getReqSysStance () {
		return reqSysStance;
	}

	/**
	 * Set the value related to the column: reqSysStance
	 * @param reqSysStance the reqSysStance value
	 */
	public void setReqSysStance (java.lang.String reqSysStance) {
		this.reqSysStance = reqSysStance;
	}



	/**
	 * Return the value associated with the column: reqTime
	 */
	public java.lang.String getReqTime () {
		return reqTime;
	}

	/**
	 * Set the value related to the column: reqTime
	 * @param reqTime the reqTime value
	 */
	public void setReqTime (java.lang.String reqTime) {
		this.reqTime = reqTime;
	}



	/**
	 * Return the value associated with the column: tradeAmount
	 */
	public java.lang.String getTradeAmount () {
		return tradeAmount;
	}

	/**
	 * Set the value related to the column: tradeAmount
	 * @param tradeAmount the tradeAmount value
	 */
	public void setTradeAmount (java.lang.String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}



	/**
	 * Return the value associated with the column: tradeFee
	 */
	public java.lang.String getTradeFee () {
		return tradeFee;
	}

	/**
	 * Set the value related to the column: tradeFee
	 * @param tradeFee the tradeFee value
	 */
	public void setTradeFee (java.lang.String tradeFee) {
		this.tradeFee = tradeFee;
	}



	/**
	 * Return the value associated with the column: bk_chk
	 */
	public java.lang.Integer getBkChk () {
		return bkChk;
	}

	/**
	 * Set the value related to the column: bk_chk
	 * @param bkChk the bk_chk value
	 */
	public void setBkChk (java.lang.Integer bkChk) {
		this.bkChk = bkChk;
	}



	/**
	 * Return the value associated with the column: deduct_stlm_date
	 */
	public java.lang.String getDeductStlmDate () {
		return deductStlmDate;
	}

	/**
	 * Set the value related to the column: deduct_stlm_date
	 * @param deductStlmDate the deduct_stlm_date value
	 */
	public void setDeductStlmDate (java.lang.String deductStlmDate) {
		this.deductStlmDate = deductStlmDate;
	}



	/**
	 * Return the value associated with the column: whetherTk
	 */
	public boolean isWhetherTk () {
		return whetherTk;
	}

	/**
	 * Set the value related to the column: whetherTk
	 * @param whetherTk the whetherTk value
	 */
	public void setWhetherTk (boolean whetherTk) {
		this.whetherTk = whetherTk;
	}



	/**
	 * Return the value associated with the column: outAccount
	 */
	public java.lang.String getOutAccount () {
		return outAccount;
	}

	/**
	 * Set the value related to the column: outAccount
	 * @param outAccount the outAccount value
	 */
	public void setOutAccount (java.lang.String outAccount) {
		this.outAccount = outAccount;
	}



	/**
	 * Return the value associated with the column: payType
	 */
	public java.lang.String getPayType () {
		return payType;
	}

	/**
	 * Set the value related to the column: payType
	 * @param payType the payType value
	 */
	public void setPayType (java.lang.String payType) {
		this.payType = payType;
	}



	/**
	 * Return the value associated with the column: dz_file_name
	 */
	public java.lang.String getDzFileName () {
		return dzFileName;
	}

	/**
	 * Set the value related to the column: dz_file_name
	 * @param dzFileName the dz_file_name value
	 */
	public void setDzFileName (java.lang.String dzFileName) {
		this.dzFileName = dzFileName;
	}



	/**
	 * Return the value associated with the column: inst_name
	 */
	public java.lang.String getInstName () {
		return instName;
	}

	/**
	 * Set the value related to the column: inst_name
	 * @param instName the inst_name value
	 */
	public void setInstName (java.lang.String instName) {
		this.instName = instName;
	}



	/**
	 * Return the value associated with the column: deductSysReference
	 */
	public java.lang.String getDeductSysReference () {
		return deductSysReference;
	}

	/**
	 * Set the value related to the column: deductSysReference
	 * @param deductSysReference the deductSysReference value
	 */
	public void setDeductSysReference (java.lang.String deductSysReference) {
		this.deductSysReference = deductSysReference;
	}



	/**
	 * Return the value associated with the column: termId
	 */
	public java.lang.String getTermId () {
		return termId;
	}

	/**
	 * Set the value related to the column: termId
	 * @param termId the termId value
	 */
	public void setTermId (java.lang.String termId) {
		this.termId = termId;
	}



	/**
	 * Return the value associated with the column: merCode
	 */
	public java.lang.String getMerCode () {
		return merCode;
	}

	/**
	 * Set the value related to the column: merCode
	 * @param merCode the merCode value
	 */
	public void setMerCode (java.lang.String merCode) {
		this.merCode = merCode;
	}



	/**
	 * Return the value associated with the column: process
	 */
	public java.lang.String getProcess () {
		return process;
	}

	/**
	 * Set the value related to the column: process
	 * @param process the process value
	 */
	public void setProcess (java.lang.String process) {
		this.process = process;
	}



	/**
	 * Return the value associated with the column: payStatus
	 */
	public java.lang.String getPayStatus () {
		return payStatus;
	}

	/**
	 * Set the value related to the column: payStatus
	 * @param payStatus the payStatus value
	 */
	public void setPayStatus (java.lang.String payStatus) {
		this.payStatus = payStatus;
	}



	/**
	 * Return the value associated with the column: tradeDate
	 */
	public java.lang.String getTradeDate () {
		return tradeDate;
	}

	/**
	 * Set the value related to the column: tradeDate
	 * @param tradeDate the tradeDate value
	 */
	public void setTradeDate (java.lang.String tradeDate) {
		this.tradeDate = tradeDate;
	}



	/**
	 * Return the value associated with the column: tradeTime
	 */
	public java.lang.String getTradeTime () {
		return tradeTime;
	}

	/**
	 * Set the value related to the column: tradeTime
	 * @param tradeTime the tradeTime value
	 */
	public void setTradeTime (java.lang.String tradeTime) {
		this.tradeTime = tradeTime;
	}



	/**
	 * Return the value associated with the column: orderStatus
	 */
	public java.lang.String getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: orderStatus
	 * @param orderStatus the orderStatus value
	 */
	public void setOrderStatus (java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * Return the value associated with the column: orderContent
	 */
	public java.lang.String getOrderContent () {
		return orderContent;
	}

	/**
	 * Set the value related to the column: orderContent
	 * @param orderContent the orderContent value
	 */
	public void setOrderContent (java.lang.String orderContent) {
		this.orderContent = orderContent;
	}



	/**
	 * Return the value associated with the column: orderAmount
	 */
	public java.lang.String getOrderAmount () {
		return orderAmount;
	}

	/**
	 * Set the value related to the column: orderAmount
	 * @param orderAmount the orderAmount value
	 */
	public void setOrderAmount (java.lang.String orderAmount) {
		this.orderAmount = orderAmount;
	}



	/**
	 * Return the value associated with the column: currency
	 */
	public java.lang.String getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * @param currency the currency value
	 */
	public void setCurrency (java.lang.String currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: orderCommitTime
	 */
	public java.lang.String getOrderCommitTime () {
		return orderCommitTime;
	}

	/**
	 * Set the value related to the column: orderCommitTime
	 * @param orderCommitTime the orderCommitTime value
	 */
	public void setOrderCommitTime (java.lang.String orderCommitTime) {
		this.orderCommitTime = orderCommitTime;
	}



	/**
	 * Return the value associated with the column: tkCount
	 */
	public java.lang.String getTkCount () {
		return tkCount;
	}

	/**
	 * Set the value related to the column: tkCount
	 * @param tkCount the tkCount value
	 */
	public void setTkCount (java.lang.String tkCount) {
		this.tkCount = tkCount;
	}



	/**
	 * Return the value associated with the column: tkAmount
	 */
	public java.lang.String getTkAmount () {
		return tkAmount;
	}

	/**
	 * Set the value related to the column: tkAmount
	 * @param tkAmount the tkAmount value
	 */
	public void setTkAmount (java.lang.String tkAmount) {
		this.tkAmount = tkAmount;
	}



	/**
	 * Return the value associated with the column: tkFee
	 */
	public java.lang.String getTkFee () {
		return tkFee;
	}

	/**
	 * Set the value related to the column: tkFee
	 * @param tkFee the tkFee value
	 */
	public void setTkFee (java.lang.String tkFee) {
		this.tkFee = tkFee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.com.chinaebi.dz.object.DuizhangHfyhLst)) return false;
		else {
			cn.com.chinaebi.dz.object.DuizhangHfyhLst duizhangHfyhLst = (cn.com.chinaebi.dz.object.DuizhangHfyhLst) obj;
			if (null == this.getId() || null == duizhangHfyhLst.getId()) return false;
			else return (this.getId().equals(duizhangHfyhLst.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}