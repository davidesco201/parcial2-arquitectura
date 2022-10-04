package co.edu.unisabana.parcialarquitectura.service.impl;


import co.edu.unisabana.parcialarquitectura.service.exception.IllegalSaleException;
import co.edu.unisabana.parcialarquitectura.service.port.SaveExternalPort;
import org.springframework.stereotype.Service;

@Service
public class Buy {

  private final SaveExternalPort saveExternalPort;
  public Buy (SaveExternalPort saveExternalPort){
    this.saveExternalPort = saveExternalPort;
  }
  public String makePurchase(int vendorCode, int buyerCode, String item) {
    if (buyerCode == vendorCode) {
      throw new IllegalSaleException(vendorCode, buyerCode);
    }
    int result = this.saveExternalPort.savePurchase(buyerCode, item);
    if (result == 1) {
      return "Product sold";
    } else {
      return "The sale was not possible";
    }
  }
}
