@Novus
Feature: Automatización de Formulario

  Scenario Outline: Ingreso de datos
    Given ingreso a la pagina de NovusTechnology
    And ingreso los datos del formulario
      | Nombre | Apellido | Pasatiempos | Genero    |
      | York   | Correa   | Deportes    | Masculino |
    And ingreso el numero de telefono y correo electronico "<CorreoElectronico>"
    And seleccionamos un "<Departamento>" y la primera ciudad
    And selecciono los comandos de selenium y cargo una imagen
    Then hacemos click en el boton enviar y validamos el mensaje "Información Personal"
    Examples:
      | CorreoElectronico    | Departamento |
      | yorkcorrea1@test.com | LIMA         |


  @Error
  Scenario: Validar mensaje error
    Given ingreso a la pagina de NovusTechnology
    Then valido el mensaje de error "Este campo es obligatorio"

  @Toast
  Scenario: Comprobar Toast de la pagina NovusTechnology
    Given ingreso a la pagina de NovusTechnology
    When doy click al boton Toast
    Then valido que se muestre el Toast

  @Alerta
  Scenario:Comprobar la Alerta de la pagina NovusTechnology
    Given ingreso a la pagina de NovusTechnology
    Then valido que al aceptar se abra una nueva ventana y al cancelar no haga nada


  @Csv
  Scenario: Ingreso de datos mediante Csv
    Given ingreso a la pagina de NovusTechnology
    Then ingresamos la data