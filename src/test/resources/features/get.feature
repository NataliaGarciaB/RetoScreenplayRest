Feature: Prueba del servicio GET
    Yo como usuario
    deseo probar el servicio GET
    que proviene del dominio Reqres

  Scenario: Verificar respuesta del servio GET del usuario veintitres
    Given el cliente se encunetra en el dominio Reqres
    When  el cliente realiza la peticion del servicio GET
    Then la respues del servicio deberia de ser 404

  Scenario: Verificar respuesta del servio GET del usuario doce
    Given el cliente se encunetra en el dominio Reqres principal
    When  el cliente realiza la peticion del servicio
    Then el codigo respuesta deberia ser 200

