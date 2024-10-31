from utilidades import cabecalho
# from utilidades import somar
x = 10  # variavel global 
def somar(numero1, numero2):
    resultado = numero1 + numero2
    return resultado
# print("Inicio do programa")
cabecalho()
# print("Vamos executar outra vez")
# cabecalho()
# res = somar(30, 20)
somar(numero2=30, numero1=20)
somar(80)
somar(numero2=30)
print("Soma: ", x)
# res2 = somar(res, 40)

# print("Resultado 1: ", res)
# print("Resultado 2: ", res2)
# print("Fim do programa")


