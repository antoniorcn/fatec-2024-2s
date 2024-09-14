# numeros_pares = [i  for i in range(0, 201, 2)]
numeros_pares = [i * 2  for i in range(0, 101)] 


# Mostrar apenas os primeiros 
# 10 numeros da lista numeros_pares
print("Primeiros 10 numeros")
indice = 0
while indice < 10:
    print(numeros_pares[indice])
    indice = indice + 1


# Mostrar apenas os ultimos
# 10 numeros da lista numeros_pares
print("Ultimos 10 numeros")
indice = 91
while indice < 101:
    print(numeros_pares[indice])
    indice = indice + 1


# print( numeros_pares )