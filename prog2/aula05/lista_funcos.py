#         0    1    2    3    4
notas = [6.0, 7.0, 8.0, 6.0, 5.0]
print("Notas: ", notas)

notas.append(3.0)
print("Notas: ", notas)

notas.insert(2, 4.0)
print("Notas: ", notas)

ultimo_elemento = notas.pop()
print("Ultimo Elemento: ", ultimo_elemento)
print("Notas: ", notas)

elemento_posicao2 = notas.pop(2)
print("Tirando o elemento posicao 2: ", elemento_posicao2)
print("Notas: ", notas)


print("Procurando se tem alguma nota 8,0: ")
posicao = notas.index(8.0)
print("Localizado na posicao: ", posicao)