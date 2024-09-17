import os

# 0 - Planicie
# 1 - Mansão Assombrada
# 2 - Floresta Densa
# 3 - Litoral
mapa = [
    [2, 2, 1], 
    [0, 0, 2], 
    [3, 3, 3]
] 
agamenon = {"linha": 1, "coluna": 0}

while True:
    os.system("cls")

    lin = agamenon["linha"]
    col = agamenon["coluna"]
    celula = mapa[ lin ][ col ]

    if celula == 0:
        print("Você encontra-se em uma planicie")
    elif celula == 1:
        print("Você encontrou uma mansão assombrada")
    elif celula == 2:
        print("Você está em uma floresta densa e perigosa")
    elif celula == 3:
        print("""Você chegou no litoral, é possível sentir
        as ondas nos pés e observar um farol distante""")

    print("Você pode seguir para:")
    print("(N)orte")
    print("(S)ul")
    print("(O)este")
    print("(L)este")
    direcao = input("Por favor indique a direção: ").upper()[0]

    if direcao == 'N':
        agamenon["linha"] -= 1
    elif direcao == 'S':
        agamenon["linha"] += 1
    elif direcao == 'O':
        agamenon["coluna"] -= 1
    elif direcao == 'L':
        agamenon["coluna"] += 1

    if agamenon['coluna'] < 0:
        agamenon['coluna'] = 0
    if agamenon['coluna'] > 2:
        agamenon['coluna'] = 2
    if agamenon['linha'] < 0:
        agamenon['linha'] = 0
    if agamenon['linha'] > 2:
        agamenon['linha'] = 2