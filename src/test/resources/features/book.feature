# language: pt

Funcionalidade: Reservar uma sala

  Cenário: Reservar uma quarto disponível
    Dado que a "Sala América do Sul" existe
    E a sala esta disponível para reserva hoje
    Quando eu reservar para uma hora apartir de agora
    Então a sala deve ser reservada com sucesso

  Cenário: Conflito quando uma sala já está agendada
    Dado que a "Sala Europa" existe
    E a sala esta disponível para reserva hoje
    E um usuario reservou a sala por uma hora apartir de agora
    Quando eu reservar para uma hora apartir de agora
    Então a reserva deve dar um conflito
