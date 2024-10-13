package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateOrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_DepositDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_FastCreateOrderListDTO;

public interface ManageProperty_OrderInfoService {
	public abstract void createOrder_ManageProperty(ManageProperty_CreateOrderDTO newOrder);
	public abstract void createFastOrderList_ManageProperty(ManageProperty_FastCreateOrderListDTO newOrderList);
	public abstract void createOrderForDeposit_ManageProperty(ManageProperty_DepositDTO depositDTO);
}
