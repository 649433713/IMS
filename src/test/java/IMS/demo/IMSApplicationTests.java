package IMS.demo;

import IMS.demo.dto.PurchaseDTO;
import IMS.demo.dto.TradeGoodsDTO;
import IMS.demo.service.BuyerService;
import IMS.demo.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IMSApplicationTests {
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private PurchaseService purchaseService;

	@Test
	public void contextLoads() {

		PurchaseDTO purchaseDTO = new PurchaseDTO();
		purchaseDTO.setNote("test2");

		List<TradeGoodsDTO> tradeGoodsDTOS = new ArrayList<>();
		TradeGoodsDTO tradeGoodsDTO1 = new TradeGoodsDTO();
		tradeGoodsDTO1.setGoodsId("123");
		tradeGoodsDTO1.setBuyer("wf");
		tradeGoodsDTO1.setNote("test1");
		tradeGoodsDTO1.setNum(2);
		tradeGoodsDTO1.setPrice(20.0);
		tradeGoodsDTO1.setTax(5.0);
		tradeGoodsDTOS.add(tradeGoodsDTO1);
		TradeGoodsDTO tradeGoodsDTO2 = new TradeGoodsDTO();
		tradeGoodsDTO2.setGoodsId("1231");
		tradeGoodsDTO2.setBuyer("wf");
		tradeGoodsDTO2.setNote("test2");
		tradeGoodsDTO2.setNum(2);
		tradeGoodsDTO2.setPrice(20.0);
		tradeGoodsDTO2.setTax(5.0);
		tradeGoodsDTOS.add(tradeGoodsDTO2);
		purchaseDTO.setGoodsList(tradeGoodsDTOS);

		purchaseService.purchase(purchaseDTO);

	}

}
