package co.edu.unisabana.parcialarquitectura.repository;

import co.edu.unisabana.parcialarquitectura.service.port.SaveExternalPort;
import org.springframework.stereotype.Repository;

@Repository
public class Database implements SaveExternalPort {

  @Override
  public int savePurchase(int buyerCode, String item) {
    if (buyerCode == 0 || item == null || item.isEmpty()) {
      return 0;
    }
    return 1;
  }
}
