package com.dx.lesson.test.bean


data class OrderDetailBean(
    val accountingChannelType: Int,
    val accountingChannelTypeName: String,
    val agreementStatus: Int,
    val arrearsAmount: Int,
    val canRevoke: Int,
    val contractStatus: Int,
    val details: List<Detail>,
    val employCount: Int,
    val executeCount: Int,
    val factors: String,
    val invalidPerformance: String,
    val invoiceCount: Int,
    val invoicedAmount: Int,
    val invoicing: String,
    val isContainCert: Int,
    val isGuarantee: String,
    val isRefund: Int,
    val isShow: Int,
    val main: Main,
    val orderEmployNo: String,
    val orderItemNo: String,
    val orderType: Int,
    val paidTime: String,
    val refundCount: Int,
    val refundWay: Boolean,
    val remarks: List<Any>,
    val ruleInfo: String,
    val ruleName: String,
    val ruleType: Int,
    val swapCount: Int,
    val swapStatus: Boolean,
    val threadId: Int,
    val threadType: Int,
    val totalAmount: Int,
    val totalArtificialDiscountAmount: Int,
    val totalDealAmount: Int,
    val totalDetailDiscountAmount: Int,
    val totalDiscountAmount: Int,
    val totalGoodsPresentedDiscountAmount: Int,
    val totalPresentedDiscountAmount: Int,
    val totalPriceDifferenceAmount: Int,
    val totalPriceDiscountAmount: Int
)

data class Detail(
    val activity: Activity,
    val activityAmount: Any,
    val agencyDiscountAmount: Any,
    val agencyFee: Any,
    val agencyQuantity: Any,
    val agencyRefundAmount: Int,
    val artificialAmount: Int,
    val certificates: Any,
    val coverUrl: String,
    val dealAmount: Int,
    val detailDiscountAmount: Int,
    val detailType: DetailType,
    val detailTypeName: String,
    val factors: Any,
    val giftActivity: Any,
    val giftList: List<Any>,
    val id: Int,
    val isGift: Boolean,
    val itemQuantity: Int,
    val items: List<Item>,
    val mainSkuCode: String,
    val orderDetailNo: String,
    val orderNo: String,
    val performanceThresholdRate: Int,
    val preSaleSkuAmount: Any,
    val priceDiscountAmount: Int,
    val priceDiscountName: String,
    val priceDiscountType: Int,
    val priceParams: Any,
    val quantity: Int,
    val rule: Any,
    val ruleDiscountAmount: Any,
    val ruleInfo: Any,
    val ruleNo: String,
    val ruleType: Int,
    val saleSku: SaleSku,
    val saleSkuDealAmount: Any,
    val saleSkuRefundAmount: Int,
    val serveDiscountAmount: Any,
    val serveFee: Any,
    val serveQuantity: Any,
    val serveRefundAmount: Int,
    val serverParamDay: ServerParamDay,
    val serverParamHours: ServerParamHours,
    val serverQuantity: Any,
    val spu: Spu,
    val tagRule: Any,
    val totalAmount: Int,
    val unitName: Any
)

data class Main(
    val addressDetail: Any,
    val afterSale: Any,
    val authId: Int,
    val authName: String,
    val buyerRatio: Any,
    val channel: Int,
    val channelName: String,
    val createTime: String,
    val customer: Customer,
    val customerBabyBirthday: Any,
    val dealAmount: Int,
    val detailDiscountAmount: Int,
    val discountTotalAmount: Int,
    val favoriteAunt: FavoriteAunt,
    val firstOrder: Boolean,
    val firstOrderDateTime: Any,
    val healthManager: Any,
    val isCleaningOrder: Boolean,
    val isUpIdentityInfo: Any,
    val orderDiscountAmount: Int,
    val orderGoodsType: Int,
    val orderNo: String,
    val orderStatus: OrderStatus,
    val ownerPlace: Any,
    val ownerPlaceAddress: Any,
    val ownerPlaceAddressDetail: Any,
    val paidAmount: Int,
    val payableAmount: Int,
    val performanceShareType: Any,
    val performanceShareTypeName: Any,
    val performanceThresholdAmount: Int,
    val priceDiscountAmount: Int,
    val processedAmount: Int,
    val refundAmount: Int,
    val refundPayableAmount: Int,
    val remark: Any,
    val residualAmount: Int,
    val ruleType: Int,
    val sale: Sale,
    val saleGroupId: Int,
    val saleGroupName: String,
    val serverAddress: Any,
    val serverAddressDetail: Any,
    val serverDate: Any,
    val serverEndTime: Any,
    val serverStartTime: Any,
    val share: Boolean,
    val shareRatio: Any,
    val shareSale: ShareSale,
    val signMember: Any,
    val storeId: Int,
    val storeName: String,
    val threadChannel: String,
    val threadId: Int,
    val threadOwner: ThreadOwner,
    val totalAmount: Int,
    val tradeStatus: TradeStatus,
    val vuAuntId: Any
)

data class Activity(
    val activityNo: Any,
    val activityType: Any,
    val amount: Int,
    val title: Any
)

data class DetailType(
    val description: Any,
    val key: Int,
    val value: String
)

data class Item(
    val agencyType: Boolean,
    val agreementCapacity: Int,
    val auntInfo: Any,
    val dealAmount: Int,
    val detailDiscountAmount: Int,
    val detailDiscountName: Any,
    val detailDiscountType: Any,
    val disableReason: Any,
    val eduCourseId: Any,
    val eduCourseName: Any,
    val firstUnitId: Int,
    val firstUnitName: String,
    val goods: Goods,
    val goodsType: Int,
    val goodsTypeName: String,
    val isGift: Boolean,
    val mainSkuCode: Any,
    val orderDetailNo: String,
    val orderItemNo: String,
    val orderNo: String,
    val paidAmount: Any,
    val performanceThreSholdRate: Int,
    val priceDiscountAmount: Int,
    val priceDiscountName: String,
    val priceDiscountType: Int,
    val quantity: Int,
    val receivedAmount: Any,
    val refundAmount: Int,
    val refundAndSwapQuantity: Any,
    val refundPayableAmount: Int,
    val refundQuantity: Int,
    val remainQuantity: Any,
    val ruleType: Int,
    val secondUnitId: Int,
    val secondUnitName: String,
    val serverGoodsCode: String,
    val storeId: Int,
    val storeName: Any,
    val swapOutQuantity: Int,
    val totalAmount: Int,
    val totalServices: Int,
    val unitPrice: Int
)

data class SaleSku(
    val code: String,
    val name: String
)

data class ServerParamDay(
    val dictCode: Any,
    val dictLabel: Any,
    val dictPrimaryValue: Any
)

data class ServerParamHours(
    val dictCode: Any,
    val dictLabel: Any,
    val dictPrimaryValue: Any
)

data class Spu(
    val code: String,
    val name: String
)

data class Goods(
    val code: String,
    val name: String
)

data class Customer(
    val encryPhone: String,
    val id: Long,
    val name: String,
    val phone: String
)

data class FavoriteAunt(
    val encryPhone: Any,
    val id: Any,
    val name: Any,
    val phone: Any
)

data class OrderStatus(
    val description: String,
    val key: Int,
    val value: String
)

data class Sale(
    val encryPhone: String,
    val id: Long,
    val name: String,
    val phone: String
)

data class ShareSale(
    val encryPhone: Any,
    val id: Any,
    val name: Any,
    val phone: Any
)

data class ThreadOwner(
    val encryPhone: Any,
    val id: Long,
    val name: String,
    val phone: Any
)

data class TradeStatus(
    val description: String,
    val key: Int,
    val value: String
)