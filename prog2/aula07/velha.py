matriz = [
    [3, 3, 3],
    [3, 3, 3],
    [3, 3, 3]
]

print("Matriz: ", matriz)
print("Linha (2): ", matriz[2])
print("Valor (linha-1)(coluna-2): ", matriz[1][2])

# Trocar valor de uma determinada posicao
matriz[2][0] = 1


print("Matriz: ", matriz)
print("Linha (2): ", matriz[2])
print("Valor (linha-1)(coluna-2): ", matriz[1][2])


linha = matriz[0]  # [3, 3, 3]
linha[1] #3