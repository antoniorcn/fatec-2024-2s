#        0  1  2  3  4   5
lista = [2, 4, 6, 8, 10, 12]
print("Lista original: ", lista)
lista.append(14)
lista.append(16)
print("Lista com numeros adicionados: ", lista)

lista.remove(8)
print("Lista com o 8 removido: ", lista)

lista.pop(1)
print("Lista com o 2nd elemento removido: ", lista)
# [12, 10, 8, 6, 4, 2]
print("Lista invertida: ", lista[::-1])


# texto = "ABC123"
# texto_lista = list(texto)
# print(texto_lista)