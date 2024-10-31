# semente = 15
# numero_aleatorio = 33

# semente = 33
# outro_numero_aleatorio = 97

# semente = 97
# outro_numero_aleatorio = 54

from random import random, randint, seed
from time import time

print("Timestamp atual: ", time())
# numero_aleatorio = random()
# novo_numero = round(numero_aleatorio * 10)
# print(novo_numero)
seed(356)
print("Numeros para a Mega Sena")
numero_mega_sena_1 = round(randint(1, 60) * 0.5)
numero_mega_sena_2 = round(randint(1, 60) * 0.5)
numero_mega_sena_3 = round(randint(1, 60) * 0.5)
numero_mega_sena_4 = round(randint(1, 60) * 0.5)
numero_mega_sena_5 = round(randint(1, 60) * 0.5)
numero_mega_sena_6 = round(randint(1, 60) * 0.5)
print(numero_mega_sena_1)
print(numero_mega_sena_2)
print(numero_mega_sena_3)
print(numero_mega_sena_4)
print(numero_mega_sena_5)
print(numero_mega_sena_6)

# Como transformar um valor em uma 
# escala de 0 a 1 em um valor na escala de 1 a 10 

