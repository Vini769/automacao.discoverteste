#language: pt
Funcionalidade: Validar métodos API

  @usuarioTest
  Cenário: Validar Fluxo
    Dado que seja um administrador e selecionar um usuario
    Quando solicitar lista de usuarios
    Então obtenho resultado das validacoes
