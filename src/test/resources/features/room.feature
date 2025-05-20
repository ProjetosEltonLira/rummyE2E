# language: pt

Funcionalidade: Listar salas

  Esquema do Cenário: Listar salas
    Quando pesquisar todas as salas
    Então encontro a sala "<Nome>"

    Exemplos:
      | Nome                  |
      | Sala América do Sul   |
      | Sala Europa           |
      | Sala América do Norte |
      | Sala África           |