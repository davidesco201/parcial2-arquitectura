package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.service.exception.IllegalSaleException;
import co.edu.unisabana.parcialarquitectura.service.impl.Buy;
import co.edu.unisabana.parcialarquitectura.service.port.SaveExternalPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BuyTest {
  @InjectMocks
  private Buy service;

  @Mock
  private SaveExternalPort saveExternalPort;

  @Test
  public void Given_vendor_code_and_buyer_code_different_and_item_its_not_null_or_empty_When_makePurchase_Then_return_product_sold_message() {
    Mockito.when(saveExternalPort.savePurchase(3, "Books")).thenReturn(1);
    String result = service.makePurchase(2, 3, "Books");
    Mockito.verify(saveExternalPort).savePurchase(3, "Books");
    assertEquals("Product sold", result);
  }
  @Test
  public void Given_vendor_code_and_buyer_code_same_and_item_its_not_null_or_empty_When_makePurchase_Then_throw_IlegalSaleException(){
    assertThrows(IllegalSaleException.class, ()-> service.makePurchase(3, 3, "Books"));
  }
  @Test
  public void Given_buyer_code_equals_0_vendor_code_2_item_its_empty_When_makePurchase_Then_return_the_sale_was_not_possible_message(){
    Mockito.when(saveExternalPort.savePurchase(0, "")).thenReturn(0);
    String result = service.makePurchase(2, 0, "");
    Mockito.verify(saveExternalPort).savePurchase(0, "");
    assertEquals("The sale was not possible", result);
  }

}