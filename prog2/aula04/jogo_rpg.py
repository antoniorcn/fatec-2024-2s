import os
x = 1
while x == 1:
    os.system("cls")
    print("Jogo de RPG")
    print("""
        Você está em uma caverna escura, umida, 
        apertada, você está ouvindo alguns barulhos,
        vindo do norte.
        """)
    print("Onde você deseja ir: ")
    direcao = input("(N)orte (S)ul (L)este (O)este  (X)Sair do Jogo: ").upper()

    if direcao == "S":
        print("""
            Excelente, você agora está em uma floresta 
            densa, escura, com arvores muito antigas,
            e pequenos insetos rastejantes
        """)
    elif direcao == "N":
        print("""
            Encontrou um lobo faminto, que te estraçalhou
            Você perdeu o jogo
            G A M E   O V E R
        """)
    elif direcao == "O":
        print("""
            Agora você esta em um pantano, fétido, com diversas arvores mortas.
            Cuidado pode haver jacarés
        """)
    elif direcao == "L":
        print("""
            Você chegou em uma praia, com areia branquinha e mar azul bem claro
            É possível ver os peixes
        """)
    elif direcao == "X":
        x = 2
        continue
        # break
    else:
        print("Você não pode ir para esta direção")

    input("Tecle <ENTER> para continuar")

print("Fim do jogo")