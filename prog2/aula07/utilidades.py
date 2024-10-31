def cabecalho():
    global x
    j = 15
    print("Programação II - Jogos Digitais")
    print("Nome: Antonio")
    print("Aula 07")

def somar(numero1=0, numero2=0):
    global x
    resultado = numero1 + numero2
    # print("Resultado: ", resultado)
    x = resultado
    # return resultado


def somar_input():
    num1 = int(input("Digite um numero"))
    num2 = int(input("Digite outro numero"))
    resultado = num1 + num2
    return resultado
