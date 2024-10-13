package com.cuongsolution.manageproperty.front.web.TestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_OrderDTO;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageDebt_OrderInfoService;

@RestController
public class TestMeBabyController {
	@Autowired
	private ManageDebt_OrderInfoService testService;
	@GetMapping(value="/test")
	public Page<ManageDebt_OrderDTO> testPageable()  {
		return this.testService.getDebtList_BelongToWorksheet_ManageDebt(1,PageRequest.of(0, 30));
    }
}
