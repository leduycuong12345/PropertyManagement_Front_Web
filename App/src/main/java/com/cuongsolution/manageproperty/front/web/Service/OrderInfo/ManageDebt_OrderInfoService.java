package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_OrderDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RestResponsePage;


public interface ManageDebt_OrderInfoService {
	public abstract RestResponsePage<ManageDebt_OrderDTO> getDebtList_BelongToLand_ManageDebt_Pageable(long landID,int selectedPage,int totalRowPerPage);
	public abstract RestResponsePage<ManageDebt_OrderDTO> getDebtList_BelongToLand_ManageDebt_PageableAndSorting(long landID,int selectedPage,int totalRowPerPage,String keyword);
	public abstract RestResponsePage<ManageDebt_OrderDTO> getDebtList_BelongToWorksheet_ManageDebt(long worksheetId,Pageable pageable);
	public abstract RestResponsePage<ManageDebt_OrderDTO> getDebtList_BelongToWorksheet_ManageDebt_Pageable(long worksheetId,Pageable pageable);
	public abstract void deleteOrder_ManageDebt(long orderID);
	public abstract void hardDeleteOrder_ManageDebt(long orderID);
}
