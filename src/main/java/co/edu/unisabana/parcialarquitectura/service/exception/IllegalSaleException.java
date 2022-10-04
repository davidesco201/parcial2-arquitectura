package co.edu.unisabana.parcialarquitectura.service.exception;

public class IllegalSaleException extends RuntimeException {

  public IllegalSaleException(int vendorCode, int buyerCode) {
    super("No es permitido realizar la venta al mismo vendedor" + vendorCode + " y comprador "
        + buyerCode);
  }
}
