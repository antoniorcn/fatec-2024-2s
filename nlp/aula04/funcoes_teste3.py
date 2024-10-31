
def somar( txt, *numeros ):
    print("Txt: ", txt)
    print("Numeros: ", numeros)
    soma = 0
    for num in numeros:
        soma += num
    return soma


resultado = somar('Texto', 10, 20, 30, 40)
print("Resultado: ", resultado)