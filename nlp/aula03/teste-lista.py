#        0  1  2  3  4
lista = [2, 4, 6, 8, 10]
print("Lista: ", lista)
print("3º elemento: ", lista[2])

sub_lista = lista[1:4]
print("Sublista: ", sub_lista)

# lista_numeros = []
# for i in range(1, 101):
#     lista_numeros.append( i )
lista_numeros = [i**2 for i in range(1, 101)]
print("Lista numeros: ", lista_numeros)

texto = "Gosto de estudar na Fatec"
print("Texto: ", texto)
lista_texto = list(texto)
print("Lista texto: ", lista_texto)


# Conjuntos
conj = {9, 11, 2, 3, 5, 6, 7, 8}
print("Numeros do conjunto: ")
print("3º numero: ", list(conj)[2])
for c in conj:
    print(c)