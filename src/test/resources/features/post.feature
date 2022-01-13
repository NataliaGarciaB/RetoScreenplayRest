Feature:Prueba del servicio POST
    Yo como usuario
    deseo probar el servicio POST
    que proviene del dominio Reqres

  Scenario: Verificar respuesta del servio POST REGISTER
    Given el cliente se encuentra en Reqres
    When  el cliente solicita la peticion del servicio POST REGISTER
    Then la respuesta del token deberia ser "QpwL5tke4Pnpja7X4"


  Scenario: Verificar respuesta del servio POST UNSUCCESFUL
    Given el cliente se encuentra en Reqres POST
    When  el cliente solicita la peticion del servicio POST UNSUCCESFUL
    Then la respuesta del mensaje deberia ser "Missing password"