from random import randint
import os
valor_jogador = 1000.0
valor_banca = 5000.0

while True:
    # Menu 
    os.system("cls")
    print(f"Você tem R$ {valor_jogador:.2f}")
    print(f"A banca tem R$ {valor_banca:.2f}")    
    print("Bem vindo ao jogo do Leaozinho")
    print("Escolha seu tipo de aposta")
    print("1) - Apostar nos números PARES")
    print("2) - Apostar nos números IMPARES")
    print("3) - Apostar em um número específico")
    escolha = int(input("Faça sua escolha 1, 2 ou 3"))

    continua_jogo = True

    # Se escolheu apostar em numero especifico
    if escolha == 3:
        numero_especificado = int(input("Digite um numero entre 1 e 36"))
        if numero_especificado < 1 or numero_especificado > 36:
            print("Numero é invalido")
            continua_jogo = False

    # Determina o valor da aposta
    if continua_jogo:
        print("Informe quanto você deseja apostar")
        aposta = float(input("valor ==>"))
        venceu = False

        if aposta > valor_jogador:
            continua_jogo = False
            print("Você não tem este valor disponivel")


    # Variaveis Ok pode iniciar o jogo
    if continua_jogo:
        valor_banca = valor_banca + aposta
        valor_jogador = valor_jogador - aposta
        numero_aleatorio = randint(0, 80)
        if numero_aleatorio > 36:
            numero_aleatorio = 0
        print("Deu o numero: ", numero_aleatorio)
        if numero_aleatorio == 0:
            print("Você perdeu")
        elif escolha == 1 and numero_aleatorio % 2 == 0:
            venceu = True
            razao_pagamento = 2
            print("Você ganhou")
        elif escolha == 2 and numero_aleatorio % 2 == 1:
            venceu = True
            razao_pagamento = 2
            print("Você ganhou")
        elif escolha == 3 and numero_aleatorio == numero_especificado:
            venceu = True
            razao_pagamento = 30
        else:
            print("Você perdeu")


        if venceu:
            print("Parabéns você venceu esta rodada")  
            ganho = (razao_pagamento * aposta)
            valor_banca = valor_banca - ganho
            valor_jogador = valor_jogador + ganho
        else:
            print("Que pena você perdeu esta rodada")

        if valor_banca <= 0: 
            print("Parabéns você ganhou e quebrou a banca")
            break

        if valor_jogador <= 0:
            print("Que pena você perdeu, junte mais dinheiro e venha ser freguês nosso")
            break
    input("Tecle <ENTER> para continuar")

