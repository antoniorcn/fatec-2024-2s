#            0    1    2    3   4   5   6   7   8    9    10  11   12   13  14  15  16  17  18  19  
lista = [   110, 188, 157, 47, 77, 66, 195, 17, 134, 192, 38, 93, 151, 178, 87, 91, 37, 51, 14 ]

print("Lista desordenada")
print(lista)
lista.sort()
print("Lista ordenada")
print(lista)

tamanho = len(lista)
mediana = lista[tamanho // 2]
if tamanho % 2 == 0:
    indice_2 = tamanho // 2
    indice_1 = indice_2 - 1
    mediana = (lista[indice_1] + lista[indice_2]) / 2

print("Mediana: ", mediana)



