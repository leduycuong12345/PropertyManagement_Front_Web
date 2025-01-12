package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;

import java.time.LocalDate;
import java.util.List;

import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_OrderDTO;


public interface ManageOrder_OrderInfoService {
	public abstract List<ManageOrder_OrderDTO> getOrderList_ManageOrder(long landID,LocalDate selectedDate);
	public abstract void deleteOrder_ManageOrder(long orderID);
	public abstract void hardDeleteOrder_ManageOrder(long orderID);
}
