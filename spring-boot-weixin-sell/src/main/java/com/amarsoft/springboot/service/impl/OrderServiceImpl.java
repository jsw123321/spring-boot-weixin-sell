/** 
　 * Title: OrderServiceImpl.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月14日
　 * @version 1.0 
*/

package com.amarsoft.springboot.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.amarsoft.springboot.converters.OrderMaster2OrderDTOConverter;
import com.amarsoft.springboot.dataobject.OrderDetail;
import com.amarsoft.springboot.dataobject.OrderMaster;
import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.dto.CartDTO;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.OrderStatusEnum;
import com.amarsoft.springboot.enums.PayStatusEnum;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
import com.amarsoft.springboot.repository.OrderDetailRepository;
import com.amarsoft.springboot.repository.OrderMasterRepository;
import com.amarsoft.springboot.service.OrderService;
import com.amarsoft.springboot.service.ProductInfoService;
import com.amarsoft.springboot.utils.KeyUtils;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Title: OrderServiceImpl
 * @Description: 订单业务增删改查实现类
 * @author jiangshanwen
 * @date: 2019年12月14日下午11:39:28 （日期） 
 * @version:v.1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
     
	 @Autowired
	 private OrderService orderService;
	 
	 @Autowired
	 private ProductInfoService productInfoService;
	 
	 @Autowired
	 private OrderDetailRepository  orderDetailRepository;
	 
	 @Autowired
	 private OrderMasterRepository  orderMasterRepository;

    /**
     * ```
		POST /sell/buyer/order/create
		参数
		name: "张三"
		phone: "18868822111"
		address: "慕课网总部"
		openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
		items: [{
		    productId: "1423113435324",
		    productQuantity: 2 //购买数量
		}]
     */
	 /**
	  * 
	  * @Title: create
	  * @Description: 创建订单
	  * @param orderDTO
	  * @return  OrderDTO
	  * @author jiangshanwen
	  * @date 2019年12月15日 下午7:35:18
	  * @throws
	  */
	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		/**OrderDTO
		 * // 订单id. 
			private String orderId;
			//买家名字.
			private String buyerName;
			//买家电话.
			private String buyerPhone;
			//买家地址.
			private String buyerAddress;
			//买家微信openid
			private String buyerOpenid;
			//订单总金额. 
			private BigDecimal orderAmount;
			//订单状态，默认为新下单
			private Integer orderStatus;
			//支付状态，默认未支付
			private Integer payStatus;
			//订单明细列表
			private List<OrderDetail> orderDetailList;
		 */
		//初始化
		BigDecimal orderFeeSum = new BigDecimal(BigInteger.ZERO);
		String orderId=KeyUtils.getUniqueKey();
		//1.查询商品       价格productId和数量productQuantity
		//(1)获得订单明细列表:根据controller出纳过来的orderDTO来获得订单明细列表
		List<OrderDetail> orderDetailList= orderDTO.getOrderDetailList();
		//(2)查询商品信息:遍历订单明细列表，根据商品id查询商品信息，如果查到结果为空说明商品不存在（需要创建异常枚举类）
		for (OrderDetail orderDetail : orderDetailList) {
			ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
			if(null==productInfo){
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
				//throw new SellException(ResultEnum.PRODUCT_NOT_EXIST.getMessage());
		//(3)计算订单的总金额:遍历订单明细列表，根据订单明细中商品id查询到的商品信息其中的商品单价和数量来计算本次订单的总金额
			/**ProductInfo
			private String productId;// 商品id
			private String productName;//商品名称
			private BigDecimal productPrice;//单价
			private Integer productStock;//库存
			private String productDescription;//描述
			private String productIcon;//小图
			private Integer productStatus;// 商品状态,0正常1下架
			private Integer categoryType;//类目编号
			*/
			 orderFeeSum= productInfo.getProductPrice()
					 .multiply(new BigDecimal(orderDetail.getProductQuantity()))
					 .add(orderFeeSum);
		//(4)字段赋值:给订单明细的字段赋值
			orderDetail.setDetailId(KeyUtils.getUniqueKey());
			BeanUtils.copyProperties(productInfo, orderDetail);
			System.out.println(orderId);
			log.info("orderId:{}",orderId);
			orderDetail.setOrderId(orderId);
			orderDetailRepository.save(orderDetail);
		    /** OrderDetail
			private String detailId;
			private String orderId;//订单id.
			
			private String productId;//商品id.
			private String productName;//商品名称.
			private BigDecimal productPrice;//当前价格，单位分.
			private String productIcon;//小图.
			
			private Integer productQuantity;//数量.
		     */
		}
		//(5)订单的创建
		/**
			private String orderId;// 订单id.
			private String buyerName;// 买家名字.
			private String buyerPhone;// 买家电话. 
			private String buyerAddress;// 买家地址. 
			private String buyerOpenid;// 买家微信openid. 
			private BigDecimal orderAmount;// 订单总金额. 
			private Integer orderStatus;// 订单状态，默认为新下单. 
			private Integer payStatus;// 支付状态，默认未支付.
		 */
		OrderMaster orderMaster=new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
//		orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
//		orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
//		orderMaster.setBuyerName(orderDTO.getBuyerName());
//		orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
		orderMaster.setOrderAmount(orderFeeSum);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.NOTPAY.getCode());
		orderMasterRepository.save(orderMaster);
		//(6)库存的增减:封装一个库存增加或者减少的方法，以便在此调用
		List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
		productInfoService.decreaseStock(cartDTOList);
		return orderDTO;
	}

    /**
     * 
     * @Title: findOne
     * @Description: 根据订单id查询所属订单
     * @param orderId
     * @return OrderDTO
     * @author jiangshanwen
     * @date 2019年12月15日 下午7:36:36
     * @throws
     */
	@Override
	public OrderDTO findOne(String orderId) {
		OrderMaster orderMaster = orderMasterRepository.getOne(orderId);
		if(null==orderMaster){
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
//		OrderMaster one = orderMasterRepository.getOne("1576409643590274207");
		OrderDTO orderDTO=new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		List<OrderDetail> orderDetailList = orderDetailRepository.findListByOrderId(orderId);
		if(CollectionUtils.isEmpty(orderDetailList)){
			throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
		}
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}
    /**
     * 
     * @Title: findList
     * @Description: 查询当前用户下所有的订单
     * @param  buyerOpenid
     * @param  pageable
     * @return  Page<OrderDTO> 
     * @author jiangshanwen
     * @date 2019年12月15日 下午7:57:01
     * @throws
     */
	@Override
	public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
		Page<OrderMaster> OrderMasterPage = orderMasterRepository.buyerOpenid(buyerOpenid, pageable);
		List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(OrderMasterPage.getContent());
		return new PageImpl<OrderDTO>(orderDTOList,pageable,OrderMasterPage.getTotalElements());
	}
	
	 /**
     * 
     * @Title: cancle
     * @Description: 取消当前用户下的订单
     * @param  OrderDTO
     * @return  OrderDTO
     * @author jiangshanwen
     * @date 2019年12月18日 下午7:57:01
     * @throws
     */
	public OrderDTO cancle(OrderDTO orderDTO) {
		OrderMaster orderMaster=new OrderMaster();
		//(1)判断订单状态
		if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
			log.info("【取消订单】订单状态不正确:OrderId:{},	OrderStatus:{}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		
		//(2)修改订单状态
		orderDTO.setOrderStatus(OrderStatusEnum.CANCLE.getCode());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = orderMasterRepository.save(orderMaster);
		if(null==updateResult){
			log.info("【取消订单】订单取消失败：orderId:{}",orderMaster.getOrderId());
			throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		}
		//(3)返回库存
		if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
			log.info("【取消订单】订单详情为空:ordeDTO:{}",orderDTO);
			throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
		}
		List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
		productInfoService.increaseStock(cartDTOList);
		//(4)如果已支付，就退款
		if(orderDTO.getPayStatus().equals(PayStatusEnum.PAY.getCode())){
			//todo
		}
		return orderDTO;
	}
	/**
	 * 
	 * @Title: finished
	 * @Description: 将新下单的订单转化为完结订单
	 * @param orderDTO
	 * @return OrderDTO
	 * @author jiangshanwen
	 * @date 2019年12月18日 下午11:35:42
	 * @throws 
	 *   @see com.amarsoft.springboot.service.OrderService#finished(com.amarsoft.springboot.dto.OrderDTO)
	 */
	@Override
	@Transactional
	public OrderDTO finished(OrderDTO orderDTO) {
		//判断状态
		if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
			log.error("【完结订单】订单状态不正确：orderId:{},orderStatus:{}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
		    throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//修改状态
		orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
		OrderMaster orderMaster=new OrderMaster();
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster saveResult = orderMasterRepository.save(orderMaster);
		if(null==saveResult){
			log.error("【完结订单】更新订单状态失败：orderId:{}, orderStatus:{}",orderMaster.getOrderId(),orderMaster.getOrderStatus());
		    throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		}
		return orderDTO;
	}

    /**
     * @Title: payid
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param orderDTO
     * @return OrderDTO
     * @author jiangshanwen
     * @date 2019年12月18日 下午10:30:50
     * @throws 
     * @see com.amarsoft.springboot.service.OrderService#payid(com.amarsoft.springboot.dto.OrderDTO)
     */
	@Override
	@Transactional
	public OrderDTO payid(OrderDTO orderDTO) {
		//判断订单状态
		if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
			log.error("【支付订单】订单状态不正确：orderId:{},orderStatus:{}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
		    throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//判断订单支付状态
		if(!orderDTO.getPayStatus().equals(PayStatusEnum.NOTPAY.getCode())){
			log.error("【支付订单】支付状态不正确：orderId:{},payStatus:{}",orderDTO.getOrderId(),orderDTO.getPayStatus());
		    throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		//修改订单状态
		orderDTO.setPayStatus(PayStatusEnum.PAY.getCode());
		orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
		OrderMaster orderMaster=new OrderMaster();
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = orderMasterRepository.save(orderMaster);
		if(null==updateResult){
			log.error("【支付订单】订单更新失败：orderId:{},orderStatus:{},payStatus:{}",orderMaster.getOrderId(),orderMaster.getOrderStatus(),orderMaster.getPayStatus());
		    throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
		}
		return orderDTO;
	}

}
