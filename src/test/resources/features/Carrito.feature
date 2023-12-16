@Carrito
Feature: Compra de un articulo con Tarjeta de Credito

  Background: Generar Tarjeta
    Given la pagina DemoGuru esta disponible
    When doy click en generar tarjeta

  @Carrito1
  Scenario: Compro una sola vez
    #Given la pagina DemoGuru esta disponible
    #When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono una cantidad de productos al carrito y le doy comprar
    Then ingreso los datos de la tarjeta


  @Carrito2
  Scenario Outline: Compro 2 veces
    #Given la pagina DemoGuru esta disponible
    #When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And agrego una cantidad "<cantidad>" de productos al carrito
    And ingreso los datos de la tarjeta
    Then validamos que el pago fue exitoso "Payment successfull!"
    Examples:
      | cantidad |
      | 3        |
      | 5        |