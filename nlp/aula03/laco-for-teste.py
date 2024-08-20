# lista = [1, 2, 3, 4, 5]

# for numero in lista:
#     print(numero)

print("Inicio do programa")
for numero in range(0, 1001, 5):
    if numero > 180:
        continue
    print(numero)

    if numero > 200:
        break
else:
    print("Laço for terminou normalmente")
print("Fim do programa")