from random import random

while True:
    print("J O G O   D E   D A D O S")
    print("Digite um numero entre 1 e 6")
    str_num = input()
    num = int(str_num)
    if num >= 1 and num <= 6:
        print("Jogando o dado")
        dado = round(random() * 5 + 1)
        print("Dado: ", dado)
        if num == dado:
            print("Parabens você acertou")
        else:
            print("Que pena você errou")
    else:
        print("Por favor digite o numero entre 1 e 6")

    print("Você quer jogar novamente (S/N)")
    resposta = input()
    if resposta == "N":
        print("Bora ir para o SIJOGA")
        break
