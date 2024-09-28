# (S)omar
# S(u)btrair
# (M)ultiplicar
# (D)ividir

#1 Criar uma funcao que mostre o menu acima e
# peça ao usuario para escolher uma opcao
# retornando a opcao escolhida

def menu():
    print("Calculadora")
    print("(S)omar")
    print("S(u)btrair")
    print("(M)ultiplicar")
    print("(D)ividir")
    opcao = input("Escolha uma opcao: ")
    return opcao.upper()
    

op = menu()
num1 = float(input("Digite um numero: "))
num2 = float(input("Digite outro numero: "))
if op == "S":
    resultado = num1 + num2
    print("Resultado da soma:", resultado)
elif op == "U":
    resultado = num1 - num2
    print("Resultado da subtração:", resultado)
elif op == "M":
    resultado = num1 * num2
    print("Resultado da multiplicação:", resultado)
elif op == "D":
    resultado = num1 / num2
    print("Resultado da divisão:", resultado)




