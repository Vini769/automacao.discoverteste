#language: pt
Funcionalidade: Validar métodos API

  @usuarioTest
  Esquema do Cenário: Validar Fluxo

    Dado UmAdministrador

    Quando SolicitarListaDeUsuarios

    Então ObtenhoResultadosDasValidacoes
