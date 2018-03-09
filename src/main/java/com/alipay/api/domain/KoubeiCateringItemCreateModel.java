package com.alipay.api.domain;

import java.util.Date;
import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 口碑餐饮行业商品创建接口
 *
 * @author auto create
 * @since 1.0, 2017-12-25 10:12:02
 */
public class KoubeiCateringItemCreateModel extends AlipayObject {

	private static final long serialVersionUID = 7724366214393983383L;

	/**
	 * 服务商、服务商员工、商户、商户员工等口碑角色操作时必填，对应为《koubei.member.data.oauth.query》中的auth_code，默认有效期24小时；isv自身角色操作的时候，无需传该参数
	 */
	@ApiField("auth_code")
	private String authCode;

	/**
	 * 商品可用时段列表。最多添加三条规则。该内容仅用于展示，不影响实际核销。
	 */
	@ApiListField("available_periods")
	@ApiField("available_period_info")
	private List<AvailablePeriodInfo> availablePeriods;

	/**
	 * 商品购买须知
	 */
	@ApiField("buyer_notes")
	private BuyerNotesInfo buyerNotes;

	/**
	 * 口碑商品所属的后台类目id，ISV可通过开放接口koubei.item.category.children.batchquery来获得后台类目树，并选择叶子类目，作为该值传入
	 */
	@ApiField("category_id")
	private String categoryId;

	/**
	 * 商品首图。支持bmp,png,jpeg,jpg,gif格式的图片，建议宽高比16:9，建议宽高：1242*698px 图片大小≤5M。图片大小超过5M,接口会报错。若图片尺寸不对，口碑服务器自身不会做压缩，但是口碑把这些图片放到客户端上展现时，自己会做性能优化(等比缩放，以图片中心为基准裁剪)
	 */
	@ApiField("cover")
	private String cover;

	/**
	 * 商品生效时间，商品状态有效并且到达生效时间后才可在客户端（消费者端）展示出来，如果商品生效时间小于当前时间，则立即生效。
说明：商品的生效时间不能早于创建当天的0点
	 */
	@ApiField("gmt_start")
	private Date gmtStart;

	/**
	 * 发布商品库存数量
	 */
	@ApiField("inventory")
	private Long inventory;

	/**
	 * 商品详情-菜品图文详情
	 */
	@ApiListField("item_dishes")
	@ApiField("item_dish_info")
	private List<ItemDishInfo> itemDishes;

	/**
	 * 商品详情-商品套餐内容
	 */
	@ApiListField("item_packages")
	@ApiField("item_package_info")
	private List<ItemPackageInfo> itemPackages;

	/**
	 * 商家公告，最多不超过200个字符
	 */
	@ApiField("latest_notice")
	private String latestNotice;

	/**
	 * 商品备注信息。用于商户内部管理，用户页面不露出。
	 */
	@ApiField("memo")
	private String memo;

	/**
	 * 商品详情-商家介绍图文详情
	 */
	@ApiField("merchant_introduction")
	private IntroductionInfo merchantIntroduction;

	/**
	 * 操作人员身份类型。如果是isv代操作，请传入ISV；如果是商户操作请传入MERCHANT；如果是商户员工则传入M_STAFF
	 */
	@ApiField("operator_type")
	private String operatorType;

	/**
	 * 商品原价。字符串类型，单位元，2位小数。最高价格49998元
	 */
	@ApiField("original_price")
	private String originalPrice;

	/**
	 * 商品详情-套餐补充说明列表
	 */
	@ApiListField("package_notes")
	@ApiField("string")
	private List<String> packageNotes;

	/**
	 * 商品详情图片列表。尺寸大小与商品首图一致，最多5张。C端上展现时，自己会做性能优化(等比缩放，以图片中心为基准裁剪)
	 */
	@ApiListField("picture_details")
	@ApiField("string")
	private List<String> pictureDetails;

	/**
	 * 商品现价（优惠价）。字符串类型，单位元，2位小数。最高价格49998元
	 */
	@ApiField("price")
	private String price;

	/**
	 * 支持英文字母和数字，由开发者自行定义（不允许重复），在商品notify消息中也会带有该参数，以此标明本次notify消息是对哪个请求的回应
	 */
	@ApiField("request_id")
	private String requestId;

	/**
	 * 商品需要关联的门店id列表，即传入一个或多个shop_id。
	 */
	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	/**
	 * 商品编码，由商家自定义，不可重复，用于商品核销。如果ticket_display_mode选择付款码核销方式(USER_PAY_CODE)，则sku_id必填。如果ticket_display_mode选择券码核销方式(TICKET_CODE)，则sku_id必须为空
	 */
	@ApiField("sku_id")
	private String skuId;

	/**
	 * 商品名称，请勿超过60个字符
	 */
	@ApiField("subject")
	private String subject;

	/**
	 * 商品购买凭证核销方式。枚举值为：USER_PAY_CODE代表付款码核销方式，如果选择付款码核销，则sku_id必填。TICKET_CODE代表券码核销方式，如果选择券码核销，则sku_id必须为空
	 */
	@ApiField("ticket_display_mode")
	private String ticketDisplayMode;

	/**
	 * 商品不可用日期区间。该内容仅用于展示，不影响实际核销。
	 */
	@ApiListField("unavailable_periods")
	@ApiField("unavailable_period_info")
	private List<UnavailablePeriodInfo> unavailablePeriods;

	/**
	 * 购买有效期：商品自购买起多长时间内有效，取值范围 7-360，单位天。举例，如果是7的话，是到第七天晚上23:59:59失效。商品购买后，没有在有效期内核销，则自动退款给用户。举例：买了一个鱼香肉丝杨梅汁套餐的商品，有效期一个月，如果一个月之后，用户没有消费该套餐，则自动退款给用户
	 */
	@ApiField("validity_period")
	private Long validityPeriod;

	/**
	 * 商品顺序权重，必须是整数，不传默认为0，权重数值越大排序越靠前
	 */
	@ApiField("weight")
	private String weight;

	public String getAuthCode() {
		return this.authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public List<AvailablePeriodInfo> getAvailablePeriods() {
		return this.availablePeriods;
	}
	public void setAvailablePeriods(List<AvailablePeriodInfo> availablePeriods) {
		this.availablePeriods = availablePeriods;
	}

	public BuyerNotesInfo getBuyerNotes() {
		return this.buyerNotes;
	}
	public void setBuyerNotes(BuyerNotesInfo buyerNotes) {
		this.buyerNotes = buyerNotes;
	}

	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCover() {
		return this.cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getGmtStart() {
		return this.gmtStart;
	}
	public void setGmtStart(Date gmtStart) {
		this.gmtStart = gmtStart;
	}

	public Long getInventory() {
		return this.inventory;
	}
	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	public List<ItemDishInfo> getItemDishes() {
		return this.itemDishes;
	}
	public void setItemDishes(List<ItemDishInfo> itemDishes) {
		this.itemDishes = itemDishes;
	}

	public List<ItemPackageInfo> getItemPackages() {
		return this.itemPackages;
	}
	public void setItemPackages(List<ItemPackageInfo> itemPackages) {
		this.itemPackages = itemPackages;
	}

	public String getLatestNotice() {
		return this.latestNotice;
	}
	public void setLatestNotice(String latestNotice) {
		this.latestNotice = latestNotice;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public IntroductionInfo getMerchantIntroduction() {
		return this.merchantIntroduction;
	}
	public void setMerchantIntroduction(IntroductionInfo merchantIntroduction) {
		this.merchantIntroduction = merchantIntroduction;
	}

	public String getOperatorType() {
		return this.operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getOriginalPrice() {
		return this.originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public List<String> getPackageNotes() {
		return this.packageNotes;
	}
	public void setPackageNotes(List<String> packageNotes) {
		this.packageNotes = packageNotes;
	}

	public List<String> getPictureDetails() {
		return this.pictureDetails;
	}
	public void setPictureDetails(List<String> pictureDetails) {
		this.pictureDetails = pictureDetails;
	}

	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getRequestId() {
		return this.requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}
	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

	public String getSkuId() {
		return this.skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTicketDisplayMode() {
		return this.ticketDisplayMode;
	}
	public void setTicketDisplayMode(String ticketDisplayMode) {
		this.ticketDisplayMode = ticketDisplayMode;
	}

	public List<UnavailablePeriodInfo> getUnavailablePeriods() {
		return this.unavailablePeriods;
	}
	public void setUnavailablePeriods(List<UnavailablePeriodInfo> unavailablePeriods) {
		this.unavailablePeriods = unavailablePeriods;
	}

	public Long getValidityPeriod() {
		return this.validityPeriod;
	}
	public void setValidityPeriod(Long validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getWeight() {
		return this.weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

}
